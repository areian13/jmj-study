import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
// S4_10773
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int curr = Integer.parseInt(br.readLine());
            if (curr == 0)
                stack.pop();
            else
                stack.push(curr);
        }

        int result = 0;
        int length = stack.size();
        for (int i = 0; i < length; i++) {
            result += stack.pop();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.toString(result));

        bw.flush();
        br.close();
        bw.close();
    }
}
