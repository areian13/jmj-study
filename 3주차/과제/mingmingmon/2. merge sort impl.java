import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    // 오름차순, 내림차순 정렬하는 부분을 따로 함수로 빼려고 시도했으나, firstIndex++, secondIndex++을 해야하는 경우에
    // 포인터 접근이 안돼서 실패했습니다.. 주석처리한 함수 부분을 그냥 merge 메소드 안에 배치했는데, 어떻게 해결해야 할까요?

/*    static void sortAsc (int firstIndex, int secondIndex, int tempIndex, int[] arr, int[] temp) {
        if (arr[firstIndex] <= arr[secondIndex]) {
            temp[tempIndex] = arr[firstIndex];
            firstIndex++;
        } else {
            temp[tempIndex] = arr[secondIndex];
            secondIndex++;
        }
        tempIndex++;
    }

    static void sortDesc (int firstIndex, int secondIndex, int tempIndex, int[] arr, int[] temp) {
        if (arr[firstIndex] <= arr[secondIndex]) {
            temp[tempIndex] = arr[firstIndex];
            firstIndex++;
        } else {
            temp[tempIndex] = arr[secondIndex];
            secondIndex++;
        }
        tempIndex++;
    }*/

    static void merge(boolean isAsc, int startIndex, int midIndex, int endIndex, int[] arr) {
        int length = endIndex - startIndex + 1;
        int[] temp = new int[length];
        int tempIndex = 0;
        int firstIndex = startIndex;
        int secondIndex = midIndex + 1;

        while (firstIndex <= midIndex && secondIndex <= endIndex) {
            if (isAsc ^ (arr[firstIndex] > arr[secondIndex])) {
                temp[tempIndex] = arr[firstIndex];
                firstIndex++;
            }
            else {
                temp[tempIndex] = arr[secondIndex];
                secondIndex++;
            }
            tempIndex++;
        }

        int start = firstIndex <= midIndex ? firstIndex : secondIndex;
        int end = firstIndex <= midIndex ? midIndex : endIndex;
        for (int i = start; i <= end; i++) {
            temp[tempIndex] = arr[i];
            tempIndex++;
        }

        for (int number : temp) {
            arr[startIndex] = number;
            startIndex++;
        }
    }

    static void mergeSort(boolean isAsc, int startIndex, int endIndex, int[] arr) {
        if (startIndex == endIndex)
            return;

        int midIndex = (startIndex + endIndex) / 2;

        mergeSort(isAsc, startIndex, midIndex, arr);
        mergeSort(isAsc, midIndex + 1, endIndex, arr);
        merge(isAsc, startIndex, midIndex, endIndex, arr);
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = {2,6,4,3,7,8,1,9,5,0};
        int startIndex = 0;
        int endIndex = arr.length - 1;
        mergeSort(true, startIndex, endIndex, arr);
        
        bw.write("mergeSort 오름차순 결과: ");
        for(int number : arr) {
            bw.write(number + " ");
        }
        
        bw.write("\n");
        
        mergeSort(false, startIndex, endIndex, arr);

        bw.write("mergeSort 내림차순 결과: ");
        for(int number : arr) {
            bw.write(number + " ");
        }

        bw.flush();

        bw.close();
    }
}
