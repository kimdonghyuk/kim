package date20140807;

import java.util.Scanner;

public class Player {
	public int myLocation; // 지금내위치
	public int myMoney; // 돈
	public String myName; // 플레이어 이름
	public int playerNum; // 고유아이디
	public static int playerCnt;
	Scanner scanner;

	// 생성자
	public Player(String myName) {
		super();
		this.myLocation = 0;
		this.myMoney = 1000;
		this.myName = myName;
		this.playerNum += playerCnt;
		playerCnt++;
		// this.playerNum = playerNum;
	}

	// 나의 위치 값 보여주기
	public int getMyLocation() {
		return myLocation;
	}

	// 나의 위치 값 변경
	public void setMyLocation(int myLocation) {
		this.myLocation = myLocation;
	}

	// 나의 머니 값 보여주기
	public int getMyMoney() {
		return myMoney;
	}

	// 나의 머니 값 변경
	public void setMyMoney(int myMoney) {
		this.myMoney = 30;
		this.myMoney = myMoney;
	}

	// 나의 이름 보여주기
	public String getMyName() {
		return myName;
	}

	// 나의 이름 변경
	public void setMyName(String myName) {
		this.myName = myName;
	}

	// 고유아이디 보여주기
	public int getPlayerNum() {
		return playerNum;
	}

	// 고유 아이디 변경
	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	@Override
	public String toString() {
		return "Player [myLocation=" + myLocation + ", myMoney=" + myMoney
				+ ", myName=" + myName + ", playerNum=" + playerNum
				+ ", scanner=" + scanner + "]";
	}

}