
public class Test {
public static void main(String[] args) {
	
	/*
	 * 
	 * 
	 * 
	 *public Address(String city, String state, String streetAddress, String zipCode) {
		super();
		this.city = city;
		this.state = state;
		this.streetAddress = streetAddress;
		this.zipCode = zipCode;
	}
	 */
	
	Address genAddress = new Address("Olathe", "KS","1310 E Beverly Dr.", "66061");
	Employee test1 = new Employee("Wartha");
	Employee test2 = new Employee("Mary");
	Employee test3 = new Employee("Jesus");
	
	
	EmployeeLink link1 = new EmployeeLink(test1);
	EmployeeLink link2 = new EmployeeLink(test2);
	EmployeeLink link3 = new EmployeeLink(test3);
	
EmployeeList employeeList = new EmployeeList();
	
	
	employeeList.addEmployee("A", genAddress, null, 1200, true);
	employeeList.addEmployee("Y", genAddress, null, 1200, true);
	employeeList.addEmployee("X", genAddress, null, 1200, true);
	employeeList.addEmployee("W", genAddress, null, 1200, true);
	employeeList.addEmployee("V", genAddress, null, 1200, true);
	employeeList.addEmployee("U", genAddress, null, 1200, true);
	employeeList.addEmployee("T", genAddress, null, 1200, true);
	employeeList.addEmployee("S", genAddress, null, 1200, true);
	employeeList.addEmployee("R", genAddress, null, 1200, true);
	employeeList.addEmployee("Q", genAddress, null, 1200, true);
	employeeList.addEmployee("P", genAddress, null, 1200, true);
		System.out.println(employeeList.size());
	//temp = employeeList.mergeSort(employeeList.getFirst());
	employeeList.mergeSort(employeeList.getFirst());
	System.out.println(employeeList.size());
	System.out.println(employeeList.getFirst().getNext().getNext().getObject().getName());
	//employeeList.MergeSort(link1);
	employeeList.print();
	//EmployeeList tempList = new EmployeeList(temp);
	

}
}
