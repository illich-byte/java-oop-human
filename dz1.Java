public class Main {
    public static void main(String[] args) {
        Builder builder = new Builder("Ivan", 35, "ABC Construction");
        Sailor sailor = new Sailor("Petro", 28, "Black Sea Ship");
        Pilot pilot = new Pilot("Oleh", 40, "Boeing 737");

        builder.showInfo();
        builder.build();

        System.out.println();

        sailor.showInfo();
        sailor.sail();

        System.out.println();

        pilot.showInfo();
        pilot.fly();
    }
}

class Human {
    protected String name;
    protected int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Builder extends Human {
    private String company;

    public Builder(String name, int age, String company) {
        super(name, age);
        this.company = company;
    }

    public void build() {
        System.out.println(name + " is building...");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Company: " + company);
    }
}

class Sailor extends Human {
    private String ship;

    public Sailor(String name, int age, String ship) {
        super(name, age);
        this.ship = ship;
    }

    public void sail() {
        System.out.println(name + " is sailing...");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Ship: " + ship);
    }
}

class Pilot extends Human {
    private String aircraft;

    public Pilot(String name, int age, String aircraft) {
        super(name, age);
        this.aircraft = aircraft;
    }

    public void fly() {
        System.out.println(name + " is flying...");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Aircraft: " + aircraft);
    }
}