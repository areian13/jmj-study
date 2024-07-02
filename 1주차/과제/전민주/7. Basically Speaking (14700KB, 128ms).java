import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static String reverse(String text) {
        int length = text.length();
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    static int cToi(char c) {
        if ('0' <= c && c <= '9')
            return c - '0';
        return c - 'A' + 10;
    }

    static int baseToDecimal(String n, int b) {
        int length = n.length();
        int result = 0;
        int digit = 1;
        for (int i = length - 1; i >= 0; i--) {
            char c = n.charAt(i);
            int number = cToi(c);
            result += number * digit;
            digit *= b;
        }
        return result;
    }

    static String decimalToBase(int number, int toBase) {
        StringBuilder sb = new StringBuilder();

        while(number != 0) {
            int mod = number % toBase;
            if (mod >= 10){
                sb.append((char)(number % toBase - 10 + 'A'));
            } else {
                sb.append(number % toBase);
            }

            number /= toBase;
        }

        String result = reverse(sb.toString());

        return result;
    }

    static String convertBase(String number, int fromBase, int toBase) {
        String result = decimalToBase(baseToDecimal(number, fromBase), toBase);
        String paddedString = String.format("%7s", result);
        return result.length() > 7 ? "  ERROR" : paddedString;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while ((line = br.readLine()) != null /*&& !line.isEmpty()*/) {

            String number = (line.substring(0, 7).trim());
            String fromBase = (line.substring(8, 11).trim());
            String toBase = (line.substring(11).trim());
            //System.out.printf("%s %s %s\n", number, fromBase, toBase);
            String result = convertBase(number, Integer.parseInt(fromBase), Integer.parseInt(toBase));
            //System.out.println(result);
            bw.write(result + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

}
