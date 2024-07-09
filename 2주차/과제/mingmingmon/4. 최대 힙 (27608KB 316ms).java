import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
// S2_11279
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(br.readLine());
            if (curr == 0) {
                bw.write((pq.isEmpty() ? 0 : pq.poll()) + "\n");
            } else {
                pq.add(curr);
            }
        }

        bw.flush();

        br.close();
        bw.close();

    }
}
