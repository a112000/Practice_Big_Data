import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice_9 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("////////////////////////////////////////////" +
                "/// Variant 1, Task num.4: even and odd numbers ///" +
                "////////////////////////////////////////////");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> partitions = numbers.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        List<Integer> evens = partitions.get(true);
        List<Integer> odds = partitions.get(false);
        System.out.println(evens);
        System.out.println(odds);
        System.out.println();

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 1, Task num.5: list of strings to a set of strings ///" +
                "////////////////////////////////////////////");
        List<String> strings = Arrays.asList("word", "word", "house", "room", "house");
        Set<String> set_strings = strings.stream().collect(Collectors.toSet());
        System.out.println(set_strings);
        System.out.println();

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 2, Task num.4: list of strings to a map of strings with indices ///" +
                "////////////////////////////////////////////");
        Map<Integer, String> partitions_s = IntStream.range(0, strings.size()).boxed()
                .collect(Collectors.toMap(Function.identity(), strings::get));
        System.out.println(partitions_s);
        System.out.println();

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 2, Task num.5: group by first chars in strings ///" +
                "////////////////////////////////////////////");
        Map<Character, List<String>> groupings_s = strings.stream()
                .flatMap(s -> Stream.of(s.split("[^a-zA-Z]")))
                .filter(s -> s.length() > 0)
                .map(s -> s.toLowerCase())
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(groupings_s);
        System.out.println();
    }
}
