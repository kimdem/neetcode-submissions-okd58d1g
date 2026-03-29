class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int row = triplets.length;
        int[] counting = new int[3];

        for(int i=0; i<row; i++) {
            boolean isOver = false;;
            for(int j=0; j<3; j++) {
                if(target[j] < triplets[i][j]) {isOver = true; break;}
            }
            if(!isOver) {
                for(int p=0; p<3; p++) {
                    counting[p] = Math.max(triplets[i][p], counting[p]);
                }
                if(checkTarget(target, counting)) return true;
            }
        }
        return false;
    }

    private boolean checkTarget(int[] target, int[] count) {
        for(int i=0; i<3; i++) {
            if(target[i] != count[i]) return false;
        }
        return true;
    }
}

