package http2;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Scanner;

public class RequestInputStream {

	private InputStream in;
	private Scanner scanner;
	private String urlPattern;
	private String urlPage;
	private String urlKey;
	private String fileName;
	private String ext;
	private String query;
	
	public RequestInputStream(InputStream in) throws Exception{
		
		this.in = in;
		this.scanner = new Scanner(in);
		parsingRequest(scanner.nextLine());
	}
	
	private void parsingRequest(String dataStr) throws Exception {

		//GET / HTTP1.1
		
		String[] arr = dataStr.split(" ");
		
		this.urlPattern = URLDecoder.decode(arr[1],"UTF-8");
		
		
		String[] outerArr = urlPattern.split("\\?");
		
		this.urlPage = outerArr[0];
		
		System.out.println(urlPage);
		
//		System.out.println(urlPage.split("\\.")[0]);
		
		this.urlKey = urlPage.split("\\.")[0];
		
		this.ext = outerArr[0].substring(outerArr[0].indexOf(".")+1);
		
		if(outerArr.length > 1){
			this.query = outerArr[1];
			
			this.fileName = outerArr[1].split("\\=")[1];
		}
		
	}

	public String getFileName() {
		return fileName;
	}

	public InputStream getIn() {
		return in;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public String getUrlPattern() {
		return urlPattern;
	}

	public String getUrlPage() {
		return urlPage;
	}

	public String getExt() {
		return ext;
	}

	public String getQuery() {
		return query;
	}

	public String getUrlKey() {
		return urlKey;
	}
}
