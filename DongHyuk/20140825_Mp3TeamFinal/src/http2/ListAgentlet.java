package http2;

import java.io.File;

public class ListAgentlet extends Agentlet {

	@Override
	public void doJob(RequestInputStream request, ResponseOutputStream response)throws Exception {
		String dirName = "C:\\zzz\\mp3";

		File mp3Dir = new File(dirName);

		String[] songList = mp3Dir.list(); // ������ξȿ� ���� ����Ʈ ���ڿ��迭�� ����
		
		String msg = "<ul>";
		for (String string : songList) {
			msg = msg + "<li>" + "<a href='listen.htm?file=" + string + "'>" + string + "</a>" + "</li>";
		}
		msg = msg + "</ul>";

		response.getBos().write(msg.getBytes("UTF-8"));
		
		makeResponseHearder(request.getExt(), response.getBos().size(), response);
	}

}
