class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) sb.append(str.length() + "@" + str);
        return sb.toString();
    }

    public List<String> decode(String str) {
        int start = 0;
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(str.charAt(i)=='@') {
                for(int j=start; j<i; j++) sb.append(str.charAt(j));
                int index = Integer.parseInt(sb.toString());
                sb.setLength(0);
                for(int j=i+1; j<index+1+i; j++) sb.append(str.charAt(j));
                ans.add(sb.toString());
                sb.setLength(0);
                start = i + index + 1;
                i+=index+1;
            }
        }
        return ans;
    }
}
