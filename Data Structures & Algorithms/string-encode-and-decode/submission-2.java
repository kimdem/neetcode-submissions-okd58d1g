class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length());
            sb.append("#" + str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        int k=0;
        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) == '#') {
                int size = Integer.parseInt(str.substring(k,i));
                for(int j=i+1; j<i+1+size; j++) {
                    sb.append(str.charAt(j));
                }
                ans.add(sb.toString());
                sb.setLength(0);
                i += size + 1;
                k = i;
            }
        }
        return ans;
    }
}
