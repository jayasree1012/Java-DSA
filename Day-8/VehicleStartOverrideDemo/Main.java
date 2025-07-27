class Vehicle{
    void start(){
        System.out.println("Vehicle Started");
    }
}
class Car extends Vehicle{
    @Override
    void start(){
        System.out.println("Car Started");
    }
}
class Bike extends Vehicle{
    @Override
    void start(){
        System.out.println("Bike Started");
    }
}
public class Main
{
	public static void main(String[] args) {
	    Car car = new Car();
	    car.start();
	    Bike bike = new Bike();
	    bike.start();
	}
}
