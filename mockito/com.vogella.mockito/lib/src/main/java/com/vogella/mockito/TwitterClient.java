package com.vogella.mockito;

public class TwitterClient {

	public void sendTweet(ITweet tweet) {
		String message = tweet.getMessage();

		// TODO send the message to Twitter
		// not implemented as this is only a demo for the usage of Mockito
		System.out.println(message);
	}
}