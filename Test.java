import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

public class Test {
	public static void main(String[] args) {

		/*
		 * 
		 * 
		 * 
		 * public Address(String city, String state, String streetAddress,
		 * String zipCode) { super(); this.city = city; this.state = state;
		 * this.streetAddress = streetAddress; this.zipCode = zipCode; }
		 */

		
		Address genAddress = new Address("Olathe", "KS", "1310 E Beverly Dr.", "66061");
		Address genAddress1 = new Address("Olathe", "KS", "1311 E Beverly Dr.", "66061");
		Address genAddress2 = new Address("Olathe", "KS", "1312 E Beverly Dr.", "66061");
		Address genAddress3 = new Address("Olathe", "KS", "1313 E Beverly Dr.", "66061");
		Address genAddress4 = new Address("Olathe", "KS", "1314 E Beverly Dr.", "66061");

		Address athecoAddress = new Address("Atheco", "Olathe", "KS", "1310 E Beverly Dr.", "66061");
		Address totalDesignAddress = new Address("Total Design", "Olathe", "KS", "1310 E Beverly Dr.", "66061");
		Address dickRaysPlumbingAddress = new Address("Dick Ray's Plumbing", "Olathe", "KS", "1310 E Beverly Dr.",
				"66061");
		Address kBSAddress = new Address("KBS", "Olathe", "KS", "1310 E Beverly Dr.", "66061");
		Address murpheysAddress = new Address("Murphey's", "Olathe", "KS", "1310 E Beverly Dr.", "66061");

		WorkSite atheco = new WorkSite("Atheco",athecoAddress, false);
		WorkSite totalDesign = new WorkSite("Total Design",totalDesignAddress, true);
		WorkSite dickRaysPlumbing = new WorkSite("Dick Ray's Master Plumber",dickRaysPlumbingAddress, true);
		WorkSite kBS = new WorkSite("KBS", kBSAddress, true);
		WorkSite murpheys = new WorkSite("Murhpy's Construction Ltd", murpheysAddress, true);

		WorkSiteList workSites = new WorkSiteList();
		
		workSites.insert(atheco);
		workSites.insert( totalDesign);
		workSites.insert( dickRaysPlumbing);
			System.out.println("After adding 3 our work site list size: "+workSites.getSize());
		workSites.insert(atheco);
		workSites.insert(murpheys);
		workSites.insert(kBS);
		workSites.insert(atheco);
		workSites.insert(murpheys);
		workSites.insert(kBS);
		
		
		System.out.println("After adding 9 our work site list size: "+workSites.getSize());
		
		workSites.removeDuplicates();
		
		workSites.print();
		System.out.println("After removing duplicates out work site list size: "+workSites.getSize());
		
		
		CleaningAdministration myBusiness = new CleaningAdministration();

		myBusiness.addEmployee("Andrea", genAddress, null, 150, true);

		myBusiness.addEmployee("Zach", genAddress, null, 1278, true);
	
		System.out.println(myBusiness.getCurrentEmployees().getSize());
		// myBusiness.getCurrentEmployees().print();
		myBusiness.addEmployee("Michael", genAddress, null, 12310, true);

		myBusiness.addEmployee("Wilson", genAddress, null, 11400, true);
		myBusiness.addEmployee("Brianna", genAddress, null, 14100, true);
		myBusiness.addEmployee("Martha", genAddress, null, 100, true);
		myBusiness.addEmployee("Steve", genAddress, null, 500, true);
		myBusiness.addEmployee("Steve Sipp", genAddress, null, 7900, true);
		myBusiness.addEmployee("Annah Sipp", genAddress, null, 12200, true);
		myBusiness.addEmployee("Felicia Coleman", genAddress, null, 1900, true);
		myBusiness.addEmployee("David Sipp", genAddress, null, 1800, true);
		System.out.println();
		System.out.println("close");
		
		/*
		int randomPay = 0;
		
		for (int i = 0; i < 300; i++) {
			randomPay = (int) (Math.random() * 100000 + 1);

			myBusiness.addEmployee("Random", genAddress, null, randomPay, true);
		}
		*/
System.out.println(myBusiness.getCurrentEmployees().getSize());

		long time1 = System.nanoTime();
		myBusiness.getCurrentEmployees().sortByPayRateDescending();
		System.out.println(myBusiness.getCurrentEmployees().getSize()+ "after sort");

		
		/*long time2 = System.nanoTime();
		long timeTaken = time2 - time1;

		System.out.println("Time taken " + timeTaken / 1000000000.0 + " S"); */
		System.out.println(myBusiness.getCurrentEmployees().size()+"test");
		System.out.println(myBusiness.getCurrentEmployees().getFirst().getObject().getName());
		System.out.println("\n");

		myBusiness.getCurrentEmployees().print();
		// temp = employeeList.mergeSort(employeeList.getFirst());
		// EmployeeLink linklink = employeeList.getFirst();
		// EmployeeLink newSorted = employeeList.mergeSort(linklink);

		// employeeList.setFirst(newSorted);
		// employeeList.MergeSort(link1);
		// EmployeeList tempList = new EmployeeList(temp);

		// System.out.println("\n\nDescending attempt");
		// System.out.println(employeeList.size());
		// employeeList.print();

		// System.out.println("\n\nName Ascending attempt");
		// employeeList.sortByNameAscending();
		// System.out.println(employeeList.size());
		// employeeList.print();

		// System.out.println("\n\nPay Rate Ascending attempt");
		// employeeList.sortByPayRateAscending();
		// System.out.println(employeeList.size());
		// employeeList.print();

	}
}
