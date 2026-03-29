class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, int[]> map = new LinkedHashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch, new int[]{i,i});
            } else {
                int[] arr = map.get(ch);
                arr[1]=i;
            }
        }
        List<Integer> li = new ArrayList<>();
        int[] mixArr = new int[2];
        for(int[] arr : map.values()) {
            if(mixArr[0] <= arr[0] && arr[0] <=mixArr[1] && arr[1] != -1) {
                mixArr[1] = Math.max(mixArr[1], arr[1]); 
            } else {
                li.add(mixArr[1]-mixArr[0]+1);
                mixArr[0] = arr[0];
                mixArr[1] = arr[1];
            }
        }
        li.add(mixArr[1]-mixArr[0]+1);
        return li;
    }   
}


