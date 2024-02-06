package task1;

public class NPC implements Interactable{
	private String name;
	
	public NPC() {
		name = "no name";
	}
	public NPC(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void interact() {
		System.out.println("Greetings traveler. My name is " + getName());
	}

}
