/*
LeetCode 103 - Binary Tree Zigzag Level Order Traversal

Topic: Trees, BFS, Queue

Approach:
1. Perform normal level order traversal.
2. Use a flag to track direction.
3. If left-to-right, add elements normally.
4. If right-to-left, add elements at index 0.
5. Toggle direction after each level.

Time Complexity: O(n)
Space Complexity: O(n)
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        levelOrderTrav(root, ans);
        for(int i=0; i<ans.size(); i++){
            if(i%2 != 0){
                Collections.reverse(ans.get(i));
            }
        }
        return ans;
    }
    private void levelOrderTrav(TreeNode root, List<List<Integer>> ans){
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = q.remove();
                level.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            ans.add(level);
        }
    }
    
}