import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 */

/**
 * @author Michael Homan
 *
 */
public class Employee {
	/*
	 * NOTES an employee .StartsWork(LocalDateTime) and then
	 * .EndsWork(LocalDateTime) the interval is stored in hours worked. But also
	 * a place where it is logged with where they were working.
	 * 
	 * we need boolean, isWorking ::currently:: if true then EndsWork() can run,
	 * if not then it does nothing. EndsWork will create an entry in some list
	 * or structure
	 * 
	 * 
	 * deadlines - track what needs done by a certain point in the week.
	 * 
	 * instance of a list that is Work to be completed. boolean tag on each
	 * particular worksite instance, of temporary or recurring,
	 */
	private boolean isCurrentEmployee = true;
	private String name;
	private Address address;
	private String phoneNumber;

	private String empID; // Unique employee id#
	private LocalDateTime startDate;
	private LocalDateTime leavingDate;

	private int payRate; // 1500 = 15.00$
	private boolean isDriver;

	private CleaningEventList upcomingCleaningEvents = new CleaningEventList();
	private CleaningEventList completedCleaningEvents = new CleaningEventList();
	private WorkSiteList employeesWorkSites = new WorkSiteList();

	private LocalDateTime clockInTime;

	private TimeClockArray timeClockHistory = new TimeClockArray(this);
	private TimeClockArray timeClockCurrentPayPeriod = new TimeClockArray(this);

	private PaycheckArray paychecks = new PaycheckArray(this);

	public PaycheckArray getPaychecks() {
		return paychecks;
	}

	private boolean isClockedIn = false;

	//////////////////
	/*
	 * private PayCheckList Paychecks; private WorkHistoryList daysWorked
	 * private UpcomingScheduleList
	 *
	 *
	 *
	 * 
	 */

	public CleaningEventList getUpcomingCleaningEvents() {
		return upcomingCleaningEvents;
	}

	/**
	 * 
	 * @return List of completed cleaning events
	 */
	public CleaningEventList getCompletedCleaningEvents() {
		return completedCleaningEvents;
	}

	public Employee(String name, Address address, LocalDateTime startDate, int payRate, boolean isDriver) {
		super();
		this.name = name;
		this.address = address;
		this.startDate = startDate;
		this.payRate = payRate;
		this.isDriver = isDriver;
	}

	/**
	 * 
	 * @param name
	 */
	public Employee(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public WorkSiteList getEmployeesWorkSites() {
		return employeesWorkSites;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * 
	 * @return Employee's current phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * 
	 * @return
	 */
	public String getEmployeeID() {
		return empID;
	}

	protected void setEmployeeID(String empID) {
		this.empID = empID;
	}

	/**
	 * 
	 * @return date employee started
	 */
	public LocalDateTime getStartDate() {
		return startDate;
	}

	/**
	 * 
	 * @param startDate
	 */
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	/**
	 * 
	 * @return hourly payrate in cents ($.01) move 2 decimal places to get
	 *         hourly wage in dollars
	 */
	public int getPayRate() {
		return payRate;
	}

	/**
	 * 
	 * @param payRate
	 */
	public void setPayRate(int payRate) {
		this.payRate = payRate;
	}

	/**
	 * 
	 * @return true if the employee is certified/verified/qualified to drive
	 *         work vehicles
	 */
	public boolean isDriver() {
		return isDriver;
	}

	public void setDriver(boolean isDriver) {
		this.isDriver = isDriver;
	}

	public void clockIn() {
		if (!isClockedIn) {

			this.clockInTime = LocalDateTime.now();
			isClockedIn = true;
		}
		// else
		// Employee is already clocked in
	}

	/*
	 * For testing / driver purposes only
	 */
	public void clockIn(LocalDateTime timeIn) {
		if (!isClockedIn) {

			this.clockInTime = timeIn;
			isClockedIn = true;

		}
	}

	/**
	 * Allows the employee to punch out. This action logs the hours worked in
	 * two arrays One array will hold the employees hours
	 */
	public void clockOut() {
		if (isClockedIn) {
			// Initialize a new TimeClockNode to add to our
			// Array which tracks all of our shifts worked.
			LocalDateTime clockOutTime = LocalDateTime.now();
			this.timeClockCurrentPayPeriod.addEntry(this,this.clockInTime, clockOutTime);
			this.timeClockHistory.addEntry(this,this.clockInTime, clockOutTime);
			this.clockInTime = null;
			this.isClockedIn = false;
		}
		// else
		// Employee is not clocked in
	}

	/**
	 * For testing purposes only
	 * 
	 * @param timeOut
	 */
	public void clockOut(LocalDateTime timeOut) {
		if (isClockedIn) {

			// Initialize a new TimeClockNode to add to our
			// Array which tracks all of our shifts worked.
			LocalDateTime clockOutTime = timeOut;
			this.timeClockCurrentPayPeriod.addEntry(this, this.clockInTime, clockOutTime);
			this.timeClockHistory.addEntry(this, this.clockInTime, clockOutTime);
			this.clockInTime = null;
			this.isClockedIn = false;

		}
		// else
		// Employee is not clocked in
	}

	protected void addWorksite(WorkSite newSite) {
		this.employeesWorkSites.insert(newSite);
		this.employeesWorkSites.removeDuplicates();
	}

	private String payRateFormat() {

		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String payFormat = formatter.format((payRate / 100.0));

		return payFormat;
	}

	private String payFormat(int hours) {

		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String payFormat = formatter.format(hours * (payRate / 100.0));

		return payFormat;
	}

	public boolean isCurrentEmployee() {
		return isCurrentEmployee;
	}

	public void setCurrentEmployee(boolean isCurrentEmployee) {
		this.isCurrentEmployee = isCurrentEmployee;
	}

	public TimeClockArray getTimeClockHistory() {
		return timeClockHistory;
	}

	public TimeClockArray getTimeClockCurrentPayPeriod() {
		return timeClockCurrentPayPeriod;
	}

	public boolean isClockedIn() {
		return isClockedIn;
	}

	/**
	 * prints employee information
	 */
	public void print() {
		String startDateString = "";
		String leavingDateString = "";

		if (startDate != null) {

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			startDateString = "\nEmployee Start Date: " + startDate.format(dtf);

		}
		if (!isCurrentEmployee) {

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			leavingDateString = "\nEmployee Leavning Date: " + this.leavingDate.format(dtf);
		}
		String info = "Name: " + this.getName() + "\nEmployee ID:" + empID + startDateString + leavingDateString
				+ "\nEmployee Pay Rate: " + payRateFormat() + "/hour" + "\n" + "";

		System.out.println(info);
	}

	/**
	 * prints each time card node for the current pay period
	 */
	public void printTimeCardCurrent() {

		this.timeClockCurrentPayPeriod.print();
	}

	/**
	 * prints time clock node for each shift the employee has ever worked
	 */
	public void printTimeClockHistoryAllTime() {
		this.timeClockHistory.print();
	}

}
