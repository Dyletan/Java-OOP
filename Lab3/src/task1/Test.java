package task1;

public class Test {

	public static void main(String[] args) {
		UserInterface i = new UserInterface();
		i.interact();
		NPC n = new NPC("Karl");
		n.interact();
		YouTubeChannel y = new YouTubeChannel("Lololowka", "https://www.youtube.com/@MrLololoshka", 1000000, 15000000, true, 1500);
		System.out.println(y);
	}
}
