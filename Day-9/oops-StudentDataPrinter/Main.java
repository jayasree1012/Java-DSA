import java.util.Scanner;
class Student{
    int roll;
    String name;
    public Student(String name, int roll){
        this.name = name;
        this.roll = roll;
    }
    
    void display(){
        System.out.println(this.name + "\nMarks: " + this.roll);
    }
}
class Abc{
    static final int a = 10;
}
public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    Student obj = new Student(sc.next(), sc.nextInt());
	    obj.display();
	    
	    System.out.println(Abc.a);
	}
}
