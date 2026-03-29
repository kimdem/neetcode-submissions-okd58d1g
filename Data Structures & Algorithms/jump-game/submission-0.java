class Solution {
    public boolean canJump(int[] nums) {
        int myZone = 0;
        for(int i=0; i<nums.length; i++) {
            if(i > myZone) {System.out.println("I = " + i); return false;}
            myZone = Math.max(myZone, nums[i]+i);
        }
        return true;        
    }
}
