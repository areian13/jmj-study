import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// B2_25501
public class Main {

    static void isPalindrome(String line, int start, int end, int[] arr) {
        arr[1]++;
        if (start >= end) {
            arr[0] = 1;
            return;
        }
        if (line.charAt(start) != line.charAt(end)) {
            arr[0] = 0;
            return;
        }
        isPalindrome(line, start + 1, end - 1, arr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int[] arr = new int[2];
            String line = br.readLine();
            int end = line.length() - 1;
            isPalindrome(line, 0, end, arr);
            bw.write(arr[0] + " " + arr[1] + "\n");
        }

        bw.flush();

        br.close();
        bw.close();

    }
}
