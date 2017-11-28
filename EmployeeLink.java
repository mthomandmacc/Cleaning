
public class EmployeeLink extends Link{
	
	private EmployeeLink next = null;
	private Employee object;
	
	public EmployeeLink(){
		
	}
	public EmployeeLink(Employee employee){
		this.object = employee;
	}
	
	
	@Override
	public Employee getObject(){
		return this.object;
	}
	public EmployeeLink getNext() {
		return next;
	}
	public void setNext(EmployeeLink next) {
		this.next = next;
	}
	public void setObject(Employee object) {
		this.object = object;
	}
	
	
	
	
}
