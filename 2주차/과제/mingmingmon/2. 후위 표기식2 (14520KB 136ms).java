import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
// S3_1935
public class Main {

    static double transferCharacterToDouble(Character character, int[] value) {
        return value[character - 'A'];
    }

    static void operateStack(Character curr, int[] value, Stack<Double> stack) {
        switch (curr) {
            case '+': {
                double second = stack.pop();
                double first = stack.pop();
                stack.push(first + second);
                break;
            }
            case '-': {
                double second = stack.pop();
                double first = stack.pop();
                stack.push(first - second);
                break;
            }
            case '*': {
                double second = stack.pop();
                double first = stack.pop();
                stack.push(first * second);
                break;
            }
            case '/': {
                double second = stack.pop();
                double first = stack.pop();
                stack.push(first / second);
                break;
            }
            case '%': {
                double second = stack.pop();
                double first = stack.pop();
                stack.push(first % second);
                break;
            }
            default: {
                stack.push(transferCharacterToDouble(curr, value));
            }
        }
    }

    static double calculatePostfix(String postfix, int[] value) {
        Stack<Double> stack = new Stack<>();
        int length = postfix.length();
        for (int i = 0; i < length; i++) {
            char curr = postfix.charAt(i);
            operateStack(curr, value, stack);
        }
        return stack.pop();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String characterPostfix = br.readLine();

        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        double result = calculatePostfix(characterPostfix, value);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.format("%.2f", result));

        bw.flush();

        br.close();
        bw.close();
    }
}
