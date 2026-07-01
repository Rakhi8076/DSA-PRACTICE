/*
GFG - Bottom View of Binary Tree

Topic: Trees, BFS, Queue, HashMap

Approach:
1. Perform level order traversal (BFS).
2. Store node value for every horizontal distance (hd).
3. Unlike Top View, keep updating the value.
4. The last node seen at each hd will be visible from the bottom.
5. Use TreeMap to maintain sorted order of hd.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/

class Solution {
    static class Info{
        Node node;
        int hd;
        Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0;
        int max = 0;
        q.add(new Info(root, 0));
        q.add(null);
        while(!q.isEmpty()){
            Info curr = q.poll();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                map.put(curr.hd, curr.node);
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd-1));
                    min = Math.min(curr.hd-1, min);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(curr.hd+1, max);
                }
            }
        }
        for(int i=min; i<=max; i++){
            if(map.containsKey(i)){
                result.add(map.get(i).data);
            }
        }
        return result;
    }
}