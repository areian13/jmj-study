import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// S3_15651
/*
시간 복잡도 :
O(n^m)

최대 시간도 :
7^7 = 823,543

시간 복잡도 구하는 과정 :
1. 재귀 시 선택지 : 재귀함수를 한 번 돌 때 for문 안에서 1부터 n까지 n번을 돌아야 합니다.
2. 재귀 최대 깊이 : 하나의 재귀함수는 만들고자하는 수열의 길이인 m의 깊이까지 들어가야 합니다.
3. 총 호출 횟수 : n번 도는 for문을 m 깊이까지 실행해야 하기 때문에 시간 복잡도는 O(n^m)이 됩니다.
 */
public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void makeSequence(int cnt, int[] arr, int n, int m) throws IOException {
        if (cnt == m) {
            for (int number : arr) {
                bw.write(number + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[cnt] = i;
            makeSequence(cnt + 1, arr, n, m);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        makeSequence(0, arr, n, m);

        bw.flush();

        br.close();
        bw.close();
    }
}
