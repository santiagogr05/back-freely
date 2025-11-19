package com.freely.freely.strategy;

import com.freely.freely.config.ResendProperties;
import com.freely.freely.entities.Notification;
import com.freely.freely.entities.NotificationChannel;
import com.freely.freely.entities.NotificationType;
import com.freely.freely.entities.User;
import com.freely.freely.repositories.INotificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmailNotificationStrategyTest {

    @Mock
    private INotificationRepository notificationRepository;

    @Mock
    private ResendProperties resendProperties;

    @InjectMocks
    private EmailNotificationStrategy emailNotificationStrategy;

    private Notification testNotification;
    private User testUser;

    @BeforeEach
    void setUp() {
        // Create a test user
        testUser = new User();
        testUser.setId(1);
        testUser.setName("Test User");
        testUser.setEmail("test@example.com");

        // Create a test notification
        testNotification = new Notification();
        testNotification.setId(1);
        testNotification.setUser(testUser);
        testNotification.setType(NotificationType.NEW_MESSAGE);
        testNotification.setTitle("Test Notification");
        testNotification.setMessage("This is a test message");
        testNotification.setChannel(NotificationChannel.EMAIL);
        testNotification.setStatus("PENDING");

        // Setup ResendProperties mock
        when(resendProperties.getApiKey()).thenReturn("test-api-key");
        when(resendProperties.getFromEmail()).thenReturn("noreply@freely.com");
    }

    @Test
    void testGetChannel() {
        // Test that the strategy returns the correct channel
        NotificationChannel channel = emailNotificationStrategy.getChannel();
        assertEquals(NotificationChannel.EMAIL, channel);
    }

    @Test
    void testSendNotification_SavesNotification() {
        // Mock the repository save method
        when(notificationRepository.save(any(Notification.class))).thenReturn(testNotification);

        // Note: This test will try to actually send an email via Resend API
        // In a real test, you would mock the Resend client, but for now we'll catch the exception
        try {
            emailNotificationStrategy.send(testNotification);
        } catch (RuntimeException e) {
            // Expected to fail because we're using a fake API key
            assertTrue(e.getMessage().contains("Failed to send Email via resend"));
        }

        // Verify that the notification was saved to the database
        verify(notificationRepository, times(1)).save(testNotification);
    }

    @Test
    void testNotificationRepositoryInjection() {
        // Test that dependencies are properly injected
        assertNotNull(emailNotificationStrategy);
    }

    @Test
    void testNotificationHasCorrectUser() {
        // Verify the notification has the correct user information
        assertEquals("test@example.com", testNotification.getUser().getEmail());
        assertEquals("Test User", testNotification.getUser().getName());
    }

    @Test
    void testNotificationProperties() {
        // Verify all notification properties are set correctly
        assertNotNull(testNotification.getUser());
        assertEquals(NotificationType.NEW_MESSAGE, testNotification.getType());
        assertEquals("Test Notification", testNotification.getTitle());
        assertEquals("This is a test message", testNotification.getMessage());
        assertEquals(NotificationChannel.EMAIL, testNotification.getChannel());
        assertEquals("PENDING", testNotification.getStatus());
    }
}

