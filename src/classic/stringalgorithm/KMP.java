package classic.stringalgorithm;

/**
 * Created by fdh on 2017/9/25.
 */
public class KMP {
//    public static int[] createNext(String p) {
//        int[] next = new int[p.length()];
//        next[0] = 0;
//        int max = next[0];
//        for (int i = 1; i < p.length(); i++) {
//            while (max > 0 && p.charAt(max) != p.charAt(i)) {
//                max = next[max - 1];
//            }
//            if (p.charAt(max) == p.charAt(i)) {
//                max++;
//            }
//            next[i] = max;
//        }
//        return next;
//    }
//
//    public static int kmp(String context, String p) {
//        int i = 0,j = 0;
//        int[] next = createNext(p);
//        while (i < context.length() && j < p.length()) {
//            while (context.charAt(i) == p.charAt(j)) {
//                i++;
//                j++;
//                if (j == p.length()) {
//                    return i - p.length();
//                }
//                if (i == context.length()) {
//                    return -1;
//                }
//            }
//            if (j == 0) {
//                i++;
//            } else {
//                j = next[j - 1];
//            }
//        }
//        return -1;
//    }
//

    public static int[] createNext(String p) {
        int[] next = new int[p.length()];
        next[0] = 0;
        int max = 0;
        for (int i = 1; i < p.length(); i++) {
            while (max > 0 && p.charAt(max) != p.charAt(i)) {
                max = next[max - 1];
            }
            if (p.charAt(max) == p.charAt(i)) {
                max++;
            }
            next[i] = max;
        }
        return next;
    }

    public static int kmp(String context, String p) {
        int i = 0, j = 0;
        int[] next = createNext(p);
        while (i < context.length() && j < p.length()) {
            while (context.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                if (j == p.length()) {
                    return i - p.length();
                }
                if (i == context.length()) {
                    return -1;
                }
            }

            if (j == 0) {
                i++;
            } else {
                j = next[j - 1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String context = "ABCDBCDECB";
        String pattern = "BCDE";
        System.out.println(kmp(context, pattern));
    }
}
