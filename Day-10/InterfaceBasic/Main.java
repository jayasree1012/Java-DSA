interface Atm{
    void sum();
}
class A implements Atm{
    public void sum(){
        System.out.println(10+2);
    }
}
public class Main
{
	public static void main(String[] args) {
	    A a = new A();
	    a.sum();
	    
	}
}
