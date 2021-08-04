/*
 * Copyright (c) 2020 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package com.vogella.mockito.mockstatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.exceptions.verification.NoInteractionsWanted;
import org.mockito.exceptions.verification.WantedButNotInvoked;

class StaticMockTest {

	@Test
	void testStaticMockSimple() {
		assertEquals("foo", Dummy.foo());
		try (MockedStatic<Dummy> ignored = mockStatic(Dummy.class)) {
			assertNull(Dummy.foo());
		}
		assertEquals("foo", Dummy.foo());
	}

	@Test
	void testStaticMockWithVerification() {
		try (MockedStatic<Dummy> dummy = mockStatic(Dummy.class)) {
			dummy.when(Dummy::foo).thenReturn("bar");
			assertEquals("bar", Dummy.foo());
			dummy.verify(Dummy::foo);
		}
	}

	void testStaticMockWithVerificationFailed() {
		try (MockedStatic<Dummy> dummy = mockStatic(Dummy.class)) {

			assertThrows(WantedButNotInvoked.class, () -> {
				dummy.verify(Dummy::foo);
			});
		}
	}

	@Test
	void testStaticMockWithMoInteractions() {
		try (MockedStatic<Dummy> dummy = mockStatic(Dummy.class)) {
			dummy.when(Dummy::foo).thenReturn("bar");
			dummy.verifyNoInteractions();
		}
	}

	void testStaticMockWithMoInteractionsFailed() {
		try (MockedStatic<Dummy> dummy = mockStatic(Dummy.class)) {
			dummy.when(Dummy::foo).thenReturn("bar");
			assertEquals("bar", Dummy.foo());

			assertThrows(NoInteractionsWanted.class, () -> {
				dummy.verifyNoInteractions();
			});

		}
	}

	@Test
	void testStaticMockWithMoMoreInteractions() {
		try (MockedStatic<Dummy> dummy = mockStatic(Dummy.class)) {
			dummy.when(Dummy::foo).thenReturn("bar");
			assertEquals("bar", Dummy.foo());
			dummy.verify(Dummy::foo);
			dummy.verifyNoMoreInteractions();
		}
	}

	void testStaticMockWithMoMoreInteractionsFailed() {
		try (MockedStatic<Dummy> dummy = mockStatic(Dummy.class)) {
			dummy.when(Dummy::foo).thenReturn("bar");
			assertEquals("bar", Dummy.foo());
			assertThrows(NoInteractionsWanted.class, () -> {
				dummy.verifyNoMoreInteractions();
			});
		}
	}

	@Test
	void testStaticMockWithDefaultAnswer() {
		try (MockedStatic<Dummy> dummy = mockStatic(Dummy.class, invocation -> "bar")) {
			assertEquals("bar", Dummy.foo());
			dummy.verify(Dummy::foo);
		}
	}

	@Test
	void testStaticMockWithRealMethodCall() {
		try (MockedStatic<Dummy> dummy = mockStatic(Dummy.class)) {
			dummy.when(Dummy::foo).thenCallRealMethod();
			assertEquals("foo", Dummy.foo());
			dummy.verify(Dummy::foo);
		}
	}

	@Test
	void testStaticMockReset() {
		try (MockedStatic<Dummy> dummy = mockStatic(Dummy.class)) {
			dummy.when(Dummy::foo).thenReturn("bar");
			dummy.reset();
			assertNull(Dummy.foo());
		}
	}

	@Test
	void testStaticMockClear() {
		try (MockedStatic<Dummy> dummy = mockStatic(Dummy.class)) {
			dummy.when(Dummy::foo).thenReturn("bar");
			assertEquals("bar", Dummy.foo());
			dummy.clearInvocations();
			dummy.verifyNoInteractions();
		}
	}

	@Test
	void testStaticMockDoesNotAffectDifferentThread() throws InterruptedException {
		try (MockedStatic<Dummy> dummy = mockStatic(Dummy.class)) {
			dummy.when(Dummy::foo).thenReturn("bar");
			assertEquals("bar", Dummy.foo());
			dummy.verify(Dummy::foo);
			AtomicReference<String> reference = new AtomicReference<>();
			Thread thread = new Thread(() -> reference.set(Dummy.foo()));
			thread.start();
			thread.join();
			assertEquals("foo", reference.get());
			dummy.when(Dummy::foo).thenReturn("bar");
			assertEquals("bar", Dummy.foo());
			dummy.verify(Dummy::foo, times(2));
		}
	}

	@Test
	void testStaticMockCanCoexistWithMockInDifferentThread() throws InterruptedException {
		try (MockedStatic<Dummy> dummy = mockStatic(Dummy.class)) {
			dummy.when(Dummy::foo).thenReturn("bar");
			assertEquals("bar", Dummy.foo());
			dummy.verify(Dummy::foo);
			AtomicReference<String> reference = new AtomicReference<>();
			Thread thread = new Thread(() -> {
				try (MockedStatic<Dummy> dummy2 = mockStatic(Dummy.class)) {
					dummy2.when(Dummy::foo).thenReturn("qux");
					reference.set(Dummy.foo());
				}
			});
			thread.start();
			thread.join();
			assertEquals("qux", reference.get());
			dummy.when(Dummy::foo).thenReturn("bar");
			assertEquals("bar", Dummy.foo());
			dummy.verify(Dummy::foo, times(2));
		}
	}

	void testStaticMockMustBeExclusiveInScopeWithinThread() {

		try {
			try (MockedStatic<Dummy> dummy = mockStatic(Dummy.class);
					MockedStatic<Dummy> duplicate = mockStatic(Dummy.class)) {

				fail("Not supposed to allow duplicates");
			}

		} catch (Exception e) {
			assertEquals(MockitoException.class, e.getClass());
		}
	}

	@Test
	void testStaticMockVoid() {
		try (MockedStatic<Dummy> dummy = mockStatic(Dummy.class)) {
			Dummy.fooVoid("bar");
			assertNull(Dummy.var1);
			dummy.verify(() -> Dummy.fooVoid("bar"));
		}
		Dummy.fooVoid("bar");
		assertEquals("bar", Dummy.var1);
	}

	static class Dummy {

		static String var1 = null;

		static String foo() {
			return "foo";
		}

		static void fooVoid(String var2) {
			var1 = var2;
		}
	}
}
