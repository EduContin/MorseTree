import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        MorseBinaryTree tree = new MorseBinaryTree();

        // Insert Morse code for letters A-Z and numbers 0-9
        tree.insert(".-", 'A');
        tree.insert("-...", 'B');
        tree.insert("-.-.", 'C');
        tree.insert("-..", 'D');
        tree.insert(".", 'E');
        tree.insert("..-.", 'F');
        tree.insert("--.", 'G');
        tree.insert("....", 'H');
        tree.insert("..", 'I');
        tree.insert(".---", 'J');
        tree.insert("-.-", 'K');
        tree.insert(".-..", 'L');
        tree.insert("--", 'M');
        tree.insert("-.", 'N');
        tree.insert("---", 'O');
        tree.insert(".--.", 'P');
        tree.insert("--.-", 'Q');
        tree.insert(".-.", 'R');
        tree.insert("...", 'S');
        tree.insert("-", 'T');
        tree.insert("..-", 'U');
        tree.insert("...-", 'V');
        tree.insert(".--", 'W');
        tree.insert("-..-", 'X');
        tree.insert("-.--", 'Y');
        tree.insert("--..", 'Z');
        tree.insert("-----", '0');
        tree.insert(".----", '1');
        tree.insert("..---", '2');
        tree.insert("...--", '3');
        tree.insert("....-", '4');
        tree.insert(".....", '5');
        tree.insert("-....", '6');
        tree.insert("--...", '7');
        tree.insert("---..", '8');
        tree.insert("----.", '9');

        // Display the tree
        System.out.println("Morse Code Binary Tree:");
        tree.displayTree();

        // Test searching
        System.out.println("\nSearch Results:");
        System.out.println("'.-' represents: " + tree.search(".-"));
        System.out.println("'...' represents: " + tree.search("..."));
        System.out.println("'--' represents: " + tree.search("--"));
        System.out.println("'.----' represents: " + tree.search(".----"));

        // Display the tree
        System.out.println("Morse Code Binary Tree:");
        tree.displayTree();

        // User input functionality
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter a Morse code message (use space to separate characters, or 'q' to quit):");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            System.out.print("Decoded message: ");
            for (String morseChar : input.split(" ")) {
                char decodedChar = tree.search(morseChar);
                if (decodedChar != '\0') {
                    System.out.print(decodedChar);
                } else {
                    System.out.print("?");
                }
            }
            System.out.println();
        }
        scanner.close();
        System.out.println("Program ended.");
    }

}