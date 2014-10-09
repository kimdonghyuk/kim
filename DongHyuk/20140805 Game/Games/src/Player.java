
public class Player {
	
	private String name;
	int hp = 100;
	Weapon weapon;
	
	public Player(String name, Weapon weapon) {
		super();
		this.name = name;
		this.weapon = weapon;
	}
	
	public int attack(){
		return weapon.attackPoint();
	}

	public String toString() {
		return "Player [name=" + name + ", hp=" + hp + ", weapon=" + weapon
				+ "]";
	}
	
	

}
