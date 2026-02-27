import java.util.Scanner;
public class PalindromeCheckerApp {
    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    // Add node at end
    public static void add(char data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Check palindrome using fast/slow pointer & reverse
    public static boolean isPalindrome() {

        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        // Find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node prev = null;
        Node current = slow;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Compare halves
        Node firstHalf = head;
        Node secondHalf = prev;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data)
                return false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Reset list before new input
    public static void clearList() {
        head = null;
    }

    /**
     * Application entry point for UC8
     */

    public static void main (String[] args)
    {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        clearList();

        // Convert input string to linked list
        for (char c : input.toCharArray()) {
            add(c);
        }

        boolean result = isPalindrome();

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);

        scanner.close();
    }
}
