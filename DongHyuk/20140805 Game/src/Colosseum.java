import java.util.Scanner;


public class Colosseum {

	private Scanner scanner;
	private MonsterManager manager;
	
	public Colosseum(){
		scanner = new Scanner(System.in);
		manager = new MonsterManager();
	}
	
	
	public Player makePlayer(){
		System.out.println("플레이어의 이름을 입력하세요");
		String name = scanner.nextLine();
		
		Weapon weapon = new Weapon("sword",6,4);
		
		Player player = new Player(name, weapon);
		
		return player;
		
	}
	
	public void startGame(){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~Bit Colosseum~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println(" Start Your Game!!!! Uhaaaaaa ");
		
		Player player = this.makePlayer();
		
		battle(player);
	}
	
	public void battle(Player player){
		
		System.out.println("Fight! Monster!");
		
		Monster monster = manager.getNextMonster();
		
		System.out.println(monster);
		
		if(monster == null){
			return;
		}
		
		while (true) {

			int attackAmount = player.attack();

			int monsterHP = monster.damage(attackAmount);

			if (monsterHP <= 0) {
				System.out.println("다음에는 살아날수 없을껄!!!");
			}
		}// end while
	}
}
