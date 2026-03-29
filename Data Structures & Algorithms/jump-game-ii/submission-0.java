class Solution {
    public int jump(int[] nums) {
        int output = 0;
        int max = 0;
        int window = 0;

        for(int i=0; i<nums.length-1; i++) {
            max = Math.max(max, i+nums[i]);
            
            if(i == window) {
                output++;
                window = max;
            }
        }

        return output;
    }
}
