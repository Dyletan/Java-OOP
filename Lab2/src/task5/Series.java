package task5;

public class Series extends Circuit {
	private Circuit resistor1;
	private Circuit resistor2;

	public Series(Circuit resistor1, Circuit resistor2) {
		this.resistor1 = resistor1;
		this.resistor2 = resistor2;
	}

    @Override
    public double getResistance() {
        return resistor1.getResistance() + resistor2.getResistance();
    }

    @Override
    public double getPotentialDiff() {
        return resistor1.getPotentialDiff() + resistor2.getPotentialDiff();
    }

    @Override
    public void applyPotentialDiff(double V) {
        double current = V / getResistance();
        resistor1.applyPotentialDiff(current * resistor1.getResistance());
        resistor2.applyPotentialDiff(current * resistor2.getResistance());
    }
}

