import java.io.InputStream;
import java.net.URL;

public class URLEx extends Thread {

	@Override
	public void run() {
		try {
			view();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	String path;
	URL url;

	public URLEx(String path) throws Exception {
		this.path = path;
		this.url = new URL(path);
	}

	public void view() throws Exception {
		byte[] buffer = new byte[1024];

		InputStream in = url.openStream();

		int count = in.read(buffer);

		System.out.println(count);
	}

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < 500; i++) {
			System.out.println(i);
			URLEx obj = new URLEx(
					"http://www.coupang.com/deal.pang?coupang=69311345");
			obj.start();
		}

	}
}
