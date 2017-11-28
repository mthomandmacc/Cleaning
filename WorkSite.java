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

	public WorkSite(String title, Address address, boolean hasSecurityCode) {

		this.title = title;
		this.address = address;
		this.hasSecurityCode = hasSecurityCode;

	}

	/**
	 * Double the size of the duties array when necessary, to add more room
	 */


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

}