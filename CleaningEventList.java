
public class CleaningEventList {
	//The head of our list
	private CleaningEventLink first;
	//number of events in the list
	private int size = 0;

	/**
	 * Empty constructor
	 */
	public CleaningEventList() {
	}
	
	/*
	public void addEvent(CleaningEvent event, String startDay, int startHour, int startMinute, String deadLineDay,
			int deadlineHour, int deadLineMinute) {

	}
	
	
	
	public void addEvent(CleaningEvent event) {
		CleaningEventLink newLink = new CleaningEventLink(event);

		if (this.first == null) {
			first = newLink;
			this.size++;

		} else {
			CleaningEventLink current = first;
			// We work our way to the last link in the list
			while (current != null && current.getNext() != null) {
				current = current.getNext();
			}
			// set the last link's "next link" to our new link, adding our new
			// link to the end
			current.setNext(newLink);
			this.size++;
		}
	}
*/
	
	/*
	 * sort by
	 * 
	 * worksite name
	 * 
	 * employee assigned
	 * 
	 * isCompleted
	 * 
	 * startDate
	 * 
	 * 
	 * GET ONLY INCOMPLETE GET ONLY COMPLETE GET ONLY BY SPECIFIC EMPLOYEE GET
	 * ONLY IS RECURRING
	 * 
	 */
	protected void setFirst(CleaningEventLink newLink){
		if(this.first == null){
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
			//Sort by Work Site title ascending
			if (link1.getEvent().getWorkSite().getTitle().compareTo(link2.getEvent().getWorkSite().getTitle()) >= 0) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}
		} else if (sortByIndex == 2) {
			//Sort by work site title descending
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
	
	public boolean isEmpty(){
		return (this.first==null);
	}

	protected void insert(CleaningEventLink newLink){
		if(isEmpty()){
			this.first = newLink;
		} else {
			newLink.setNext(this.first);
			this.first = newLink;
		}
	}
	public CleaningEventLink getFirst() {
		return first;
	}

	public int getSize() {
		return size;
	}

}
