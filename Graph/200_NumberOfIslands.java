class Solution {   
    static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length; //row;
        int n = grid[0].length; //col
        int vis[][] = new int[m][n];
        int islands = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    islands++;
                    bfs(grid, i, j, vis);
                }
            }
        }
        return islands;
    }
    private void bfs(char[][] grid, int row, int col, int[][] vis){
        Queue<Pair> q = new LinkedList<>();
        vis[row][col] = 1;
        q.add(new Pair(row, col));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair curr = q.poll();
            for(int i=0; i<4; i++){
                int nRow = curr.first + dr[i];
                int nCol = curr.second + dc[i];
                    if(nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == '1' && vis[nRow][nCol] == 0){
                        vis[nRow][nCol] = 1;
                        q.add(new Pair(nRow , nCol));
                    }
            }
        }
    }
}