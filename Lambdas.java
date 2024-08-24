package Lambdas;

/* Lambdas_Code Finished in: 24/08/24
 * 
 * By Fernando Sánchez González
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Lambdas {

    public static void main(String[] args) {

        // Supplier<T>, Abstract Method .get()
        System.out.println("*Supplier*");

        // Supplying a Greeting
        Supplier<String> greetingSupplier = () -> "Hello, World!"; // Return "Hello, World!"
        String greeting = greetingSupplier.get();
        System.out.println("Example #1: " + greeting);

        // Supplying a random double value
        Supplier<Double> randomDoubleSupplier = () -> Math.random(); // Return a random double between 0 and 1
        System.out.println("Example #2: " + randomDoubleSupplier.get());

        // Supplying an empty ArrayList
        Supplier<List<Integer>> arrayListSupplier = () -> new LinkedList<>(); // Return an empty ArrayList
        System.out.println("Example #3: " + arrayListSupplier.get());

        // Supplying a fixed number
        Supplier<Integer> fixedNumberSupplier = () -> 42; // Return 42
        System.out.println("Example #4: " + fixedNumberSupplier.get());

        // Consumer<T>, Abstract Method .accept(T)
        System.out.println("*Consumer*");

        // Printing a message
        Consumer<String> messagePrinter = msg -> System.out.println(msg); // Parameter String, Return void
        messagePrinter.accept("Welcome to Lambda Expressions!");

        // Appending text to a StringBuilder
        Consumer<StringBuilder> appendText = sb -> sb.append(" Smith"); // Parameter StringBuilder, Return void
        StringBuilder nameBuilder = new StringBuilder("John");
        appendText.accept(nameBuilder); // Appends " Smith" to the existing StringBuilder "John".
        System.out.println(nameBuilder);

        // Using it with a List
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Consumer<String> printName = name -> System.out.println("Name: " + name); // Parameter String, Return void
        names.forEach(printName); // forEach() internally calls printName.accept(name) for each element in the names list.

        // Incrementing a number
        Consumer<Integer> incrementNumber = num -> System.out.println(num + 1); // Parameter Integer, Return void
        incrementNumber.accept(10);

        // BiConsumer<T, U>, Abstract Method .accept(T, U)
        System.out.println("*BiConsumer*");

        // Printing name and age
        BiConsumer<String, Integer> displayPersonInfo = (name, age) -> {
            System.out.println("Name: " + name + ", Age: " + age); // Printing name and age
        };
        displayPersonInfo.accept("Emily", 25);

        // Adding entries to a Map
        Map<String, Integer> ageMap = new HashMap<>();
        BiConsumer<String, Integer> mapAdder = (key, value) -> ageMap.put(key, value); // Parameter <String, Integer>, Return void
        mapAdder.accept("Jack", 30);
        mapAdder.accept("Jill", 28);
        System.out.println(ageMap); // Printing map

        // Performing a multiplication operation
        BiConsumer<Integer, Integer> multiplyAndLog = (x, y) -> {
            int result = x * y;
            System.out.println("Result of " + x + " * " + y + " = " + result);
        };
        multiplyAndLog.accept(7, 8);

        // Combining two strings
        BiConsumer<String, String> combineStrings = (s1, s2) -> {
            String result = s1 + s2;
            System.out.println(result);
        };
        combineStrings.accept("Hello", " Universe");

        // Predicate<T>, Abstract Method .test(T)
        System.out.println("*Predicate*");

        // Checking if a string is not empty
        Predicate<String> isNotEmpty = str -> !str.isEmpty(); // Parameter <String>, Return boolean
        System.out.println(isNotEmpty.test("Not Empty")); // true

        // Checking if a number is positive
        Predicate<Integer> isPositive = num -> num > 0; // Parameter <Integer>, Return boolean
        System.out.println(isPositive.test(-5)); // false

        // Filtering a list of numbers
        List<Integer> numbers = List.of(1500, 800, 2500, 1200); // Create list with integers
        Predicate<Integer> greaterThan1000 = num -> num > 1000; // Parameter <Integer>, Return boolean
        List<Integer> filteredNumbers = numbers.stream() // Create a stream from the list
                                               .filter(greaterThan1000) // Internally calls test(T) for each element in the stream
                                               .collect(Collectors.toList()); // Gathers the filtered elements into a new list.
        System.out.println(filteredNumbers);

        // Checking if a number is odd
        Predicate<Integer> isOdd = num -> num % 2 != 0; // Parameter <Integer>, Return boolean
        System.out.println(isOdd.test(7)); // true

        // BiPredicate<T, U>, Abstract Method .test(T, U)
        System.out.println("*BiPredicate*");

        // Comparing two integers to see if the first is smaller than the second
        BiPredicate<Integer, Integer> isSmaller = (a, b) -> a < b; // Parameter <Integer, Integer>, Return boolean
        System.out.println(isSmaller.test(3, 5)); // true

        // Checking if one string starts with another
        BiPredicate<String, String> startsWith = (str, prefix) -> str.startsWith(prefix);
        System.out.println(startsWith.test("Lambda Expressions", "Lambda")); // true

        // Checking if two strings are anagrams
        BiPredicate<String, String> areAnagrams = (s1, s2) -> {
            char[] array1 = s1.replaceAll("\\s", "").toLowerCase().toCharArray();
            char[] array2 = s2.replaceAll("\\s", "").toLowerCase().toCharArray();
            Arrays.sort(array1);
            Arrays.sort(array2);
            return Arrays.equals(array1, array2);
        };
        System.out.println(areAnagrams.test("Listen", "Silent")); // true

        // Function<T, R>, Abstract Method .apply(T)
        System.out.println("*Function*");

        // Converting a String to its uppercase
        Function<String, String> toUpperCase = str -> str.toUpperCase(); // Parameter <String>, Return String
        System.out.println(toUpperCase.apply("lowercase"));

        // Calculating the square of a number
        Function<Integer, Integer> square = num -> num * num; // Parameter <Integer>, Return Integer
        System.out.println(square.apply(5)); // 25

        // Concatenating a suffix to a string
        Function<String, String> addSuffix = str -> str + " Jr."; // Parameter <String>, Return String
        System.out.println(addSuffix.apply("John"));

        // Converting a number to its binary string representation
        Function<Integer, String> toBinary = num -> Integer.toBinaryString(num); // Parameter <Integer>, Return String
        System.out.println(toBinary.apply(10)); // 1010

        // BiFunction<T, U, R>, Abstract Method .apply(T, U)
        System.out.println("*BiFunction*");

        // Combining two strings with a separator
        BiFunction<String, String, String> combineWithSeparator = (str1, str2) -> str1 + " | " + str2; // Parameter <String, String, String>, Return String
        System.out.println(combineWithSeparator.apply("Part 1", "Part 2"));

        // Calculating the area of a rectangle
        BiFunction<Double, Double, Double> rectangleArea = (width, height) -> width * height; // Parameter <Double, Double, Double>, Return Double
        System.out.println(rectangleArea.apply(5.0, 8.0)); // 40.0

        // Adding two doubles
        BiFunction<Double, Double, Double> addDoubles = (a, b) -> a + b; // Parameter <Double, Double, Double>, Return Double
        System.out.println(addDoubles.apply(2.5, 3.5)); // 6.0

        // Calculating the average of three numbers
        BiFunction<Integer, Integer, Double> averageOfThree = (a, b) -> (a + b) / 2.0; // Parameter <Integer, Integer, Double>, Return Double
        Double averageResult = averageOfThree.apply(7, 13);
        System.out.println(averageResult);

        // UnaryOperator<T>, Abstract Method .apply(T)
        System.out.println("*UnaryOperator*");

        // Appending a suffix to a string
        UnaryOperator<String> appendSuffix = name -> name + " Sr."; // Parameter <String>, Return String
        System.out.println(appendSuffix.apply("Michael"));

        // Doubling an integer value
        UnaryOperator<Integer> doubleValue = num -> num * 2; // Parameter <Integer>, Return Integer
        System.out.println(doubleValue.apply(8)); // 16

        // Function<T, R>, Abstract Method .apply(T)
        System.out.println("*Function*");

        // Converting a list of integers to strings
        Function<List<Integer>, List<String>> convertToStrings = list -> list.stream()
                                                                             .map(Object::toString)
                                                                             .collect(Collectors.toList()); // Parameter <List<Integer>>, Return List<String>
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        List<String> strings = convertToStrings.apply(integers);
        System.out.println(strings);


        // Incrementing a number by one
        UnaryOperator<Integer> increment = num -> num + 1; // Parameter <Integer>, Return Integer
        System.out.println(increment.apply(15)); // 16

        // BinaryOperator<T>, Abstract Method .apply(T, T)
        System.out.println("*BinaryOperator*");

        // Multiplying two integers
        BinaryOperator<Integer> multiply = (a, b) -> a * b; // Parameter <Integer, Integer>, Return Integer
        System.out.println(multiply.apply(6, 7)); // 42

        // Concatenating two strings
        BinaryOperator<String> concatenate = (s1, s2) -> s1 + s2; // Parameter <String, String>, Return String
        System.out.println(concatenate.apply("Hello, ", "World!"));

        // Finding the maximum of two integers
        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b; // Parameter <Integer, Integer>, Return Integer
        System.out.println(max.apply(12, 19)); // 19

        // Combining two lists
        BinaryOperator<List<String>> combineLists = (list1, list2) -> {
            List<String> combined = new LinkedList<>(list1);
            combined.addAll(list2);
            return combined;
        }; // Parameter <List<String>, List<String>>, Return List<String>
        List<String> list1 = Arrays.asList("A", "B", "C");
        List<String> list2 = Arrays.asList("D", "E", "F");
        List<String> combinedList = combineLists.apply(list1, list2);
        System.out.println(combinedList);

    }
}


