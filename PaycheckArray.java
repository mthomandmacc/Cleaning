
public class PaycheckArray {
	private int arraySize = 24;
	private PaycheckNode[] payHistory = new PaycheckNode[arraySize];
	private int paycheckCount = 0;
	private Employee employee;
	public PaycheckArray(Employee employee){
		this.employee = employee;
	}
	

	public void ensureCapacity() {
		PaycheckNode[] temp = new PaycheckNode[arraySize * 2];

		for (int i = 0; i < arraySize; i++) {
			temp[i] = payHistory[i];
		}
		payHistory = temp;
	}
	
	public PaycheckNode[] getPayHistory(){
		return this.payHistory;
	}


	public int getArraySize() {
		return arraySize;
	}


	public int getPaycheckCount() {
		return paycheckCount;
	}


	public Employee getEmployee() {
		return employee;
	}
	
	public void incrementPaycheckCounter(){
		this.paycheckCount++;
	}
	
	public void  printPaychecks(){
		for (int i = 0; i < this.paycheckCount;i++){
			System.out.println(payHistory[i].toString()+"\n");
		}
	}
}
