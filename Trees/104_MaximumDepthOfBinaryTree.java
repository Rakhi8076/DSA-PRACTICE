/*
LeetCode 104 - Maximum Depth of Binary Tree

Topic: Trees, DFS, Recursion

Approach:
1. Find depth of left subtree.
2. Find depth of right subtree.
3. Return 1 + max(leftDepth, rightDepth).

Time Complexity: O(n)
Space Complexity: O(h)
where h = height of the tree
*

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return Math.max(lh, rh)+1;
    }
}