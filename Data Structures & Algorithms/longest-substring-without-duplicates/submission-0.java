class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int res = 0;
        int l = 0;
        int r = 0;
        Set<Character> set = new HashSet<>();
        for (l = 0; l < s.length(); l++) {
            while(r < s.length()) {
                if (!set.contains(s.charAt(r))) {
                    set.add(s.charAt(r));
                    if (set.size() > res) res = set.size();
                } else {
                    set.remove(s.charAt(l));
                    break;
                }
                r++;
            }
        }
        return res;
    }
}
