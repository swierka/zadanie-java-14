package pl.notify.reader;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.notify.model.Notification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Primary
public class ConsoleReader implements NotificationReader {

    public List<Notification> getNotifications() throws IOException {

        Scanner scanner = new Scanner(System.in);
        List<Notification> notifications = new ArrayList<>();

        System.out.println("Wpisz NEXT, aby dodać kolejne powiadomienie lub EXIT, aby zakończyć");
        while (scanner.nextLine().equals("NEXT")) {
            System.out.println("Podaj nazwę użytkownika");
            String username = scanner.nextLine();
            System.out.println("Podaj email");
            String email = scanner.nextLine();
            System.out.println("Podaj nr telefonu");
            String telephone = scanner.nextLine();
            System.out.println("Podaj treść do wysłania");
            String content = scanner.nextLine();
            notifications.add(new Notification(username, email, telephone, content));
            System.out.println("Wpisz NEXT, aby dodać kolejne powiadomienie lub EXIT, aby zakończyć");
        }
        scanner.close();
        return notifications;
    }
}