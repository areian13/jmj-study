import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
// G3_1865
public class Main {

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static boolean canTimeTravel(int n, int[] dist, List<Edge> edges) {
        for (int j = 1; j <= n; j++) {
            for (Edge edge : edges) {
                int start = edge.start;
                int end = edge.end;
                int weight = edge.weight;

                if (dist[start] == Integer.MAX_VALUE)
                    continue;
                if (dist[end] > dist[start] + weight) {
                    dist[end] = dist[start] + weight;
                }
            }
        }

        for (int startPoint : dist) {
            // 이렇게 하면 dist가 음수여도 n번째 순환에서 dist가 갱신 된 건지 모름
            System.out.println(startPoint);
            if (startPoint < 0)
                return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            List<Edge> edges = new ArrayList<>();
            for (int j = 0; j < m + w; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                if (j < m) {
                    edges.add(new Edge(start, end, weight));
                    edges.add(new Edge(end, start, weight));
                } else {
                    weight = -1 * weight;
                    edges.add(new Edge(start, end, weight));
                }
            }

            int[] dist = new int[n + 1];
            Arrays.fill(dist, 0);

            String result = canTimeTravel(n, dist, edges) ? "YES\n" : "NO\n";

            bw.write(result);

        }

        bw.flush();

        br.close();
        bw.close();
    }
}
