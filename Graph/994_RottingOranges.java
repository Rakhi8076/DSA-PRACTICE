class Solution {
    static class Pair{
        int row;
        int col;
        int time;
        Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int time = 0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            time = Math.max(time, curr.time);
            for(int j=0; j<4; j++){
                    int nr = curr.row + dr[j];
                    int nc = curr.col + dc[j];
                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.add(new Pair(nr, nc, curr.time+1));
                    }
                }
        }
        return fresh == 0 ? time : -1;
    }
}