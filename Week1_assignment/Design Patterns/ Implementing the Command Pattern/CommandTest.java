public class CommandTest {
    public static void main(String[] args) {
        // Create a Light instance
        Light light = new Light();

        // Create command instances
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Create a RemoteControl instance
        RemoteControl remote = new RemoteControl();

        // Test turning the light on
        remote.setCommand(lightOn);
        System.out.println("Pressing button to turn on the light:");
        remote.pressButton();

        // Test turning the light off
        remote.setCommand(lightOff);
        System.out.println("Pressing button to turn off the light:");
        remote.pressButton();
    }
}
