import java.time.LocalDateTime;

public class TimeClockArray {

	private Employee employee;
	private int ArraySize = 2 * 365;
	private int indexTracker = 0;
	private TimeClockNode[] timeClockArray = new TimeClockNode[ArraySize];
	private LocalDateTime payPeriodStartDate;
	private LocalDateTime payPeriodEndDate; 

	public TimeClockArray(Employee emp) {
		this.employee = emp;
	}

	public void ensureCapacity() {
		TimeClockNode[] temp = new TimeClockNode[ArraySize * 2];

		for (int i = 0; i < ArraySize; i++) {
			temp[i] = timeClockArray[i];
		}
		timeClockArray = temp;
	}

	public void incrementIndexTracker() {
		indexTracker++;
	}

	public int getIndexTracker() {
		return this.indexTracker;
	}

	public TimeClockNode[] getTimeClockArray() {
		return this.timeClockArray;
	}

	public void addEntry(Employee employee,LocalDateTime clockInTime, LocalDateTime clockOutTime) {
	
			if (indexTracker == timeClockArray.length) {
			
				ensureCapacity();
			}
			if(indexTracker == 0){
				this.payPeriodStartDate = clockInTime;
			}
			TimeClockNode timeWorked = new TimeClockNode(clockInTime, clockOutTime, this.employee.getPayRate());
			this.timeClockArray[indexTracker++] = timeWorked;

		
	}
	
	public LocalDateTime getPayPeriodStartDate() {
		return payPeriodStartDate;
	}

	public void setPayPeriodStartDate(LocalDateTime payPeriodStartDate) {
		this.payPeriodStartDate = payPeriodStartDate;
	}

	public LocalDateTime getPayPeriodEndDate() {
		return payPeriodEndDate;
	}

	public void setPayPeriodEndDate(LocalDateTime payPeriodEndDate) {
		this.payPeriodEndDate = payPeriodEndDate;
	}

	protected void resetTracker(){
	
		this.indexTracker = 0;
		
	}
	
	protected void print(){
		for(int i = 0; i < indexTracker; i++){
			System.out.println(this.timeClockArray[i].toString()+"\n");
		}
	}

	public double calculateGrossPay(){
		double grossPay = 0;
		for(int i = 0; i < indexTracker; i++){
		grossPay+=this.timeClockArray[i].getTotalHours()*this.timeClockArray[i].getPayRate()/100.0;
		}
		return grossPay;
	}
	 public double calculateTotalHoursWorked(){
		 double totalHours = 0;
			for(int i = 0; i < indexTracker; i++){
			totalHours+=this.timeClockArray[i].getTotalHours();
			}
			return totalHours;
	 }
}
