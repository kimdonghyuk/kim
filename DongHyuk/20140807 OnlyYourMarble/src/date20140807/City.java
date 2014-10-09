package date20140807;

import java.util.Scanner;
import java.lang.Math;

public class City extends Tile {

	Scanner scanner;
	Player player;
	private int cityPrice; // Tile ����Ʈ���� ���ð����� �߰��׸����� �߻�(���)
	int ownerNum; // �÷����� ID��ȣ�� �޾� ���������� Ȯ��

	// ���� ������ ����
	public City(int cityPrice, int ownerNum) {
		super();
		this.cityPrice = cityPrice;
		this.ownerNum = ownerNum;
	}

	// �ֻ��� ������ 1~6������ ������� ����ϴ� �Լ�
	public int diceNum() {
		int diceNum = ((int) Math.random() * 6) + 1;
		return diceNum;
	}

	// City�� �����ϸ� �����ϰ� ����1�̳� ����2�� ����
	// �����ϴ� ��� ���� �Լ��� �ٸ��� �����ϹǷ� �÷��̾ �Լ� input������ ����
	public void diceGame(Player player) {
		int selectNum = ((int) Math.random() * 2);
		if (selectNum == 0) {
			highNumGame(player);
		} else if (selectNum == 1) {
			approximateGame(player);
		}
	}

	// �迭 ���� �� �迭������ ��ҵ��� ���ڿ��� ���
	@Override
	public String toString() {
		return "City [scanner=" + scanner + ", cityPrice=" + cityPrice
				+ ", ownerNum=" + ownerNum + "]";
	}

	// �ش� City�� �������θ� Ȯ���ϰ� ����/�ܰ�Ȯ��/����� �ΰ����� ����

	public void checkCity(int cityStatus, Player player) {
		if (cityStatus == 1) {
			System.out.println("�� ������ ���� ���������� �����Դϴ�.");
			System.out.println("==========������========");
			System.out.println("||  1. �ܰ� Ȯ���մϴ�.  ||");
			System.out.println("|| 2. �ش������� �����մϴ�. ||");
			System.out.println("|| 3. �ش������� ����մϴ�. ||");
			Scanner sc = new Scanner(System.in);
			int select = sc.nextInt();
			switch (select) {
			case 1:
				System.out.println("������ �ܰ� : " + player.myMoney);
				Scanner returnMenu = new Scanner(System.in);
				System.out.println("Enter�� ������ ���� �޴��� ���ư��ϴ�.");
				Scanner againMenu = new Scanner(System.in);
				int reselect = againMenu.nextInt();
				checkCity(0, player);
			case 2:
				System.out.println("�ش� ���� �����մϴ�.");
				this.ownerNum = player.playerNum;
				player.myMoney = player.myMoney - cityPrice;
				System.out.println("���� ���� �Ŀ� ���� �ܰ� : " + player.myMoney);
			case 3:
				System.out.println("�ش������� �������� �ʰ� ����ϵ��� �մϴ�.");
			}
			// Tile�� �����̸鼭 ���������� ��� (cityStatus���� 1)
			if (cityStatus == 2) {
				System.out.println("�� ������ ���� �������� �����Դϴ�.");
				if (player.playerNum == this.ownerNum) {
					System.out.println("����� �ڽ��� ���Դϴ�. �׳� �������ڽ��ϴ� ~��");
				} else {
					System.out.println("����� �ٸ������ ���Դϴ�. ����Ḧ �����Ͻʽÿ�.");
					player.myMoney = player.myMoney - (int) (this.cityPrice)
							/ 10;
					System.out.println("���� �ܰ� : " + player.myMoney);
					System.out.println("���ø� �μ��Ͻðڽ��ϱ�? (Yes ,No)");
					System.out.println(">> �ʿ��� �ݾ� : " + ((this.cityPrice) * 2));
					String selectBuy = scanner.nextLine();

					switch (selectBuy) {
					case "Yes":
						System.out.println("������ ���ø� �μ��մϴ�.");
						player.myMoney = player.myMoney - (this.cityPrice) * 2;
						// ���� ���ø� �μ��� ��� ���� ������ �ι� ����
						System.out.println("���� �ܰ� : " + player.myMoney);
					case "No":
						System.out.println("���ø� �μ����� �ʽ��ϴ�.");
					}
				}
			}

		}
	}

	// �ش� City�� �������θ� Ȯ���ϰ� ����/�ܰ�Ȯ��/����� �ΰ����� �����ϴ� �Լ� ����

	// �ֻ����� ������ �� ���� ���ڰ� ������ ���� �̱�� ����
	public void highNumGame(Player player) {
		System.out.println("�ֻ����� ���� �� �������ڰ� ������ �̱�ϴ�.");
		System.out.println(">> �ֻ����� �������� Enter�� �����ּ���");
		Scanner startGame = new Scanner(System.in);
		int start = startGame.nextInt();

		int playerNum = diceNum(); // �÷��̾� �ֻ��� ��
		int comNum = diceNum(); // ��ǻ�� �ֻ��� ��
		// �� ����� �ֻ��� �� ��
		if (playerNum > comNum) {
			System.out.println("�÷��̾ �� �������ڰ� ���ͼ� �¸��Ͽ����ϴ�.");
			player.myMoney = player.myMoney + this.cityPrice / 10;
			System.out.println("���� ���� ��� : " + player.myMoney);
		} else if (playerNum < comNum) {
			System.out.println("��ǻ�Ͱ� �� �������ڰ� ���ͼ� �÷��̾�� �й��Ͽ����ϴ�.");
			player.myMoney = player.myMoney - this.cityPrice / 10;
			System.out.println("���� ���� ��� : " + player.myMoney);
		} else if (playerNum == comNum) {
			System.out.println("���� ���ڰ� ���Խ��ϴ�. �ֻ����� �ٽ� �����ּ���.");
			highNumGame(player);
		}
	}

	// �ֻ����� ������ �� ���� ���ڰ� ������ ���� �̱�� ���� ����

	// �λ�� �߿��� ���ذ����� �� �ٻ簪�� ������ ����� �̱�� �Լ�
	public void approximateGame(Player player) {
		System.out.println("�ֻ����� ���� ���ذ����� �ٻ��� ���ڰ� ������ ����� �¸��մϴ�.");
		System.out.println(">> �ֻ����� �������� Enter�� �����ּ���");
		String startGame = scanner.nextLine();

		int basicNum = diceNum(); // �񱳱����� �Ǵ� �ֻ�����
		int playerNum = diceNum(); // �÷��̾� �ֻ��� ��
		int comNum = diceNum();

		int playerResult = (int) Math.pow((playerNum - basicNum), 2);
		int comResult = (int) Math.pow((comNum - basicNum), 2);

		// �� ����� �ֻ��� �� ��
		if (playerNum < comNum) {
			System.out.println("�÷��̾ �� �ٻ��Ѱ��� ���ͼ� �¸��Ͽ����ϴ�.");
			player.myMoney = player.myMoney + this.cityPrice / 10;
			System.out.println("���� ���� ��� : " + player.myMoney);
		} else if (playerNum > comNum) {
			System.out.println("��ǻ�Ͱ� �� �ٻ��Ѱ��� ���ͼ� �÷��̾�� �й��Ͽ����ϴ�.");
			player.myMoney = player.myMoney - this.cityPrice / 10;
			System.out.println("���� ���� ��� : " + player.myMoney);
		} else if (playerNum == comNum) {
			System.out.println("���� ���ڰ� ���Խ��ϴ�. �ֻ����� �ٽ� �����ּ���.");
			approximateGame(player);
		}
	}

	public int getCityPrice() {
		return cityPrice;
	}

	public void setCityPrice(int cityPrice) {
		this.cityPrice = cityPrice;
	}

}
