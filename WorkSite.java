/**
 * 
 */

/**
 * @author Michael Homan
 *
 */
public class WorkSite {

	private String title;
	private Address address;
	private boolean hasSecurityCode;
	private String securityCode;
	private String workSiteID;
	

	

	public WorkSite(String title, Address address, boolean hasSecurityCode) {

		this.title = title;
		this.address = address;
		this.hasSecurityCode = hasSecurityCode;

	}



	public String getWorkSiteID() {
		return workSiteID;
	}

	public void setWorkSiteID(String workSiteID) {
		this.workSiteID = workSiteID;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isHasSecurityCode() {
		return hasSecurityCode;
	}

	public void setHasSecurityCode(boolean hasSecurityCode) {
		this.hasSecurityCode = hasSecurityCode;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getTitle(){
		
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public void print(){
		
		String workPrint = ""; 
		System.out.println(this.title+"\n\n");
		this.getAddress().print();
		
	}

}