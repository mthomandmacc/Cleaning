import java.text.NumberFormat;
import java.time.LocalDateTime;

/**
 * 
 */

/**
 * @author Michael Homan
 *
 */
public class Employee {
	/*
	 *  NOTES  an employee .StartsWork(LocalDateTime) and then .EndsWork(LocalDateTime) the interval is stored in hours worked.  But also a 
	 *  place where it is logged with where they were working. 
	 *  
	 *  we need boolean, isWorking ::currently:: if true then EndsWork() can run, if not then it does nothing.  EndsWork will create an entry in 
	 *  some list or structure  
	 *  
	 *  
	 *  deadlines - track what needs done by a certain point in the week.
	 * 
	 *  instance of a list that is Work to be completed.  boolean tag on each particular worksite instance, of temporary or recurring, 
	 */
	
	private String name;
	private Address address;	
	private String empID; //Unique employee id#
	private LocalDateTime startDate;
	private int payRate; //1500 = 15.00$
	private boolean isDriver; 
	private boolean isCurrentEmployee;
	private CleaningEventList cleaningEvents = new CleaningEventList();
	
	
	
	//////////////////
	/*
	private PayCheckList Paychecks;
	private WorkHistoryList daysWorked
	private UpcomingScheduleList

	*
	*
	*
	*/

public CleaningEventList getCleaningEvents() {
		return cleaningEvents;
	}

	public void setCleaningEvents(CleaningEventList cleaningEvents) {
		this.cleaningEvents = cleaningEvents;
	}

public Employee(String name, Address address, LocalDateTime startDate, int payRate,
			boolean isDriver) {
		super();
		this.name = name;
		this.address = address;
		this.startDate = startDate;
		this.payRate = payRate;
		this.isDriver = isDriver;
	}

public Employee() {
		
	}

public Employee(String name){
	this.name = name;	
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String getEmployeeID() {
		return empID;
	}


	public void setEmployeeID(String empID) {
		this.empID = empID;
	}


	public LocalDateTime getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}


	public int getPayRate() {
		return payRate;
	}


	public void setPayRate(int payRate) {
		this.payRate = payRate;
	}


	public boolean isDriver() {
		return isDriver;
	}

	public void setDriver(boolean isDriver) {
		this.isDriver = isDriver;
	}
	
	private String payRateFormat(){
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String payFormat = formatter.format((payRate/100.0));
	
		return payFormat;
	}
	
	private String payFormat(int hours){
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String payFormat = formatter.format(hours*(payRate/100.0));
	
		return payFormat;
	}
	
	public boolean isCurrentEmployee() {
		return isCurrentEmployee;
	}

	public void setCurrentEmployee(boolean isCurrentEmployee) {
		this.isCurrentEmployee = isCurrentEmployee;
	}

	public void printEmployee(){
		String startDateString = "";
		if(startDate!=null){startDateString = "\nEmployee Start Date: "+startDate.toString();}
		String info  ="Name: "+ this.getName()+
				 "\nEmployee ID:"+ empID+
				startDateString+
				 "\nEmployee Pay Rate: "+payRateFormat()+"/hour"+
				 "\n";
		
		System.out.println(info);
	}
	
}
