import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> getPossibleGap(int[] teethMark, HashMap<Integer, Boolean> hm) {
        int length = teethMark.length;
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i < length; i++) {
            int gap = teethMark[i] - teethMark[0];
            boolean isAzber = true;
            for (int j = 1; j < length; j++) {
                if (!hm.containsKey(teethMark[j] - gap) && !hm.containsKey(teethMark[j] + gap)) {
                    isAzber = false;
                    break;
                }
            }
            if (isAzber)
                result.add(gap);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] teethMark = new int[n];
        HashMap<Integer, Boolean> hm = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            teethMark[i] = Integer.parseInt(st.nextToken());
            hm.put(teethMark[i], true);
        }

        List<Integer> result = getPossibleGap(teethMark, hm);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = result.size();
        bw.write(size + "\n");

        for (int gap : result) {
            bw.write(gap + " ");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
