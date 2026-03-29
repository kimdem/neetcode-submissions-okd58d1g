class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev1 = cost[0];
        int prev2 = cost[1];

        for(int i=2; i<cost.length; i++) {
            int now = Math.min(prev1+cost[i], prev2+cost[i]);
            prev1 = prev2;
            prev2 = now;
        }
        return Math.min(prev1, prev2);
    }   
}
