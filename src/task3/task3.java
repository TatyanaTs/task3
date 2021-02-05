package task3; //java -jar task3.jar test1.txt test2.txt test3.txt test4.txt test5.txt

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class task3 {
    static float[][] data = new float[5][16];

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            String filePath = args[i];
            Scanner scanner = new Scanner(new File(filePath));
            int n = 0;
            do {
                String[] nums = scanner.nextLine().split("[\\\\n\\s]+");
                data[i][n] = Float.parseFloat(nums[0]);
                n++;
            } while (n < 16);
            scanner.close();
        }
        findTimeRange();
    }

static void findTimeRange() {
    float[] sum = new float[16];
        for (int i = 0; i < 16; i++) {
            sum[i] = (data[0][i] + data[1][i] + data[2][i] + data[3][i] + data[4][i]) / 5;
        }
    float max = sum[0];
    int maxIndex = 0;
    for (int index = 0; index < sum.length; index++) {
        if (sum[index] > max) {
            max = sum[index];
            maxIndex = index;
        }
    }
    System.out.println(maxIndex+1);
}
}
