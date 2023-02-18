# REGEX

INTRO:

**Character Classes** - it represents a set or class of characters
List:
1. "." - Matches any Character
2. [aei] - it finds all occurrance of each character
3. [aei][Fj] - replace there characters if followed by [Fj]
4. [^ej] - actual character class.  It mean "except".  In this case, in Regex.Regex.java, it refers to replace all characters except e & j.  Just because it is inside the "[]".
5. [a-e1-5] - The "-" indicates it is a range and case-sensitive 
6. (?i) - ignores case sensitivity.  Works with ASCII  CODE (?u)
7. \d - it is for digits
8. \D - replace all non-digits
9. \s = replaces all white spaces to include \t and \n
10. \S = replaces-only tabs and new lines
11. "\w" matches **any word character**, which includes letters, digits, and underscores. It is equivalent to the character class "[a-zA-Z0-9_]".
12. "\W" matches **any non-word character**, which includes any character that is not a letter, digit, or underscore. It is equivalent to the character class "[^a-zA-Z0-9_]".
13. \b- 
`    String input = "Say hello to the world";
    Pattern pattern = Pattern.compile("\\bhello\\b");
    Matcher matcher = pattern.matcher(input);
    if (matcher.find()) {
    System.out.println("Match found at position " + matcher.start());
    }`





**Boundary Matcher** - Looks for boundaries such as the beginning and end of a string or a word.
1. "^" -> Must match **beginning** of string, but not if it reoccurs again 
2. "$" -> the dollar sign ($) is used as an anchor that matches the end of a line or string. When used at the end of a regular expression pattern, it matches the position immediately before the end of the string or line.
3. [aei] -> it finds all occurrance of each character


**Quantifiers** - Now quantify specify how often an element in a regular expression can occur.

1. {} -  curly braces "{}" are used to indicate a quantifier, which specifies how many times a character or group of characters can appear.
- {2, 4} specified range 
#### This is an example for a date below: 
`\d{4}-\d{2}-\d{2}
`
2. + - Matches the preceding character one or more times.
- The pattern "go+l" would match "gol", "gool", "goooool", but not "gl" because there must be at least one "o" between the "g" and the "l".
3. * - Matches the preceding character zero or more times.
- The pattern "go*l" would match "gl", "gol", "gool", "goooool", and any other variations with any number of "o"s, including "g" followed by "l" with no "o"s.
- May be optional occurrence

### Pattern Matcher




```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
public static void main(String[] args) {
// Step 1: Create a Pattern object
Pattern pattern = Pattern.compile("\\d+");

        // Step 2: Create a Matcher object
        String input = "Hello 123 World 456";
        Matcher matcher = pattern.matcher(input);

        // Step 3: Find matches in the input string
        while (matcher.find()) {
            String match = matcher.group();
            System.out.println(match);
        }
    }
````

Here's a breakdown of what's happening:

1. We create a Pattern object using the Pattern.compile() method. The pattern, \\d+, matches one or more digits. 
2. We create a Matcher object using the pattern.matcher() method and pass in the input string we want to search, "Hello 123 World 456". 
3. We use the matcher.find() method to find all matches in the input string. Inside the while loop, we use the matcher.group() method to retrieve the matched string and print it to the console.
````
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexExample {

public static void main(String[] args) {

String input = "The quick brown fox jumped over the lazy dog.";
Pattern pattern = Pattern.compile("\\w+");
Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String match = matcher.group();
            System.out.println("Match found: " + match);
        }
    }
}
`








