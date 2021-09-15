package benchmarks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 200, time = 1, timeUnit = TimeUnit.MILLISECONDS)
//@Fork(value = 3, jvmArgsAppend = {"-XX:+UseParallelGC", "-Xms1g", "-Xmx1g"})
@Fork(value = 1)
@BenchmarkMode(org.openjdk.jmh.annotations.Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(org.openjdk.jmh.annotations.Scope.Benchmark)
public class ToArrayBench {

	@Param({ "0", "1", "10", "100", "1000" })
	int size;
	@Param({ "arraylist" })//, "hashset"
	String type;
	Collection<Foo> coll;

	@Setup
	public void setup() {
		if (type.equals("arraylist")) {
			coll = new ArrayList<Foo>();
		} else if (type.equals("hashset")) {
			coll = new HashSet<Foo>();
		} else {
			throw new IllegalStateException();
		}
		for (int i = 0; i < size; i++) {
			coll.add(new Foo(i));
		}
	}

	@Benchmark
	public Object[] simple() {
		return coll.toArray();
	}

	@Benchmark
	public Foo[] zero() {
		return coll.toArray(new Foo[0]);
	}

	@Benchmark
	public Foo[] sized() {
		return coll.toArray(new Foo[coll.size()]);
	}

	@Benchmark
	public Foo[] arrayNew() {
		return coll.toArray(Foo[]::new);
	}

	public static class Foo {
		private int i;

		public Foo(int i) {
			this.i = i;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Foo foo = (Foo) o;
			return i == foo.i;
		}

		@Override
		public int hashCode() {
			return i;
		}
	}

}