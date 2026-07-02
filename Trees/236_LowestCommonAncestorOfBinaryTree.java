/*
LeetCode 236 - Lowest Common Ancestor of a Binary Tree

Topic: Trees, DFS, Recursion

Approach:
1. If root is null, p, or q → return root.
2. Search in left and right subtrees.
3. If both sides return non-null,
   current root is the LCA.
4. Otherwise return the non-null side.

Time Complexity: O(n)
Space Complexity: O(h)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if(leftNode == null){
            return rightNode;
        }
        if(rightNode == null){
            return leftNode;
        }
        return root;
    }
}