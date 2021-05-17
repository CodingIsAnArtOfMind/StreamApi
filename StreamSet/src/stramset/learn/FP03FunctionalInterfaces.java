package stramset.learn;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FP03FunctionalInterfaces {
	/*
	 * A function Interface which contain only one abstract method. No body no
	 * return type
	 * 
	 * Fun method is called func discriptor
	 * 
	 * boolean isEven(int x) { return x%2==0; }
	 * 
	 * int squared(int x) { return x * x; }
	 * 
	 */

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		Collector<Integer, ?, List<Integer>> list = Collectors.toList();
		Function<Integer, Integer> cubeNumber = x -> x * x * x;
		Function<Integer, Integer> cubeNumber2 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer x) {
				return x * x * x;
			}

		};
		List<Integer> cubeNumbers = numbers.stream().map(cubeNumber2).collect(list);
		System.out.println("--- Cube Number List----");
		System.out.println(cubeNumbers);
		System.out.println("--- Dynamic Method Cube List----");
		// Mapping to a method 2nd method for above solution more dynamic

		List<Integer> suareNumbers = mappedAndExtractValue(numbers, list, x -> x * x);
		List<Integer> cubeNumberNumbers = mappedAndExtractValue(numbers, list, x -> x * x * x);
		List<Integer> doubleNumbers = mappedAndExtractValue(numbers, list, x -> (x * x) ^ 2);
		System.out.println(suareNumbers);
		System.out.println(cubeNumberNumbers);
		System.out.println(doubleNumbers);

		System.out.println("----------------------------------");

		Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

		// The compiler is doing below logic for us for above code.
		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer x) {
				return x % 2 == 0;
			}

		};

		Function<Integer, Integer> squareFunction = x -> x * x;

		Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer x) {
				return x * x;
			}

		};

		Consumer<Integer> sysoutConsumer = System.out::println;

		Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
			public void accept(Integer x) {
				System.out.println(x);
			}
		};

		numbers.stream().filter(isEvenPredicate2).map(squareFunction2).forEach(sysoutConsumer2);

		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
		// BinaryOperator<Integer> sumBinaryOperator = (x,y) => x + y;

		BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return a + b;
			}

		};

		int sum = numbers.stream().reduce(0, sumBinaryOperator);
	}

	/**
	 * @param numbers
	 * @param list
	 * @param cubeNumber2
	 * @return
	 */
	private static List<Integer> mappedAndExtractValue(List<Integer> numbers, Collector<Integer, ?, List<Integer>> list,
			Function<Integer, Integer> cubeNumber2) {
		return numbers.stream().map(cubeNumber2).collect(list);
	}
}
