package com.freely.freely.strategy;

import com.freely.freely.config.ResendProperties;
import com.freely.freely.entities.Notification;
import com.freely.freely.entities.NotificationChannel;
import com.freely.freely.repositories.INotificationRepository;
import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.SendEmailRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationStrategy implements NotificationStrategy {

    private static final Logger log = LoggerFactory.getLogger(EmailNotificationStrategy.class);

    private final INotificationRepository notificationRepository;
    private final ResendProperties props;

    public EmailNotificationStrategy(INotificationRepository notificationRepository, ResendProperties props) {
        this.notificationRepository = notificationRepository;
        this.props = props;
    }

    @Override
    public NotificationChannel getChannel() {
        return NotificationChannel.EMAIL;
    }

    @Override
    public void send(Notification notification) {
        notificationRepository.save(notification);

        Resend resend = new Resend(props.getApiKey());

        SendEmailRequest sendEmailRequest = SendEmailRequest.builder()
                .from(props.getFromEmail())
                .to(notification.getUser().getEmail())
                .subject(notification.getTitle())
                .html("<p>" + notification.getMessage() + "</p>")
                .build();

        try {
            var response = resend.emails().send(sendEmailRequest);
            log.info("Email sent successfully to: {}. Response: {}", notification.getUser().getEmail(), response);
        } catch (ResendException e) {
            log.error("Resend API error: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to send email via Resend: " + e.getMessage(), e);
        } catch (Exception e) {
            log.error("Unexpected error sending email: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to send email: " + e.getMessage(), e);
        }
    }
}
