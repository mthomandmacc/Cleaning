import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 */

/**
 * @author Michael Homan
 *
 */
public class CleaningEvent {

	private WorkSite workSite;

	private LocalTime startTime;
	private LocalTime deadlineTime;

	private LocalDate startDate;
	private LocalDate deadlineDate;

	private int dayOfWeekStart;
	private int dayOfWeekdeadline;

	private boolean isCompleted = false;
	private LocalDateTime completedTime = null;
	private boolean hasEmployeeAssigned;
	private Employee employeeAssigned;

	private String cleaningEventID;

	/**
	 * 
	 * @param workSite
	 * @param startMonth
	 * @param startDateDayOfMonth
	 * @param startDateYear
	 * @param startHour
	 * @param startMinute
	 * @param deadlineMonth
	 * @param deadlineDateDayOfMonth
	 * @param deadlineDateYear
	 * @param deadlineHour
	 * @param deadlineMinute
	 */
	public CleaningEvent(WorkSite workSite, int startMonth, int startDateDayOfMonth, int startDateYear, int startHour,
			int startMinute, int deadlineMonth, int deadlineDateDayOfMonth, int deadlineDateYear, int deadlineHour,
			int deadlineMinute) {
		this.workSite = workSite;
		this.startTime = LocalTime.of(startHour, startMinute);
		this.deadlineTime = LocalTime.of(deadlineHour, deadlineMinute);
		this.startDate = LocalDate.of(startDateYear, startMonth, startDateDayOfMonth);
		this.deadlineDate = LocalDate.of(deadlineDateYear, deadlineMonth, deadlineDateDayOfMonth);

	}

	public CleaningEvent(WorkSite workSite, LocalDate startDate, LocalTime startTime, LocalDate deadlineDate,
			LocalTime deadlineTime) {

		this.workSite = workSite;
		this.startTime = startTime;
		this.deadlineTime = deadlineTime;
		this.startDate = startDate;
		this.deadlineDate = deadlineDate;

	}

	/**
	 * Empty Cleaning Event constructor
	 */
	public CleaningEvent() {

	}

	public WorkSite getWorkSite() {
		return workSite;
	}

	public void setWorkSite(WorkSite workSite) {
		this.workSite = workSite;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getDeadlineTime() {
		return deadlineTime;
	}

	public void setDeadlineTime(LocalTime deadlineTime) {
		this.deadlineTime = deadlineTime;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(LocalDate deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public int getDayOfWeekStart() {
		return dayOfWeekStart;
	}

	public void setDayOfWeekStart(int dayOfWeekStart) {
		this.dayOfWeekStart = dayOfWeekStart;
	}

	public int getDayOfWeekdeadline() {
		return dayOfWeekdeadline;
	}

	public void setDayOfWeekdeadline(int dayOfWeekdeadline) {
		this.dayOfWeekdeadline = dayOfWeekdeadline;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public boolean isHasEmployee() {
		return hasEmployeeAssigned;
	}

	public void setHasEmployee(boolean hasEmployee) {
		this.hasEmployeeAssigned = hasEmployee;
	}

	public Employee getEmployeeAssigned() {
		return employeeAssigned;
	}

	public void setEmployeeAssigned(Employee employeeAssigned) {
		this.employeeAssigned = employeeAssigned;
	}

	public LocalDateTime getCompletedTime() {
		return completedTime;
	}

	public void setCompletedTime(LocalDateTime completedTime) {
		this.completedTime = completedTime;
	}

	public boolean isHasEmployeeAssigned() {
		return hasEmployeeAssigned;
	}

	public void setHasEmployeeAssigned(boolean hasEmployeeAssigned) {
		this.hasEmployeeAssigned = hasEmployeeAssigned;
	}

	public String getCleaningEventID() {
		return this.cleaningEventID;
	}

	public void setCleaningEventID(String id) {
		this.cleaningEventID = id;
	}

	public void print() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a");

		System.out.println("ID: " + this.cleaningEventID + "\nWork Site: " + this.workSite.getTitle());
		if (this.hasEmployeeAssigned) {
			System.out.println("Employee Assigned: " + this.employeeAssigned.getName() + "\nEmployee ID: "
					+ this.employeeAssigned.getEmployeeID());
		}
		System.out.println("Start date: " + dateFormat.format(this.startDate) + "\nStart time: "
				+ timeFormat.format(this.startTime) + "\n------------------------" + "\nDeadline date: "
				+ dateFormat.format(this.deadlineDate) + "\nDeadline time: " + timeFormat.format(this.deadlineTime)
				+ "\n");
	}
}
