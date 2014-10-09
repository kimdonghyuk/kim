
public class Monster {

	int hp;
	int firePower;
	String name;
	
	
//	public Monster(String name){
//		this(name,0);
//	}//같은 이름에 매개변수가 다름. : 오버로딩
//	public Monster(String name, int hp){
//		this.name = name;
//		this.hp = hp;
//	}
	
	
	// 여러개일때 Alt + Shift + S >> Generate getter and Setter
	// 선택한 이름 매개변수 여러개 오버로딩함.
	public int getHp() {
		return hp;
	}

	public Monster setHp(int hp) { // 빌더라는 방식으로 Type을 클래스 이름으로 바꾸고 return this입력
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
