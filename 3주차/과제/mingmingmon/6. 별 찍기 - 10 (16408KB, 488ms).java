import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    // G5_2447
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean isStar(int i, int j, int n) {
        if ((i / n % 3 == 1) && (j / n % 3 == 1))
            return false;
        if (n == 1)
            return true;
        return isStar(i, j , n / 3);

    }
    
    static void drawStar(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(isStar(i, j, n / 3) ? "*" : " ");
            }
            bw.write("\n");
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        drawStar(n);

        bw.flush();
        
        br.close();
        bw.close();
    }
}
