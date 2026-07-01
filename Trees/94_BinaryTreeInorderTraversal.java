/*
LeetCode 94 - Binary Tree Inorder Traversal

Topic: Trees, DFS, Recursion

Approach:
Inorder Traversal:
1. Traverse Left Subtree
2. Visit Root
3. Traverse Right Subtree

Time Complexity: O(n)
Space Complexity: O(h)
where h = height of tree
*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans;
    }

    private void inOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }
}