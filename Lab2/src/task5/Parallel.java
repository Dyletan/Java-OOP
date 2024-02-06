package task5;

public class Parallel extends Circuit {
	private Circuit resistor1;
	private Circuit resistor2;

	public Parallel(Circuit resistor1, Circuit resistor2) {
		this.resistor1 = resistor1;
		this.resistor2 = resistor2;
	}

	@Override
	public double getResistance() {
		return resistor1.getResistance()*resistor2.getResistance() /
				(resistor1.getResistance() + resistor2.getResistance());
	}

	@Override
	public double getPotentialDiff() {
		return resistor1.getPotentialDiff();
	}

	@Override
	public void applyPotentialDiff(double V) {
		resistor1.applyPotentialDiff(V);
		resistor2.applyPotentialDiff(V);
	}
}

