package toutiao;

import java.util.*;

/**
 * Created by fdh on 2017/9/7.
 */
public class Paragraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] paragraph = new String[n];
        String[] query = new String[m];
        List<Set<String>> list = new ArrayList<>(n);
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            paragraph[i] = scanner.nextLine();
        }
        for (int i = 0; i < n; i++) {
            String[] words = paragraph[i].split(" ");
            Set<String> wordSet = new HashSet<>(words.length);
            for (String word : words) {
                word = word.toLowerCase();
                wordSet.add(word);
            }
            list.add(wordSet);
        }
        for (int i = 0; i < m; i++) {
            query[i] = scanner.nextLine();
        }
        for (int i = 0; i < m; i++) {
            int max = 0;
            int index = 0;
            String[] words = query[i].split(" ");
            for (int j = 0; j < list.size(); j++) {
                int num = 0;
                for (String word : words) {
                    if (list.get(j).contains(word.toLowerCase())) {
                        num++;
                    }
                }
                if (num > max) {
                    max = num;
                    index = j;
                }
            }
            System.out.println(paragraph[index]);
        }


    }
}
