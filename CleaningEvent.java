import java.time.LocalDateTime;

/**
 * 
 */

/**
 * @author Michael Homan
 *
 */
public class CleaningEvent {
	
	private WorkSite workSite;
	private LocalDateTime startTime;
	private LocalDateTime deadLine;
	private boolean isRecurring = false; //if false, then this only occurs once.  if true then it will be added to a list of recurring events
	private int recurrenceInterval;	//once a week? twice a week?
	private boolean isCompleted = false;
	
	public CleaningEvent(WorkSite workSite, LocalDateTime startTime, LocalDateTime deadLine, boolean isRecurring,
			int recurrenceInterval) {

		this.workSite = workSite;
		this.startTime = startTime;
		this.deadLine = deadLine;
		this.isRecurring = isRecurring;
		this.recurrenceInterval = recurrenceInterval;
	
	}
	
	public CleaningEvent(WorkSite workSite, LocalDateTime startTime, LocalDateTime deadLine) {
	
		this.workSite = workSite;
		this.startTime = startTime;
		this.deadLine = deadLine;
	
	}

	public CleaningEvent() {
	
	}

	public WorkSite getWorkSite() {
		return workSite;
	}

	public void setWorkSite(WorkSite workSite) {
		this.workSite = workSite;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(LocalDateTime deadLine) {
		this.deadLine = deadLine;
	}

	public boolean isRecurring() {
		return isRecurring;
	}

	public void setRecurring(boolean isRecurring) {
		this.isRecurring = isRecurring;
	}

	public int getRecurrenceInterval() {
		return recurrenceInterval;
	}

	public void setRecurrenceInterval(int recurrenceInterval) {
		this.recurrenceInterval = recurrenceInterval;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	
	
}
