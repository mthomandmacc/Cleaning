import java.time.LocalDateTime;

public class EmployeeList /* extends LinkedList */ {

	private EmployeeLink first = null;
	private int size = 0;

	public EmployeeList() {

	}

	public EmployeeList(EmployeeLink first) {
		this.first = first;
	}

	/*
	 * public void addEmployee(String name, Address address, LocalDateTime
	 * startDate, int payRate, boolean isDriver) { Employee newEmployee = new
	 * Employee(name, address, startDate, payRate, isDriver); EmployeeLink
	 * newLink = new EmployeeLink(newEmployee);
	 * newEmployee.setEmployeeID(EmployeeID++);
	 * 
	 * if (this.first == null) { this.first = newLink; } else { EmployeeLink
	 * current = first; while (current.getNext() != null) { current =
	 * current.getNext(); } current.setNext(newLink); } size++; }
	 */
	private EmployeeLink getMiddle(EmployeeLink startLink) {

		EmployeeLink slow, fast, middle;
		slow = startLink;
		fast = startLink;

		while (fast != null && fast.getNext() != null && fast.getNext().getNext() != null) {

			slow = slow.getNext();
			fast = fast.getNext().getNext();

		}
		middle = slow;
		return middle;

	}

	public Employee find(String employeeID) {
		EmployeeLink current = this.first;
		while (current != null) {
			if (current.getObject().getEmployeeID().equals(employeeID)) {
				return current.getObject();
			}
			current = current.getNext();
		}
		return null;
	}

	public void sortByNameAscending() {
		EmployeeLink temp = mergeSort(this.first, 1);
		first = temp;
	}

	public void sortByNameDescending() {
		EmployeeLink temp = mergeSort(this.first, 2);
		first = temp;
	}

	public void sortByStartDateAscending() {
		EmployeeLink temp = this.first;
		first = mergeSort(temp, 3);
	}

	public void sortByStartDateDescending() {
		EmployeeLink temp = this.first;
		first = mergeSort(temp, 4);
	}

	public void sortByPayRateAscending() {
		EmployeeLink temp = mergeSort(this.first, 5);
		this.first = temp;
	}

	public void sortByPayRateDescending() {
		EmployeeLink temp = this.first;
		first = mergeSort(temp, 6);
	}

	public void sortByEmployeeIDAscending() {
		EmployeeLink temp = this.first;
		this.first = mergeSort(temp, 7);

	}

	public void sortByEmployeeIDDescending() {
		EmployeeLink temp = this.first;
		this.first = mergeSort(temp, 8);

	}

	private EmployeeLink mergeSort(EmployeeLink head, int sortByIndex) {
		// If list is partitioned fully - return head
		if (head == null || head.getNext() == null) {
			return head;
		}
		// Find the middle link in the current list
		EmployeeLink middle = getMiddle(head);
		// We will split the current list in half, set the head of the second
		// half
		EmployeeLink secondHead = middle.getNext();
		// Now we break the link between the first list and the second list so
		// they are completely disconnected.
		middle.setNext(null);

		// Now we merge the two seperate lists

		return mergeLists(mergeSort(head, sortByIndex), mergeSort(secondHead, sortByIndex), sortByIndex);

	}

	// ByNameDescending
	// ByStartDateAscending
	private EmployeeLink mergeLists(EmployeeLink link1, EmployeeLink link2, int sortByIndex) {
		if (link1 == null) {
			return link2;
		}
		if (link2 == null) {
			return link1;
		}
		if (sortByIndex == 1) {
			// sort by name ascending

			if (link1.getObject().getName().compareTo(link2.getObject().getName()) > 0) {

				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}
		} else if (sortByIndex == 2) {
			// sort by name descending
			if (link1.getObject().getName().compareTo(link2.getObject().getName()) < 0) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}
		} else if (sortByIndex == 3) {
			// sort by start date ascending
			if (link1.getObject().getStartDate().isBefore(link2.getObject().getStartDate())) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}

		} else if (sortByIndex == 4) {
			// sort by start date descending

			if (link1.getObject().getStartDate().isAfter(link2.getObject().getStartDate())) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}
		} else if (sortByIndex == 5) {
			// sort by pay rate ascending

			if (link1.getObject().getPayRate() > link2.getObject().getPayRate()) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}

		} else if (sortByIndex == 6) {
			// sort by pay rate descending
			if (link1.getObject().getPayRate() < link2.getObject().getPayRate()) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}
		} else if (sortByIndex == 7) {
			// sort by name ascending
			if (link1.getObject().getEmployeeID().compareTo(link2.getObject().getEmployeeID()) >= 0) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}
		} else if (sortByIndex == 8) {
			// sort by name ascending
			if (link1.getObject().getEmployeeID().compareTo(link2.getObject().getEmployeeID()) < 0) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}

		} else {
			return null;
		}

	}

	protected void addFirst(EmployeeLink newLink) {
		if (this.first == null) {
			this.first = newLink;
		} else {
			newLink.setNext(this.first);
			this.first = newLink;

		}

	}

	private EmployeeLink mergeListsByNameDescending(EmployeeLink link1, EmployeeLink link2) {
		if (link1 == null) {
			return link2;
		}
		if (link2 == null) {
			return link1;
		}

		if (link1.getObject().getName().compareTo(link2.getObject().getName()) <= 0) {
			link2.setNext(mergeListsByNameDescending(link1, link2.getNext()));
			return link2;
		} else {
			link1.setNext(mergeListsByNameDescending(link1.getNext(), link2));
			return link1;
		}
	}

	private EmployeeLink mergeListsByStartDateAscending(EmployeeLink link1, EmployeeLink link2) {
		if (link1 == null) {
			return link2;
		}
		if (link2 == null) {
			return link1;
		}

		if (link1.getObject().getStartDate().isBefore(link2.getObject().getStartDate())) {
			link2.setNext(mergeListsByStartDateAscending(link1, link2.getNext()));
			return link2;
		} else {
			link1.setNext(mergeListsByStartDateAscending(link1.getNext(), link2));
			return link1;
		}
	}

	private EmployeeLink mergeListsByStartDateDescending(EmployeeLink link1, EmployeeLink link2) {
		if (link1 == null) {
			return link2;
		}
		if (link2 == null) {
			return link1;
		}

		if (link1.getObject().getStartDate().isAfter(link2.getObject().getStartDate())) {
			link2.setNext(mergeListsByStartDateDescending(link1, link2.getNext()));
			return link2;
		} else {
			link1.setNext(mergeListsByStartDateDescending(link1.getNext(), link2));
			return link1;
		}
	}

	private EmployeeLink mergeListsByPayRateAscending(EmployeeLink link1, EmployeeLink link2) {
		if (link1 == null) {
			return link2;
		}
		if (link2 == null) {
			return link1;
		}

		if (link1.getObject().getPayRate() > link2.getObject().getPayRate()) {
			link2.setNext(mergeListsByPayRateAscending(link1, link2.getNext()));
			return link2;
		} else {
			link1.setNext(mergeListsByPayRateAscending(link1.getNext(), link2));
			return link1;
		}
	}

	private EmployeeLink mergeListsByPayRateDescending(EmployeeLink link1, EmployeeLink link2) {
		if (link1 == null) {
			return link2;
		}
		if (link2 == null) {
			return link1;
		}

		if (link1.getObject().getPayRate() < link2.getObject().getPayRate()) {
			link2.setNext(mergeListsByPayRateDescending(link1, link2.getNext()));
			return link2;
		} else {
			link1.setNext(mergeListsByPayRateDescending(link1.getNext(), link2));
			return link1;
		}
	}

	public EmployeeLink getFirst() {
		return first;
	}

	protected void setFirst(EmployeeLink first) {
		this.first = first;
	}

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	protected void insert(Employee emp) {
		EmployeeLink newLink = new EmployeeLink(emp);
		newLink.setNext(this.first);
		this.first = newLink;
	}

	/**
	 * Cycles throught the list counting each link
	 * 
	 * @return Size - number of links in the list
	 */
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

	public EmployeeLink removeEmployee(String EmployeeID) {
		EmployeeLink previous = null;
		EmployeeLink current = this.first;

		while (current != null) {
			if (EmployeeID.equals(current.getObject().getEmployeeID())) {
				if (previous == null) {
					this.size--;
					this.first = current.getNext();
					return current;
				} else {
					// remove the current link by linking previous to current's
					// next link
					this.size--;
					previous.setNext(current.getNext());
					return current;
				}
			}
			previous = current;
			current = current.getNext();
		}
		// didn't find matching employee to remove
		return null;
	}

	public void incrementSize() {
		this.size++;
	}

	public void decrementSize() {
		this.size--;
	}

	/**
	 * Prints the complete list of employees Calls the method printEmployee() on
	 * each link in our list
	 */
	public void print() {
		EmployeeLink current = first;
		if (current != null) {
			current.getObject().print();
		}
		while (current.getNext() != null) {

			current = current.getNext();
			current.getObject().print();

		}
	}

}
