package task1;

public class YouTubeChannel extends MediaAccount {
	 private int numberOfVideos;
	 private boolean isVerified;
	 {
		 numberOfVideos = 0;
		 isVerified = false;
	 }
	 
	 public YouTubeChannel() {}

	 public YouTubeChannel(String name, String domain, double yearlyRevenue, int numOfSubscribers, boolean isVerified, int numberOfVideos) {
	     super(name, domain, yearlyRevenue, numOfSubscribers);
	     this.numberOfVideos = numberOfVideos;
	     this.isVerified = isVerified;
	 }

	 public int getNumberOfVideos() {
	     return numberOfVideos;
	 }

	 public void setNumberOfVideos(int numberOfVideos) {
	     this.numberOfVideos = numberOfVideos;
	 }

	 public boolean isVerified() {
	     return isVerified;
	 }

	 public void setVerified(boolean isVerified) {
	     this.isVerified = isVerified;
	 }

	 public String toString() {
	     return super.toString() + " " + getNumberOfVideos() + " " +(isVerified() ? "Verified" : "Not Verified");
	 }

	 public boolean equals(Object o) {
	     if (this == o) return true;
	     if (o == null || getClass() != o.getClass()) return false;
	     YouTubeChannel other = (YouTubeChannel) o;
	     return numberOfVideos == other.numberOfVideos && isVerified == other.isVerified && super.equals(o);
	 }
	}
