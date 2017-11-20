/**
 * 
 */

/**
 * @author Michael Homan
 *
 */
public class WorkSite {
	 
	private Address address;
	private boolean hasSecurityCode;
	private String securityCode;
	private int DEFAULT_DUTIES_SIZE=8;
	private int dutiesCount=0;
	private String[] duties = new String[DEFAULT_DUTIES_SIZE];
	private String timeFrameToClean;//weekend? evening?
	
	
	public WorkSite(){
		
	}
	public WorkSite(Address address){
		
	this.address = address;
		this.securityCode = securityCode;
		
		
	}
	public void addDuty(String duty){
		if(dutiesCount==duties.length){
			ensureCapacity();
		}
		duties[dutiesCount++] = duty;
	}
	
	/**
	 * Double the size of the duties array when necessary, to add more room
	 */
	public void ensureCapacity(){
		String[] temp = new String[dutiesCount*2];
		for(int i = 0 ; i < dutiesCount; i++){
			temp[i] = duties[i];
		}
		duties = temp;
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
	public int getDEFAULT_DUTIES_SIZE() {
		return DEFAULT_DUTIES_SIZE;
	}
	public void setDEFAULT_DUTIES_SIZE(int dEFAULT_DUTIES_SIZE) {
		DEFAULT_DUTIES_SIZE = dEFAULT_DUTIES_SIZE;
	}
	public int getDutiesCount() {
		return dutiesCount;
	}
	public void setDutiesCount(int dutiesCount) {
		this.dutiesCount = dutiesCount;
	}
	public String[] getDuties() {
		return duties;
	}
	public void setDuties(String[] duties) {
		this.duties = duties;
	}
	
}