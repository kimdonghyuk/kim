package date20140807;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TileManager {

	public ArrayList<Tile> tileList;
	private int diceNum1;
	public Tile[] tileArray;
	private Scanner scanner;
	private int tileCount, cityCount;
	private int trigger2;
	private int cityPrice = (int) (Math.random() * 51)*10 + 500;

	public TileManager() {
		scanner = new Scanner(System.in);
		System.out.println("총 타일의 갯수를 입력해주세요 : ");
		tileCount = Integer.parseInt(scanner.nextLine());
		System.out.println("도시 타일의 갯수를 입력해주세요(총 타일의 갯수보다 무조건 작아야 합니다.) : ");
		cityCount = Integer.parseInt(scanner.nextLine());
		tileList = shuffleTile(tileCount, cityCount);
		for (int j = 0; j < tileList.size(); j++) {
			System.out.print(tileList.get(j).getName() + ", ");
		}
		tileArray = tileList.toArray(tileArray);
	}

	public ArrayList<Tile> shuffleTile(int tileCount, int cityCount) {

		tileArray = new Tile[tileCount];

		int cnt1 = 0, cnt2 = 0;
		int tileIndex = 0, cityIndex = 0;
		int cityNum = 0, emptyNum = 0;

		while (true) {
			cityIndex = (int) (Math.random() * cityCount);
			// System.out.println("첫 번째 루프를 돌고 있습니다.");
			if (tileArray[cityIndex] == null) {
				// System.out.println("첫 번째 조건문 실행");
				cnt1++;
				tileArray[cityIndex] = new City(cityPrice,1);
				tileArray[cityIndex].setLocattionNum(cityIndex);
				tileArray[cityIndex].setName("City" + cityNum);
				((City) tileArray[cityIndex]).setCityPrice(500 + (int) (Math
						.random() * 500));
				cityNum++;
				if (cnt1 == cityCount)
					break;
			}
		}

		while (true) {
			tileIndex = (int) ((Math.random() * (tileCount - cityCount)) + cityCount);
			// System.out.println("두 번째 루프를 돌고 있습니다.");
			if (tileArray[tileIndex] == null) {
				// System.out.println("두 번째 조건문 실행");
				cnt2++;
				tileArray[tileIndex] = new Tile();
				tileArray[tileIndex].setLocattionNum(tileIndex);
				tileArray[tileIndex].setName("Empty" + emptyNum);
				emptyNum++;
				if (cnt2 == (tileCount - cityCount))
					break;
			}
		}
		tileList = new ArrayList<Tile>(Arrays.asList(tileArray));
		Collections.shuffle(tileList);
		return tileList;
	}

	public void goToNextTile(int myLocation) {
		System.out.println("Enter를 누르면 주사위를 굴립니다.");
		// scanner = new Scanner(System.in);
		// scanner.nextInt();
		diceNum1 = (int) (1 + Math.random() * 6);
		System.out.println("주사위를 굴렸습니다. 주사위 값은 " + diceNum1 + "입니다.");
		System.out.println("다음 타일로 이동합니다.");
		myLocation += diceNum1;
	}

	public void checkMyLocation(Tile tile, Player player) {
		if (player.myLocation > tileCount) {
			player.myLocation -= tileCount;
			player.myMoney += 500;
			System.out.println("월급 " + player.myMoney + "를 받았습니다.");
		} else {
			Tile city = tileArray[player.myLocation];
			tile.checkCity(tile.cityStatus, player);
		}

	}

	@Override
	public String toString() {
		return "TileManager [tileArray=" + Arrays.toString(tileArray)
				+ ", scanner=" + scanner + ", tileCount=" + tileCount
				+ ", cityCount=" + cityCount + "]";
	}

}