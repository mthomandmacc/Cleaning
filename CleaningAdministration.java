import java.time.LocalDateTime;

public class CleaningAdministration {

	private CleaningEventList masterCleaningEventList = new CleaningEventList();
	
	// Our master list of current and past employees
	private EmployeeList masterEmployeeList = new EmployeeList();
	// List of employees presently employed with us
	private EmployeeList currentEmployees = new EmployeeList();

	private WorkSiteList ourWorkSites = new WorkSiteList();
	
	// Static id number that increments with each new hire
	private static int employeeIDNumber = 9000;
	private String employeeID = "EMP" ;

	private static int workSiteIDNumber = 200;
	private static int cleaningEventID = 44000;

	public void addEmployee(String name, Address address, LocalDateTime startDate, int payRate, boolean isDriver) {
		Employee newEmployee = new Employee(name, address, startDate, payRate, isDriver);
		EmployeeLink newLink = new EmployeeLink(newEmployee);
		newEmployee.setEmployeeID(employeeID+employeeIDNumber);
		employeeIDNumber++;
		
		//insert our newly created employee to both of our lists
		masterEmployeeList.insert(newLink);
		currentEmployees.insert(newLink);

		//increment the size counter on each of our lists
		this.currentEmployees.incrementSize();
		this.masterEmployeeList.incrementSize();

	}

	
	
	public void addCleaningEvent(WorkSite workSite, int startMonth, int startDateDayOfMonth, int startDateYear,
			int startHour, int startMinute, int deadlineMonth, int deadlineDateDayOfMonth, int deadlineDateYear,
			int deadlineHour, int deadlineMinute) {

		CleaningEvent newEvent = new CleaningEvent(workSite, startMonth, startDateDayOfMonth, startDateYear, startHour,
				startMinute, deadlineMonth, deadlineDateDayOfMonth, deadlineDateYear, deadlineHour, deadlineMinute);
		CleaningEventLink newEventLink = new CleaningEventLink(newEvent);
		
		masterCleaningEventList.insert(newEventLink);
		
	}
	
	
	
	/**
	 * Here is a constructor that takes quite a lot of parameters, this is to cut down on the need to
	 * create individual instances of WorkSite, Address, and the various LocalDate/LocalTime objects
	 * 
	 * This version of the constructor is like this for testing purposes/for the driver
	 * 
	 * @param employeeAssigned Employee who is assigned this cleaning event
	 * @param workSiteTitle The name of the work location
	 * @param workSiteCity City work site is located in
	 * @param workSiteState State work site is located in
	 * @param workSiteStreetAddress Street address of the work site
	 * @param workSiteZipCode Zip code of the work site
	 * @param workSiteHasSecurityCode True if there is a security code
	 * @param workSiteSecurityCode null if no security code, otherwise the security code for the work site
	 * @param startMonth The month the cleaning event becomes available (3 for March)
	 * @param startDateDayOfMonth The day of the month the cleaning event becomes available (23 for the 23rd)
	 * @param startDateYear The year the cleaning event becomes available (1988)
	 * @param startHour The hour the cleaning event becomes available (3 for 3:00AM / 22 for 10:00PM)
	 * @param startMinute The minute of the hour the cleaning event becomes available, becomes available becomes avail..lah..blah
	 * @param deadlineMonth The month the date the cleaning event must be completed by
	 * @param deadlineDateDayOfMonth The day the cleaning event must be completed by
	 * @param deadlineDateYear The year the cleaning event must be completed by
	 * @param deadlineHour The hour the cleaning event must be completed by
	 * @param deadlineMinute The minute the cleaning event must be completed by
	 */
	public void addCleaningEvent(Employee employeeAssigned, String workSiteTitle, String workSiteCity, String workSiteState, String workSiteStreetAddress, String workSiteZipCode,boolean workSiteHasSecurityCode, String workSiteSecurityCode, int startMonth, int startDateDayOfMonth, int startDateYear,
			int startHour, int startMinute, int deadlineMonth, int deadlineDateDayOfMonth, int deadlineDateYear,
			int deadlineHour, int deadlineMinute) {
		
		Address workSiteAddress = new Address(workSiteCity, workSiteState, workSiteStreetAddress,workSiteZipCode);
		WorkSite newWorkSite = new WorkSite(workSiteTitle,workSiteAddress,workSiteHasSecurityCode);
		if(workSiteHasSecurityCode){
			newWorkSite.setSecurityCode(workSiteSecurityCode);
		}
		
		
		CleaningEvent newEvent = new CleaningEvent(newWorkSite, startMonth, startDateDayOfMonth, startDateYear, startHour,
				startMinute, deadlineMonth, deadlineDateDayOfMonth, deadlineDateYear, deadlineHour, deadlineMinute);
		
		
		
		
		CleaningEventLink newEventLink = new CleaningEventLink(newEvent);
		
		employeeAssigned.getCleaningEvents().insert(newEventLink);
		
		masterCleaningEventList.insert(newEventLink);
		
	}
	
	
	


	public EmployeeList getCurrentEmployees() {
		return currentEmployees;
	}

	public void setCurrentEmployees(EmployeeList currentEmployees) {
		this.currentEmployees = currentEmployees;
	}

	public CleaningEventList getMasterCleaningEventList() {
		return masterCleaningEventList;
	}

	public EmployeeList getMasterEmployeeList() {
		return masterEmployeeList;
	}

	/**
	 * 
	 * @param EmployeeID
	 *            ID that is linked to the employee we are searching for
	 * @return Employee whose ID matches the string parameter
	 */



	private EmployeeLink findEmp(String EmployeeID) {
		// we will search through the master list of all employees
		EmployeeLink current = this.masterEmployeeList.getFirst();
		while (current.getNext() != null) {
			if (current.getObject().getEmployeeID().equals(EmployeeID)) {
				return current;
			}
			current = current.getNext();

		}
		// else return null
		return null;
	}

	public void printEmpEvents(String EmployeeID) {

	}

}
