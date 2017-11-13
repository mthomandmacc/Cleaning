/**
 * 
 */

/**
 * @author Michael Homan
 *
 */
public class LinkedList<O> {

	private Link<O> first;

	
	public LinkedList() {

	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public void addFirst(Link<O> newLink) {
		if (this.getFirst() == null) {
			this.first = newLink;
		} else {

			newLink.setNext(this.first);
			this.first = newLink;
		}
	}

	public void addLast(Link<O> newLink) {
		// find the last link in the chain
		if (this.first != null) {
			Link<?> current = this.first;
			while (current.getNext() != null) {
				current = current.getNext();
			}

			current.setNext(newLink); // add newLink to the last link in the
										// chain

		}

	}

	public void insertAfter(Link<O> linkToInsert, O objectToInsertAfter) {
		Link<?> current = this.first;
		while (current != null) {
			if (current.getObject().equals(objectToInsertAfter)) {
				linkToInsert.setNext(current.getNext());
				current.setNext(linkToInsert);
			}

			current = current.getNext();

		}
	}

	public void insertAfter(Link<O> linkToInsert, Link<O> linkToInsertAfter) {
		Link<O> current = this.first;
		while (current != null) {
			if (current.equals(linkToInsertAfter)) {
				linkToInsert.setNext(current.getNext());
				current.setNext(linkToInsert);
			}
			current = current.getNext();
		}
	}

	public void print() {

		if (this.first != null) {
			Link<O> current = this.first;
			while (current != null) {
				System.out.print(current.toString() + " | ");
				current = current.getNext();
			}
			System.out.println();
		}

	}

	public Link find(O objectToMatch) {

		// Link previous = this.first;
		Link<O> current = this.first;

		while (current != null) {

			if (current.getObject().equals(objectToMatch)) {
				System.out.println("TEST Found " + current.toString());

				return current;

			} else {
				// previous = current;
				current = current.getNext();

			}

		}
		System.out.println("TEST NO MATCH FOUND");
		return null; // If no match is found
	}

	/**
	 * Deletes a specified object from the list.
	 * 
	 * @param objectToDelete
	 * @return - returns the deleted object, for verification
	 */
	public Link<O> delete(O objectToDelete) {
		Link<O> previous = this.first;
		Link<O> current = this.first;
		Link<O> tempLink = current;

		if (current.getObject().equals(objectToDelete)) {
			if (current.getNext() != null) {
				this.first = current.getNext();
				return current;
			} else {
				this.first = null;
				return current;
			}

		}
		while (current != null) {
			if (current.getObject().equals(objectToDelete)) {

				// -----------------------------------------
				// Set the next link for the "previous" link
				if (current.getNext() != null) {

					previous.setNext(current.getNext());
				} else {

					previous.setNext(null);
					// null only if its at the end of the list

				}
				tempLink = current;
			}
			previous = current;
			current = current.getNext();
		}
		System.out.println("Cannot find object [" + objectToDelete + "] in the list to delete");
		return null;
	}
/*
	public void sortAscending() {
		LinkedList<O> tempList = this;
		LinkedList<O> sortedList = new LinkedList<>();
		Link<O> current = tempList.getFirst();
		Link<O> smallestLink = tempList.getFirst();

		while (tempList.getFirst() != null) {
			while (current != null) {
				
			}
		}
	}
*/
	public Link<O> getFirst() {
		return this.first;
	}

	public static void main(String[] args) {
	
	}
}
