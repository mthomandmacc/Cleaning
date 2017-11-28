import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
	
	public CleaningEvent(WorkSite workSite, int startMonth, int startDateDayOfMonth, int startDateYear, int startHour, int startMinute, int deadlineMonth, int deadlineDateDayOfMonth, int deadlineDateYear, int deadlineHour, int deadlineMinute) {
		this.workSite = workSite;
		this.startTime = LocalTime.of(startHour, startMinute);
		this.deadlineTime = LocalTime.of(deadlineHour, deadlineMinute);
		this.startDate = LocalDate.of(startDateYear, startMonth, startDateDayOfMonth);
		this.deadlineDate = LocalDate.of(deadlineDateYear, deadlineMonth, deadlineDateDayOfMonth);
			
	}
	
	public CleaningEvent(WorkSite workSite, LocalDate startDate, LocalTime startTime, LocalDate deadlineDate, LocalTime deadlineTime) {
	
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
		
}
