
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
	
	
	
	
EmployeeList employeeList = new EmployeeList();
	
	
	employeeList.addEmployee("Andrea", genAddress, null, 150, true);
	employeeList.addEmployee("Zach", genAddress, null, 1278, true);
	employeeList.addEmployee("Michael", genAddress, null, 123100, true);
	employeeList.addEmployee("Wilson", genAddress, null, 11400, true);
	employeeList.addEmployee("Brianna", genAddress, null, 14100, true);
	employeeList.addEmployee("Martha", genAddress, null, 100, true);
	employeeList.addEmployee("Steve", genAddress, null, 500, true);
	employeeList.addEmployee("Steve Sipp", genAddress, null, 7900, true);
	employeeList.addEmployee("Annah Sipp", genAddress, null, 12200, true);
	employeeList.addEmployee("Felicia Coleman", genAddress, null, 1900, true);
	employeeList.addEmployee("David Sipp", genAddress, null, 1800, true);
	
int randomPay = 0;

for (int i = 0 ; i < 30000; i++){
randomPay = (int)	(Math.random() * 100000 +1);

employeeList.addEmployee("Random", genAddress, null, randomPay, true);
}
	
	
	long time1 = System.nanoTime();
		employeeList.sortByPayRateDescending();
	long time2 = System.nanoTime();
	long timeTaken = time2 - time1;  
	employeeList.print();
	System.out.println("Time taken " + timeTaken/ 1000000000.0 + " S");  
		System.out.println(employeeList.size());
	
		System.out.println("\n\n\n");
	//temp = employeeList.mergeSort(employeeList.getFirst());
		//EmployeeLink linklink = employeeList.getFirst();
		//EmployeeLink newSorted = employeeList.mergeSort(linklink);
	
	//employeeList.setFirst(newSorted);
	//employeeList.MergeSort(link1);
		//EmployeeList tempList = new EmployeeList(temp);
	
		//System.out.println("\n\nDescending attempt");
//	System.out.println(employeeList.size());
//	employeeList.print();
	
	//System.out.println("\n\nName Ascending attempt");
	//employeeList.sortByNameAscending();
	//System.out.println(employeeList.size());
//	employeeList.print();
	
	
	
	//System.out.println("\n\nPay Rate Ascending attempt");
	//employeeList.sortByPayRateAscending();
	//System.out.println(employeeList.size());
	//employeeList.print();




}
}
