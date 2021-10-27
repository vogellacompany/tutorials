package com.vogella.unittest.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AssertWithCustomAssertTest {
	@Test
	void ensureNewlyCreatedUserHasNoPosts() {
	    User user = new User("admin");
	    assertThat(user.getPostCount()).as("User \"%s\" has no posts", user.getName()).isEqualTo(0);
	}
	
	@Test
	public void newlyCreatedUserHasNoPosts() throws Exception {
	    User user = new User("admin");
	    com.vogella.unittest.assertj.Assertions.assertThat(user).hasNoPosts();
	}
	
}
