package thread1;

public class Ex1 {

	public void doA() {

		for (int i = 0; i < 100; i++) {

			System.out.println(Thread.currentThread().getName() + " : " + i);
		}

	}

	public static void main(String[] args) {

		Ex1 obj = new Ex1();

		for (int i = 0; i < 10; i++) {
			new Thread() {

				@Override
				public void run() {
					obj.doA();
				}
			}.start();
		}
		obj.doA();

	}

}
