// Time Complexity	O(m × n)
// Space Complexity	O(1)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int sRow = 0;
        int sCol = 0;
        int eRow = m-1;
        int eCol = n-1;
        while(sRow <= eRow && sCol <= eCol){
            for(int i=sCol; i<=eCol; i++){
                result.add(matrix[sRow][i]);
            }
            for(int i=sRow+1; i<=eRow; i++){
                result.add(matrix[i][eCol]);
            }
            if(sRow < eRow){
                for(int i=eCol-1; i>=sCol; i--){
                result.add(matrix[eRow][i]);
            }
            }
            if(sCol < eCol){
                for(int i=eRow-1; i>sRow; i--){
                result.add(matrix[i][sCol]);
            }
            }
            sRow++;
            sCol++;
            eRow--;
            eCol--;
        }
        return result;
    }
}
