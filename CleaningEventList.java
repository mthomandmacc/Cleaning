
public class CleaningEventList {
	// The head of our list
	private CleaningEventLink first;
	// number of events in the list
	private int size = 0;

	/**
	 * Empty constructor
	 */
	public CleaningEventList() {
	}

	protected void setFirst(CleaningEventLink newLink) {
		if (this.first == null) {
			this.first = newLink;
		}
	}

	public CleaningEventLink sortByWorkSiteNameAscending() {
		CleaningEventLink temp = this.first;
		temp = mergeSort(temp, 1);
		return temp;
	}

	public CleaningEventLink sortByWorkSiteNameDescending() {
		CleaningEventLink temp = this.first;
		temp = mergeSort(temp, 2);
		return temp;
	}

	public CleaningEventLink sortByAssignnedEmployeeNameAscending() {
		CleaningEventLink temp = this.first;
		temp = mergeSort(temp, 3);
		return temp;
	}

	public CleaningEventLink sortByAssignnedEmployeeNameDescending() {
		CleaningEventLink temp = this.first;
		temp = mergeSort(temp, 4);
		return temp;
	}

	public CleaningEventLink sortByEventStartDateAscending() {
		CleaningEventLink temp = this.first;
		temp = mergeSort(temp, 5);
		return temp;
	}

	public CleaningEventLink sortByEventStartDateDescending() {
		CleaningEventLink temp = this.first;
		temp = mergeSort(temp, 6);
		return temp;
	}

	public CleaningEventLink sortByEmployeeIDAscending() {
		CleaningEventLink temp = this.first;
		temp = mergeSort(temp, 7);
		return temp;
	}

	public CleaningEventLink sortByEmployeeIDDescending() {
		CleaningEventLink temp = this.first;
		temp = mergeSort(temp, 8);
		return temp;
	}

	private CleaningEventLink mergeSort(CleaningEventLink head, int sortByIndex) {

		if (head == null || head.getNext() == null) {
			return head;
		}

		// split the list in two
		// Find the head of the second half
		CleaningEventLink middle = getMiddleLink(head);
		CleaningEventLink secondHead = middle.getNext();
		// Break the connection between our two lists
		middle.setNext(null);

		return mergeLists(head, secondHead, sortByIndex);

	}

	private CleaningEventLink mergeLists(CleaningEventLink link1, CleaningEventLink link2, int sortByIndex) {
		if (link1 == null) {
			return link2;
		}
		if (link2 == null) {
			return link1;
		}

		if (sortByIndex == 1) {
			// Sort by Work Site title ascending
			if (link1.getEvent().getWorkSite().getTitle().compareTo(link2.getEvent().getWorkSite().getTitle()) >= 0) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}
		} else if (sortByIndex == 2) {
			// Sort by work site title descending
			if (link1.getEvent().getWorkSite().getTitle().compareTo(link2.getEvent().getWorkSite().getTitle()) < 0) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}

		} else if (sortByIndex == 3) {
			if (link1.getEvent().getEmployeeAssigned().getName()
					.compareTo(link2.getEvent().getEmployeeAssigned().getName()) > 0) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}
		} else if (sortByIndex == 3) {
			if (link1.getEvent().getEmployeeAssigned().getName()
					.compareTo(link2.getEvent().getEmployeeAssigned().getName()) < 0) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}
		} else if (sortByIndex == 5) {
			if (link1.getEvent().getStartTime().isBefore(link2.getEvent().getStartTime())) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}
		} else if (sortByIndex == 6) {
			if (link1.getEvent().getStartTime().isAfter(link2.getEvent().getStartTime())) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}
		} else if (sortByIndex == 7) {
			if (link1.getEvent().getEmployeeAssigned().getEmployeeID()
					.compareTo(link2.getEvent().getEmployeeAssigned().getEmployeeID()) > 0) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}
		} else if (sortByIndex == 8) {
			if (link1.getEvent().getEmployeeAssigned().getEmployeeID()
					.compareTo(link2.getEvent().getEmployeeAssigned().getEmployeeID()) < 0) {
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

	private CleaningEventLink getMiddleLink(CleaningEventLink startLink) {
		CleaningEventLink slow, fast, middle;
		slow = startLink;
		fast = startLink;

		while (fast != null && fast.getNext() != null && fast.getNext().getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		middle = slow;
		return middle;
	}

	public CleaningEvent find(String CleaningEventID) {
		CleaningEventLink current = this.first;
		while (current != null) {
			if (current.getEvent().getCleaningEventID().equals(CleaningEventID)) {
				return current.getEvent();
			}
			current = current.getNext();
		}
		return null;
	}

	private CleaningEventLink removeNextLink(CleaningEventLink previousLink) {

		CleaningEventLink removedLink = previousLink.getNext();
		CleaningEventLink newNext = previousLink.getNext().getNext();
		previousLink.setNext(newNext);
		return removedLink;

	}

	public CleaningEventLink remove(String CleaningEventID) {

		if (this.first.getEvent().getCleaningEventID().equals(CleaningEventID)) {

			CleaningEventLink removed = this.first;
			this.first = this.first.getNext();
			return removed;

		} else {
			CleaningEventLink current = this.first;
			CleaningEventLink previous = current;
			// cycle through our list searching for a match
			while (current != null) {

				if (current.getEvent().getCleaningEventID().equals(CleaningEventID)) {
					CleaningEvent removed = current.getEvent();
					return removeNextLink(previous);

				}

				previous = current;
				current = current.getNext();
			}
			return null;
		}
	}

	public boolean isEmpty() {
		return (this.first == null);
	}

	protected void insert(CleaningEvent newEvent) {
		CleaningEventLink newEventLink = new CleaningEventLink(newEvent);
		if (isEmpty()) {
			this.first = newEventLink;
		} else {
			newEventLink.setNext(this.first);
			this.first = newEventLink;
		}
	}

	public CleaningEventLink getFirst() {
		return first;
	}

	public int getSize() {
		return size;
	}

	public void print() {
		if (!isEmpty()) {
			CleaningEventLink current = this.first;

			while (current != null) {
				current.getEvent().print();
				current = current.getNext();
			}
		}
	}

}
