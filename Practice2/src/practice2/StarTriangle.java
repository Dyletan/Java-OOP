package practice2;



public class StarTriangle {
	private int length;
	
	public StarTriangle(int length) {
		this.length = length;
	}
	
	public String toString() {
		String result = "";
		for(int i = 1; i <= length; i++) {
			for(int j = 0; j < i; j++){
				result += "[*] ";
			}
			result+=("\n");
		}
		return result;
	}
	
	
}
