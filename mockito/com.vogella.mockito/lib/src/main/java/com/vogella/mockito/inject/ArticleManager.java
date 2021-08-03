package com.vogella.mockito.inject;

import java.util.Objects;

public class ArticleManager {
	private User user;
	private ArticleDatabase database;

	// not necessary for Mockito but a Java standard supported by many framework
	// would be the usage of @Inject from Java Specification Request (JSR 330)
	// @Inject
	public ArticleManager(User user, ArticleDatabase database) {
		Objects.requireNonNull(user);
		Objects.requireNonNull(database);
		this.user = user;
		this.database = database;
	}

	public void initialize() {
		database.addListener(new ArticleListener());
		database.setUser(user);
	}
}