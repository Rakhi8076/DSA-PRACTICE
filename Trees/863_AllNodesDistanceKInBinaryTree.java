/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode righ[[t;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent_store = new HashMap<>();
        makeParentMap(root, parent_store);
        HashMap<TreeNode, Boolean> visit = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visit.put(target, true);
        int currLevel = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(currLevel == k){
                break;
            }
            currLevel++;
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null && visit.get(curr.left) == null){
                    visit.put(curr.left, true);
                    q.offer(curr.left);
                }
                if(curr.right != null && visit.get(curr.right) == null){
                    visit.put(curr.right, true);
                    q.offer(curr.right);
                }
                if(parent_store.get(curr) != null && visit.get(parent_store.get(curr)) == null){
                    visit.put(parent_store.get(curr), true);
                    q.offer(parent_store.get(curr));
                }
            }
            
        }
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            result.add(curr.val);
        }
            return result;
    }
    private void makeParentMap(TreeNode root, HashMap<TreeNode, TreeNode> parent_store){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                parent_store.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right != null){
                parent_store.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
}