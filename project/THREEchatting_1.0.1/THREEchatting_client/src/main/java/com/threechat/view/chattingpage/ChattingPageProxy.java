package com.threechat.view.chattingpage;

public class ChattingPageProxy implements IChattingPage{
	
	private IChattingPage chattingPage;
	
	public ChattingPageProxy(IChattingPage chattingPage) {
		this.chattingPage = chattingPage;
	}

	@Override
	public void startChattingPage() {
		//chattingPage.
		
	}
}
