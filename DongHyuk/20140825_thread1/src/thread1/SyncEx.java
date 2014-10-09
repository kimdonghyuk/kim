package thread1;

public class SyncEx implements Runnable {

	public void doJob() {

		synchronized (this) {

			for (int i = 0; i < 100; i++) {

				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}
	}

	@Override
	public void run() {
		doJob();

	}

	public static void main(String[] args) {

		Runnable obj = new SyncEx();

		Thread t0 = new Thread(obj);
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		Thread t3 = new Thread(obj);

		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}

}
