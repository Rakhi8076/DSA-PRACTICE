/*
LeetCode 145 - Binary Tree Postorder Traversal

Topic: Trees, DFS, Recursion

Approach:
Postorder Traversal:
1. Traverse Left Subtree
2. Traverse Right Subtree
3. Visit Root

Time Complexity: O(n)
Space Complexity: O(h)
where h = height of tree
*/

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrder(root, ans);
        return ans;
    }

    private void postOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        postOrder(root.left, ans);
        postOrder(root.right, ans);
        ans.add(root.val);
    }
}