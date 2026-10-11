import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamPractice {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList();
		List<Integer> even = nums.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println(even);
		
		System.out.println("====================================================");
		
		Optional<Integer> max = nums.stream().max(Integer::compareTo);

		System.out.println(max);
		System.out.println(max.orElse(0));
//		System.out.println(max.get()); -- only if u know list is not empty
		
		System.out.println("====================================================");
		
		Integer maxx = nums.stream().max(Integer::compareTo).orElse(null);
		System.out.println(maxx);
		
		System.out.println("====================================================");
		
		List<String> words = Arrays.asList("java", "python", "cpp", "c", "php", "nodejs", "oracle", "apple", "netflix",
				"microsoft");
		List<String> upper = words.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(upper);
		System.out.println(words);

		Map<Integer, List<String>> group = words.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(group);
	
		List<String> wordsA = words.stream().filter(s-> s.startsWith("a") || s.startsWith("A")).collect(Collectors.toList());
		System.out.println(wordsA);
	
	}

}
