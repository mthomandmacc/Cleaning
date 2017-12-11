import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class CleaningAdministration {

	private CleaningEventList masterCleaningEventList = new CleaningEventList();
	private CleaningEventList upcomingCleaningEvents = new CleaningEventList();
	private CleaningEventList unstaffedCleaningEvents = new CleaningEventList();

	// Our master list of current and past employees
	private EmployeeList masterEmployeeList = new EmployeeList();
	// List of employees presently employed with us
	private EmployeeList currentEmployees = new EmployeeList();
	private WorkSiteList ourWorkSites = new WorkSiteList();

	// Static id number that increments with each new hire

	private int employeeIDNumber = 9000;
	private int workSiteIDNumber = 200;
	private int cleaningEventID = 44000;

	private CleaningEvent[] cleaningEventMenuList = new CleaningEvent[10];

	//
	public boolean confirm(String input, Scanner s) {

		boolean continues = true;
		boolean confirmed = false;

		while (continues) {

			System.out.println(input + " : is this correct?  'y' or 'n'");
			String confirmation = s.nextLine();
			if (confirmation.equals("y") || confirmation.equals("Y") || confirmation.equals("Yes")
					|| confirmation.equals("yes")) {

				continues = false;
				confirmed = true;

			} else if (confirmation.equals("n") || confirmation.equals("N") || confirmation.equals("no")
					|| confirmation == ("No")) {

				continues = false;
				confirmed = false;

			} else {

				System.out.println("\n--------------\nPlease be careful to enter: 'y' or 'n'\n--------------");
				continues = true;

			}

		}

		return confirmed;

	}

	public void mainMenu(Scanner s) {

		simulateClearConsole();
		System.out.println("Welcome administrator! \nLet's get started..." + "\n--------------");
		boolean continues = true;
		String selection;

		while (continues) {

			System.out.println("************************************************************************"
					+ "\n*             '1'   - Employees                                        *"
					+ "\n*             '2'   - Worksites                                        *"
					+ "\n*             '3'   - Cleaning Events                                  *"
					+ "\n************************************************************************");
			System.out.println("Input a number 1-4: ");

			selection = s.nextLine();

			if (selection.equals("1")) {
				simulateClearConsole();

				employeeMenu(s);

				continues = false;
			} else if (selection.equals("2")) {
				workSiteMenu(s);
				continues = false;
			} else if (selection.equals("3")) {
				cleaningEventsMenu(s);
				continues = false;
			} else {
				simulateClearConsole();
				System.out.println("ERROR - Please enter a number 1-4\n");
			}

		}

	}

private void cleaningEventsMenu(Scanner s){
	boolean continues = true;


	while (continues) {

		System.out.println("************************************************************************"
				+ "\n*             '2'   - List Cleaning Events Master List                 *"
				+ "\n*             '3'   - List Upcoming  Cleaning Events                   *"
				+ "\n************************************************************************");
		System.out.println("Input a number 1-4: ");

		String userInput = s.nextLine();

		if (userInput.equals("1")) {
	
			listCleaningEventsMenu(s);

			continues = false;
		} else if (userInput.equals("2")) {
			listCleaningEventsMasterListMenu(s);
			continues = false;
		} else if (userInput.equals("3")) {
			listCleaningEventsUpcomingListMenu(s);
			continues = false;
		} 
	}
	}
	private void 	listCleaningEventsMasterListMenu(Scanner s){
		simulateClearConsole();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy mm:hh a");
		int arrayIndexSelection = -1;
		int currentArraySize = 0;

		CleaningEvent[] cleaningEventMenuList = new CleaningEvent[10];
		CleaningEventLink current = this.masterCleaningEventList.getFirst();

		boolean continues = true;
		while (current != null && continues) {
		
		for (int i = 0; i < 10; i++) {
			if (current != null) {

				cleaningEventMenuList[i] = current.getEvent();
				System.out.println("[" + (i + 1) + "] " + current.getEvent().getWorkSite().getTitle() + "  -  "
						+ current.getEvent().getCleaningEventID()+"\nStart Date:"+current.getEvent().getStartDate().format(dtf)+" "+current.getEvent().getStartTime().format(dtf)+"\nDead line date: " +current.getEvent().getDeadlineDate().format(dtf)+" "+current.getEvent().getDeadlineTime().format(dtf));
				current = current.getNext();
				currentArraySize = i + 1;
			}

		}
		System.out.println("************************************************************************"
				+ "\n*     'next'or 'n' to see the next 10 cleaning events                  *"
				+ "\n*     'back' or 'b' to go back to previous menu page                   *"
				+ "\n************************************************************************");

		String userInput = s.nextLine();
		 if (userInput.equals("next") || userInput.equals("Next") || userInput.equals("NEXT")
					|| userInput.equals("n") || userInput.equals("N")) {

			} else if (userInput.equals("back") || userInput.equals("BACK") || userInput.equals("Back")
					|| userInput.equals("b") || userInput.equals("B")) {
				cleaningEventsMenu(s);
			}
	}}
	private void 	listCleaningEventsUpcomingListMenu(Scanner s){
		simulateClearConsole();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy mm:hh a");
		int arrayIndexSelection = -1;
		int currentArraySize = 0;

		CleaningEvent[] cleaningEventMenuList = new CleaningEvent[10];
		CleaningEventLink current = this.upcomingCleaningEvents.getFirst();

		boolean continues = true;
		while (current != null && continues) {
		
		for (int i = 0; i < 10; i++) {
			if (current != null) {

				cleaningEventMenuList[i] = current.getEvent();
				System.out.println("[" + (i + 1) + "] " + current.getEvent().getWorkSite().getTitle() + "  -  "
						+ current.getEvent().getCleaningEventID()+"\nStart Date:"+current.getEvent().getStartDate().format(dtf)+" "+current.getEvent().getStartTime().format(dtf)+"\nDead line date: " +current.getEvent().getDeadlineDate().format(dtf)+" "+current.getEvent().getDeadlineTime().format(dtf));
				current = current.getNext();
				currentArraySize = i + 1;
			}

		}
		System.out.println("************************************************************************"
				+ "\n*     'next'or 'n' to see the next 10 cleaning events                  *"
				+ "\n*     'back' or 'b' to go back to previous menu page                   *"
				+ "\n************************************************************************");

		String userInput = s.nextLine();
		 if (userInput.equals("next") || userInput.equals("Next") || userInput.equals("NEXT")
					|| userInput.equals("n") || userInput.equals("N")) {

			} else if (userInput.equals("back") || userInput.equals("BACK") || userInput.equals("Back")
					|| userInput.equals("b") || userInput.equals("B")) {
				cleaningEventsMenu(s);
			}
	}}
	/**
	 * 
	 * @param s
	 */
	private void workSiteMenu(Scanner s) {
		simulateClearConsole();
		int arrayIndexSelection = -1;
		int currentArraySize = 0;

		WorkSite[] workSiteList = new WorkSite[10];
		WorkSiteLink current = this.ourWorkSites.getFirst();
		boolean continues = true;
		while (current != null && continues) {

			// List the first 10 employees
			for (int i = 0; i < 10; i++) {
				if (current != null) {
					workSiteList[i] = current.getWorkSite();
					System.out.println("[" + (i + 1) + "] " + current.getWorkSite().getTitle());

					current = current.getNext();
					currentArraySize = i + 1;
				}

			}
			System.out.println("************************************************************************"
					+ "\n*     'next'or 'n' to see the next 10 work sites                       *"
					+ "\n*     1-10 - the number of the work site you wish to select            *"
					+ "\n*     'main' or 'm' to go back to main menu page                       *"
					+ "\n************************************************************************");

			String userInput = s.nextLine();
			userInput = userInput.toUpperCase();
			try {
				arrayIndexSelection = Integer.parseInt(userInput);
			} catch (Exception E) {

			}

			if (arrayIndexSelection >= 0 && arrayIndexSelection <= currentArraySize) {

				continues = false;
				workSiteOptionsMenu(s, workSiteList[arrayIndexSelection - 1]);

			} else if (userInput.equals("NEXT") || userInput.equals("N")) {

			} else if (userInput.equals("MAIN") || userInput.equals("M")) {
				mainMenu(s);
			}

		}
	}

	private void workSiteOptionsMenu(Scanner s, WorkSite workSite) {

		simulateClearConsole();
		boolean continues = true;

		while (continues) {
			System.out.println("   - " + workSite.getTitle() + " -   ");
			System.out.println("************************************************************************"
					+ "\n*             '1'   - Edit Work Site                                   *"
					+ "\n*             'back' or 'b' to go back to previous menu page           *"
					+ "\n*             'main' or 'm' to go back to the main menu page           *"
					+ "\n************************************************************************");

			System.out.println("Input a number 1-4: ");
			String userInput = s.nextLine();
			userInput = userInput.toUpperCase();

			if (userInput.equals("1")) {
				updateWorkSiteMenu(s, workSite);
				continues = false;
			} else if (userInput.equals("BACK") || userInput.equals("B")) {
				workSiteMenu(s);
			} else if (userInput.equals("MAIN") || userInput.equals("M")) {
				mainMenu(s);
			}
		}
	}

	private void updateWorkSiteMenu(Scanner s, WorkSite workSite) {

		simulateClearConsole();
		boolean continues = true;
		while (continues) {
			System.out.println(workSite.getTitle());
			System.out.println("************************************************************************"
					+ "\n*     '1'  - Update Title                                              *"
					+ "\n*     '2'  - Update Address                                            *"
					+ "\n*     '3'  - Update Security Code                                      *"
					+ "\n*     'main' or 'm' to go back to the main menu page                   *"
					+ "\n*     'back' or 'b' to go back to previous menu page                   *"
					+ "\n************************************************************************");

			String userInput = s.nextLine();
			userInput = userInput.toUpperCase();
			if (userInput.equals("1")) {
				simulateClearConsole();
				continues = false;
				updateWorkSiteNameMenu(s, workSite);

			} else if (userInput.equals("2")) {
				continues = false;
				updateWorkSiteAddressMenu(s, workSite);

			} else if (userInput.equals("3")) {

				updateWorkSiteSecurityCodeMenu(s, workSite);
			}

			else if (userInput.equals("BACK") || userInput.equals("B")) {
				listCurrentEmployeeMenu(s);
			} else if (userInput.equals("MAIN") || userInput.equals("M")) {
				mainMenu(s);
			}

		}
	}

	private void updateWorkSiteNameMenu(Scanner s, WorkSite workSite) {
		simulateClearConsole();
		boolean continues = true;

		while (continues) {
			System.out.println("Would you like to edit " + workSite.getTitle() + "'s title?");
			System.out.println("'yes' or 'no'");
			String userInput = s.nextLine();
			userInput = userInput.toUpperCase();
			if (userInput.equals("Y") || userInput.equals("YES")) {
				System.out.println("Please enter a new name for work site: " + workSite.getWorkSiteID());
				String newName = s.nextLine();
				System.out.println(workSite.getTitle() + " will be renamed to " + newName + "\nConfirm ('y' or 'n')");
				userInput = s.nextLine();
				userInput = userInput.toUpperCase();
				if (userInput.equals("Y") || userInput.equals("YES")) {
					continues = false;

					workSite.setTitle(newName);
					workSite.getAddress().setName(newName);
					updateWorkSiteMenu(s, workSite);

				} else if (userInput.equals("N") || userInput.equals("NO")) {
					updateWorkSiteMenu(s, workSite);
				} else {
					System.out.println("Please be sure to input 'y' or 'n'");
				}

			}
		}
	}

	private void updateWorkSiteAddressMenu(Scanner s, WorkSite workSite) {

		boolean continues = true;
		while (continues) {
			simulateClearConsole();
			System.out.println(workSite.getTitle());

			System.out.println("---------");
			workSite.getAddress().print();

			System.out.println("---------");
			System.out.println("Would you like to update this address?\n'y' or 'n'");
			String userInput = s.nextLine();
			userInput = userInput.toUpperCase();

			if (userInput.equals("Y") || userInput.equals("YES")) {

				boolean coninues2 = true;

				while (coninues2) {
					simulateClearConsole();
					System.out.println("Street Address: " + workSite.getAddress().getStreetAddress()
							+ "\nIs this correct?\n'y' or 'n'");
					userInput = s.nextLine();
					userInput = userInput.toUpperCase();

					if (userInput.equals("N") || userInput.equals("NO")) {

						System.out.println(
								"Please enter a new Street Address for this address\nFor Example '1410 N B St'");

						String newStreet = s.nextLine();
						simulateClearConsole();
						System.out.println(newStreet + "\nIs this correct?\n'y' or 'n'");
						userInput = s.nextLine();
						userInput = userInput.toUpperCase();

						if (userInput.equals("Y") || userInput.equals("YES")) {

							workSite.getAddress().setStreetAddress(newStreet);

						} else if (userInput.equals("N") || userInput.equals("NO")) {
							System.out.println("Let's try again!");
						} else {
							simulateClearConsole();
							System.out.println("Please input 'y' or 'n'");
						}
					}
					boolean continues3 = true;
					while (continues3) {
						simulateClearConsole();
						System.out
								.println("City: " + workSite.getAddress().getCity() + "\nIs this correct?\n'y' or 'n'");
						userInput = s.nextLine();
						userInput = userInput.toUpperCase();
						if (userInput.equals("N") || userInput.equals("NO")) {

							System.out.println("Please enter a new city for this address\nFor Example 'Olathe'");

							String newCity = s.nextLine();
							System.out.println(newCity + "\nIs this correct?\n'y' or 'n'");
							userInput = s.nextLine();
							userInput = userInput.toUpperCase();

							if (userInput.equals("Y") || userInput.equals("YES")) {

								workSite.getAddress().setCity(newCity);
								continues3 = false;

							} else if (userInput.equals("N") || userInput.equals("NO")) {

							}

						} else if (userInput.equals("Y") || userInput.equals("YES")) {

							continues3 = false;
						}
					}
					boolean continues4 = true;
					while (continues4) {
						simulateClearConsole();
						System.out.println(
								"State: " + workSite.getAddress().getState() + "\nIs this correct?\n'y' or 'n'");
						userInput = s.nextLine();
						userInput = userInput.toUpperCase();
						if (userInput.equals("N") || userInput.equals("NO")) {

							System.out.println("Please enter a new State for this address\nFor Example 'Kansas'");

							String newState = s.nextLine();
							simulateClearConsole();
							System.out.println(newState + "\nIs this correct?\n'y' or 'n'");
							userInput = s.nextLine();
							userInput = userInput.toUpperCase();

							if (userInput.equals("Y") || userInput.equals("YES")) {

								workSite.getAddress().setState(newState);
								continues4 = false;

							} else if (userInput.equals("N") || userInput.equals("NO")) {
								continues4 = false;
							}

						} else if (userInput.equals("Y") || userInput.equals("YES")) {
							continues4 = false;
						}
					}
					boolean continues5 = true;
					while (continues5) {
						simulateClearConsole();
						System.out.println(
								"Zip Code: " + workSite.getAddress().getZipCode() + "\nIs this correct?\n'y' or 'n'");
						userInput = s.nextLine();
						userInput = userInput.toUpperCase();
						if (userInput.equals("N") || userInput.equals("NO")) {

							System.out.println("Please enter a new zip code for this address\nFor Example '66061'");

							String newZip = s.nextLine();
							simulateClearConsole();
							System.out.println(newZip + "\nIs this correct?\n'y' or 'n'");
							userInput = s.nextLine();
							userInput = userInput.toUpperCase();

							if (userInput.equals("Y") || userInput.equals("YES")) {

								workSite.getAddress().setCity(newZip);

							}

						} else if (userInput.equals("Y") || userInput.equals("YES")) {
							continues5 = false;

						}
					}
				}

			} else if (userInput.equals("N") || userInput.equals("NO")) {
				updateWorkSiteMenu(s, workSite);

			}

		}

	}

	private void updateWorkSiteSecurityCodeMenu(Scanner s, WorkSite workSite) {
		simulateClearConsole();
		boolean continues = true;

		if (!workSite.isHasSecurityCode()) {
			boolean continues2 = true;
			while (continues2) {
				System.out.println(workSite.getTitle()
						+ " doesn't seem to have a security code.\nWould you like to add one?\n'y' or 'n'");
				String securityCodeAddition = s.nextLine();
				securityCodeAddition = securityCodeAddition.toUpperCase();
				if (securityCodeAddition.equals("N") || securityCodeAddition.equals("N")) {

					updateWorkSiteMenu(s, workSite);
				}
				if (securityCodeAddition.equals("Y") || securityCodeAddition.equals("YES")) {
					simulateClearConsole();
					continues2 = false;
					boolean continues3 = true;
					System.out.println("Let's set the new security code for " + workSite.getTitle());
					while (continues3) {

						System.out.println("Please enter the new security code:");
						String newCode1 = s.nextLine();
						simulateClearConsole();
						System.out.println("Please confirm new security code:");
						String newCode2 = s.nextLine();

						if (newCode1.equals(newCode2)) {

							workSite.setSecurityCode(newCode1);

							continues3 = false;
							updateWorkSiteMenu(s, workSite);
						} else {
							simulateClearConsole();
							System.out.println("Security codes did not match");
						}
					}

				}
			}
		} else {
			while (continues) {
				System.out.println("Would you like to edit " + workSite.getTitle() + "'s security Code?");
				System.out.println("'yes' or 'no'");
				String userInput = s.nextLine();
				userInput = userInput.toUpperCase();
				if (userInput.equals("Y") || userInput.equals("YES")) {
					System.out.println("Please enter the new security code for " + workSite.getTitle());
					String newCode1 = s.nextLine();
					simulateClearConsole();
					System.out.println("Please confirm the new security code: ");
					String newCode2 = s.nextLine();
					if (newCode1.equals(newCode2)) {
						continues = false;
						workSite.setSecurityCode(newCode1);
					} else {
						System.out.println("Security codes did not match");

					}

				}
			}
		}
	}

	/**
	 * Select between searching for employee by Employee ID, List all current
	 * employees, and list current and past employees 'back' or 'main' will take
	 * you away from this menu
	 * 
	 * @param s
	 *            scanner
	 */
	private void employeeMenu(Scanner s) {
		simulateClearConsole();
		boolean continues = true;

		while (continues) {

			System.out.println("************************************************************************"
					+ "\n*             '1'   - Find Employee                                    *"
					+ "\n*             '2'   - List Current Employees                           *"
					+ "\n*             '3'   - List Current and Past Employees                  *"
					+ "\n*             'back' or 'b' to go back to previous menu page           *"
					+ "\n*             'main' or 'm' to go back to the main menu page           *"
					+ "\n************************************************************************");

			System.out.println("Input a number 1-4: ");
			String selection = s.nextLine();

			if (selection.equals("1")) {
				findEmployeeMenu(s);
				continues = false;
			} else if (selection.equals("2")) {

				listCurrentEmployeeMenu(s);
				continues = false;
			} else if (selection.equals("3")) {
				//////////////////////////////////// NEED TO APPEND AND MAKE IT
				//////////////////////////////////// ONLY PAST EMPLOYEES
				listMasterEmployeeMenu(s);
				continues = false;
			} else if (selection.equals("back") || selection.equals("BACK") || selection.equals("Back")
					|| selection.equals("b") || selection.equals("B")) {
				mainMenu(s);
				continues = false;

			} else if (selection.equals("main") || selection.equals("MAIN") || selection.equals("Main")
					|| selection.equals("m") || selection.equals("M")) {
				mainMenu(s);
				continues = false;
			}

		}
	}

	/**
	 * Menu for searching for an employee by employee ID
	 * 
	 * @param s
	 *            scanner
	 */
	private void findEmployeeMenu(Scanner s) {
		simulateClearConsole();
		boolean continues = true;
		while (continues) {
			System.out.println("	   *Enter Employee ID*	 ");
			System.out.println("-------------------------------------");

			System.out.println("************************************************************************"
					+ "\n*     Enter the Employee ID of the Employee you wish to find           *"
					+ "\n*                                                                      *"
					+ "\n*     'back' or 'b' to go back to previous menu page                   *"
					+ "\n*     'main' or 'm' to go back to the main menu page                   *"
					+ "\n************************************************************************");

			String entry = s.nextLine();
			entry = entry.toUpperCase();
			Employee result = null;

			result = findEmployee(entry);

			if (result != null) {
				continues = false;
				employeeOptionsMenuFromSearch(s, result);
			} else {

				simulateClearConsole();
				System.out.println("Employee ID: " + entry + " not found.");

			}
		}

	}

	private void addEmployeeMenu(Scanner s) {

		simulateClearConsole();

	}

	private void listCurrentEmployeeMenu(Scanner s) {
		simulateClearConsole();
		int arrayIndexSelection = -1;
		int currentArraySize = 0;

		Employee[] employeeMenuList = new Employee[10];
		EmployeeLink current = this.currentEmployees.getFirst();

		boolean continues = true;
		while (current != null && continues) {

			// List the first 10 employees
			for (int i = 0; i < 10; i++) {
				if (current != null) {

					employeeMenuList[i] = current.getObject();
					System.out.println("[" + (i + 1) + "] " + current.getObject().getName() + "  -  "
							+ current.getObject().getEmployeeID());
					current = current.getNext();
					currentArraySize = i + 1;
				}

			}
			System.out.println("************************************************************************"
					+ "\n*     'next'or 'n' to see the next 10 employees                        *"
					+ "\n*     1-10 - the number of the employee you wish to select             *"
					+ "\n*     'back' or 'b' to go back to previous menu page                   *"
					+ "\n************************************************************************");

			String userInput = s.nextLine();

			try {
				arrayIndexSelection = Integer.parseInt(userInput);
			} catch (Exception E) {

			}

			if (arrayIndexSelection >= 0 && arrayIndexSelection <= currentArraySize) {

				continues = false;
				employeeOptionsMenu(s, employeeMenuList[arrayIndexSelection - 1]);

			} else if (userInput.equals("next") || userInput.equals("Next") || userInput.equals("NEXT")
					|| userInput.equals("n") || userInput.equals("N")) {

			} else if (userInput.equals("back") || userInput.equals("BACK") || userInput.equals("Back")
					|| userInput.equals("b") || userInput.equals("B")) {
				employeeMenu(s);
			}

		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	}

	private void listMasterEmployeeMenu(Scanner s) {
		simulateClearConsole();
		int arrayIndexSelection = -1;
		int currentArraySize = 0;

		Employee[] employeeMenuList = new Employee[10];
		EmployeeLink current = this.masterEmployeeList.getFirst();

		boolean continues = true;
		while (current != null && continues) {

			// List the first 10 employees
			for (int i = 0; i < 10; i++) {
				if (current != null) {

					employeeMenuList[i] = current.getObject();
					System.out.println("[" + (i + 1) + "] " + current.getObject().getName() + "  -  "
							+ current.getObject().getEmployeeID());
					current = current.getNext();
					currentArraySize = i + 1;
				}

			}
			System.out.println("************************************************************************"
					+ "\n*     'next'or 'n' to see the next 10 employees                        *"
					+ "\n*     1-10 - the number of the employee you wish to select             *"
					+ "\n*     'back' or 'b' to go back to previous menu page                   *"
					+ "\n************************************************************************");

			String userInput = s.nextLine();

			try {
				arrayIndexSelection = Integer.parseInt(userInput);
			} catch (Exception E) {

			}

			if (arrayIndexSelection >= 0 && arrayIndexSelection <= currentArraySize) {

				continues = false;
				employeeOptionsMenu(s, employeeMenuList[arrayIndexSelection - 1]);

			} else if (userInput.equals("next") || userInput.equals("Next") || userInput.equals("NEXT")
					|| userInput.equals("n") || userInput.equals("N")) {

			} else if (userInput.equals("back") || userInput.equals("BACK") || userInput.equals("Back")
					|| userInput.equals("b") || userInput.equals("B")) {
				employeeMenu(s);
			}

		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	}

	private void employeeOptionsMenu(Scanner s, Employee emp) {
		simulateClearConsole();
		System.out.println("*--**--**--" + emp.getName() + "--**--**--*");
		System.out.println();

		System.out.println("************************************************************************"
				+ "\n*     '1'  - Get employee information                                  *"
				+ "\n*     '2'  - Get Upcoming Cleaning Events                              *"
				+ "\n*     '3'  - Get current pay period info                               *"
				+ "\n*     '4'  - Get pay history                                           *"
				+ "\n*     '5'  - Update employee information                               *"
				+ "\n*     'main' or 'm' to go back to the main menu page                   *"
				+ "\n*     'back' or 'b' to go back to previous menu page                   *"
				+ "\n************************************************************************");

		String userInput = s.nextLine();

		if (userInput.equals("1")) {
			employeeInfoMenu(s, emp);
		} else if (userInput.equals("2")) {
			employeeUpcomingCleaningEventsMenu(s, emp);
		} else if (userInput.equals("4")) {
			employeePayHistory(s, emp);

			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		} else if (userInput.equals("3")) {
			employeeCurrentPayHistory(s, emp);

			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		} else if (userInput.equals("5")) {
			updateEmployeeInformationMenu(s, emp);

		} else if (userInput.equals("back") || userInput.equals("BACK") || userInput.equals("Back")
				|| userInput.equals("b") || userInput.equals("B")) {
			listCurrentEmployeeMenu(s);
		} else if (userInput.equals("main") || userInput.equals("MAIN") || userInput.equals("Main")
				|| userInput.equals("m") || userInput.equals("M")) {
			mainMenu(s);
		}

	}

	private void updateEmployeeInformationMenu(Scanner s, Employee emp) {
		simulateClearConsole();
		boolean continues = true;
		while (continues) {
			System.out.println(emp.getName() + " - " + emp.getEmployeeID());
			System.out.println("************************************************************************"
					+ "\n*     '1'  - Update Name                                               *"
					+ "\n*     '2'  - Update Address                                            *"
					+ "\n*     '3'  - Update Pay Rate                                           *"
					+ "\n*     '4'  - Update Phone Number                                       *"
					+ "\n*     'main' or 'm' to go back to the main menu page                   *"
					+ "\n*     'back' or 'b' to go back to previous menu page                   *"
					+ "\n************************************************************************");

			String userInput = s.nextLine();
			if (userInput.equals("1")) {
				simulateClearConsole();
				continues = false;
				updateEmployeeNameMenu(s, emp);

			} else if (userInput.equals("2")) {
				continues = false;
				udateEmployeeAddressMenu(s, emp);

			} else if (userInput.equals("3")) {

				// updateEmployeePayRateMenu(s,emp);
			} else if (userInput.equals("4")) {
				// updateEmployeePhoneNumber(s,emp);
			} else if (userInput.equals("back") || userInput.equals("BACK") || userInput.equals("Back")
					|| userInput.equals("b") || userInput.equals("B")) {
				listCurrentEmployeeMenu(s);
			} else if (userInput.equals("main") || userInput.equals("MAIN") || userInput.equals("Main")
					|| userInput.equals("m") || userInput.equals("M")) {
				mainMenu(s);
			}

		}
	}

	private void updateEmployeeNameMenu(Scanner s, Employee emp) {
		simulateClearConsole();
		boolean continues = true;

		while (continues) {
			System.out.println("Would you like to edit " + emp.getName() + "'s name?");
			System.out.println("'yes' or 'no'");
			String userInput = s.nextLine();
			userInput = userInput.toUpperCase();
			if (userInput.equals("Y") || userInput.equals("YES")) {
				System.out.println("Please enter a new name for employee " + emp.getEmployeeID());
				String newName = s.nextLine();
				System.out.println(emp.getName() + " will be renamed to " + newName + "\nConfirm ('y' or 'n')");
				userInput = s.nextLine();
				userInput = userInput.toUpperCase();
				if (userInput.equals("Y") || userInput.equals("YES")) {
					continues = false;

					emp.setName(newName);
					emp.getAddress().setName(newName);

				} else if (userInput.equals("N") || userInput.equals("NO")) {
					updateEmployeeInformationMenu(s, emp);
				}

				System.out.println("Please be sure to input 'y' or 'n'\n");

			}
		}
	}

	private void udateEmployeeAddressMenu(Scanner s, Employee emp) {

		boolean continues = true;
		while (continues) {
			simulateClearConsole();
			System.out.println(emp.getName() + " - " + emp.getEmployeeID());

			System.out.println("---------");
			emp.getAddress().print();

			System.out.println("---------");
			System.out.println("Would you like to update this address?\n'y' or 'n'");
			String userInput = s.nextLine();
			userInput = userInput.toUpperCase();

			if (userInput.equals("Y") || userInput.equals("YES")) {

				boolean coninues2 = true;

				while (coninues2) {
					simulateClearConsole();
					System.out.println("Street Address: " + emp.getAddress().getStreetAddress()
							+ "\nIs this correct?\n'y' or 'n'");
					userInput = s.nextLine();
					userInput = userInput.toUpperCase();

					if (userInput.equals("N") || userInput.equals("NO")) {

						System.out.println(
								"Please enter a new Street Address for this address\nFor Example '1410 N B St'");

						String newStreet = s.nextLine();
						simulateClearConsole();
						System.out.println(newStreet + "\nIs this correct?\n'y' or 'n'");
						userInput = s.nextLine();
						userInput = userInput.toUpperCase();

						if (userInput.equals("Y") || userInput.equals("YES")) {

							emp.getAddress().setStreetAddress(newStreet);

						} else if (userInput.equals("N") || userInput.equals("NO")) {
							System.out.println("Let's try again!");
						} else {
							simulateClearConsole();
							System.out.println("Please input 'y' or 'n'");
						}
					}
					boolean continues3 = true;
					while (continues3) {
						simulateClearConsole();
						System.out.println("City: " + emp.getAddress().getCity() + "\nIs this correct?\n'y' or 'n'");
						userInput = s.nextLine();
						userInput = userInput.toUpperCase();
						if (userInput.equals("N") || userInput.equals("NO")) {

							System.out.println("Please enter a new city for this address\nFor Example 'Olathe'");

							String newCity = s.nextLine();
							System.out.println(newCity + "\nIs this correct?\n'y' or 'n'");
							userInput = s.nextLine();
							userInput = userInput.toUpperCase();

							if (userInput.equals("Y") || userInput.equals("YES")) {

								emp.getAddress().setCity(newCity);
								continues3 = false;

							} else if (userInput.equals("N") || userInput.equals("NO")) {

							}

						} else if (userInput.equals("Y") || userInput.equals("YES")) {

							continues3 = false;
						}
					}
					boolean continues4 = true;
					while (continues4) {
						simulateClearConsole();
						System.out.println("State: " + emp.getAddress().getState() + "\nIs this correct?\n'y' or 'n'");
						userInput = s.nextLine();
						userInput = userInput.toUpperCase();
						if (userInput.equals("N") || userInput.equals("NO")) {

							System.out.println("Please enter a new State for this address\nFor Example 'Kansas'");

							String newState = s.nextLine();
							simulateClearConsole();
							System.out.println(newState + "\nIs this correct?\n'y' or 'n'");
							userInput = s.nextLine();
							userInput = userInput.toUpperCase();

							if (userInput.equals("Y") || userInput.equals("YES")) {

								emp.getAddress().setState(newState);
								continues4 = false;

							} else if (userInput.equals("N") || userInput.equals("NO")) {
								continues4 = false;
							}

						} else if (userInput.equals("Y") || userInput.equals("YES")) {
							continues4 = false;
						}
					}
					boolean continues5 = true;
					while (continues5) {
						simulateClearConsole();
						System.out.println(
								"Zip Code: " + emp.getAddress().getZipCode() + "\nIs this correct?\n'y' or 'n'");
						userInput = s.nextLine();
						userInput = userInput.toUpperCase();
						if (userInput.equals("N") || userInput.equals("NO")) {

							System.out.println("Please enter a new zip code for this address\nFor Example '66061'");

							String newZip = s.nextLine();
							simulateClearConsole();
							System.out.println(newZip + "\nIs this correct?\n'y' or 'n'");
							userInput = s.nextLine();
							userInput = userInput.toUpperCase();

							if (userInput.equals("Y") || userInput.equals("YES")) {

								emp.getAddress().setCity(newZip);

							}

						} else if (userInput.equals("Y") || userInput.equals("YES")) {
							continues5 = false;

						}
					}
				}

			} else if (userInput.equals("N") || userInput.equals("NO")) {
				updateEmployeeInformationMenu(s, emp);

			}

		}

	}

	private void updateEmployeePayRateMenu(Scanner s, Employee emp) {

	}

	private void updateEmployeePhoneNumber(Scanner s, Employee emp) {

	}

	private void employeeOptionsMenuFromSearch(Scanner s, Employee emp) {
		simulateClearConsole();
		System.out.println("*--**--**--" + emp.getName() + "--**--**--*");
		System.out.println();

		System.out.println("************************************************************************"
				+ "\n*     '1'  - Get employee information                                  *"
				+ "\n*     '2'  - Get Upcoming Cleaning Events                              *"
				+ "\n*     '3'  - Get current pay period info                               *"
				+ "\n*     '4'  - Get pay history                                           *"
				+ "\n*     '5'  - Update employee information                               *"
				+ "\n*     'main' or 'm' to go back to the main menu page                   *"
				+ "\n*     'back' or 'b' to go back to previous menu page                   *"
				+ "\n************************************************************************");

		String userInput = s.nextLine();

		if (userInput.equals("1")) {
			employeeInfoMenu(s, emp);
		} else if (userInput.equals("2")) {
			employeeUpcomingCleaningEventsMenu(s, emp);
		} else if (userInput.equals("4")) {
			employeePayHistory(s, emp);

			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		} else if (userInput.equals("3")) {
			employeeCurrentPayHistory(s, emp);

			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		} else if (userInput.equals("5")) {
			updateEmployeeInformationMenu(s, emp);

		} else if (userInput.equals("back") || userInput.equals("BACK") || userInput.equals("Back")
				|| userInput.equals("b") || userInput.equals("B")) {
			findEmployeeMenu(s);
		} else if (userInput.equals("main") || userInput.equals("MAIN") || userInput.equals("Main")
				|| userInput.equals("m") || userInput.equals("M")) {
			mainMenu(s);
		}

	}

	private void employeeInfoMenu(Scanner s, Employee emp) {
		simulateClearConsole();
		emp.print();

		boolean continues = true;

		while (continues) {

			System.out.println("************************************************************************"
					+ "\n*     'back' or 'b' to go back to previous menu page                   *"
					+ "\n*     'main' or 'm' to go back to the main menu page                   *"
					+ "\n************************************************************************");
			String userInput = s.nextLine();
			if (userInput.equals("back") || userInput.equals("BACK") || userInput.equals("Back")
					|| userInput.equals("b") || userInput.equals("B")) {

				continues = false;
				employeeOptionsMenu(s, emp);
			}

			else if (userInput.equals("main") || userInput.equals("MAIN") || userInput.equals("Main")
					|| userInput.equals("m") || userInput.equals("M")) {
				continues = false;
				mainMenu(s);

			}

		}
	}

	private void employeeUpcomingCleaningEventsMenu(Scanner s, Employee emp) {
		boolean continues = true;
		emp.getUpcomingCleaningEvents().print();
		while (continues) {
			System.out.println("************************************************************************"
					+ "\n*     'back' or 'b' to go back to previous menu page                   *"
					+ "\n*     'main' or 'm' to go back to the main menu page                   *"
					+ "\n************************************************************************");

			String userInput = s.nextLine();
			if (userInput.equals("back") || userInput.equals("BACK") || userInput.equals("Back")
					|| userInput.equals("b") || userInput.equals("B")) {

				continues = false;
				employeeOptionsMenu(s, emp);
			}

			else if (userInput.equals("main") || userInput.equals("MAIN") || userInput.equals("Main")
					|| userInput.equals("m") || userInput.equals("M")) {
				continues = false;
				mainMenu(s);

			}

		}

	}

	private void employeePayHistory(Scanner s, Employee emp) {
		simulateClearConsole();
		emp.getPaychecks().printPaychecks();
		System.out.println("************************************************************************"
				+ "\n*     'main' or 'm' to go back to the main menu page                   *"
				+ "\n*     'back' or 'b' to go back to previous menu page                   *"
				+ "\n************************************************************************");

		String userInput = s.nextLine();

		if (userInput.equals("back") || userInput.equals("BACK") || userInput.equals("Back") || userInput.equals("b")
				|| userInput.equals("B")) {
			employeeOptionsMenu(s, emp);
		} else if (userInput.equals("main") || userInput.equals("MAIN") || userInput.equals("Main")
				|| userInput.equals("m") || userInput.equals("M")) {
			mainMenu(s);
		}

	}

	private void employeeCurrentPayHistory(Scanner s, Employee emp) {
		String userInput;
		emp.printTimeCardCurrent();
		System.out.println("************************************************************************"
				+ "\n*     'main' or 'm' to go back to the main menu page                   *"
				+ "\n*     'back' or 'b' to go back to previous menu page                   *"
				+ "\n************************************************************************");

		userInput = s.nextLine();

		if (userInput.equals("back") || userInput.equals("BACK") || userInput.equals("Back") || userInput.equals("b")
				|| userInput.equals("B")) {
			employeeOptionsMenu(s, emp);
		} else if (userInput.equals("main") || userInput.equals("MAIN") || userInput.equals("Main")
				|| userInput.equals("m") || userInput.equals("M")) {
			mainMenu(s);
		}
	}

	public void initiateConsole() {
		Scanner s = new Scanner(System.in);

		mainMenu(s);

	}

	public void simulateClearConsole() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	public void spaceGap() {
		for (int i = 0; i < 8; i++) {
			System.out.println();
		}
	}

	public void listCurrentEmployeesAlphabetically() {

	}

	public void listCurrentEmployeesBySeniority() {
		Scanner s = new Scanner(System.in);

	}

	public void listCurrentEmployeesPayRate() {

		this.getCurrentEmployees().sortByPayRateAscending();
		Scanner s = new Scanner(System.in);

		// return employeeID

		// so another method will call this, and it will then implement
		// something on the employee like fire, pay raise, assign job, assign to
		// unstaffed cleaning event

	}

	/**
	 * This constructor adds an employee to our company
	 * 
	 * @param name
	 *            Employee' First and last name
	 * @param address
	 *            Employee's home address
	 * @param startDate
	 *            Employee's hire date
	 * @param payRate
	 *            Employee's hourly payrate (1100 for $11.00/hr)
	 * @param isDriver
	 *            Is the employee a driver for our company? True for yes.
	 */

	public void addEmployee(String name, Address address, LocalDateTime startDate, int payRate, boolean isDriver) {
		Employee newEmployee = new Employee(name, address, startDate, payRate, isDriver);

		newEmployee.setEmployeeID("EMP-" + employeeIDNumber);
		employeeIDNumber++;

		// insert our newly created employee to both of our lists
		masterEmployeeList.insert(newEmployee);
		currentEmployees.insert(newEmployee);

		// increment the size counter on each of our lists
		this.currentEmployees.incrementSize();
		this.masterEmployeeList.incrementSize();
	}

	/**
	 * Adds a new hire, assigns start date based on day and time of creation.
	 * 
	 * @param name
	 *            Employee' First and last name
	 * @param address
	 *            Employee's home address
	 * @param payRate
	 *            Employee's hourly payrate (1100 for $11.00/hr)
	 * @param isDriver
	 *            Is the employee a driver for our company? True for yes.
	 */
	public void /* new hire */ addEmployee(String name, Address address, int payRate, boolean isDriver) {
		Employee newEmployee = new Employee(name, address, LocalDateTime.now(), payRate, isDriver);

		newEmployee.setEmployeeID("EMP-" + employeeIDNumber);
		employeeIDNumber++;

		// insert our newly created employee to both of our lists
		masterEmployeeList.insert(newEmployee);
		currentEmployees.insert(newEmployee);

		// increment the size counter on each of our lists
		this.currentEmployees.incrementSize();
		this.masterEmployeeList.incrementSize();

	}

	public Employee removeEmployee(String empID) {
		Scanner s = new Scanner(System.in);
		Employee employeeToBeRemoved = findEmployee(empID);
		employeeToBeRemoved.print();

		boolean confirmed = false;
		System.out.println("\nAre you sure you want to remove " + employeeToBeRemoved.getName() + "?" + "'y' or 'n'");

		while (confirmed == false) {

			String answer = s.nextLine();
			if (answer.equals("y") || answer.equals("Y") || answer.equals("Yes") || answer.equals("yes")) {
				// removeFromList(empID);'
				// return employee
				System.out.println("success now code the rest");
				confirmed = true;
				return employeeToBeRemoved;

			} else if (answer.equals("n") || answer.equals("N") || answer.equals("no") || answer == ("No")) {
				System.out.println(employeeToBeRemoved.getName() + " will not be removed.");
				confirmed = true;
			} else {
				System.out.println("Please be careful to enter 'y' or 'n'");
			}

		}
		return null;
	}

	/**
	 * Adds an upcoming cleaning event to the unstaffedCleaningEventsList
	 * 
	 * @param workSite
	 *            Location we need to clean
	 * @param startMonth
	 *            The month the cleaning event becomes available (3 for March)
	 * @param startDateDayOfMonth
	 *            The day of the month the cleaning event becomes available (23
	 *            for the 23rd)
	 * @param startDateYear
	 *            The year the cleaning event becomes available (1988)
	 * @param startHour
	 *            The hour the cleaning event becomes available (3 for 3:00AM /
	 *            22 for 10:00PM)
	 * @param startMinute
	 *            The minute of the hour the cleaning event becomes available,
	 *            becomes available becomes avail..lah..blah
	 * @param deadlineMonth
	 *            The month the date the cleaning event must be completed by
	 * @param deadlineDateDayOfMonth
	 *            The day the cleaning event must be completed by
	 * @param deadlineDateYear
	 *            The year the cleaning event must be completed by
	 * @param deadlineHour
	 *            The hour the cleaning event must be completed by
	 * @param deadlineMinute
	 *            The minute the cleaning event must be completed by
	 */
	public void addCleaningEvent(WorkSite workSite, int startMonth, int startDateDayOfMonth, int startDateYear,
			int startHour, int startMinute, int deadlineMonth, int deadlineDateDayOfMonth, int deadlineDateYear,
			int deadlineHour, int deadlineMinute) {

		// Constructing our new cleaning event
		CleaningEvent newEvent = new CleaningEvent(workSite, startMonth, startDateDayOfMonth, startDateYear, startHour,
				startMinute, deadlineMonth, deadlineDateDayOfMonth, deadlineDateYear, deadlineHour, deadlineMinute);
		// Assigning our unique ID
		newEvent.setCleaningEventID("EVT-" + this.cleaningEventID++);

		// Adding the new cleaning event to our master list as well as our
		// unstaffed cleaning events list
		masterCleaningEventList.insert(newEvent);
		unstaffedCleaningEvents.insert(newEvent);
		ourWorkSites.insert(workSite);
		ourWorkSites.removeDuplicates();
	}

	/**
	 * Here is a constructor that takes quite a lot of parameters, this is to
	 * cut down on the need to create individual instances of WorkSite, Address,
	 * and the various LocalDate/LocalTime objects
	 * 
	 * This version of the constructor is like this for testing purposes/for the
	 * driver
	 * 
	 * @param employeeAssigned
	 *            Employee who is assigned this cleaning event
	 * @param workSiteTitle
	 *            The name of the work location
	 * @param workSiteCity
	 *            City work site is located in
	 * @param workSiteState
	 *            State work site is located in
	 * @param workSiteStreetAddress
	 *            Street address of the work site
	 * @param workSiteZipCode
	 *            Zip code of the work site
	 * @param workSiteHasSecurityCode
	 *            True if there is a security code
	 * @param workSiteSecurityCode
	 *            null if no security code, otherwise the security code for the
	 *            work site
	 * @param startMonth
	 *            The month the cleaning event becomes available (3 for March)
	 * @param startDateDayOfMonth
	 *            The day of the month the cleaning event becomes available (23
	 *            for the 23rd)
	 * @param startDateYear
	 *            The year the cleaning event becomes available (1988)
	 * @param startHour
	 *            The hour the cleaning event becomes available (3 for 3:00AM /
	 *            22 for 10:00PM)
	 * @param startMinute
	 *            The minute of the hour the cleaning event becomes available,
	 *            becomes available becomes avail..lah..blah
	 * @param deadlineMonth
	 *            The month the date the cleaning event must be completed by
	 * @param deadlineDateDayOfMonth
	 *            The day the cleaning event must be completed by
	 * @param deadlineDateYear
	 *            The year the cleaning event must be completed by
	 * @param deadlineHour
	 *            The hour the cleaning event must be completed by
	 * @param deadlineMinute
	 *            The minute the cleaning event must be completed by
	 */
	public void addCleaningEvent(Employee employeeAssigned, String workSiteTitle, String workSiteCity,
			String workSiteState, String workSiteStreetAddress, String workSiteZipCode, boolean workSiteHasSecurityCode,
			String workSiteSecurityCode, int startMonth, int startDateDayOfMonth, int startDateYear, int startHour,
			int startMinute, int deadlineMonth, int deadlineDateDayOfMonth, int deadlineDateYear, int deadlineHour,
			int deadlineMinute) {

		Address workSiteAddress = new Address(workSiteCity, workSiteState, workSiteStreetAddress, workSiteZipCode);
		WorkSite newWorkSite = new WorkSite(workSiteTitle, workSiteAddress, workSiteHasSecurityCode);

		// check if this newly constructed worksite already exists in our system

		newWorkSite.setWorkSiteID("WS-" + workSiteIDNumber++);

		// Set security code, if necessary
		if (workSiteHasSecurityCode) {
			newWorkSite.setSecurityCode(workSiteSecurityCode);
		}

		// update our two WorkSiteLists - employees and the companies
		employeeAssigned.getEmployeesWorkSites().insert(newWorkSite);
		this.ourWorkSites.insert(newWorkSite);
		this.ourWorkSites.removeDuplicates();

		// Constructing our new cleaning event and assigning a unique ID to the
		// event
		CleaningEvent newEvent = new CleaningEvent(newWorkSite, startMonth, startDateDayOfMonth, startDateYear,
				startHour, startMinute, deadlineMonth, deadlineDateDayOfMonth, deadlineDateYear, deadlineHour,
				deadlineMinute);
		newEvent.setCleaningEventID("EVT-" + this.cleaningEventID++);

		// Add our new cleaning event to our cleaning event lists, the employee
		// assigned to the event's list
		// as well as our company wide cleaning list
		employeeAssigned.getUpcomingCleaningEvents().insert(newEvent);
		masterCleaningEventList.insert(newEvent);

	}

	/**
	 * Assign an employee to an unstaffed cleaning event
	 * 
	 * @param EmployeeID
	 *            ID of employe you wish to schedule
	 * @param CleaningEventID
	 *            ID specifying the unstaffed cleaning event
	 * @return true if employee is found AND cleaning event was unstaffed
	 */
	public boolean assignEmployee(String EmployeeID, String CleaningEventID) {
		try {
			Employee assignedEmployee = this.currentEmployees.find(EmployeeID);
			CleaningEvent clnEvent = this.unstaffedCleaningEvents.find(CleaningEventID);

			assignedEmployee.getUpcomingCleaningEvents().insert(clnEvent);

			clnEvent.setEmployeeAssigned(assignedEmployee);
			this.unstaffedCleaningEvents.remove(CleaningEventID);

			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Get employee by searching with EmployeeID (EMP-9090)
	 * 
	 * @param EmployeeID
	 *            Unique employee ID of the you wish to find
	 * @return Employee whos ID matches EmployeeID
	 */
	public Employee findEmployee(String EmployeeID) {

		return this.masterEmployeeList.find(EmployeeID);
	}

	/**
	 * 
	 * @return List containing all of the companies current employees
	 */
	public EmployeeList getCurrentEmployees() {

		return currentEmployees;
	}

	/**
	 * 
	 * @return list of all upcoming and past Cleaning events
	 */
	public CleaningEventList getMasterCleaningEventList() {

		return masterCleaningEventList;
	}

	/**
	 * 
	 * @return list of all current and past employees
	 */
	public EmployeeList getMasterEmployeeList() {

		return masterEmployeeList;
	}

	/**
	 * 
	 * @param EmployeeID
	 *            ID that is linked to the employee we are searching for
	 * @return Employee whose ID matches the string parameter
	 */

	private EmployeeLink findEmp(String EmployeeID) {
		// we will search through the master list of all employees

		EmployeeLink current = this.masterEmployeeList.getFirst();

		while (current.getNext() != null) {

			if (current.getObject().getEmployeeID().equals(EmployeeID)) {

				return current;

			}

			current = current.getNext();

		}
		// else return null
		return null;
	}

	/**
	 * 
	 * @return list of upcoming cleaning events
	 */
	public CleaningEventList getUpcomingCleaningEvents() {

		return upcomingCleaningEvents;
	}

	/**
	 * 
	 * @return list of all unstaffed upcoming cleaning events
	 */
	public CleaningEventList getUnstaffedCleaningEvents() {

		return unstaffedCleaningEvents;
	}

	/**
	 * 
	 * @return
	 */
	public WorkSiteList getCurrentWorkSites() {

		return ourWorkSites;
	}

	public void executePayRoll() {

		sortCurrentEmployeesByID();

		EmployeeLink current = this.currentEmployees.getFirst();

		while (current != null) {

			addPaycheckEntry(current.getObject());
			current = current.getNext();

		}
	}

	/**
	 * 
	 */
	private void sortCurrentEmployeesByID() {
		this.currentEmployees.sortByEmployeeIDAscending();
	}

	public void addPaycheckEntry(Employee employee) {
		// Before we do anything we need to make sure that our paycheck array is
		// large enough for another entry
		// If the array is currently full we will double its size
		if (employee.getPaychecks().getPaycheckCount() == employee.getPaychecks().getPayHistory().length) {
			employee.getPaychecks().ensureCapacity();
		}

		// Create our new paycheck node by taking the employees time clock data
		// from the current pay period
		PaycheckNode newNode = new PaycheckNode(employee.getTimeClockCurrentPayPeriod(), employee);
		employee.getPaychecks().getPayHistory()[employee.getPaychecks().getPaycheckCount()] = newNode;

		// Setting the end of the pay period to the date that payroll is
		// processed
		employee.getTimeClockCurrentPayPeriod().setPayPeriodEndDate(LocalDateTime.now());

		employee.getPaychecks().incrementPaycheckCounter();

		for (int i = 0; i < employee.getTimeClockCurrentPayPeriod().getIndexTracker(); i++) {
			employee.getTimeClockCurrentPayPeriod().getTimeClockArray()[i] = null;
		}

		employee.getTimeClockCurrentPayPeriod().resetTracker();

	}

	public void printEmployeeUpcomingEvents(String EmployeeID) {

		findEmployee(EmployeeID).getUpcomingCleaningEvents().print();

	}

	public void printEmployeeCompletedEvents(String EmployeeID) {

		findEmployee(EmployeeID).getUpcomingCleaningEvents().print();

	}
}
