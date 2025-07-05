import java.util.Scanner;

class Car {
    String make;
    String model;
    int year;


    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void startEngine() {
        System.out.println(make + " " + model + " (" + year + ") engine started..");
    }

    public void stopEngine() {
        System.out.println(make + " " + model + " (" + year + ") engine stoped..");
        System.out.println();
    }
}

class ElectricCar extends Car {
    Scanner bc = new Scanner(System.in);
    int batteryLevel;

    public ElectricCar(String make, String model, int year, int batteryLevel) {
        super(make, model, year);
        this.batteryLevel = batteryLevel;
    }


    public void startEngine() {
        if (batteryLevel > 20) {
            System.out.println(make + " " + model + " (" + year + ") is silently power on...");
            System.out.println(make + " " + model + " (" + year + ") engine stoped..");
            System.out.println();
        } else {
            System.out.println(make + " " + model + " (" + year + ") Low battery! Please charge...");
            System.out.println("To charge battery.. Enter \"charge battery\"");
            String inputChargeBattery = bc.nextLine();
            if (inputChargeBattery.equals("charge battery")) {
                System.out.println("....charging on....");
            }
        }
    }

    public void chargeBattery() {

        batteryLevel = 100;
        System.out.println(model + " (" + year + ") battery is charged to " + batteryLevel + "%");
    }
}

public class Main {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        Car petrolCar = new Car("Toyota","Corolla",2020);
        System.out.print("Enter Tesla battery level : ");
        int batteryLevel = sc.nextInt();
        ElectricCar tesla = new ElectricCar("Tesla","Model 3",2025, batteryLevel);

        petrolCar.startEngine();
        petrolCar.stopEngine();

        if (batteryLevel > 20) {
            tesla.startEngine();
        }else {
            tesla.startEngine();
            tesla.chargeBattery();
        }

    }
}
