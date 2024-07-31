public class Computer {
    // Required attributes
    private String CPU;
    private String RAM;
    private String storage;

    // Optional attributes
    private boolean hasGraphicsCard;
    private boolean hasBluetooth;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasBluetooth = builder.hasBluetooth;
    }

    // Getters
    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public boolean hasGraphicsCard() { return hasGraphicsCard; }
    public boolean hasBluetooth() { return hasBluetooth; }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", storage='" + storage + '\'' +
                ", hasGraphicsCard=" + hasGraphicsCard +
                ", hasBluetooth=" + hasBluetooth +
                '}';
    }

    // Static nested Builder class
    public static class Builder {
        // Required attributes
        private String CPU;
        private String RAM;
        private String storage;

        // Optional attributes
        private boolean hasGraphicsCard;
        private boolean hasBluetooth;

        public Builder(String CPU, String RAM, String storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.storage = storage;
        }

        public Builder setGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Builder setBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
