package tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * тренировочный класс дерева
 * обход в глубину с рекурсией и без
 * обход в ширину за счет особенностей применяемых коллекций
 */
public class Tree {
    public static void main(String[] args) {
        Node root =
                new Node(20,
                        new Node(7,
                                new Node(4, null, new Node(6)), new Node(9)),
                        new Node(35,
                                new Node(31, new Node(28), null),
                                new Node(40, new Node(38), new Node(52))));

        System.out.println("Сумма дерева recursive: " + root.sumRecursive());
        System.out.println("Сумма дерева deep: " + root.sumDeep(root));
        System.out.println("Сумма дерева width: " + root.sumWidth(root));

    }

    static class Node {
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

        public int sumRecursive() {
            int sum = value;
            System.out.println(value);
            if (left != null) {
                sum += left.sumRecursive();
            }
            if (right != null) {
                sum += right.sumRecursive();
            }
            return sum;
        }

        public int sumDeep(Node root) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            int sum = 0;
            while (!stack.empty()) {
                Node node = stack.pop();
                sum += node.value;
                System.out.println(node.value);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            return sum;
        }

        /**
         * поиск в ширину позволяет найти ближайших к корню элемент
         * @param root
         * @return
         */
        public int sumWidth(Node root) {
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(root);
            int sum = 0;
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                sum += node.value;
                System.out.println(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            return sum;
        }

    }

}
