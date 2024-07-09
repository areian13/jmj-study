import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// S3_29813
public class Main {
    static class StudentInfo {
        String initial;

        int studentId;

        StudentInfo(String initial, int studentId) {
            this.initial = initial;
            this.studentId = studentId;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<StudentInfo> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String initial = st.nextToken();
            int studentId = Integer.parseInt(st.nextToken());
            q.offer(new StudentInfo(initial, studentId));
        }

        for (int i = 0; i < n / 2; i++) {
            StudentInfo studentInfo = q.poll();
            int studentId = studentInfo.studentId;
            for (int j = 0; j < studentId - 1; j++) {
                q.offer(q.poll());
            }
            q.poll();
        }

        String favoriteStudentInitial = q.poll().initial;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(favoriteStudentInitial);
        bw.flush();

        br.close();
        bw.close();
    }
}
