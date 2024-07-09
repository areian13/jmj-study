import java.io.*;

public class Main {
    // 왜 메모리 초과가 났는지. if문에서 bomb의 길이만큼 sb.substring을 만드는건 똑같잖아요.
    // G4_9935
    static boolean isBomb(StringBuilder sb, String bomb) {
        int bombLength = bomb.length();
        int sbLength = sb.length() - 1;
        for (int i = bombLength - 1; i >= 0; i--) {
            if (bomb.charAt(i) != sb.charAt(sbLength--))
                return false;
        }
        return true;
    }

    static String getSurvivedString(String string, String bomb) {
        StringBuilder sb = new StringBuilder();
        int length = string.length();
        int bombLength = bomb.length();

        for (int i = 0; i < length; i++) {
            char curr = string.charAt(i);
            sb.append(curr);
            if (sb.length() < bombLength)
                continue;
            if (isBomb(sb, bomb)) {
                sb.delete(sb.length() - bombLength, sb.length());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();
        String bomb = br.readLine();

        String survivedString = getSurvivedString(string, bomb);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(survivedString.isEmpty() ? "FRULA" : survivedString);
        bw.flush();

        br.close();
        bw.close();

    }


}
