package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);

        //String Literal Replacement
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".", "Y"));
        System.out.println(alphanumeric.replaceAll(".","Y"));

        //Notice the replacement length does not match with the beginning of the regex //YYYF12Ghhiiiijkl99z
        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

        //Proof of concept
        String secondString = "abcDeeeF12GhhabcDeeeiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));

        //Notice that it is within the String
        //Cannot match part of a string
        //It has to be one-to-one match
        System.out.println(alphanumeric.matches("^hello")); //false
        System.out.println(alphanumeric.matches("^abcDeee"));//false
        System.out.println(alphanumeric.matches("abcDeeeF12Ghhiiiijkl99z")); //true

        //"abcDeeeF12GhhabcDeeeiiiijkl99z" =>"abcDeeeF12GhhabcDeeeiiiTHE END"
        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));

        //Think of it as an extension
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));


        //This is how you Convert characters in a string literal
        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));

        //Comfirms that regex are case sensitive
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[a-f3-8]", "X"));
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f]", "X"));

        //replace all numbers
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));

        //Has white space
        String hasWhiteSpace = "I have blanks and \t a table, amd also newline \n";
        System.out.println(hasWhiteSpace);
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));
        System.out.println(hasWhiteSpace.replaceAll("\\S", ""));

        //replaces all whitespace
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\W", "X"));

        //Surrounds the replacement string
        System.out.println(hasWhiteSpace.replaceAll("\\b", "X"));

        String thirdAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe{3}", "YYY"));

        //One or more 'e'
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe+", "YYY"));

        //Zero or more 'e'
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe*", "YYY"));

        //This will match between 2 to 5 SPECIFIED letter 'e'
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe{2,5}", "YYY"));

        //we want to see one 'h' , zero or more 'i' followed by a character of 'j'
        System.out.println(thirdAlphanumeric.replaceAll("h+i*j", "YYY"));

        StringBuilder htmlText = new StringBuilder("<h1> My heading </h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something<p>");
        htmlText.append("<p>This is a paragraph as well<p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>This is a paragraph<p>");

        //to determine if there is any h2 tags
        String h2Pattern = ".*<h2>.*"; //<---dot will match every character and * means zero or more so there can be anything before and after the h2 and there will be a match
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());



    }

}
