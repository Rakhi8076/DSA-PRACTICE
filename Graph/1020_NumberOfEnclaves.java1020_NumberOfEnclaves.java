package Graph;

public class 1020_NumberOfEnclaves.java1020_NumberOfEnclaves {
    
}
class Solution {
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 || j == 0 || i == m-1 || j == n-1){
                    if(grid[i][j] == 1){
                        vis[i][j] = 1;
                        q.add(new Pair(i, j));
                    }
                }
            }
        }
        int dr[] = {-1, 0, 0, 1};
        int dc[] = {0, -1, 1, 0};
        while(!q.isEmpty()){
            Pair curr = q.remove();
            for(int i=0; i<4; i++){
                int nr = curr.first + dr[i];
                int nc = curr.second + dc[i];
                if(nr >=0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1 && vis[nr][nc] == 0){
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr, nc));
                }
            }
        }
        int answer = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    answer++;
                }
            }
        }
        return answer;
    }
}