
public class Monster {

	int hp;
	int firePower;
	String name;
	
	
//	public Monster(String name){
//		this(name,0);
//	}//���� �̸��� �Ű������� �ٸ�. : �����ε�
//	public Monster(String name, int hp){
//		this.name = name;
//		this.hp = hp;
//	}
	
	
	// �������϶� Alt + Shift + S >> Generate getter and Setter
	// ������ �̸� �Ű����� ������ �����ε���.
	public int getHp() {
		return hp;
	}

	public Monster setHp(int hp) { // ������� ������� Type�� Ŭ���� �̸����� �ٲٰ� return this�Է�
		this.hp = hp;
		return this;
	}

	public int getFirePower() {
		return firePower;
	}

	public Monster setFirePower(int firePower) {
		this.firePower = firePower;
		return this;
	}

	public String getName() {
		return name;
	}

	public Monster setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return "Monster [hp=" + hp + ", firePower=" + firePower + ", name="
				+ name + "]";
	}

	public int damage(int attackAmount) {
		// TODO Auto-generated method stub
		this.hp = this.hp - attackAmount;
		return this.hp;
	}
	
	


}
