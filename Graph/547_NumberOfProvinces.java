class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean vis[] = new boolean[n];
        int provinces = 0;
        for(int city=0; city<n; city++){
            if(!vis[city]){
                provinces++;
                dfs(isConnected, city, vis);
            }
        }
        return provinces;
    }
    public void dfs(int isConnected[][], int city, boolean vis[]){
        vis[city] = true;
        for(int neigh=0; neigh < isConnected.length; neigh++){
            if(!vis[neigh] && isConnected[city][neigh] == 1){
                dfs(isConnected, neigh, vis);
            }
        }
    }
}