import java.time.LocalDateTime;

public class EmployeeList extends LinkedList {

	private static int EmployeeID = 900000;
	private EmployeeLink first;
	private int size = 0;
	public EmployeeList() {

	}

	public EmployeeList(EmployeeLink first) {
		this.first = first;
	}
 
	/*
	 * public Link mergeSort(EmployeeLink headRef){
	 * 
	 * 
	 * //Link<Employee> head = headRef; EmployeeLink a, b = headRef;
	 * 
	 * if (headRef == null || headRef.getNext() == null){ return
	 * headRef;//break, no more sorting needed }
	 * 
	 * while(b!=null&&b.getNext()!=null){
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * if(this.first!=null){ EmployeeLink current = this.first;
	 * while(this.first.getNext()!=null){
	 * 
	 * }
	 * 
	 * 
	 * } }
	 */

	public void addEmployee(String name, Address address, LocalDateTime startDate, int payRate, boolean isDriver) {
		Employee newEmployee = new Employee(name, address, startDate, payRate, isDriver);
		EmployeeLink newLink = new EmployeeLink(newEmployee);
		newEmployee.setEmployeeID(EmployeeID++);

		if (this.first == null) {
			this.first = newLink;
		} else {
			EmployeeLink current = first;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newLink);
		}
		size++;
	}
	
	
	

	private EmployeeLink getMiddle(EmployeeLink startLink) {

		if (startLink == null) {
			return startLink;
		}

		EmployeeLink pointer1 = startLink;
		EmployeeLink pointer2 = startLink;

		while (pointer2 != null && pointer2.getNext() != null && pointer2.getNext().getNext() != null) {
		
			pointer1 = pointer1.getNext();
			pointer2 = pointer2.getNext().getNext();

		}
	
		return pointer1;

	}
	
	
	public void sortByNameAscending(){
		EmployeeLink temp = this.first;
		 first =  mergeSort(temp, 1);
	}
public void sortByNameDescending(){
	EmployeeLink temp = this.first;
	 first =  mergeSort(temp, 2);
	}
public void sortByStartDateAscending(){
	EmployeeLink temp = this.first;
	 first =  mergeSort(temp, 3);
}
public void sortByStartDateDescending(){
	EmployeeLink temp = this.first;
	 first =  mergeSort(temp, 4);
}
public void sortByPayRateAscending(){
	EmployeeLink temp = this.first;
	 first =  mergeSort(temp, 5);
}
public void sortByPayRateDescending(){
	EmployeeLink temp = this.first;
	 first =  mergeSort(temp, 6);
}

	private EmployeeLink mergeSort(EmployeeLink head, int sortByField){
		//If list is partitioned fully - return head
		if(head==null || head.getNext() == null) {
			return head;
		}
		//Find the middle link in the current list
		EmployeeLink middle =getMiddle(head);
		//We will split the current list in half, set the head of the second half
		EmployeeLink secondHead = middle.getNext();
		//Now we break the link between the first list and the second list so they are completely disconnected.
		middle.setNext(null);
		
		//Now we merge the two seperate lists
		
		if(sortByField == 1){
		return mergeListsByNameAscending(mergeSort(head,sortByField), mergeSort(secondHead, sortByField));
		} else if(sortByField == 2){
		return mergeListsByNameDescending(mergeSort(head, sortByField), mergeSort(secondHead, sortByField));
		} else if(sortByField == 3){
		return mergeListsByStartDateAscending(mergeSort(head, sortByField), mergeSort(secondHead, sortByField));
		} else if(sortByField == 4){
		return mergeListsByStartDateDescending(mergeSort(head, sortByField), mergeSort(secondHead, sortByField));
		} else if(sortByField == 5){
		return mergeListsByPayRateAscending(mergeSort(head, sortByField), mergeSort(secondHead, sortByField));
		} else if(sortByField == 6){
		return mergeListsByPayRateDescending(mergeSort(head, sortByField), mergeSort(secondHead, sortByField));
		}
		else {
			return null;
		}
	}
	
	private EmployeeLink mergeListsByNameAscending(EmployeeLink link1, EmployeeLink link2){
		if(link1==null){
			return link2;
		}
		if(link2==null){
			return link1;
		}
		
		if(link1.getObject().getName().compareTo(link2.getObject().getName())>0){
			 link2.setNext(mergeListsByNameAscending(link1, link2.getNext()));
			 return link2;
		} else {
			link1.setNext(mergeListsByNameAscending(link1.getNext(), link2));
			return link1;
		}
		
	}
	
	private EmployeeLink mergeListsByNameDescending(EmployeeLink link1, EmployeeLink link2){
		if(link1==null){
			return link2;
		}
		if(link2==null){
			return link1;
		}
		
		
		if(link1.getObject().getName().compareTo(link2.getObject().getName())<=0){
			link2.setNext(mergeListsByNameDescending(link1, link2.getNext()));
			return link2;
		} else {
			link1.setNext(mergeListsByNameDescending(link1.getNext(), link2));
			return link1; 
		}
	}
	private EmployeeLink mergeListsByStartDateAscending(EmployeeLink link1, EmployeeLink link2){
		if(link1==null){
			return link2;
		}
		if(link2==null){
			return link1;
		}
		
		if(link1.getObject().getStartDate().isBefore(link2.getObject().getStartDate())){
			 link2.setNext(mergeListsByStartDateAscending(link1, link2.getNext()));
			 return link2;
		} else {
			link1.setNext(mergeListsByStartDateAscending(link1.getNext(), link2));
			return link1;
		}
	}
	private EmployeeLink mergeListsByStartDateDescending(EmployeeLink link1, EmployeeLink link2){
		if(link1==null){
			return link2;
		}
		if(link2==null){
			return link1;
		}
		
		if(link1.getObject().getStartDate().isAfter(link2.getObject().getStartDate())){
			 link2.setNext(mergeListsByStartDateDescending(link1, link2.getNext()));
			 return link2;
		} else {
			link1.setNext(mergeListsByStartDateDescending(link1.getNext(), link2));
			return link1;
		}
	}
	private EmployeeLink mergeListsByPayRateAscending(EmployeeLink link1, EmployeeLink link2){
		if(link1==null){
			return link2;
		}
		if(link2==null){
			return link1;
		}
		
		if(link1.getObject().getPayRate()>link2.getObject().getPayRate()){
			 link2.setNext(mergeListsByPayRateAscending(link1, link2.getNext()));
			 return link2;
		} else {
			link1.setNext(mergeListsByPayRateAscending(link1.getNext(), link2));
			return link1;
		}
	}
	private EmployeeLink mergeListsByPayRateDescending(EmployeeLink link1, EmployeeLink link2){
		if(link1==null){
			return link2;
		}
		if(link2==null){
			return link1;
		}
		
		if(link1.getObject().getPayRate()<link2.getObject().getPayRate()){
			 link2.setNext(mergeListsByPayRateDescending(link1, link2.getNext()));
			 return link2;
		} else {
			link1.setNext(mergeListsByPayRateDescending(link1.getNext(), link2));
			return link1;
		}
	}
	
	private int getLength(EmployeeLink startingLink) {
		int count = 0;

		EmployeeLink current = startingLink;
		while (current != null) {
			count++;
			current = current.getNext();
		}
		return count;
	}

	public EmployeeLink getFirst() {
		return first;
	}

	public void setFirst(EmployeeLink first) {
		this.first = first;
	}

	// need to add the add mehtod to employeelist

	public int size() {
		int size = 0;
		EmployeeLink current = first;
		if (this.first != null) {
			size++;
		}
		while (current.getNext() != null) {
			size++;
			current = current.getNext();
		}
		return size;
	}
	
public EmployeeLink removeEmployee(int EmployeeID){
	EmployeeLink previous=null;
	EmployeeLink current = this.first;
	
	while(current!=null){
		if(EmployeeID==current.getObject().getEmployeeID())
		{
			if(previous==null){
				this.size--;
				this.first=current.getNext();
				return current;
			} else{
				//remove the current link by linking previous to current's next link
				this.size--;
				previous.setNext(current.getNext());
				return current;
			}
		}
		previous = current;
		current = current.getNext();
	}
	//didn't find matching employee to remove
	return null;
}

	public void print() {
		EmployeeLink current = first;
		if (current != null) {
			current.getObject().printEmployee();
		}
		while (current.getNext() != null) {

			current = current.getNext();
			current.getObject().printEmployee();

		}
	}

	

}
