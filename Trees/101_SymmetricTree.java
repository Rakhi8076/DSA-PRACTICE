/*
LeetCode 101 - Symmetric Tree

Topic: Trees, DFS, Recursion

Approach:
1. Compare left subtree with right subtree.
2. Left's left should match Right's right.
3. Left's right should match Right's left.
4. If all nodes satisfy the mirror condition,
   the tree is symmetric.

Time Complexity: O(n)
Space Complexity: O(h)
*/

class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}