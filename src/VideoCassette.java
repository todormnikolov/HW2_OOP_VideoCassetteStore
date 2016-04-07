import java.time.LocalDate;

public class VideoCassette {

	private int cassetteId;
	private String title;
	private LocalDate takenOn;
	private LocalDate takenTo;
	private int takenBy = 0;
	private static int id = 1;

	public VideoCassette(String title) {
		this.cassetteId = id++;
		setTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title.equals("")) {
			this.title = "Video cassette " + this.getCassetteId();
		} else {
			this.title = title;
		}
	}

	public int getCassetteId() {
		return cassetteId;
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

	public int getTakenBy() {
		return takenBy;
	}

	public void setTakenTo(LocalDate takenTo) {
		this.takenTo = takenTo;
	}

	public boolean isReturned() {
		if (this.takenOn == null) {
			return true;
		}

		return false;
	}

	public VideoCassette getVideoCassette(Account acc) {
		this.takenBy = acc.getAccountId();
		setTakenOn(LocalDate.now());
		setTakenTo(this.takenOn.plusDays(3));

		return this;
	}

	public VideoCassette returnVideoCassette(Account acc) {
		if (this.isReturned()) {
			System.out.println("The video cassette is not taken");
		} else {

			if (this.takenBy == acc.getAccountId()) {
				this.takenBy = 0;
				this.takenOn = null;
				this.takenTo = null;
			} else {
				System.out.println("This account is not take that video cassette");
			}
		}
		return this;
	}

	public void printInfo() {
		String takenOn = "";
		String takenTo = "";
		String takenBy = "";

		if (this.takenOn != null) {
			takenOn = this.getTakenOn().toString();
			takenTo = this.getTakenTo().toString();
			takenBy = "" + this.takenBy;
		}

		System.out.printf("%d - Title: %s, Taken On: %s, Taken To: %s\n", this.cassetteId, getTitle(), takenOn,
				takenTo);
	}

	public void printInfoWithAccountId() {
		String takenOn = "";
		String takenTo = "";
		String takenBy = "";

		if (this.takenOn != null) {
			takenOn = this.getTakenOn().toString();
			takenTo = this.getTakenTo().toString();
			takenBy = "" + this.takenBy;
		}

		System.out.printf("%d - Title: %s, Taken On: %s, Taken To: %s, Taken By: %s\n", this.cassetteId, getTitle(),
				takenOn, takenTo, takenBy);
	}
}
