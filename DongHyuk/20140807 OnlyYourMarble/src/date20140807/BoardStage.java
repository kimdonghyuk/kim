package date20140807;

import java.util.Scanner;

public class BoardStage {
	TileManager tileManager1 = new TileManager();
	int systemPlayerNum = 0;
	int turnCnt = 0;
	Scanner scanner;
	private int diceNum;
	private Player player;
	int trigger = 0;

	// 주사위를 돌리는 기능
	public BoardStage() { // 생성자
		super();
		this.diceNum = 0;
		scanner = new Scanner(System.in);
	}

	public int getDicenum() { // 주사위 랜덤 보기e
		System.out.println("주사위를 굴립니다.");
		return (int) (1 + Math.random() * 6);
	}

	public Player makePlayer(Player player) { // 플레이어 만드는 기능
		player.setMyLocation(0);
		System.out.println("지금내위치는? " + player.getMyLocation()); // Player.myLocation을
																	// 넣어준다.

		player.setMyMoney(1000); // 초기값
		System.out.println("지금갖고있는 돈은?" + player.getMyLocation()); // Player.myMoney을
																	// 넣어준다.

		System.out.println("이름을 입력하세요");
		scanner.nextLine();
		/*
		 * player playerNum = 0; System.out.println("사용자 아이디는?"+playerNum);
		 * 
		 * Player player = new Player(myLocation, myMoney, myName);
		 */
		return player;

	}

	public void setPlayer(Player player) { // 플레이어 두명 만들어주는 기능
		makePlayer(player);
		player.setPlayerNum(systemPlayerNum);
		systemPlayerNum++;
	}

	public void startGame() { // 플레이어 2명 만들어줌.
		System.out.println("=================================");
		System.out.println("=========Game Start!!============");
		System.out.println("=================================");
		Player player1 = new Player("플레이어1");
		Player player2 = new Player("플레이어2");
		System.out.println("==========Player정보==============");
		System.out.println(player1);
		System.out.println(player2);

		while (true) {
			failOrAlive(player1);
			failOrAlive(player2);
			if (turnCnt % 2 == 0) {
				tileManager1.goToNextTile(player1.myLocation);
				tileManager1.checkMyLocation(
						tileManager1.tileArray[player1.myLocation], player1);
				turnCnt++;
			} else {
				tileManager1.goToNextTile(player2.myLocation);
				tileManager1.checkMyLocation(
						tileManager1.tileArray[player2.myLocation], player2);
				turnCnt++;
			}

		}

	}

	// 파산하는 기능
	public void failOrAlive(Player player) {

		if (player.getMyMoney() <= 0) { // 돈이 없으면
			System.out.println("파산하셨습니다.");
			String enter = scanner.nextLine();
			System.exit(0);
		}

	}
}