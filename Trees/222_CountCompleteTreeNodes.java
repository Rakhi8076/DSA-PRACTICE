/*
LeetCode 222 - Count Complete Tree Nodes

Topic: Trees, DFS, Recursion

Approach:
1. Count current node.
2. Recursively count nodes in left subtree.
3. Recursively count nodes in right subtree.

Time Complexity: O(n)
Space Complexity: O(h)
*/

class Solution {
    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left)
                 + countNodes(root.right);
    }
}