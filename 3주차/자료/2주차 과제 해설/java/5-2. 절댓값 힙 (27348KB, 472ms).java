import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Abs implements Comparable<Abs> {
    int data;

    Abs(int data) {
        this.data = data;
    }

    @Override
    public int compareTo(Abs other) {
        if (Math.abs(this.data) != Math.abs(other.data)) {
            return Integer.compare(Math.abs(this.data), Math.abs(other.data));
        }
        return Integer.compare(this.data, other.data);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Abs> absHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                absHeap.add(new Abs(x));
            } else {
                if (absHeap.isEmpty()) {
                    absHeap.add(new Abs(0));
                }

                int result = absHeap.poll().data;
                System.out.println(result);
            }
        }
    }
}