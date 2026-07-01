/*
GFG - Top View of Binary Tree

Topic: Trees, BFS, Queue, HashMap

Approach:
1. Perform level order traversal (BFS).
2. Store first node encountered at each horizontal distance (hd).
3. Use TreeMap to keep horizontal distances sorted.
4. Traverse TreeMap and add values to answer.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
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
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        q.add(new Info(root, 0));
        q.add(null);
        int min = 0;
        int max = 0;
        while(!q.isEmpty()){
            Info curr = q.poll();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
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