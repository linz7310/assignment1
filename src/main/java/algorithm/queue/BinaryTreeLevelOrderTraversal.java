package algorithm.queue;

import datastructure.queue.LinkedListQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Level Order Traversal
 */
public class BinaryTreeLevelOrderTraversal {

    /*
        [
            [1]
            [2,3]
            [4,5,6,7]
        ]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1; // Number of nodes in current layer
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>(); // Save results for each layer
            int c2 = 0; // Number of nodes in next layer
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                level.add(n.val);
                if (n.left != null) {
                    queue.offer(n.left);
                    c2++;
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    c2++;
                }
            }
            result.add(level);
            c1 = c2;
        }

        return result;
    }

    /*
                  1
                 / \
                2   3
               /\   /\
              4  5 6  7

              头 [] 尾

              1 2 3 4 5 6 7
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                )
        );
        List<List<Integer>> lists = new BinaryTreeLevelOrderTraversal().levelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }
}
