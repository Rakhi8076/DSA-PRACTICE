class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n =  nums.length;
        int candidate1 = 0;
        int candidate2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int num: nums){
            if(num == candidate1){
                cnt1++;
            }else if(num == candidate2){
                cnt2++;
            }else if(cnt1 == 0){
                cnt1 = 1;
                candidate1 = num;
            }else if(cnt2 == 0){
                cnt2 = 1;
                candidate2 = num;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for(int num: nums){
            if(num == candidate1){
                cnt1++;
            }else if(num == candidate2){
                cnt2++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(cnt1 > n/3){
            ans.add(candidate1);
        }
        if(cnt2 > n/3){
            ans.add(candidate2);
        }
        return ans;
    }
}