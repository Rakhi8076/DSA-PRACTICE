/*
LeetCode 543 - Diameter of Binary Tree

Topic: Trees, DFS, Recursion

Approach:
1. For every node, calculate:
   left subtree height + right subtree height.
2. Update the maximum diameter.
3. Return height of current node.

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
    static class Info{
        int diam;
        int ht;
        Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    private Info findHtDia(TreeNode root){
        if(root == null){
            return new Info(0,0);
        }
        Info leftInfo = findHtDia(root.left);
        Info rightInfo = findHtDia(root.right);
        int dia = Math.max(Math.max(leftInfo.diam, rightInfo.diam), (rightInfo.ht+leftInfo.ht));
        int height = Math.max(rightInfo.ht , leftInfo.ht)+1;
        return new Info(dia, height);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return findHtDia(root).diam;
    }
}