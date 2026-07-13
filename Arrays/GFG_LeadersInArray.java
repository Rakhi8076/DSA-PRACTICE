class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int leader = arr[n-1];
        ans.add(leader);
        for(int  i=n-2; i>=0; i--){
            if(arr[i] >= leader){
                leader = arr[i];
                ans.add(leader);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
