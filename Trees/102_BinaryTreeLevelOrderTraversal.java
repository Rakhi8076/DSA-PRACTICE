/*
LeetCode 102 - Binary Tree Level Order Traversal

Topic: Trees, BFS, Queue

Approach:
1. Use a Queue for BFS.
2. Process nodes level by level.
3. For each level, store all node values in a list.
4. Add the level list to the answer.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);   
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                level.add(curr.val);
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}