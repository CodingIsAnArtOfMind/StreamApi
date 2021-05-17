package stramset.learn;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FP02Structured {
	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		List<Integer> squaredNumbers = squareList(numbers);
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"Kubernetes");

		List<Integer> evenNumbersOnly = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println(maximumNumber(numbers));
		System.out.println(minimumNumber(numbers));
		System.out.println("--- Print Sqr Numbers----");
		System.out.println(squareNumber(numbers));
		System.out.println("--- Sum of odd numbers----");
		System.out.println(sumOfOddNumber(numbers));
		System.out.println("--- Normal sorting----");
		System.out.println(normalSort(numbers));
		System.out.println("--- Reverse sorting----");
		System.out.println(reverseSort(numbers));

		// System.out.println(squaredNumbers);
		// System.out.println(evenNumbersOnly);

		// 0 12
		// 12 9
		// 21 13
		// 34 4
		// 38 6
		// 44 2
		// 46 4
		// 50 12
		// 62 15
		// 77

		// int sum = addListFunctional(numbers);
		//
		// System.out.println(sum);

	}

	private static List<Integer> reverseSort(List<Integer> numbers) {

		return numbers.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	}

	private static List<Integer> normalSort(List<Integer> numbers) {

		return numbers.stream().distinct().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
	}

	private static Integer sumOfOddNumber(List<Integer> numbers) {
		List<Integer> oddNum = numbers.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
		return oddNum.stream().reduce(0, Integer::sum);

	}

	private static Integer squareNumber(List<Integer> numbers) {
		Stream<Integer> num = numbers.stream().map(x -> x * x);
		int res = num.reduce(0, Integer::sum);

		return res;
	}

	private static Integer minimumNumber(List<Integer> numbers) {
		return numbers.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);
	}

	private static Integer maximumNumber(List<Integer> numbers) {
		return numbers.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x : y);

	}

	private static List<Integer> squareList(List<Integer> numbers) {
		// 1 , 5, 6
		// 1 -> 1
		// 5 -> 25
		// 6 -> 36

		return numbers.stream().map(number -> number * number).collect(Collectors.toList());
	}

	private static int sum(int aggregate, int nextNumber) {
		System.out.println(aggregate + " " + nextNumber);
		return aggregate + nextNumber;
	}

	private static int addListFunctional(List<Integer> numbers) {
		// Stream of number -> One result value
		// Combine them into one result => One Value
		// 0 and FP02Functional::sum
		// reduce start with initail value eg: like int sum-0;
		return numbers.stream().parallel()
				// .reduce(0, FP02Functional::sum);
				// .reduce(0, (x,y) -> x + y);
				.reduce(0, Integer::sum);
	}
}
