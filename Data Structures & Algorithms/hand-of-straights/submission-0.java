class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false; 
        int size = (hand.length / groupSize)-1;
        Arrays.sort(hand);
        List<Integer> card = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        card.add(hand[0]);
        count.add(groupSize-1);
        for(int i=1; i<hand.length; i++) {
            boolean isContains = false;
           for(int j=0; j<card.size(); j++) {
                if(count.get(j) != 0 && card.get(j)+1 == hand[i]) {
                    card.set(j, card.get(j)+1); 
                    count.set(j, count.get(j)-1);
                    isContains=true;
                    break; 
                }        
           }
           if(!isContains) {
                size--;
                if(size < 0) return false;
                card.add(hand[i]);
                count.add(groupSize-1);  
           }
           isContains = false;
        }
        return true;
    }
}