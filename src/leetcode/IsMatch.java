package leetcode;

/**
 * Created by fdh on 2017/9/22.
 */
public class IsMatch {
    public static boolean isMatch(String s, String p) {
        if (!p.contains("*") && !p.contains(".")) {
            if (s.length() != p.length()) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != p.charAt(i)) {
                    return false;
                }
            }
        }

        int i = 0;
        for (int j = 0; j < p.length(); j++) {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                char ch = p.charAt(j);
                while (i < s.length() && charEquals(ch, s.charAt(i))) {
                    i++;
                }
                j++;
            } else {
                if (i >= s.length() || !charEquals(p.charAt(j), s.charAt(i))) {
                    return false;
                }
                i++;
            }
        }

        return i > s.length() - 1;
    }

    private static boolean charEquals(char p, char c) {
        if (p == '.') {
            return true;
        }
        return p == c;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaa","a*a"));
    }
}
