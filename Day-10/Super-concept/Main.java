public class Main
{
	public static void main(String[] args) {
	    Second o = new Second();
	    o.display();
	}
}
class First{
    int a = 10;
    First(int a, int b){
        System.out.println("First");
    }
    void display(){
        System.out.println("First display");
        System.out.println(a);
    }
}
class Second extends First{
    int a = 20;
    Second(){
        super(10, 20);
        System.out.println("Second");
    }
    void display(){
        super.display();
        System.out.println("Second display");
        System.out.println(a);
        System.out.println(super.a);
    }
}
