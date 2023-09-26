package pojo;

public class Booking {
	private String firstname;
	private String lastname;
	private BookingDates bookingdates = new BookingDates();
	private double totalprice;
	private boolean depositpaid;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public boolean isDepositpaid() {
		return depositpaid;
	}

	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	public BookingDates getBookingDates() {
		return bookingdates;
	}

	public void setBookingDates(BookingDates bookingdates) {
		this.bookingdates = bookingdates;
	}
}
