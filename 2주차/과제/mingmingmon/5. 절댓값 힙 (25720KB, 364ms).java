import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
// S1_11286
public class Main {

    static class Number implements Comparable<Number>{
        int value;

        Number(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Number that) {
            if (Math.abs(this.value) != Math.abs(that.value))
                return Math.abs(this.value) - Math.abs(that.value);
            return (this.value - that.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Number> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                bw.write((pq.isEmpty() ? 0 : pq.poll().value) + "\n");
            } else {
                pq.add(new Number(x));
            }
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
