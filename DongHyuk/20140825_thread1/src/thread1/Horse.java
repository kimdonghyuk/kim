package thread1;

public class Horse extends Thread {

	private String name;
	private int pos;

	public Horse(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		gallop();
	}

	public void gallop() {

		for (int i = 0; i < 100; i++) {
			pos += (int) (Math.random() * 10);

			int dotCount = pos / 20;
			synchronized (this) {
				for (int j = 0; j < dotCount; j++) {
					System.out.print(".");}
				}
			System.out.println(name + " : " + pos);

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// end for
	}
}
