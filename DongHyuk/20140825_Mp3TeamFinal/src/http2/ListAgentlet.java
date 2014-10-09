package http2;

import java.io.File;

public class ListAgentlet extends Agentlet {

	@Override
	public void doJob(RequestInputStream request, ResponseOutputStream response)throws Exception {
		String dirName = "C:\\zzz\\mp3";

		File mp3Dir = new File(dirName);

		String[] songList = mp3Dir.list(); // 폴더경로안에 파일 리스트 문자열배열로 저장
		
		String msg = "<ul>";
		for (String string : songList) {
			msg = msg + "<li>" + "<a href='listen.htm?file=" + string + "'>" + string + "</a>" + "</li>";
		}
		msg = msg + "</ul>";

		response.getBos().write(msg.getBytes("UTF-8"));
		
		makeResponseHearder(request.getExt(), response.getBos().size(), response);
	}

}
