abstract class Movie {
	String movieid;
	String title;
	double ticketprice;
	int numberoftickets;
	Movie(String id, String tile,double ticp,int not) {
		movieid=id;
		title=tile;
		ticketprice=ticp;
		numberoftickets=not;
	}
	abstract double calculateprice();

	public void displayDetails() {
		System.out.println("id "+movieid);
		System.out.println("title "+title);
		System.out.println("ticketprice "+ticketprice);
		System.out.println("numberoftickets "+numberoftickets);

		if(numberoftickets>6) {
			System.out.println("booking cancled cannot book more than 6");
		}
		else {
			double total=calculateprice();
			System.out.println("total price "+total);
		}
	}

}
class TeluguMovie extends Movie {
	TeluguMovie(String id, String title,double ticp,int not) {
		super(id,title,ticp,not);
	}
	@Override
	double calculateprice() {
		double total = ticketprice * numberoftickets;
		return total + total * 0.05;
	}


}
class HindiMovie extends Movie {
	HindiMovie(String id, String title, double ticp, int not) {
		super(id,title,ticp,not);
	}

	@Override
	double calculateprice() {
		double total = ticketprice * numberoftickets;
		double discounted = total - total * 0.10;
		return discounted + discounted * 0.05;
	}
}


class EnglishMovie extends Movie {
	EnglishMovie(String id, String title, double ticp, int not) {
		super(id,title,ticp,not);
	}

	@Override
	double calculateprice() {
		double total = (ticketprice + 50) * numberoftickets;
		return total + total * 0.05;
	}
}
public class Main {
	public static void main(String[] args) {
		Movie ob;
		System.out.println("Movie Recored");
		ob=new TeluguMovie("M"+101,"OYE..",150,3);
		ob.calculateprice();
		ob.displayDetails();
		System.out.println();
		System.out.println("Movie Recored");
		ob=new HindiMovie("M102","TAARE ZAMEEN PAR",200,2);
		ob.calculateprice();
		ob.displayDetails();
		System.out.println();
		System.out.println("Movie Recored");
		ob=new EnglishMovie("M103","AVATAR",250,7);
		ob.calculateprice();
		ob.displayDetails();
		System.out.println();


	}
}





