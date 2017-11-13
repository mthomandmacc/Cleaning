import java.time.LocalDateTime;

public class EmployeeList extends LinkedList {

	private static int EmployeeID = 900000;
	private EmployeeLink first;
	
	public EmployeeList() {

	}
	public EmployeeList(EmployeeLink first){
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
	
	public void addEmployee(String name, Address address, LocalDateTime startDate, int payRate, boolean isDriver){
		Employee newEmployee = new Employee(name, address, startDate, payRate, isDriver);
		EmployeeLink newLink = new EmployeeLink(newEmployee);
		newEmployee.setEmployeeID(EmployeeID++);
		
		if(this.first==null){
			this.first = newLink;
		}
		else
		{
			EmployeeLink current = first;
			while(current.getNext()!=null){
				current = current.getNext();
			}
			current.setNext(newLink);
		}
		
	}
	
	public int getLength(EmployeeLink startingLink){
		int count = 0;
		
		EmployeeLink current = startingLink;
		while(current!=null){
			count++;
			current = current.getNext();
		}
		return count;
	}
	
	int count = 0;
	public EmployeeLink mergeSort(EmployeeLink a){
		EmployeeLink oldHead = a;
		EmployeeLink newHead;
		EmployeeLink temp1;
		EmployeeLink temp2;
		//find the size/length of the list
		
		int mid = getLength(a)/2;
		
		if(a==null||
				a.getNext()==null){
			return a;
		}
		
		//set our pointer to the beginning of list, and one after mid
		//We move it to the mid point
		while(mid-1>0){
			oldHead= oldHead.getNext();
			mid--;
		}
	
		newHead = oldHead.getNext();
		
		oldHead.setNext(null); 	//breaking the list
		oldHead = a;		//bring back the oldHead
		
		if(oldHead.getNext()==null){
		temp1=oldHead;
		}
		else{
			temp1=  mergeSort(oldHead);
		}
		
		if(newHead.getNext()==null){
			temp2 = newHead;
		} else{
		temp2 = mergeSort(newHead);
		}
		
		return mergeListByName(temp1,temp2);
		
		
	}
	
	private EmployeeLink mergeListByName(EmployeeLink link1, EmployeeLink link2){
		//System.out.println(count++);
		EmployeeLink result = null;
		if(link1 == null){
			return link2;
		}
		if(link2==null){
			return link1;
		}
		
		if(link1.getObject().getName().compareTo(link2.getObject().getName())<0){
			result = link2;
			result.setNext(mergeListByName(link1,link2.getNext()));		
			
		} else{
			result = link1;
			result.setNext((mergeListByName(link1.getNext(),link2)));
		}
		return result;
	
		
	}
	/*
	private void recMergeSort(int[] workSpace, int lowerBound, int upperBound){
		
		if(lowerBound == upperBound){
			return;
		}
		
		else {
			int mid = (lowerBound+upperBound) /2;
			
			recMergeSort(workSpace, lowerBound, mid);
			
			recMergeSort(workSpace,mid+1, upperBound);
			
		}
		
		
		/*
		if(headOriginal==null||headOriginal.getNext()==null){
			return headOriginal;
		}
		EmployeeLink a = headOriginal;
		EmployeeLink b = headOriginal;
		while(b!=null&&b.getNext()!=null){
			headOriginal = headOriginal.getNext();
			b = b.getNext().getNext();
		}
		b = headOriginal.getNext();
		headOriginal.setNext(null);
		return Merge(MergeSort(a), MergeSort(b));
	}
		*/
	
	
	
	public EmployeeLink Merge(EmployeeLink a, EmployeeLink b) {
		EmployeeLink temp = new EmployeeLink();
		EmployeeLink head = temp;
		EmployeeLink c = head;

		while (a != null && b != null) {
			if (a.getObject().getName().compareTo(b.getObject().getName()) >= 0) {
				c.setNext(a);
				c = a;
				a = a.getNext();
			} else {
				c.setNext(b);
				c = b;
				b = b.getNext();
			}
		}
		c.setNext((a ==null) ? b : a);
		return head.getNext();
	}

	public EmployeeLink getFirst() {
		return first;
	}

	public void setFirst(EmployeeLink first) {
		this.first = first;
	}
	
	
	//need to add the add mehtod to employeelist
	
	public int size(){
		int size = 0;
		EmployeeLink current = first;
		if(this.first!=null){
			size++;
		}
		while(current.getNext()!=null){
			size++;
			current = current.getNext();
		}
		return size;
	}
	
	public void print(){
		EmployeeLink current = first;
		if(current!=null){
			current.getObject().printEmployee();
		}
		while(current.getNext()!=null){
			
			current = current.getNext();
			current.getObject().printEmployee();
			
		}
	}
	
	
	/*
	 * public void frontBackSplit(Link<Employee> source, Link<Employee>
	 * frontRef, Link<Employee> backRef){
	 * 
	 * EmployeeLink slow; EmployeeLink fast;
	 * 
	 * if(source == null || source.getNext() == null){
	 * 
	 * }
	 * 
	 * }
	 */

}
