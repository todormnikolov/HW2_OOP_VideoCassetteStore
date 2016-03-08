import java.time.LocalDate;

public class VideoCassette {

	private int cassetteId;
	private String title;
	private LocalDate takenOn;
	private LocalDate takenTo;
	private int takenBy = 0;
	private static int id = 1;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getTakenOn() {
		return takenOn;
	}

	public void setTakenOn(LocalDate takenOn) {
		this.takenOn = takenOn;
	}

	public LocalDate getTakenTo() {
		return takenTo;
	}

	public void setTakenTo(LocalDate takenTo) {
		this.takenTo = takenTo;
	}

	public VideoCassette(String title) {
		this.cassetteId = id++;
		this.title = title;
	}

	public void getVideoCassette(Account acc) {
		this.takenBy = acc.getAccountId();
		setTakenOn(LocalDate.now());
		setTakenTo(this.takenOn.plusDays(3));
	}

	public void returnVideoCassette(Account acc) {
		if (this.takenBy == acc.getAccountId()) {
			this.takenBy = 0;
			this.takenOn = null;
			this.takenTo = null;
		}
	}

	public void printInfo() {
		String takenOn = "";
		String takenTo = "";
		String takenBy = "";
		
		if (this.takenOn != null) {
			takenOn = this.getTakenOn().toString();
			takenTo = this.getTakenTo().toString();
			takenBy = "" + this.takenBy;
		}else{
			takenOn = "";
			takenTo = "";
			takenBy = "";
		}

		System.out.printf("ID\tTitle\t\t\tTaken On\tTaken To\tTaken By\n");
		System.out.println("____________________________________________________________________________");
		System.out.printf("%d\t%s\t\t%s\t%s\t%s\n", this.cassetteId, getTitle(), takenOn, takenTo, takenBy);
	}

}
