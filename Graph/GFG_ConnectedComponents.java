import java.util.*;
class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
       for(int edge[]: edges){
           int u = edge[0];
           int v = edge[1];
           adj.get(u).add(v);
           adj.get(v).add(u);
       }
       ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       boolean vis[] = new boolean[V];
       for(int i=0; i<V; i++){
           if(!vis[i]){
               ArrayList<Integer> comp = new ArrayList<>();
               dfs(adj, comp, vis, i);
               ans.add(comp);
           }
       }
       return ans;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> comp,  boolean vis[], int curr){
        vis[curr] = true;
        comp.add(curr);
        for(int neig: adj.get(curr)){
            if(!vis[neig]){
                dfs(adj, comp, vis, neig);
            }
        }
    }
}