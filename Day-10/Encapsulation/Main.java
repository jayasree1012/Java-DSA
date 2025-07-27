class Student{
    private String name;
    void setName(String str){
        name = str;
    }
    String getName(){
        return name;
    }
}
public class Main
{
	public static void main(String[] args) {
	    Student st = new Student();
	    st.setName("Jayasree");
	    System.out.println(st.getName());
	}
}
