package date20140807;

public class Tile {

	private int locattionNum; // ���ù�ȣ���� ��ġ�� �˷��� (������ ������)
	private String name; // ������ �̸�
	public int cityStatus;

	// �迭 ���� �� �迭������ ��ҵ��� ���ڿ��� ���
	@Override
	public String toString() {
		return "Tile [locattionNum=" + locattionNum + ", name=" + name + "]";
	}

	// ���� Tile�� �������� ��ĭ���� Status���� ���ؼ� Ȯ��
	public void checkCity(int cityStatus, Player player) {
		if(cityStatus == 1){
//			new City(cityPrice,1);
		}
		System.out.println("����� ���ð� ���� �� Ÿ���Դϴ�.");
	}

	// ���� �̸��� ���ù�ȣ�� ������� �ʴ� ���̹Ƿ� private�� ��������� �ش� ������ �����Ͽ� �� �� �̿��� ������ �����Ƿ�
	// getter, setter���

	public int getLocattionNum() {
		return locattionNum;
	}

	public void setLocattionNum(int locattionNum) {
		this.locattionNum = locattionNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}