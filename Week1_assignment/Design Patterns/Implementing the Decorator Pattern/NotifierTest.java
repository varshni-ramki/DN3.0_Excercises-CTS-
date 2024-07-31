public class NotifierTest {
    public static void main(String[] args) {
        // Create an Email Notifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate Email Notifier with SMS functionality
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        
        // Decorate Email Notifier with Slack functionality
        Notifier slackNotifier = new SlackNotifierDecorator(emailNotifier);

        // Decorate Email Notifier with both SMS and Slack functionalities
        Notifier combinedNotifier = new SMSNotifierDecorator(new SlackNotifierDecorator(emailNotifier));

        // Send notifications
        System.out.println("Sending notifications with various decorators:");
        emailNotifier.send("Hello World!");
        smsNotifier.send("Hello World!");
        slackNotifier.send("Hello World!");
        combinedNotifier.send("Hello World!");
    }
}
