import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// S3_15649
/*
시간 복잡도 :
O(nPm)

최대 시간도 :
8P8 = 40320

시간 복잡도 구하는 과정 :
중복 없이 n개의 숫자를 골라 순서를 배치해야 하는 경우의 수를 구해야 하기 때문에 nPm입니다.
수열의 첫번째 자리에 올 수 있는 수는 n개이고 두번째 자리에 올 수 있는 수는 n-1개... 이기 때문에
"순열"을 사용했습니다.
 */
public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void makeSequences(int cnt, int[] arr, boolean[] isVisited, int n, int m) throws IOException {
        if (cnt== m) {
            for (int number : arr) {
                bw.write(number + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (isVisited[i])
                continue;
            isVisited[i] = true;
            arr[cnt] = i;
            makeSequences(cnt + 1, arr, isVisited, n, m);
            isVisited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        boolean[] isVisited = new boolean[n + 1];
        makeSequences(0, arr, isVisited, n, m);

        bw.flush();
        br.close();
        bw.close();
    }

}
