class Solution {
    public List<List<Integer>> generate(int numRows) {
        int n = numRows;
        List<List<Integer>> triangle = new ArrayList<>();
        for(int i=0; i<n; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || i==j){
                    temp.add(1);
                }else{
                    int val = triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j);
                    temp.add(val);
                }
            }
            triangle.add(temp);
        }
        return triangle;
    }
}