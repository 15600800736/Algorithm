package getoffer;

/**
 * Created by fdh on 2017/8/23.
 */
public class ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        String result = str.toString();
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ' ') {
                result = result.substring(0, i + 2 * j) + "%20" + result.substring(i + 2 * j + 1);
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
    }
}
