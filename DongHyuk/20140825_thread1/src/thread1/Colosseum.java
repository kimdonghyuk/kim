package thread1;

public class Colosseum {
	
	public static void main(String[] args) {
		
		Horse[] horses = new Horse[4];
		
		horses[0] = new Horse("1번말");
		horses[1] = new Horse("2번말");
		horses[2] = new Horse("3번말");
		horses[3] = new Horse("4번말");
		
		for (Horse horse : horses) {
			horse.start();			
		}
	}
}
