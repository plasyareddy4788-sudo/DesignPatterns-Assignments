class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private boolean hasGraphicsCard;
    private boolean hasBluetooth;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.hasGraphicsCard = builder.hasGraphicsCard;
        this.hasBluetooth = builder.hasBluetooth;
    }

    public void showConfiguration() {
        System.out.println("Computer Config -> CPU: " + CPU + 
                           ", RAM: " + RAM + 
                           ", Storage: " + storage + 
                           ", Graphics Card: " + hasGraphicsCard + 
                           ", Bluetooth: " + hasBluetooth);
    }

    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
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

public class BuilderPattern {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i3", "8GB", "256GB SSD")
                .build();
        basicComputer.showConfiguration();

        Computer gamingComputer = new Computer.Builder("AMD Ryzen 9", "32GB", "1TB SSD")
                .setGraphicsCard(true)
                .setBluetooth(true)
                .build();
        gamingComputer.showConfiguration();
    }
}