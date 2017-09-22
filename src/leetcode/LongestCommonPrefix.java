package leetcode;

/**
 * Created by fdh on 2017/9/22.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            boolean isPrefix = true;
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    isPrefix = false;
                }
            }
            if (!isPrefix) {
                return sb.toString();
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
