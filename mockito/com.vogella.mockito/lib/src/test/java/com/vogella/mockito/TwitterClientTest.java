package com.vogella.mockito;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TwitterClientTest {

	@Mock
	ITweet tweet;

	@Test
	void ensureThatTwitterClientCallsGetMessageOnTweet() {
		TwitterClient twitterClient = new TwitterClient();

		when(tweet.getMessage()).thenReturn("Using mockito is great");

		twitterClient.sendTweet(tweet);
		verify(tweet, atLeastOnce()).getMessage();

	}

}