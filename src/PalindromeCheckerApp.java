import java.util.Scanner;
public class PalindromeCheckerApp {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input : ");
        String input = scanner.nextLine();

        boolean result = check(input, 0, input.length() - 1);

        System.out.println("Is Palindrome? : " + result);

        scanner.close();
    }

    /**
     * Recursively checks whether a string is palindrome.
     *
     * @param s     Input string
     * @param start Starting index
     * @param end   Ending index
     * @return true if palindrome, otherwise false
     */
    private static boolean check(String s, int start, int end) {

        // Base condition: If start index crosses end index
        if (start >= end) {
            return true;
        }

        // If characters at current positions do not match
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }

        // Recursive call moving toward center
        return check(s, start + 1, end - 1);
    }
}
