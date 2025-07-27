abstract class First{
    void show(){
        System.out.println("Show");
    }
    abstract void add();
    abstract void sub();
}
class Second extends First{
    void add(){
        System.out.println(10+2);
    }
    void sub(){
        System.out.println(10-2);
    }
}
abstract class third extends First{
    void show1(){
        System.out.println("Show1");
    }
    void add(){
        System.out.println(20+1);
    }
    abstract void sub();
}
class Fourth extends third{
    void sub(){
        System.out.println(20-1);
    }
} 
public class Main
{
	public static void main(String[] args) {
	    Second se = new Second();
	    se.add();
	    se.sub();
	    Fourth f = new Fourth();
	    f.sub();
	}
}
