package stramset.learn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {
	public static void main(String[] args) {
		List<Study> studys = List.of(new Study("Spring", "Framework", 98, 20000),
				new Study("Spring Boot", "Framework", 95, 18000), new Study("API", "Microservices", 97, 22000),
				new Study("Microservices", "Microservices", 96, 25000), new Study("FullStack", "FullStack", 91, 14000),
				new Study("AWS", "Cloud", 92, 21000), new Study("Azure", "Cloud", 99, 21000),
				new Study("Docker", "Cloud", 92, 20000), new Study("Kubernetes", "Cloud", 91, 20000));
		int[] number = { 1, 2, 3, 4, 5, 6, 7, 6, 9, 40, };
		// TODO 0- Converting Array to Stream or Stream.of()
		System.out.println("----------------------");
		Arrays.stream(number);
		Arrays.stream(number).sum();
		Arrays.stream(number).average();

		// TODO 1 - allMatch, noneMatch, anyMatch (Return Boolean)

		// TODO Check reviewScore is greater then 90 for course
		studys.stream().map(cur -> cur.getReviewScore() > 90);
		System.out.println("----------------------");

		System.out.println(studys.stream().allMatch(cur -> cur.getReviewScore() > 90));

		// TODO 2- Sorting by NumberOfStudents
		System.out.println("----------------------");
		System.out.println(
				studys.stream().sorted(Comparator.comparingInt(Study::getNoOfStudents)).collect(Collectors.toList()));
		System.out.println("------Decreasing Order---------");
		System.out.println(studys.stream().sorted(Comparator.comparingInt(Study::getNoOfStudents).reversed())
				.collect(Collectors.toList()));

		// TODO 3- Sorting by NumberOfStudents and reviewScore
		System.out.println("----------------------");
		System.out.println("------Sorting by NumberOfStudents and reviewScore---------");
		System.out
				.println(
						studys.stream()
								.sorted(Comparator.comparingInt(Study::getNoOfStudents)
										.thenComparingInt(Study::getReviewScore).reversed())
								.collect(Collectors.toList()));

		// TODO 4- Choose the top 5 courses from List (By using -> Limits)
		System.out.println("----------------------");
		System.out.println("--Sorting & Choose the top 5 courses--");

		System.out
				.println(studys
						.stream().sorted(Comparator.comparingInt(Study::getNoOfStudents)
								.thenComparingInt(Study::getReviewScore).reversed())
						.limit(5).collect(Collectors.toList()));

		// TODO 5- Sort and skip the top 3 courses
		System.out.println("----------------------");
		System.out.println("--Sorting & skip top 3 courses with limit--");

		System.out.println(studys.stream()
				.sorted(Comparator.comparingInt(Study::getNoOfStudents).thenComparingInt(Study::getReviewScore)).skip(3)
				.limit(5).collect(Collectors.toList()));

		// TODO 6- takeWhile & dropWhile
		// Check the list whose reviewScore is less then 95 and return that course
		System.out.println("----------------------");
		System.out.println("Check the list whose reviewScore is greater then 95 and return that course");
		System.out.println(studys.stream().takeWhile(x -> x.getReviewScore() >= 95).collect(Collectors.toList()));

		System.out.println("Check the list whose reviewScore is less then 95 and return that course");
		System.out.println(studys.stream().dropWhile(x -> x.getReviewScore() >= 95).collect(Collectors.toList()));

		// TODO 7- Check which is best course on the basis of Number of Students, Find
		// First
		System.out.println("----------------------");
		System.out.println("Check which is best course on the basis of Number of Students");
		System.out.println(studys.stream().max(Comparator.comparing(Study::getNoOfStudents)));

		// Returning Optional.Empty

		System.out.println(studys.stream().filter(x -> x.getReviewScore() < 90)
				.min(Comparator.comparingInt(Study::getNoOfStudents).thenComparingInt(Study::getReviewScore))
				.orElse(new Study("Kubernetes", "Cloud", 91, 20000)));

		System.out.println("--------Find First & Find Any-------------");
		System.out.println(studys.stream().filter(x -> x.getReviewScore() < 90).findFirst());

		// TODO 8- Find Avg No of Students, Sum & Count
		System.out.println("--------Avg sum & Count-------------");
		System.out.println(studys.stream().filter(x -> x.getReviewScore() > 95).mapToInt(Study::getNoOfStudents).sum());
		System.out.println(
				studys.stream().filter(x -> x.getReviewScore() > 95).mapToInt(Study::getNoOfStudents).average());
		System.out
				.println(studys.stream().filter(x -> x.getReviewScore() > 95).mapToInt(Study::getNoOfStudents).count());
		System.out.println(studys.stream().filter(x -> x.getReviewScore() > 95).mapToInt(Study::getNoOfStudents).max());

		// TODO 9- Group By using hashMap by category
		System.out.println("--------Grouping By-------------");
		System.out.println(studys.stream().collect(Collectors.groupingBy(Study::getCategory)));

		System.out.println("--------Count Number of Courses-------------");
		System.out.println(studys.stream().collect(Collectors.groupingBy(Study::getCategory, Collectors.counting())));
		System.out.println("--------Get Course On the basis of highest review-------------");
		System.out.println(studys.stream().collect(Collectors.groupingBy(Study::getCategory,
				Collectors.maxBy(Comparator.comparing(Study::getReviewScore)))));
		System.out.println(studys.stream().collect(
				Collectors.groupingBy(Study::getCategory, Collectors.mapping(Study::getName, Collectors.toSet()))));
		System.out.println("--------Grouping By particualr category-------------");
		Map<String, List<Study>> res = studys.stream().filter(x -> x.getCategory().equals("Cloud"))
				.collect(Collectors.groupingBy(Study::getCategory, Collectors.toList()));
		System.out.println(res);

		// TODO test
		System.out.println("--------Testing-------------");
		studys.parallelStream().map(Study::getName).forEachOrdered(x -> {
			System.out.println(x);
		});
	}
}

class Study {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Study(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}

}