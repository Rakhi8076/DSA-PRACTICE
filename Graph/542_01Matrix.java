class Solution {
    static class Info{
        int first;
        int second;
        int step;
        Info(int first, int second, int step){
            this.first = first;
            this.second = second;
            this.step = step;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int vis[][] = new int[m][n];
        int result[][] = new int[m][n];
        Queue<Info> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.offer(new Info(i, j, 0));
                    vis[i][j] = 1;
                }else{
                    vis[i][j] = 0;
                }
            }
        }
        int dr[] = {-1, 0, 0, 1};
        int dc[] = {0, -1, 1, 0};
        while(!q.isEmpty()){
            Info curr = q.remove();
            result[curr.first][curr.second] = curr.step;
            for(int i=0; i<4 ; i++){
                int nr = curr.first + dr[i];
                int nc = curr.second + dc[i];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && vis[nr][nc] == 0){
                    q.offer(new Info(nr, nc, curr.step+1));
                    vis[nr][nc] = 1;
                }
            }
        }
        return result;
    }
}