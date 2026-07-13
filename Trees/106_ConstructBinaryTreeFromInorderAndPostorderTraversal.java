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
    int poIdx = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        poIdx = n-1;
        for(int i=0; i<n; i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, n-1);
    }
    private TreeNode helper(int[] postorder, int start , int end){
        if(start > end || poIdx < 0){
            return null;
        }
        int curr = postorder[poIdx--];
        TreeNode root = new TreeNode(curr);
        int pos = map.get(curr);
        root.right = helper(postorder, pos+1, end);
        root.left = helper(postorder, start, pos-1); 
        return root;
    }
}