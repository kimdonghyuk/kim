import java.util.Scanner;


public class Colosseum {
	
	Scanner scanner;
	MonsterManager manager;
	Player player;
	
	public Colosseum(Player player) {
		super();
		this.player = player;
	}


	public Colosseum(){
		scanner = new Scanner(System.in);
		manager = new MonsterManager();
	}
	
	
	public Player makePlayer(){
		System.out.println("�÷��̾��� �̸��� �Է��ϼ���");
		String name = scanner.nextLine();
		System.out.println("����� ���� �̸��� �Է��ϼ���");
		String weaponName = scanner.nextLine();
		System.out.println("1.���_sword");
		System.out.println("2.��_balde");
		System.out.println("3.�Ұ�_small sword");
		
		if(weaponName == "sword"){
			Weapon weaponSword = new Weapon("sword",6,4);
			this.player = new Player(name, weaponSword);
		}
		else if(weaponName == "blade"){
			Weapon weaponSword = new Weapon("sword",6,4);
			this.player = new Player(name, weaponSword);
		}
		else if(weaponName == "small sword"){
			Weapon weaponSmallSword = new Weapon("smallSword",5,6);
			this.player = new Player(name,weaponSmallSword);
		}
		return player;
	}
	
	public void startGame(){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~Bit Colosseum~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("Start Your Game!!!! Uhaaaaa");
		
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
		
		while (true){
			System.out.println("�����ϼ���");
			scanner.nextLine();
			int attackAmount = player.attack();
			
			int monsterHP = monster.damage(attackAmount);
			
			if(monsterHP <= 0){
				System.out.println("�������� ��Ƴ��� ������!!!");
				break;
			}
		}//end while
		
		battle(player);
		
	}

}





