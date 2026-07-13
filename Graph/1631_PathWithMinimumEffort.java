class Solution {
    class Pair implements Comparable<Pair>{
        int row;
        int col;
        int diff;
        Pair(int row, int col, int diff){
            this.row = row;
            this.col = col;
            this.diff = diff;
        }
         @Override
         public int compareTo(Pair p){
            return this.diff - p.diff;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int difference[][] = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                difference[i][j] = Integer.MAX_VALUE;
            }
        }
        int dr[] = {-1, 0, 0, 1};
        int dc[] = {0, -1, 1, 0};
        pq.add(new Pair(0, 0, 0));
        difference[0][0] = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int r = curr.row;
            int c = curr.col;
            int diff = curr.diff;
            if(r == m-1 && c == n-1){
                return diff;
            }
            for(int i=0; i<4; i++){
                int newR = dr[i]+r;
                int newC = dc[i]+c;
                if(newR >= 0 && newC >=0 && newR < m && newC < n){
                    int effort = Math.max(Math.abs(heights[r][c] - heights[newR][newC]), diff);
                    if(effort < difference[newR][newC]){
                        difference[newR][newC] = effort;
                        pq.add(new Pair(newR, newC, effort));
                    }
                }
            }
        }
        return 0;
    }
}