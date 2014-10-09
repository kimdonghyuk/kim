
public class Weapon {

	private String name;
	private int defaultPoint;
	private int weightPoint;
	
		public Weapon(String name, int defaultPoint, int weightPoint) {
		super();
		this.name = name;
		this.defaultPoint = defaultPoint;
		this.weightPoint = weightPoint;
	}

	public int attackPoint() {
		// TODO Auto-generated method stub
		return defaultPoint + (int)(Math.random()*weightPoint);
	}

	@Override
	public String toString() {
		return "Weapon [name=" + name + ", defaultPoint=" + defaultPoint
				+ ", weightPoint=" + weightPoint + "]";
	}

}
