public class ComputerBuilderTest {
    public static void main(String[] args) {
        // Create a basic computer
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB", "256GB SSD")
                .build();

        // Create a computer with graphics card and Bluetooth
        Computer gamingComputer = new Computer.Builder("Intel i7", "16GB", "512GB SSD")
                .setGraphicsCard(true)
                .setBluetooth(true)
                .build();

        // Create a computer with graphics card but no Bluetooth
        Computer workComputer = new Computer.Builder("Intel i9", "32GB", "1TB SSD")
                .setGraphicsCard(true)
                .build();

        System.out.println("Basic Computer: " + basicComputer);
        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Work Computer: " + workComputer);
    }
}
