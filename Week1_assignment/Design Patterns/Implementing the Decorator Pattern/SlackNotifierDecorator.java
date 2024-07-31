public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier decoratedNotifier) {
        super(decoratedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Delegate to the original notifier
        sendSlackMessage(message); // Add Slack functionality
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending Slack message with content: " + message);
    }
}
