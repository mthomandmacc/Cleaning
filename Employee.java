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
	boolean isDriver; 
	
	
	public Employee(){
		
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


	public String getEmpID() {
		return empID;
	}


	public void setEmpID(String empID) {
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
	
	
}
