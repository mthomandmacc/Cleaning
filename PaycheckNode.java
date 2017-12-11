import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;

public class PaycheckNode {

	private TimeClockArray payPeriodHoursWorked;
	private double totalHoursWorked;
	private double grossPay;
	private Employee employee;

	public PaycheckNode(TimeClockArray currentPayPeriod, Employee employee) {
		this.employee = employee;
		this.payPeriodHoursWorked = currentPayPeriod;
		totalHoursWorked = currentPayPeriod.calculateTotalHoursWorked();
		grossPay = currentPayPeriod.calculateGrossPay();

	}

	public TimeClockArray getPayPeriodHoursWorked() {
		return payPeriodHoursWorked;
	}

	public void setPayPeriodHoursWorked(TimeClockArray payPeriodHoursWorked) {
		this.payPeriodHoursWorked = payPeriodHoursWorked;
	}

	public double getTotalHoursWorked() {
		return totalHoursWorked;
	}

	public void setTotalHoursWorked(double totalHoursWorked) {
		this.totalHoursWorked = totalHoursWorked;
	}

	public double getGrossPay() {
		return grossPay;
	}

	public void setGrossPay(double grossPay) {
		this.grossPay = grossPay;
	}

	private String payRateFormat() {

		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String payFormat = formatter.format(grossPay);

		return payFormat;
	}

	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return "Name: " + this.employee.getName() + "\nPay Period Start Date: "+ this.payPeriodHoursWorked.getPayPeriodStartDate().format(dtf)+ "\nPay Period End Date: "+ this.payPeriodHoursWorked.getPayPeriodEndDate().format(dtf)+"\nTotal Hours: " + this.totalHoursWorked + "\nGross Pay: "
				+ payRateFormat();
	}

}
