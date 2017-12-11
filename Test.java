import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

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
		Address genAddress1 = new Address("Lenexa", "KS", "1851 E Aurora Ave.", "66061");
		Address genAddress2 = new Address("Olathe", "KS", "19312 E Beverly Dr.", "66061");
		Address genAddress3 = new Address("Olathe", "KS", "4315 Alexandria Dr.", "66061");
		Address genAddress4 = new Address("Olathe", "KS", "136 Black Bob", "66061");
		Address hudsonsAddress = new Address("Rockford", "IL", "24 Cherry Rd", "23013");
		
		Address athecoAddress = new Address("Atheco", "Olathe", "KS", "1310 E Beverly Dr.", "66061");
		Address totalDesignAddress = new Address("Total Design", "Olathe", "KS", "1310 E Beverly Dr.", "66061");
		Address dickRaysPlumbingAddress = new Address("Dick Ray's Plumbing", "Olathe", "KS", "1310 E Beverly Dr.",
				"66061");
		Address kBSAddress = new Address("KBS", "Olathe", "KS", "1310 E Beverly Dr.", "66061");
		Address murpheysAddress = new Address("Murphey's", "Olathe", "KS", "1310 E Beverly Dr.", "66061");

		WorkSite atheco = new WorkSite("Atheco", athecoAddress, false);
		WorkSite totalDesign = new WorkSite("Total Design", totalDesignAddress, true);
		WorkSite dickRaysPlumbing = new WorkSite("Dick Ray's Master Plumber", dickRaysPlumbingAddress, true);
		WorkSite kBS = new WorkSite("KBS", kBSAddress, true);
		WorkSite murpheys = new WorkSite("Murhpy's Construction Ltd", murpheysAddress, true);

		WorkSiteList workSites = new WorkSiteList();

		workSites.insert(atheco);
		workSites.insert(totalDesign);
		workSites.insert(dickRaysPlumbing);
		System.out.println("After adding 3 our work site list size: " + workSites.getSize());
		workSites.insert(atheco);
		workSites.insert(murpheys);
		workSites.insert(kBS);
		workSites.insert(atheco);
		workSites.insert(murpheys);
		workSites.insert(kBS);

		System.out.println("After adding 9 our work site list size: " + workSites.getSize());

		workSites.removeDuplicates();

		workSites.print();
		System.out.println("||||||||||||||||||||\n\n\n");
		
		workSites.sortByWorkSiteNameDescending();
		workSites.print();
				
				
				
				
				System.out.println("||||||||||||||||||||");
		
		System.out.println("After removing duplicates out work site list size: " + workSites.getSize());

		CleaningAdministration myBusiness = new CleaningAdministration();
		myBusiness.addCleaningEvent(atheco, 3, 23, 2018, 18, 30, 3, 24, 2018, 8, 0);
		myBusiness.addCleaningEvent(atheco, 3, 30, 2018, 18, 30, 3, 31, 2018, 8, 0);
		myBusiness.addCleaningEvent(murpheys, 4, 2, 2018, 20, 0, 4, 4, 2018, 6, 0);
		
		System.out.println("\nWe are now going to print our unstaffed upcoming cleaning events:");
		myBusiness.getUnstaffedCleaningEvents().print();

		// myBusiness.getUnstaffedCleaningEvents().remove("EVT-44002");
		// myBusiness.getUnstaffedCleaningEvents().print();

		myBusiness.addEmployee("Andrea", genAddress, null, 150, true);

		myBusiness.addEmployee("Zach", genAddress, null, 1278, true);

		System.out.println(myBusiness.getCurrentEmployees().getSize());
		myBusiness.getCurrentEmployees().print();
		
		
		myBusiness.addEmployee("Michael Homan", genAddress, null, 1410, true);
		myBusiness.addEmployee("Wilson Rodgers", genAddress, null, 1430, true);
		myBusiness.addEmployee("Brianna Latham", genAddress, null, 1625, true);
		myBusiness.addEmployee("Martha Latham", genAddress, null, 1870, true);
		myBusiness.addEmployee("Steve Latham", genAddress, null,2930, true);
		myBusiness.addEmployee("Steve Sipp", genAddress, null, 3200, true);
		myBusiness.addEmployee("Annah Sipp", genAddress, null, 1830, true);
		myBusiness.addEmployee("Felicia Coleman", genAddress, null, 1490, true);
		myBusiness.addEmployee("David Sipp", genAddress, null, 1800, true);
		myBusiness.addEmployee("Hudson Webber", hudsonsAddress,null, 1150, false);
		myBusiness.addEmployee("Daryn Ferry", genAddress4, 1620, true);

		
		
		
		
		
		
		
		
		myBusiness.assignEmployee("EMP-9001", "EVT-44002");

		//myBusiness.getUnstaffedCleaningEvents().print();

		System.out.println("masterlist");
		
		//myBusiness.getMasterCleaningEventList().print();
		
		//System.out.println("Zach's Cleaning Events");
		//myBusiness.findEmployee("EMP-9001").getCleaningEvents().print();
		// myBusiness.getMasterCleaningEventList().find("EVT-44001").print();
		//System.out.println(myBusiness.getCurrentEmployees().getSize());

		long time1 = System.nanoTime();
	
		
		System.out.println("\n\n\nnameAscending");
		myBusiness.getCurrentEmployees().sortByNameAscending();;
		myBusiness.getCurrentEmployees().print();
		System.out.println(myBusiness.getCurrentEmployees().getSize() + "after sort");
		
		myBusiness.getCurrentEmployees().sortByEmployeeIDAscending();
		
		myBusiness.getCurrentEmployees().print();
		//myBusiness.getCurrentEmployees().print();
	//	System.out.println("\n\n\n sort descending");
	//	myBusiness.getCurrentEmployees().sortByEmployeeIDDescending();
	//	myBusiness.getCurrentEmployees().print();
System.out.println("Getting emp-9001");
		

		System.out.println(myBusiness.findEmployee("EMP-9001").getName());
		
		myBusiness.findEmployee("EMP-9001").clockIn(LocalDateTime.of(2018,1,14,14,0));
		myBusiness.findEmployee("EMP-9001").clockOut(LocalDateTime.of(2018,1,14,18,0));
		myBusiness.findEmployee("EMP-9001").clockIn(LocalDateTime.of(2018, 1,15,8,15));
		myBusiness.findEmployee("EMP-9001").clockOut(LocalDateTime.of(2018, 1,15,13,30));
		myBusiness.findEmployee("EMP-9001").clockIn(LocalDateTime.of(2018, 1,16,8,0));
		myBusiness.findEmployee("EMP-9001").clockOut(LocalDateTime.of(2018, 1,16,13,10));
		myBusiness.findEmployee("EMP-9001").clockIn(LocalDateTime.of(2018, 1,17,9,15));
		myBusiness.findEmployee("EMP-9001").clockOut(LocalDateTime.of(2018, 1,17,14,45));
		
		System.out.println("");

		myBusiness.findEmployee("EMP-9001").printTimeCardCurrent();
		
		
		
		//Michael Homan clocks in and out --test
		System.out.println("Getting emp-9002");
		System.out.println(myBusiness.findEmployee("EMP-9002").getName());
		
		LocalDateTime timeIn1 = LocalDateTime.of(2018, 2, 1, 10, 3);
		LocalDateTime timeOut1 = LocalDateTime.of(2018, 2, 1, 14, 47);
		myBusiness.findEmployee("EMP-9002").clockIn(timeIn1);
		myBusiness.findEmployee("EMP-9002").clockOut(timeOut1);
		LocalDateTime timeIn2 = LocalDateTime.of(2018, 2, 2, 9, 12);
		LocalDateTime timeOut2 = LocalDateTime.of(2018, 2, 2, 17, 43);
		
		myBusiness.findEmployee("EMP-9002").clockIn(timeIn2);	
		myBusiness.findEmployee("EMP-9002").clockOut(timeOut2);
		LocalDateTime timeIn3 = LocalDateTime.of(2018, 2, 3, 10, 14);
		LocalDateTime timeOut3 = LocalDateTime.of(2018, 2, 3, 18, 8);
	
		myBusiness.findEmployee("EMP-9002").clockIn(timeIn3);
		myBusiness.findEmployee("EMP-9002").clockOut(timeOut3);
		LocalDateTime timeIn4= LocalDateTime.of(2018, 2, 4, 8, 22);
		LocalDateTime timeOut4 = LocalDateTime.of(2018, 2, 4, 10, 36);
	
		myBusiness.findEmployee("EMP-9002").clockIn(timeIn4);
		myBusiness.findEmployee("EMP-9002").clockOut(timeOut4);
		LocalDateTime timeIn5= LocalDateTime.of(2018, 2, 5, 10, 58);
		LocalDateTime timeOut5 = LocalDateTime.of(2018, 2, 5,14, 52);
		
		myBusiness.findEmployee("EMP-9002").clockIn(timeIn5);
		myBusiness.findEmployee("EMP-9002").clockOut(timeOut5);
		LocalDateTime timeIn6 = LocalDateTime.of(2018, 2, 9, 10, 15);
		LocalDateTime timeOut6 = LocalDateTime.of(2018, 2, 9, 18, 0);
		
		myBusiness.findEmployee("EMP-9002").clockIn(timeIn6);
		myBusiness.findEmployee("EMP-9002").clockOut(timeOut6);
		LocalDateTime timeIn7 = LocalDateTime.of(2018, 2, 12, 10, 25);
		LocalDateTime timeOut7 = LocalDateTime.of(2018, 2, 12, 16, 0);
		
		
		//Wilson Rodgers is gonna do some work now
		System.out.println("Getting emp-9003");
		System.out.println(myBusiness.findEmployee("EMP-9003").getName());
		myBusiness.findEmployee("EMP-9003").clockIn(timeIn7);
		myBusiness.findEmployee("EMP-9003").clockOut(timeOut7);

		LocalDateTime timeIn8 = LocalDateTime.of(2016, 2, 13, 9, 1);
		LocalDateTime timeOut8 = LocalDateTime.of(2016, 2, 13, 11, 9);
		myBusiness.findEmployee("EMP-9003").clockIn(timeIn8);
		myBusiness.findEmployee("EMP-9003").clockOut(timeOut8);

		
		
		System.out.println(myBusiness.findEmployee("EMP-9002").getName());
		System.out.println("attemping to print Michael's timecard");

		myBusiness.findEmployee("EMP-9002").printTimeCardCurrent();	
		System.out.println("\n\n"+myBusiness.findEmployee("EMP-9003").getName());
		System.out.println("myBusiness.findEmployee(\"EMP-9003\").printTimeCardCurrent();");
		myBusiness.findEmployee("EMP-9003").printTimeCardCurrent();
		
		
		System.out.println("testing payroll");
		myBusiness.executePayRoll();
		
		
		
		myBusiness.findEmployee("EMP-9002").printTimeCardCurrent();	
		
		myBusiness.findEmployee("EMP-9002").getPaychecks().printPaychecks();
		
myBusiness.findEmployee("EMP-9003").printTimeCardCurrent();	
		
		myBusiness.findEmployee("EMP-9003").getPaychecks().printPaychecks();
		//myBusiness.removeEmployee("EMP-9002");
	
		
		myBusiness.getCurrentWorkSites().print();
		myBusiness.initiateConsole();
		
		//Scanner scan = new Scanner(System.in);
		//String newName = "Joseph";
	 
		//System.out.println("printing "+myBusiness.confirm(newName, scan));
		
	//System.out.println(	myBusiness.findEmployee("EMP-9002").getTimeClockCurrentPayPeriod().getTimeClockArray()[0].toString());

		/*
		 * int randomPay = 0;
		 * 
		 * for (int i = 0; i < 300; i++) { randomPay = (int) (Math.random() *
		 * 100000 + 1);
		 * 
		 * myBusiness.addEmployee("Random", genAddress, null, randomPay, true);
		 * 
		 * 
		 * System.out.println(myBusiness.getCurrentEmployees().size()+"test");
		 * System.out.println(myBusiness.getCurrentEmployees().getFirst().
		 * getObject().getName()); System.out.println("\n");
		 * 
		 * myBusiness.getCurrentEmployees().print(); }
		 */
				
				

		/*
		 * long time2 = System.nanoTime(); long timeTaken = time2 - time1;
		 * 
		 * System.out.println("Time taken " + timeTaken / 1000000000.0 + " S");
		 */

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
