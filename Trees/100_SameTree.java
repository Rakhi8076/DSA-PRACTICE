/*
LeetCode 100 - Same Tree

Topic: Trees, DFS, Recursion

Approach:
1. If both nodes are null, return true.
2. If one is null and the other isn't, return false.
3. Check current node values.
4. Recursively compare left and right subtrees.

Time Complexity: O(n)
Space Complexity: O(h)
*/
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left , q.left) && isSameTree(p.right, q.right);
    }
}