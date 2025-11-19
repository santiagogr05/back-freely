package com.freely.freely.controllers;

import com.freely.freely.entities.Notification;
import com.freely.freely.entities.NotificationChannel;
import com.freely.freely.entities.NotificationType;
import com.freely.freely.entities.User;
import com.freely.freely.repositories.IUserRepository;
import com.freely.freely.strategy.EmailNotificationStrategy;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Test", description = "Testing endpoints")
public class TestController {

    private final EmailNotificationStrategy emailNotificationStrategy;
    private final IUserRepository userRepository;

    @PostMapping("/send-test-email")
    @Operation(summary = "Send a test email notification",
               description = "Sends a test email to verify the email notification strategy is working")
    public ResponseEntity<Map<String, String>> sendTestEmail(
            @RequestParam String email,
            @RequestParam(required = false, defaultValue = "Test Email") String title,
            @RequestParam(required = false, defaultValue = "This is a test email from Freely!") String message) {

        Map<String, String> response = new HashMap<>();

        try {
            // Find user by email or create a temporary one for testing
            User user = userRepository.findByEmail(email).orElseGet(() -> {
                User tempUser = new User();
                tempUser.setEmail(email);
                tempUser.setName("Test User");
                return tempUser;
            });

            // Create a test notification
            Notification notification = new Notification();
            notification.setUser(user);
            notification.setType(NotificationType.NEW_MESSAGE);
            notification.setTitle(title);
            notification.setMessage(message);
            notification.setChannel(NotificationChannel.EMAIL);
            notification.setStatus("PENDING");

            // Send the notification
            emailNotificationStrategy.send(notification);

            response.put("status", "success");
            response.put("message", "Test email sent successfully to " + email);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Failed to send email: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping("/email-strategy-info")
    @Operation(summary = "Get email strategy information",
               description = "Returns information about the email notification strategy configuration")
    public ResponseEntity<Map<String, String>> getEmailStrategyInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("channel", emailNotificationStrategy.getChannel().toString());
        info.put("status", "Email notification strategy is configured and ready");
        return ResponseEntity.ok(info);
    }
}

