class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                result.add(curr);
                vis[curr] = true;
                for(int i=0; i<adj.get(curr).size(); i++){
                    q.add(adj.get(curr).get(i));
                }
            }
        }
        return result;
    }
}