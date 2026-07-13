class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int longSub = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            sum += arr[i];
            if(sum == k){
                longSub = i+1;
            }
            int rem = sum-k;
            if(map.containsKey(rem)){
                int len = i-map.get(rem);
                longSub = Math.max(longSub, len);
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return longSub;
    }
}
