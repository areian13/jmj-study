import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {

    static class AbsComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            if (Math.abs(a) != Math.abs(b)) {
                return Integer.compare(Math.abs(a), Math.abs(b));
            }
            return Integer.compare(a, b);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> absHeap = new PriorityQueue<>(new AbsComparator());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                absHeap.add(x);
            } else {
                if (absHeap.isEmpty()) {
                    absHeap.add(0);
                }

                int result = absHeap.poll();
                System.out.println(result);
            }
        }
    }
}