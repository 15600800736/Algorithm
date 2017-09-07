package exercise;

/**
 * Created by fdh on 2017/9/6.
 */

    public class SystemUtil {
    public static boolean isAdmin(String userId) {
        return userId.toLowerCase() == "admin";
    }

    public static void main(String[] args) {
        System.out.println(isAdmin("Admin"));
    }
}
