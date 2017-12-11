
public class WorkSiteList {
	private WorkSiteLink first;
	private int size = 0;

	public WorkSiteList() {

	}

	protected void setFirst(WorkSiteLink newFirst) {
		if (this.first == null) {
			this.size = 1;
		}
		this.first = newFirst;
	}

	protected int getSize() {
		return this.size;
	}

	protected boolean isEmpty() {
		return first == null;
	}

	/**
	 * Insert a worksite at the front of our list
	 * @param workSite WorkSite you wish to add
	 */
	public void insert(WorkSite workSite) {
		WorkSiteLink newLink = new WorkSiteLink(workSite);
		
		//If list is empty, newLink is the first link
		if (isEmpty()) {
			this.first = newLink;
			//increment our size counter from 0 to 1
			size++;
		} else {
			//else chain the newLink
			newLink.setNext(this.first);
			this.first = newLink;
			size++;
		}
	}

	public void sortByWorkSiteNameAscending() {
		WorkSiteLink sortedLink = mergeSort(this.first, 1);
		this.first = sortedLink;

	}

	public void sortByWorkSiteNameDescending() {
		WorkSiteLink sortedLink = mergeSort(this.first, 2);
		this.first = sortedLink;
	}

	public void sortByWorkSiteCityAscending() {
		WorkSiteLink sortedLink = mergeSort(this.first, 3);
		this.first = sortedLink;
	}

	public void sortByWorkSiteCityDescending() {
		WorkSiteLink sortedLink = mergeSort(this.first, 4);
		this.first = sortedLink;
	}

	/**
	 * Checks to see if two worksites are identical, for reducing redundancy
	 * 
	 * @param first
	 *            first of two worksites to compare
	 * @param second
	 *            second of two worksites to compare
	 * @return
	 */
	protected boolean areTheSameSites(WorkSiteLink first, WorkSiteLink second) {
		return (first.getWorkSite().getAddress().getCity().equals(second.getWorkSite().getAddress().getCity())
				&& first.getWorkSite().getAddress().getState().equals(second.getWorkSite().getAddress().getState())
				&& first.getWorkSite().getTitle().equals(second.getWorkSite().getTitle()) && first.getWorkSite()
						.getAddress().getStreetAddress().equals(second.getWorkSite().getAddress().getStreetAddress()));
	}

	protected boolean areTheSameSites(WorkSite first, WorkSite second) {
		return (first.getAddress().getCity().equals(second.getAddress().getCity())
				&& first.getAddress().getState().equals(second.getAddress().getState())
				&& first.getTitle().equals(second.getTitle()) && first
						.getAddress().getStreetAddress().equals(second.getAddress().getStreetAddress()));
	}

	public WorkSiteLink getFirst() {
		return first;
	}

	/**
	 * Removes the link after the provided link
	 * @param previousLink The previous link to the one removed
	 * @return deleted link, for confirmation
	 */
	protected WorkSiteLink removeNextLink(WorkSiteLink previousLink) {

		WorkSiteLink removedLink = previousLink.getNext();
		WorkSiteLink newNext = previousLink.getNext().getNext();
		previousLink.setNext(newNext);
		return removedLink;

	}

	/**
	 * Removes duplicate links in our WorkSiteList
	 * 
	 * We need only one link per worksite
	 */
	public void removeDuplicates() {

		// First and most importantly lets sort our list by title
		sortByWorkSiteNameAscending();
		WorkSiteLink current = this.first;
		// Lets compare each link one at a time
		// We will then remove duplicates
		while (current != null && current.getNext() != null) {
			
			if (areTheSameSites(current, current.getNext())) {
				removeNextLink(current);
				//decrement our size counter
				size--;
			} else {
				current = current.getNext();
			}
		}
	}

	private WorkSiteLink mergeSort(WorkSiteLink head, int sortByIndex) {

		if (head == null || head.getNext() == null) {
			return head;
		}

		// split the list in two
		// Find the head of the second half
		WorkSiteLink middle = getMiddleLink(head);
		WorkSiteLink secondHead = middle.getNext();
		// Break the connection between our two lists
		middle.setNext(null);

		return mergeLists(mergeSort(head, sortByIndex), mergeSort(secondHead, sortByIndex), sortByIndex);

	}

	private WorkSiteLink mergeLists(WorkSiteLink link1, WorkSiteLink link2, int sortByIndex) {
		if (link1 == null) {
			return link2;
		}
		if (link2 == null) {
			return link1;
		}

		if (sortByIndex == 1) {
			// sort by name -Ascending-
			if (link1.getWorkSite().getTitle().compareTo(link2.getWorkSite().getTitle()) >= 0) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}
		} else if (sortByIndex == 2) {
			// sort by name -Descending-
			if (link1.getWorkSite().getTitle().compareTo(link2.getWorkSite().getTitle()) < 0) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			}

		} else if (sortByIndex == 3) {
			// sort by city and title -Ascending-
			if (link1.getWorkSite().getAddress().getCity().compareTo(link2.getWorkSite().getAddress().getCity()) > 0) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else if (link1.getWorkSite().getAddress().getCity()
					.compareTo(link2.getWorkSite().getAddress().getCity()) < 0) {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			} else {
				if (link1.getWorkSite().getTitle().compareTo(link2.getWorkSite().getTitle()) > 0) {
					link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
					return link2;
				} else {
					link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
					return link1;
				}
			}
		} else {
			// sort by city -Descending- and title -Ascending-
			if (link1.getWorkSite().getAddress().getCity().compareTo(link2.getWorkSite().getAddress().getCity()) < 0) {
				link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
				return link2;
			} else if (link1.getWorkSite().getAddress().getCity()
					.compareTo(link2.getWorkSite().getAddress().getCity()) < 0) {
				link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
				return link1;
			} else {
				if (link1.getWorkSite().getTitle().compareTo(link2.getWorkSite().getTitle()) < 0) {
					link2.setNext(mergeLists(link1, link2.getNext(), sortByIndex));
					return link2;
				} else {
					link1.setNext(mergeLists(link1.getNext(), link2, sortByIndex));
					return link1;
				}

			}
		}
	}

	/**
	 * Find the middle link by incrementing two seperate links, one doubly fast
	 * by the time the fast link reaches the end, the slow link will be at the
	 * middle link
	 * 
	 * @param startLink
	 *            the head link of our list
	 * @return middle link in the list
	 */
	public WorkSiteLink getMiddleLink(WorkSiteLink startLink) {
		WorkSiteLink slow = startLink;
		WorkSiteLink fast = startLink;

		// fast will crawl at the twice the rate as slow

		while (fast != null && fast.getNext() != null && fast.getNext().getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		// once fast has won the race, slow is the middle link
		return slow;
	}

	public void print() {
		if (!isEmpty()) {
			WorkSiteLink current = this.first;
			current.print();
			current = current.getNext();
			while (current != null) {
				current.print();
				current = current.getNext();
			}
		}
	}

}
