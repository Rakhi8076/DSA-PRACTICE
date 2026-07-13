/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        if(!isLeaf(root)){
            ans.add(root.data);
        }
        addLeftNodes(root, ans);
        addLeafNodes(root, ans);
        addRightNodes(root, ans);
        return ans;
    }
    private boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }
    private void addLeftNodes(Node root, ArrayList<Integer> ans){
       
        Node curr = root.left;
        while(curr != null && !isLeaf(curr)){
            ans.add(curr.data);
            if(curr.left != null){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
    }
    private void addLeafNodes(Node root, ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        if(isLeaf(root)){
            ans.add(root.data);
        }
        addLeafNodes(root.left, ans);
        addLeafNodes(root.right, ans);
    }
    private void addRightNodes(Node root, ArrayList<Integer> ans){
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr != null && !isLeaf(curr)){
            temp.add(curr.data);
            if(curr.right != null){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
        for(int i=temp.size()-1; i>=0; i--){
            ans.add(temp.get(i));
        }
    }
}