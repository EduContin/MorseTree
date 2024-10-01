class MorseBinaryTree {
    private Node root;

    public MorseBinaryTree() {
        root = new Node();
    }

    public void insert(String morseCode, char character) {
        Node current = root;
        for (char symbol : morseCode.toCharArray()) {
            if (symbol == '.') {
                if (current.left == null) {
                    current.left = new Node();
                }
                current = current.left;
            } else if (symbol == '-') {
                if (current.right == null) {
                    current.right = new Node();
                }
                current = current.right;
            }
        }
        current.character = character;
    }

    public char search(String morseCode) {
        Node current = root;
        for (char symbol : morseCode.toCharArray()) {
            if (symbol == '.') {
                current = current.left;
            } else if (symbol == '-') {
                current = current.right;
            }
            if (current == null) {
                return '\0';
            }
        }
        return current.character;
    }

    public void displayTree() {
        displayTreeRecursive(root, "", "");
    }

    private void displayTreeRecursive(Node node, String prefix, String childrenPrefix) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + (node.character != '\0' ? node.character : ""));

        if (node.left != null || node.right != null) {
            displayTreeRecursive(node.right, childrenPrefix + "├── ", childrenPrefix + "│    ");
            displayTreeRecursive(node.left, childrenPrefix + "└── ", childrenPrefix + "   ");
        }
    }
}