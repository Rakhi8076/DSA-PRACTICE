// Time	O(N log N)
// Space  O(N)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        ArrayList<int[]> result = new ArrayList<>();
        for(int curr[]: intervals){
            if(result.size() == 0){
                result.add(curr);
            }else{
                int last[] = result.get(result.size()-1);
                if(curr[0] <= last[1]){
                    last[1] = Math.max(last[1], curr[1]);
                }else{
                    result.add(curr);
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}