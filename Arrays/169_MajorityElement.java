// Time Complexity = O(n) + O(n) = O(n)
// Space Complexity = O(n)
class Solution {
    public static int majorityElement(int[] nums) {
       int n = nums.length;
       int majority = nums[0];
       int vote = 1;
       for(int i=1; i<n; i++){
        if(vote == 0){
            vote++;
            majority = nums[i];
        }else if(majority = nums[i]){
            vote++;
        }else{
            vote--;
        }
       }
       return majority;
    }
};