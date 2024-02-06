package task1b;

public abstract class LibraryItem {
	protected String title;
	protected String author;
	protected int publicationYear;
	public LibraryItem() {

	}
	public LibraryItem(String title, String author, int publicationYear) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
	}
	public void setTitle(String t) {
		title = t;
	}
	public void setAuthor(String a) {
		author = a;
	}
	public void setPublicationYaer(int p) {
		publicationYear = p;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public String toString() {
		return getTitle() +" " +getAuthor()+ " " + getPublicationYear();
	}
}
