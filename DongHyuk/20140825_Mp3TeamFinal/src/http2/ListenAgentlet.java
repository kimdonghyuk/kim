package http2;

public class ListenAgentlet extends Agentlet {

	@Override
	public void doJob(RequestInputStream request, ResponseOutputStream response)
			throws Exception {
		
		String msg = "<audio src='" + request.getFileName() + "' autoplay='autoplay' controls='controls'>";
		
		response.getBos().write(msg.getBytes());
		
		System.out.println("aaaaa         " + request.getExt());
		
		makeResponseHearder(request.getExt(), response.getBos().size(), response);
	}

}
