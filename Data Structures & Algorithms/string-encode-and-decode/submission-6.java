class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length() + "@" + str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '@') {
                int n = Integer.parseInt(str.substring(start, i));
                ans.add(str.substring(i+1, i+n+1));
                start = i + n + 1;
                i = start;
            }
        }
        return ans;
    }
}
