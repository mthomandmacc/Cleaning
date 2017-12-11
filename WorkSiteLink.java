
public class WorkSiteLink {
	private WorkSite workSite;
	private WorkSiteLink next = null;
	
	public WorkSiteLink(WorkSite workSite){
		this.workSite = workSite;
	}
	
	public WorkSiteLink getNext(){
		return next;
	}
	
	public void setNext(WorkSiteLink newNext){
		this.next = newNext;
	}
	
	public WorkSite getWorkSite(){
		return this.workSite;
	}
	
	public void print(){
		System.out.println("Title: "+this.workSite.getTitle()+"\nAddress: "+this.workSite.getAddress().getCity()); 
		System.out.println();
	}
}
