class MorseBinaryTree {
    private Node root; // Root

    // Initializes empty root node
    public MorseBinaryTree() {
        root = new Node();
    }

    // Method to insert a char and morsecode to tree
    public void insert(String morseCode, char character) {
        Node current = root;
        for (char symbol : morseCode.toCharArray()) {
            if (symbol == '.') {
                // If dot, go left
                if (current.left == null) {
                    current.left = new Node();
                }
                current = current.left;
            } else if (symbol == '-') {
                // If dash, go right
                if (current.right == null) {
                    current.right = new Node();
                }
                current = current.right;
            }
        }
        // Set the char at the final
        current.character = character;
    }

    // Method to search for a char using morse
    public char search(String morseCode) {
        Node current = root;
        for (char symbol : morseCode.toCharArray()) {
            if (symbol == '.') {
                current = current.left;
            } else if (symbol == '-') {
                current = current.right;
            }
            // If node is null, char not found
            if (current == null) {
                return '\0';
            }
        }
        // Return the char at the final
        return current.character;
    }

    // Method to display entire tree
    public void displayTree() {
        displayTreeRecursive(root, "", "");
    }

    private void displayTreeRecursive(Node node, String prefix, String childrenPrefix) {
        if (node == null) {
            return;
        }

        // Print the actual node
        System.out.println(prefix + (node.character != '\0' ? node.character : ""));

        // Recursively display left and right
        if (node.left != null || node.right != null) {
            displayTreeRecursive(node.right, childrenPrefix + "├── ", childrenPrefix + "│    ");
            displayTreeRecursive(node.left, childrenPrefix + "└── ", childrenPrefix + "   ");
        }
    }
}
