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
	
	/**
	 * Constructor taking city state street zip...
	 * 
	 * @param city	...you should understand...
	 * @param state	...what these mean...
	 * @param streetAddress	...please don't make me comment this any more...
	 * @param zipCode	...I love you...
	 */
	public Address(String city, String state, String streetAddress, String zipCode) {
		this.city = city;
		this.state = state;
		this.streetAddress = streetAddress;
		this.zipCode = zipCode;
	}
	
	/**
	 * 
	 * @param name Name of person or business
	 * @param city	City...
	 * @param state	State...
	 * @param streetAddress I dont like this anymore
	 * @param zipCode --
	 */
	public Address(String name, String city, String state, String streetAddress, String zipCode) {
		this.name = name;
		this.city = city;
		this.state = state;
		this.streetAddress = streetAddress;
		this.zipCode = zipCode;
	}
	
	/**
	 * 
	 * @return return name on address
	 */
	public String getName() {
		return name;
	}

	/**
	 * Assign a name to 
	 * @param name
	
	public void setName(String name) {
		this.name = name;
	}
 */
	public String getCity() {
		return city;
	}
	
	/**
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 
	 * @return State
	 */
	public String getState() {
		return state;
	}
	/**
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 
	 * @return street address (like 1410 N B St)
	 */
	public String getStreetAddress() {
		return streetAddress;
	}
	/**
	 * 
	 * @param streetAddress like 1310 E Beverly St
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	/**
	 * 
	 * @return
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * 
	 * @param zipCode
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public void setName(String newName){
		this.name = newName;
	}
	
	public void print(){
		String addressToPrint = "";
		if(this.name!=null){
			addressToPrint = "Name: "+ this.name;
		}
	addressToPrint += "Street :"+ this.streetAddress+"\nCity: "+this.city+"\nState: "+this.state+"\nZip code: "+this.zipCode;
		System.out.println(addressToPrint);
	}
	
}