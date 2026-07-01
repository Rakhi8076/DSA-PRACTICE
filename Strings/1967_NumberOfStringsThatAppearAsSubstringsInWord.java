/*
LeetCode 1967 - Number of Strings That Appear as Substrings in Word

Topic: Strings

Approach:
For each pattern, check whether it exists in the given word using
the contains() method.

If present, increment the answer.

Time Complexity: O(n * m)
Space Complexity: O(1)
*/
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for(int i=0; i<patterns.length; i++){
            if(word.contains(patterns[i])){
                ans++;
            }
        }
        return ans;
    }
}