package thread1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapEx {

	public static void main(String[] args) {

		Map<String, String> ipMap = new HashMap<String, String>();

		ipMap.put("dh", "192.168.0.86"); // ����
		ipMap.put("jy", "192.168.0.77"); // ����
		ipMap.put("jh", "192.168.0.36"); // ����
		ipMap.put("mj", "192.168.0.24"); // ����

		Collection<String> values = ipMap.values();

		for (String aValue : values) {
			System.out.println(aValue);
		}

		Iterator<String> it = ipMap.keySet().iterator();

		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key);
			System.out.println(ipMap.get(key));
		}

	}

}
