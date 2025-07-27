public class Main 
{
	public static void main(String[] args) {
	    Mathematics maths = new Mathematics();
	    maths.add(2,3);
	    maths.add(5);
	    System.out.println(maths.add(10.0));
	}
}

class Mathematics extends Object{
    void add(int a, int b){
        System.out.println(a+b);
    }
    int add(int a){
        return a*a;
    }
    double add(double a){
        return (a*a*a);
    }
}
