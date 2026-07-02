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
    static class Pair{
        int idx;
        TreeNode node;
        Pair(int idx, TreeNode node){
            this.idx = idx;
            this.node = node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        while(!q.isEmpty()){
            int size = q.size();
            int minIdx = q.peek().idx;
            int first = 0;
            int last = 0;
            for(int i=0; i<size; i++){
                Pair curr = q.poll();
                int currIdx = curr.idx;
                if(i == 0){
                    first = currIdx;
                }
                if(i == size-1){
                    last = currIdx;
                }
                if(curr.node.left != null){
                    q.offer(new Pair(currIdx*2 + 1, curr.node.left));
                }
                if(curr.node.right != null){
                    q.offer(new Pair(currIdx*2 + 2, curr.node.right));
                }
            }
            maxWidth = Math.max(maxWidth, last-first+1);
        }
      
        return maxWidth;
    }
}