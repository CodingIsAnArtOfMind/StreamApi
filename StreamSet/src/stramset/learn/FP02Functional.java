package stramset.learn;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {
	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<Integer> squaredNumbers = squareList(numbers);

		List<Integer> evenNumbersOnly = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());

		// System.out.println(squaredNumbers);
		System.out.println(evenNumbersOnly);

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

	private static List<Integer> squareList(List<Integer> numbers) {
		// TODO Auto-generated method stub
		return null;
	}
}
