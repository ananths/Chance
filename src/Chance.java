public class Chance {

	private static final double GUARANTEED_VALUE = 1.0;
	private final double probability;

	public Chance(double valueAsFraction) {
		if (valueAsFraction < 0 || valueAsFraction > 1)
			throw new IllegalArgumentException(
					"Probability should be between 0 and 1");
		this.probability = valueAsFraction;
	}

	public Chance not() {
		return new Chance(GUARANTEED_VALUE - probability);
	}

	public Chance and(Chance otherChance) {
		return new Chance(probability * otherChance.probability);
	}

	public Chance or(Chance otherChance) {
		return nor(otherChance).not(); 
	}

	private Chance nor(Chance otherChance) {
		return this.not().and(otherChance.not());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chance other = (Chance) obj;
		if (probability != other.probability)
			return false;
		return true;
	}

}
