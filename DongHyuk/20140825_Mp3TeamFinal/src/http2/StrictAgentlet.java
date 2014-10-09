package http2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class StrictAgentlet extends Agentlet {

	private static final String ROOT = "C:\\zzz\\mp3";
	
	@Override
	public void doJob(RequestInputStream request, ResponseOutputStream response)
			throws Exception {
		// TODO Auto-generated method stub
		
		// /aaa.mp3
		String targetFileName = request.getUrlPage();
		String ext = request.getExt();
		
		System.out.println("ext :" + ext);
		
		ByteArrayOutputStream bos = response.getBos();
		
		File targetFile = new File(ROOT+targetFileName.replaceAll("//", File.pathSeparator));

		System.out.println(targetFile);
		
		CopyUtil.copy(new FileInputStream(targetFile), bos, true, false);
		
		makeResponseHearder(ext, bos.size(), response);
		
		
	}

}