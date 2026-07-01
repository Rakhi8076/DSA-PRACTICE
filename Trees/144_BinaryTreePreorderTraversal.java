/*
LeetCode 144 - Binary Tree Preorder Traversal

Topic: Trees, DFS, Recursion

Approach:
Preorder Traversal:
1. Visit Root
2. Traverse Left Subtree
3. Traverse Right Subtree

Time Complexity: O(n)
Space Complexity: O(h)
where h = height of tree
*/
import java.util.*;
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(ans, root);
        return ans;
    }

    private void preOrder(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }

        ans.add(root.val);
        preOrder(ans, root.left);
        preOrder(ans, root.right);
    }
}