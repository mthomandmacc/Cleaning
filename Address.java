/**
 * 
 */

/**
 * @author Michael Homan
 *
 */
public class Address {
	//test
	private String city;
	private String state;
	private String streetAddress;
	private String zipCode;
	
	public Address(String city, String state, String streetAddress, String zipCode) {
		super();
		this.city = city;
		this.state = state;
		this.streetAddress = streetAddress;
		this.zipCode = zipCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
}