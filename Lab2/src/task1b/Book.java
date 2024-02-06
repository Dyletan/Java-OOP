package task1b;

public class Book extends LibraryItem{
	double cost;
	int numOfPages;
	public Book() {
		
	}
	public Book(String title, String author, int publicationYear, double cost, int numOfPages) {
		super(title, author, publicationYear);
		this.cost = cost;
		this.numOfPages = numOfPages;
	}
	public double getCost() {
		return cost;
	}
	public int getNumOfPages() {
		return numOfPages;
	}
	public void setCost(double c) {
		cost = c;
	}
	public void setNumOfPages(int n) {
		numOfPages = n;
	}
	public String toString() {
		return super.toString() + " " +  getCost()+ " " + getNumOfPages();
	}
}
