package stramset.learn;

import java.util.List;
import java.util.function.Predicate;

public class HigherOrderFn {
	public static void main(String[] args) {
		List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));

		// A fn which return fn is called HOFn
		// Extract Method ---> course -> course.getReviewScore() > 95
		// int cutOff = 95;
		Predicate<Course> reviewScoreGreaterThan95Predicate = extracted(95);

		Predicate<Course> reviewScoreGreaterThan90Predicate = extracted(90);

	}

	/**
	 * @param cutOff
	 * @return
	 */
	private static Predicate<Course> extracted(int cutOff) {
		return course -> {

			return course.getReviewScore() > cutOff;
		};
	}
}
