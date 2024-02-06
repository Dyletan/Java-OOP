package task1;

public abstract class MediaAccount {
	private String name;
	private String domain;
	private double yearlyRevenue;
	private int numOfSubscribers;
	{
		name = "No name";
		domain = "None";
		yearlyRevenue = 0;
		
	}
	
	public MediaAccount() {}
	public MediaAccount(String name, String domain, double yearlyRevenue, int numOfSubscribers) {
		this.name = name;
		this.domain = domain;
		this.yearlyRevenue = yearlyRevenue;
		this.numOfSubscribers = numOfSubscribers;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public double getYealyRevenue() {
		return yearlyRevenue;
	}
	public void setYealyRevenue(double yearlyRevenue) {
		this.yearlyRevenue = yearlyRevenue;
	}
	public int getNumOfSubscribers() {
		return numOfSubscribers;
	}
	public void setNumOfSubscribers(int numOfSubscribers) {
		this.numOfSubscribers = numOfSubscribers;
	}
	public String toString() {
		return getName() + " " + getDomain() + "  " + getYealyRevenue() + " " + getNumOfSubscribers();
	}
	public boolean equals(Object o) {
	   if (this == o)
	       return true;
	   if (o == null || getClass() != o.getClass())
	       return false;
	   MediaAccount other = (MediaAccount) o;
	   return other.yearlyRevenue == yearlyRevenue && numOfSubscribers == other.numOfSubscribers &&  name.equals(other.name)
	           && domain.equals(other.domain);
	}
	

	
}
