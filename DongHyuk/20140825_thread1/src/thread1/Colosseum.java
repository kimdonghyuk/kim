package thread1;

public class Colosseum {
	
	public static void main(String[] args) {
		
		Horse[] horses = new Horse[4];
		
		horses[0] = new Horse("1锅富");
		horses[1] = new Horse("2锅富");
		horses[2] = new Horse("3锅富");
		horses[3] = new Horse("4锅富");
		
		for (Horse horse : horses) {
			horse.start();			
		}
	}
}
