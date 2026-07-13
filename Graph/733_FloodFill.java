class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgCol = image[sr][sc];
        if(orgCol == color) return image;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        dfs(image, sr, sc, color, orgCol, dr, dc);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int color,int orgCol, int[] dr, int[] dc){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != orgCol){
            return;
        }
        image[sr][sc] = color;
        int m = image.length;
        int n = image[0].length;
        for(int i=0; i<4; i++){
            int nr = sr + dr[i];
            int nc = sc + dc[i];
            if(nr >= 0 && nr < image.length &&
               nc >= 0 && nc < image[0].length &&
               image[nr][nc] == orgCol) {
                dfs(image, nr, nc, color, orgCol, dr, dc);
            }
        }
    }
}