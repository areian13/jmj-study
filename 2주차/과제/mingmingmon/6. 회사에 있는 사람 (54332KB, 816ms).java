import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
// S5_7785
public class Main {

    static void toggleLog(HashMap<String, Boolean> hm, String name) {
        hm.replace(name, !hm.get(name));
    }

    static void sortNamesDesc(List<String> names, HashMap<String, Boolean> hm) {
        for(String key : hm.keySet()) {
            if (hm.get(key))
                names.add(key);
        }

        Collections.sort(names, Collections.reverseOrder());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Boolean> hm = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();

            if (!hm.containsKey(name))
                hm.put(name, true);
            else
                toggleLog(hm, name);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> names = new ArrayList<>();
        sortNamesDesc(names, hm);
        for(String name : names) {
            bw.write(name + "\n");
        }

        bw.flush();

        br.close();
        bw.close();

    }
}
