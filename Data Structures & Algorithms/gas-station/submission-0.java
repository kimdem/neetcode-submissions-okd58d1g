class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int size = gas.length;
        boolean goal;

        for(int i=0; i<size; i++) {
            if(gas[i] < cost[i]) { continue;}
            int fuel = gas[i];
            int position = i;
            goal = true;
            for(int j=0; j<size; j++) {
                fuel -=cost[position];
                if(fuel < 0) {goal=false; break;}
                if(position==size-1) {position=0;}
                else position++;
                fuel+=gas[position];
            }
            if(goal) return i;
            goal = false;
        }
        return -1;                    
    }
}
