package task5;

public abstract class Circuit {
	public abstract double getResistance();
	public abstract void applyPotentialDiff(double V);
	public abstract double getPotentialDiff();

	public double getPower() {
		return getPotentialDiff() * getPotentialDiff() / getResistance();
	}

	public double getCurrent() {
		return getPotentialDiff() / getResistance();
	}
}
