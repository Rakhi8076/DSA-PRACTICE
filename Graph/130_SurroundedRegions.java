class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int vis[][] = new int[m][n];
        int dr[] = {-1, 0, 0, 1};
        int dc[] = {0, -1, 1, 0};
        for(int i=0; i<n; i++){
            if(board[0][i] == 'O' && board[0][i] == 'O'){
                dfs(0, i, board, dr, dc, vis);
            }
            if(board[m-1][i] == 'O' && board[m-1][i] == 'O'){
                dfs(m-1, i, board, dr, dc, vis);
            }
        }
        for(int i=0; i<m; i++){
             if(board[i][0] == 'O' && board[i][0] == 'O'){
                dfs(i, 0, board, dr, dc, vis);
            }
            if(board[i][n-1] == 'O' && board[i][n-1] == 'O'){
                dfs(i, n-1, board, dr, dc, vis);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(int row, int col, char[][] board, int[] dr, int[] dc, int[][] vis){
        vis[row][col] = 1;
        for(int i=0; i<4; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];
            if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && vis[nr][nc] == 0 && board[nr][nc] == 'O'){
                dfs(nr, nc, board, dr, dc, vis);
            }
        }
    }
}