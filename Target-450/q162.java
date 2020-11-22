/**
 * C:\Users\kriti\Desktop\Target 450\q162.java
 * @author Kritika Srivastava
 * @since November 22, 2020
 *
 * Level Order Traversal
 * Link - https://practice.geeksforgeeks.org/problems/level-order-traversal/1#
 */
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class q162 {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Level_order_traversal g = new Level_order_traversal();
            ArrayList<Integer> res = g.levelOrder(root);
            for (Integer num : res)
                System.out.print(num + " ");
            System.out.println();
            t--;

        }
    }

}

// } Driver Code Ends

// User function Template for Java

/*
 * class Node { int data; Node left, right;
 * 
 * Node(int item) { data = item; left = right = null; } }
 */
class Level_order_traversal {
    // You are required to complete this method
    static ArrayList<Integer> levelOrder(Node node) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        if (node == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        while (!q.isEmpty()) {
            node = q.poll();
            l.add(node.data);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }

        }
        return l;
    }
}