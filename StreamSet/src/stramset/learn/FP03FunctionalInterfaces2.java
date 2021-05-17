package stramset.learn;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FunctionalInterfaces2 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		Predicate<Integer> isEvenPredicate = (Integer x) -> x % 2 == 0;

		Function<Integer, Integer> squareFunction = x -> x * x;

		// TODO 1st arg is input and 2nd arg is output in Fn

		Function<Integer, String> stringOutpuFunction = x -> x + " ";

		// TODO Taking Input but returning Void
		Consumer<Integer> sysoutConsumer = x -> System.out.println(x);

		BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;

		// No input > Return Something the empty () state no parameter
		Supplier<Integer> randomIntegerSupplier = () -> {
			Random random = new Random();
			return random.nextInt(1000);
		};

		// System.out.println(randomIntegerSupplier.get());

		UnaryOperator<Integer> unaryOperator = x -> 3 * x;
		System.out.println(unaryOperator.apply(10));

		// Used when u have 2 input args u need boolean return
		BiPredicate<Integer, String> biPredicate = (number, str) -> {
			return number < 10 && str.length() > 5;
		};

		System.out.println(biPredicate.test(10, "in28minutes"));

		// Need 3rd to recognize the return type
		BiFunction<Integer, String, String> biFunction = (number, str) -> {
			return number + " " + str;
		};

		System.out.println(biFunction.apply(15, "in28minutes"));

		BiConsumer<Integer, String> biConsumer = (s1, s2) -> {
			System.out.println(s1);
			System.out.println(s2);
		};

		biConsumer.accept(25, "in28Minutes");

		// In wrapper class we have issue like boxing and autoBoxing which crete
		// perfomance issue better to use primitive
		BinaryOperator<Integer> sumBinaryOperator2 = (x, y) -> x + y;

		// Primitive
		IntBinaryOperator intBinaryOperator = (x, y) -> x + y;

		// IntBinaryOperator
		// IntConsumer
		// IntFunction
		// IntPredicate
		// IntSupplier
		// IntToDoubleFunction
		// IntToLongFunction
		// IntUnaryOperator

		// Long, Double, Int

		// numbers.stream().filter(isEvenPredicate).map(squareFunction).forEach(sysoutConsumer);

		// int sum = numbers.stream().reduce(0, sumBinaryOperator);
	}
}
