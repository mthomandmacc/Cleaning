import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeClockNode {


	private LocalDateTime clockIn;
	private LocalDateTime clockOut;
	private double totalHours;
	private int employeePayRate;

	protected TimeClockNode(LocalDateTime clockInTime, LocalDateTime clockOutTime, int empPayRate) {

		
		this.clockIn = clockInTime;
		this.clockOut = clockOutTime;
		this.employeePayRate = empPayRate;
		int minutesWorked = (int) clockInTime.until(clockOutTime, ChronoUnit.MINUTES);
		int hoursWorked = minutesWorked / 60;
		int remainder = minutesWorked % 60;
		double quarterHour = 0;

		if (remainder >= 0 && remainder < 8) {
			quarterHour = 0;
		} else if (remainder >= 8 && remainder < 23) {
			quarterHour = .25;
		} else if (remainder >= 8 && remainder < 38) {
			quarterHour = .50;
		} else if (remainder >= 38 && remainder < 52) {
			quarterHour = .75;
		} else if (remainder >= 52 && remainder <= 60) {
			quarterHour = 1;
		}

		this.totalHours = hoursWorked + quarterHour;

	}

	private String payRateFormat() {

		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String payFormat = formatter.format((this.employeePayRate / 100.0));

		return payFormat;
	}

	public String toString() {
		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("hh:mm a");
		return "Date Clocked In: " + this.clockIn.format(formatterDate) + "\nTime Clocked In: "
				+ this.clockIn.format(formatterTime) + "\nDate Clocked Out: " + this.clockOut.format(formatterDate)
				+ "\nTime Clocked Out: " + this.clockOut.format(formatterTime) + "\nHours Worked: " + totalHours
				+ "\nPay Rate: " + payRateFormat()+"/hr";

	}
	
	public double getTotalHours(){
		return this.totalHours;
	}
	public int getPayRate(){
		return this.employeePayRate;
	}

}
