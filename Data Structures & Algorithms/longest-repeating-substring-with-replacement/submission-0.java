class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int res = 0;
        Map<Character, Integer> m = new HashMap<>();
        int maxValue = 0;
        for(r = 0; r < s.length(); r++) {
            if (m.containsKey(s.charAt(r))) {
                m.put(s.charAt(r), m.get(s.charAt(r)) + 1);
            } else {
                m.put(s.charAt(r), 1);
            }
            maxValue = Math.max(maxValue, m.get(s.charAt(r)));
            while(r - l + 1 - maxValue > k) {
                m.put(s.charAt(l), m.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
