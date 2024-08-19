import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
// G4_11657_3
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

    static boolean hasNegativeLoop(int n, int m, List<Edge> edges, long[] dist) {
        for (int i = 1; i <= n; i++) { // n - 1번만 돌면 거리가 최종 결정되는데, n번 돌아보겠다
            for (int j = 0; j < m; j++) {
                Edge edge = edges.get(j);
                int start = edge.start;
                int end = edge.end;
                int weight = edge.weight;

                if (dist[start] == Integer.MAX_VALUE)
                    continue;
                if (dist[end] > dist[start] + weight) {
                    dist[end] = dist[start] + weight;
                    if (i == n)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, weight));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0; // 1에서 모든 정점으로 가는 최단거리를 구하겠다

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (hasNegativeLoop(n, m, edges, dist)) {
            bw.write("-1\n");
        } else {
            for (int i = 2; i <= n; i++) {
                bw.write(dist[i] == Integer.MAX_VALUE ? "-1" : Long.toString(dist[i]));
                bw.write("\n");
            }
        }

        bw.flush();

        br.close();
        bw.close();

    }
}
