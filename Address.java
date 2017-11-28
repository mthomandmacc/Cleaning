/**
 * 
 */

/**
 * @author Michael Homan
 *
 */
public class Address {
	
	private String name;
	private String city;
	private String state;
	private String streetAddress;
	private String zipCode;
	

	public Address(String city, String state, String streetAddress, String zipCode) {
		this.city = city;
		this.state = state;
		this.streetAddress = streetAddress;
		this.zipCode = zipCode;
	}
	public Address(String name, String city, String state, String streetAddress, String zipCode) {
		this.name = name;
		this.city = city;
		this.state = state;
		this.streetAddress = streetAddress;
		this.zipCode = zipCode;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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