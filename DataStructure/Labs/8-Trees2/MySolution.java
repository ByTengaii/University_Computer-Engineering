class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int data) {
        root = insertRecursive(root, data);
    }

    Node insertRecursive(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRecursive(root.left, data);
        else if (data >= root.data)
            root.right = insertRecursive(root.right, data);

        return root;
    }

    void inorder() {
        inorderRecursive(root);
        System.out.println();
    }

    void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }

    void printLeaves() {
        printLeavesRecursive(root);
        System.out.println();
    }

    void printLeavesRecursive(Node root) {
        if (root != null) {
            if (root.left == null && root.right == null)
                System.out.print(root.data + " ");
            printLeavesRecursive(root.left);
            printLeavesRecursive(root.right);
        }
    }

    public void printPathsToLeaves() {
        List<Integer> path = new ArrayList<>();
        PathsToLeavesRecursive(root, path);
    }

    private void PathsToLeavesRecursive(Node node, List<Integer> path) {
        if (node == null) {
            return;
        }

        path.add(node.data);

        if (node.left == null && node.right == null) {
            System.out.println(path);
        } else {
            PathsToLeavesRecursive(node.left, new ArrayList<>(path));
            PathsToLeavesRecursive(node.right, new ArrayList<>(path));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        Scanner sc = new Scanner(System.in);

        String mode = sc.nextLine();

        int[] tree_arr = new int[10];

        for (int i = 0; i < 10; i++) {
            if (sc.hasNextInt()) {
                tree_arr[i] = sc.nextInt();
            }
        }                          

        for (int i = 0; i < 10; i++)
            tree.insert(tree_arr[i]);

        if (mode.equals("inorder")) {
            System.out.println("Inorder traversal: ");
            tree.inorder();
        }
        else if (mode.equals("leaf")) {
            System.out.println("Leaf Nodes: ");
            tree.printLeaves();
        }
        else if (mode.equals("path")) {
            System.out.println("Path to each leaf: ");
            tree.printPathsToLeaves();
        }
    }
}
