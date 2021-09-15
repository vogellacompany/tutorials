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
public class LocalInitialization {

	@Setup
	public void setup() {
	}

	@Benchmark
	public void unnecessaryInitialization() {
		String s = "";
		s = "Hello";
	}
	
	@Benchmark
	public void directAssignment() {
		String s =  "Hello";
	}
}