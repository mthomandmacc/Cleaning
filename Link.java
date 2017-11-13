/**
 * 
 */

/**
 * @author Michael Homan
 *
 */
public class Link<O> {

	private Link next = null;
	private O object;

	public Link() {

	}

	public Link(O obj, Link next) {
		this.object = obj;
		this.next = next;
	}

	public Link(O obj) {
		this.object = obj;
	}

	public void setNext(Link setNext) {

		this.next = setNext;

	}

	public Link getNext() {

		return this.next;

	}

	public Object getObject() {
		return object;
	}

	public void setObject(O obj) {
		this.object = obj;

	}
}
