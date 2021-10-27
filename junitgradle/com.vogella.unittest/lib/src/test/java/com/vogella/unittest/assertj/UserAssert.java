package com.vogella.unittest.assertj;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

public class UserAssert extends AbstractAssert<UserAssert, User> {

    public UserAssert hasNoPosts() {
          // check that actual User we want to make assertions on is not null.
          isNotNull();

          // overrides the default error message with a more explicit one
          String assertjErrorMessage = "\nExpecting User <%s> to have no posts\n but was:\n  <%s> posts";

          // null safe check
          int actualNumberOfPosts = actual.getPostCount();
          if (!Objects.areEqual(actualNumberOfPosts, 0)) {
            failWithMessage(assertjErrorMessage, actual.getName(), actualNumberOfPosts);
          }

          // return the current assertion for method chaining
          return this;
        }

    public UserAssert(User actual) {
        super(actual, UserAssert.class);
    }

    public static UserAssert assertThat(User actual) {
        return new UserAssert(actual);
    }

}