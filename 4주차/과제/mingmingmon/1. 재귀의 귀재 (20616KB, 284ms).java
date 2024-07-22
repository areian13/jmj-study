import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// B2_25501
public class Main {
    static int cnt;

    static int isPalindrome(String line, int start, int end) {
        if (start >= end)
            return 1;
        if (line.charAt(start) != line.charAt(end))
            return 0;
        cnt++;
        return isPalindrome(line, start + 1, end - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int length = line.length() - 1;
            cnt = 1;
            bw.write(isPalindrome(line, 0, length) + " " + cnt + "\n");
        }

        bw.flush();

        br.close();
        bw.close();

    }
}
