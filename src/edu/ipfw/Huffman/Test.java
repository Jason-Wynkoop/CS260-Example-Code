package edu.ipfw.Huffman;
import java.util.Scanner;


public class Test {

    private static Huffman tree = new Huffman();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter text: ");
        String userInput = scanner.nextLine();
        if (userInput.charAt(0) == ' ' && userInput.charAt(1) == ' ') {
            tree.add(' ', userInput.trim());
        } else
            tree.add(userInput.charAt(0), userInput.substring(1));
        for (int i = 0; i < userInput.length(); i++) {
            userInput = scanner.nextLine();
            tree.add(userInput.charAt(0), userInput.substring(1));
        }
        System.out.println(tree.getDecodedMessage(scanner.nextLine()));

    }


}