
public class CleaningEventLink {
	CleaningEventLink next;
	CleaningEvent event;
	
	
	public CleaningEventLink(CleaningEvent newEvent){
		this.event = newEvent;
	}
	public CleaningEventLink getNext() {
		return next;
	}
	public void setNext(CleaningEventLink next) {
		this.next = next;
	}
	public CleaningEvent getEvent() {
		return event;
	}
	public void setEvent(CleaningEvent event) {
		this.event = event;
	}
	
	
	
	
	
	
	
	
}
