package lab1;

public class Temperature {
	private double degree;
	private char scale;
	public Temperature(){
		degree = 0;
		scale = 'C';
	}
	
	public Temperature(double degree){
		this();
		this.degree = degree;
	}
	public Temperature(char scale){
		this();
		this.scale = scale;
	}
	public Temperature(double degree, char scale){
		this.degree = degree;
		this.scale = scale;
	}
	
	public void setScale(char scale) {
		if(scale != 'C' && scale != 'F') {
			System.err.println("Invalid scale!");
		}
		else {
			this.scale = scale;
		}
	}
	public void setDegree(double degree) {
		this.degree = degree;
	}
	public void setTemperature(double degree, char scale) {
		setDegree(degree);
		setScale(scale);
	}
	
	public double getDegreeCelcius() {
		if(scale == 'C')
			return this.degree;
		else {
			return (this.degree-32)/1.8;
		}
	}
	public double getDegreeFarenheit() {
		if(scale =='F') {
			return this.degree;
		}
		else {
			return 1.8*this.degree+32;
		}
	}
	public double getDegree() {
		return this.degree;
	}
	public char getScale() {
		return this.scale;
	}
	public boolean equlas(Temperature other) {
		return other.getDegreeFarenheit() == this.getDegreeFarenheit();
 	}
	public String toString() {
		return "Temperature is " + this.degree + " degrees " + this.scale;
	}
}
