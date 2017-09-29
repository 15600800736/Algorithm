package oj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by fdh on 2017/9/11.
 */
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            double[] dot = new double[n];
            for (int i = 0; i < n; i++) {
                dot[i] = Double.parseDouble(br.readLine());
            }
            int i = 0, j = 1, sum = 0;
            out:
            while (i < n) {
                while (true) {
                    while (true) {
                        if (!(getAngle(dot, indexFor(j, n), i) < 180)) {
                            if (indexFor(j - 1, n) > i) {
                                j--;
                            } else {
                                i++;
                                if (i >= n) {
                                    break out;
                                }
                                j++;
                            }

                        } else {
                            break;
                        }
                    }
                    if (!(getAngle(dot, indexFor(j + 1, n), i) < 180)) {
                        break;
                    }
                    j++;
                }
                sum += (j - i - 1);
                i++;
                j++;
            }
            System.out.println(sum + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static int indexFor(int index, int n) {
        return index % n;
    }

    private static double getAngle(double[] dot, int j, int i) {
        return dot[j] > dot[i] ? dot[j] - dot[i] : 360 - (dot[i] - dot[j]);
    }
}