
public class MonsterManager {
	
	private Monster[] monsters;
	private int ord;
	
	public MonsterManager(){
		monsters = new Monster[10];
		
		for(int i=1; i <= 10; i++){			
			monsters[i-1] =
					new Monster().setHp(i*10).setName("Lev."+i);			
		}
	}

	public Monster getNextMonster(){
		if(ord == monsters.length-1){
			return null;
		}
		
		return monsters[ord++];		
	}

	public Monster[] getMonsters() {
		return monsters;
	}

	public void setMonsters(Monster[] monsters) {
		this.monsters = monsters;
	}
	
	
}
