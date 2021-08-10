package com.vogella.unittest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class GithubIntegrationTests {

	@Test
	void ensureThatUserAPICanCalled() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.github.com/users/vogella")).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		assertThat(response.statusCode()).isEqualTo(200);

	}

	@Test
	void ensureThatJsonIsReturned() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.github.com/users/vogella")).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		Optional<String> firstValue = response.headers().firstValue("Content-Type");
		String string = firstValue.get();
		assertThat(string).startsWith("application/json");
	}

	@Test
	void ensureJsonContainsTwitterHandler() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.github.com/users/vogella")).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		// For easy to see the output
		System.out.println(body);
		assertTrue(body.contains("twitter_username\":\"vogella\""));
		// TODO check for the twitter handler
	}
}
