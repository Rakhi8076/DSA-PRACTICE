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
    int piIdx = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for(int i=0; i<n; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, n-1);
    }
    private TreeNode  helper(int[] preorder, int start, int end){
        if(start > end){
            return null;
        }
        int curr = preorder[piIdx++];
        TreeNode root = new TreeNode(curr);
        int pos = map.get(curr);
        root.left = helper(preorder, start,pos-1);
        root.right = helper(preorder, pos+1, end);
        return root;
    }
}