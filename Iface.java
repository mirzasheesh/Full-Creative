package internship;

public class Iface {
    public static void main(String[] args) {
        Car dreamCar = new FlyingCar();
        Car myCar = new NormalCar();
        Car theCar = new FloatingCar();
        dreamCar.start();
        Car.horn();
        myCar.start();
        Car.horn();
        theCar.start();
        Car.horn();
        dreamCar.run();
        myCar.run();
        theCar.run();
    }   
}


interface Car{
    static void horn(){
        System.out.println("Peeeep");
    }
    default void start(){
        System.out.println("Staring Car");
    };
    void run();
}

class FlyingCar implements Car{
    @Override
    public void run(){
        System.out.println("Car flying");
    }
}

class NormalCar implements Car{
    @Override
    public void run() {
        System.out.println("Car running");
    }
}

class FloatingCar implements Car{
    @Override
    public void start(){
        System.out.println("Fixing Tubes");
    }
    @Override
    public void run() {
        System.out.println("Car Swim");
    }
}