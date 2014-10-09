package http2;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class ResponseOutputStream {

	private OutputStream out;
	private ByteArrayOutputStream bos;
	
	public ResponseOutputStream(OutputStream out, ByteArrayOutputStream bos) {
		super();
		this.out = out;
		this.bos = bos;
	}

	public OutputStream getOut() {
		return out;
	}

	public ByteArrayOutputStream getBos() {
		return bos;
	}
	
	
	
	
}
