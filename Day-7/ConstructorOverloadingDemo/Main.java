public class Main
{
	public static void main(String[] args) {
	    Def obj = new Def();
	    obj.add();
	}
} 
class Abc{
    Abc(){
        System.out.println("Constructor overloading without param");
    }
    Abc(String s){
        System.out.println("Constructor overloading with param: " + s);
    }
    Abc(String s1, String s2){
        System.out.println("Constructor overloading with param: " + s1 + ", " + s2);
    }
    void add(){
        System.out.println("Adding");
    }
}
class Def extends Abc{
    Def(){
        super("Python");
    }
}
