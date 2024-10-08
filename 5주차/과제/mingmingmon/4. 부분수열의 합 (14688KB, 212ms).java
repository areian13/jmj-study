import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
시간 복잡도 :
O(2^n)

최대 시간도 :
2^20 = 1,048,576


시간 복잡도 구하는 과정 :
주어진 수열의 각 숫자가 부분수열로 포함될지, 안 될지 선택되는 경우는 2가지 입니다. 따라서 n개의 숫자가
부분수열에 포함될지, 안 될지의 경우의 수는 2^n 개 입니다.
 */
// S2_1182
public class Main {

    static int countSubsequence(int sum, int currIndex, int n, int s, int[] numbers) {
        int result = 0;
        if (sum + numbers[currIndex] == s)
            result++;

        if (currIndex == n- 1)
            return result;

        result += countSubsequence(sum + numbers[currIndex], currIndex + 1, n, s, numbers);
        result += countSubsequence(sum, currIndex + 1, n, s, numbers);

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int result = countSubsequence(0, 0, n, s, numbers);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.toString(result));
        bw.flush();

        br.close();
        bw.close();
    }
}
