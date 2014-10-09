
public class MonsterManager {
	
	private Monster[] monsters;
	private int ord;
	
	public MonsterManager(){
		monsters = new Monster[10];
		
		for(int i = 1; i <= 10; i++){			
			monsters[i-1] = 
			 new Monster().setHp(i*10).setFirePower(i*5).setName("Lev."+i);		
		
		}
		
		
	}
	
	public Monster[] getMonsters() {
		return monsters;
	}



	public Monster getNextMonster(){
		
		if(ord == monsters.length-1){
			return null;
		}
		
		return monsters[ord++];
		
	}

}
