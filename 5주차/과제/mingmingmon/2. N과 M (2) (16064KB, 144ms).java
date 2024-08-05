import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// S3_15650
public class Main {
/*
시간 복잡도 : O(nCm)

최대 시간도 : 8C4 = 70

시간 복잡도 구하는 과정 :
수열은 오름차순이어야하기 때문에, 수열에 포함될 숫자들이 선택이 되고 나면, 무조건 오름차순 정렬이 되어야 합니다.
즉 한 수열에 들어갈 숫자의 "조합"만 찾아주면 되기 때문에 nCm이 시간복잡도가 됩니다. 이 로직은 for문을 start부터 n까지
도는 코드에 의해 표현됩니다.
 */
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void makeSequences(int cnt, int start, int[] arr, int n, int m) throws IOException {
        if (cnt == m) {
            for (int number : arr) {
                bw.write(number + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[cnt] = i;
            makeSequences(cnt + 1, i + 1, arr, n, m);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        makeSequences(0, 1, arr, n, m);

        bw.flush();

        br.close();
        bw.close();
    }
}
