package pl.notify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import pl.notify.app.NotificationFacade;
import pl.notify.logger.FileLogger;
import pl.notify.logger.NotifyLogger;
import pl.notify.reader.ConsoleReader;
import pl.notify.reader.FileNotificationReader;
import pl.notify.reader.NotificationReader;
import pl.notify.sender.EmailNotificationSender;
import pl.notify.sender.NotificationSender;
import pl.notify.sender.SmsNotificationSender;

//@Configuration
public class AppConfig {

    @Bean
    public NotifyLogger logger() {
        FileLogger fileLogger = new FileLogger();
        return fileLogger;
    }

    @Bean
    public FileNotificationReader fileReader() {
        FileNotificationReader fileNotificationReader = new FileNotificationReader();
        return fileNotificationReader;
    }

    @Bean
    @Primary
    public ConsoleReader consoleReader() {
        ConsoleReader consoleNotificationReader = new ConsoleReader();
        return consoleNotificationReader;
    }

    @Bean
    public EmailNotificationSender emailSender() {
        EmailNotificationSender emailNotificationSender = new EmailNotificationSender();
        return emailNotificationSender;
    }

    @Bean
    @Primary
    public SmsNotificationSender smsSender() {
        SmsNotificationSender smsNotificationSender = new SmsNotificationSender();
        return smsNotificationSender;
    }


    @Bean
    public NotificationFacade facade(NotifyLogger logger, NotificationReader reader, NotificationSender sender) {
        NotificationFacade notificationFacade = new NotificationFacade(reader, sender, logger);
        return notificationFacade;
    }

}
