import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int getGCD(int a, int b) {
        if(b == 0)
            return a;
        return getGCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] trees = new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        int[] gaps = new int[n-1];
        int totalGCD = 0;
        for (int i = 0; i < n - 1; i++) {
            gaps[i] = trees[i + 1] - trees[i];
            totalGCD = getGCD(totalGCD, gaps[i]);
        }

        int numberOfTree = 0;
        for (int i = 0; i < n - 1; i++) {
            numberOfTree += gaps[i] / totalGCD - 1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(numberOfTree));
        bw.flush();

        br.close();
        bw.close();
    }
}
