class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            m.put(s1.charAt(i), m.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int l = 0;
        int r = 0;
        Map<Character, Integer> m2 = new HashMap<>();
        for (r = 0; r < s2.length(); r++) {
            // add right
            m2.put(s2.charAt(r), m2.getOrDefault(s2.charAt(r), 0) + 1);
            // logic when window size is larger than s1 size
            if (r - l + 1 > s1.length()) {
                //remove left char
                char leftChar = s2.charAt(l);
                if (m2.get(leftChar) > 1) {
                    m2.put(leftChar, m2.get(leftChar) - 1);
                } else {
                    m2.remove(leftChar);
                }
                //  increase left side of a window
                l++;
            }
            // logic when window size is equal to s1 size
            if (m.equals(m2)) {
                return true;
            }
        }

        return false;
    }
}
