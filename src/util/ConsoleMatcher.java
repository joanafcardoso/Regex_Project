package util;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by Cardoso on 23-Feb-16.
 */
// working on terminal window

public class ConsoleMatcher {
    public static void main(String[] args) {

        //check if the virtual machine has a console
        Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        String regex, search;
        while (true) {
            regex = console.readLine("%-15s", "Enter regex: ");
            search = console.readLine("%-15s", "Search text: ");
            if (search.equals("END")) break;

            try {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(search);
                boolean found = false;
                System.out.print("Found at: ");
                while (matcher.find()) {
                    System.out.print("Start: " + matcher.start() + " " + " Group: " + matcher.group() + " ");
                    found = true;
                }
                if (!found) {
                    console.format("No match found.%n");
                }
            } catch (PatternSyntaxException pe) {
                System.out.println("Regex pattern invalid");
            }
        }
    }
}