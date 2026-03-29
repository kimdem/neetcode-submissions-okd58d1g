class Solution {
    public boolean canJump(int[] nums) {
        int myZone = 0;
        for(int i=0; i<nums.length; i++) {
            if(i > myZone) {return false;}
            myZone = Math.max(myZone, nums[i]+i);
        }
        return true;        
    }
}
