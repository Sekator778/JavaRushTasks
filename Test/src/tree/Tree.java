package tree;

public class Tree {
    public static void main(String[] args) {
        Tree root =
                new Tree(20,
                        new Tree(7,
                                new Tree(4, null, new Tree(6)), new Tree(9)),
                        new Tree(35,
                                new Tree(31, new Tree(28), null),
                                new Tree(40, new Tree(38), new Tree(52))));

        System.out.println("Сумма дерева: " + root.sum());

    }

    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left) {
            this.value = value;
            this.left = left;
        }

        public int sum(Node node) {
            int sum = 0;
            if (left != null) {
                sum += sum(left);
            }
            if (right != null) {
                sum += sum(right);
            }
            return sum;
        }
    }
}
