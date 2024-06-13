import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    TreeNode left;
    int data;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

public class Tree {
    // root - left - right;
    static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        // If return from the left side then come to the next line or line number 22
        preorderTraversal(root.right);
    }

    // left - root - right;
    static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);

    }

    // left - right -root;
    static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");

    }

    static int heightOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    static int fib(int num) {
        if (num == 2) {
            return 1;
        }
        if (num == 1) {
            return 0;
        }
        int firstTerm = fib(num - 1);
        int secTerm = fib(num - 2);
        return firstTerm + secTerm;
    }

    static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // return 1 + countNodes(root.left) + countNodes(root.right);
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return 1 + leftCount + rightCount;
    }

    static List<Integer> bfsTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        q.add(root);
        while (q.size() > 0) {
            TreeNode node = q.poll();

            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }

            ans.add(node.data);
        }
        return ans;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // iterativePostorder(root);
        // System.out.println("The Total Number of Nodes are: " + countNodes(root));
        // System.out.println("The Heigth Of the Tree is " + heightOfBinaryTree(root));
        // System.out.println("The Answer is " + fib(7));
        // List<Integer> ans = bfsTraversal(root);
        // for (Integer i : ans) {
        // System.out.print(i + " ");
        // }
        preorderTraversal(root);
        System.out.println();
        inorderTraversal(root);
        System.out.println();
        postorderTraversal(root);
    }

}
