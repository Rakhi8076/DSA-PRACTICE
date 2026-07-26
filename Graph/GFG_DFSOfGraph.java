class Solution {
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean vis[] = new boolean[v];
        dfsUtil(0, adj, vis, ans);
        return ans;
    }
    public void dfsUtil(int curr, ArrayList<ArrayList<Integer>> adj, boolean vis[], ArrayList<Integer> ans){
        vis[curr] = true;
        ans.add(curr);
        for(int neig: adj.get(curr)){
            if(!vis[neig]){
                dfsUtil(neig, adj, vis, ans);
            }
        }
    }
}