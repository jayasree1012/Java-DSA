class  Participant {
	private int Participantid,numberOfEvents;
	private String name;
	private double baseRegistrationFee,eventChargePerEvent;


	public void setParticipantid(int p) {
		Participantid=p;

	}
	public void setname(String n) {
		name=n;
	}
	public void setbaseRegistrationFee(double rf) {
		baseRegistrationFee=rf;
	}
	public void setnumberOfEvents(int e) {
		numberOfEvents=e;
	}
	public void seteventChargePerEvent(double ec) {
		eventChargePerEvent=ec;
	}
	public int getParticipantid() {
		return Participantid;

	}
	public String getname() {
		return name;
	}
	public double getbaseRegistrationFee() {
		return baseRegistrationFee;
	}
	public int getnumberOfEvents() {
		return numberOfEvents;
	}
	public double geteventchargePerFee() {
		return eventChargePerEvent;
	}
	public double TotalFee() {
		return baseRegistrationFee+(numberOfEvents*eventChargePerEvent);

	}
	void display() {
		System.out.println("Participantid:"+Participantid);
		System.out.println("name:"+name);
		System.out.println("baseRegistrationFee:"+baseRegistrationFee);
		System.out.println("numberOfEvents: " + numberOfEvents + " events @ " + eventChargePerEvent + " per event");

		System.out.println("TotalFee"+TotalFee());
	}

}
public class Main {
	public static void main(String[] args) {
		Participant ob=new Participant();
		ob.setParticipantid(501);
		ob.setname("jayasree");
		ob.setbaseRegistrationFee(200);
		ob.setnumberOfEvents(3);
		ob.seteventChargePerEvent(100);
		ob.display();

	}
}
