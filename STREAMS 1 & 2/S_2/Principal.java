package Stream_2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;

public class Principal {

    public static void main(String[] args) {

        // The list of customer feedback comments
        List<String> feedbackComments = Arrays.asList(
            "Great service!",
            "The product quality is superb.",
            "Great service!",
            "Delivery was late.",
            "Excellent product.",
            "Very satisfied with the purchase.",
            "Very satisfied with the purchase.",
            "Good value for money.",
            "Poor customer support.",
            "The product quality is superb."
        );

        // Process the feedback comments to analyze meaningful feedback
        // 1. Filter comments that contain the keyword "product"
        // 2. Convert comments to uppercase
        // 3. Remove duplicate comments
        // 4. Count occurrences of each unique comment
        // 5. Sort comments by their frequency and print them

        Map<String, Long> commentFrequency = feedbackComments.stream()
            .filter(comment -> comment.toLowerCase().contains("product")) // Filter comments containing "product"
            .map(String::toUpperCase) // Convert comments to uppercase
            .distinct() // Remove duplicate comments
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // Count occurrences of each unique comment

        commentFrequency.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed()) // Sort by frequency in descending order
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " times")); // Print each comment with its frequency
    }
}

