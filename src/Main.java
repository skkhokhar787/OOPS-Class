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
    int batteryLevel;

    public void electricCar(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
        //this.batteryLevel = batteryLevel;
    }

    public ElectricCar(String make, String model, int year, int batteryLevel) {
        super(make, model, year);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void startEngine () {
        if (batteryLevel > 20) {
            System.out.println(make+" "+model+" "+"("+year+") is silently power on...");
        }else {
            System.out.println(make+" "+model+" "+"("+year+") Low battery ! Please charge...");
            System.out.println();
        }
    }
    public void chargeBattery () {
        batteryLevel = 100;
        System.out.println(model+" "+"("+year+") battery is charged to "+batteryLevel+"%");
    }
}


public class Main {
    public static void main (String [] args) {
        Car petrolCar = new Car("Toyota","Corolla",2020);
        int batteryLevel = 35;
        ElectricCar tesla = new ElectricCar("Tesla","Model 3",2025, batteryLevel);

        petrolCar.startEngine();
        petrolCar.stopEngine();

        if (batteryLevel <= 20) {
            System.out.println(" Low battery! Please charge...");
            System.out.println();
            tesla.chargeBattery();
        }
        tesla.startEngine();
        tesla.stopEngine();

    }
}
