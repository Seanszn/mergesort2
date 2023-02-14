import java.util.Random;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        float mergeStart, mergeEnd, mergeTime, bubbleStart, BubbleEnd, bubbleTime;
        Random rand = new Random();
        int[] numbers = new int[1000];
        for(int i = 0; i<numbers.length; i++){
            numbers[i] = rand.nextInt(1000);
        }
        System.out.println(Arrays.toString(numbers));
        mergeStart = System.currentTimeMillis();
        mergeSort(numbers);
        mergeEnd = System.currentTimeMillis();
        mergeTime = mergeEnd-mergeStart;
        System.out.println("merge sort took " + mergeTime + " milliseconds");
        System.out.println(Arrays.toString(numbers));
        bubbleStart= System.currentTimeMillis();
        bubbleSort(numbers);
        BubbleEnd = System.currentTimeMillis();
        bubbleTime = BubbleEnd - bubbleStart;
        System.out.println("bubble sort would have taken " + bubbleTime + "milliseconds");
    }

    public static void mergeSort(int[] array) {
        int num = array.length;
        if (num < 2) {
            return;
        }
        int mid = num / 2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[num - mid];
    
        for (int i = 0; i < mid; i++) {
            leftHalf[i] = array[i];
        }
        for (int i = mid; i < num; i++) {
            rightHalf[i - mid] = array[i];
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);
    
        mergeArray(array, leftHalf, rightHalf, mid, num - mid);
    }
    public static void mergeArray(int[] a, int[] l, int[] r, int left, int right) {
       
          int i = 0, j = 0, k = 0;
          while (i < left && j < right) {
              if (l[i] <= r[j]) {
                  a[k++] = l[i++];
              }
              else {
                  a[k++] = r[j++];
              }
          }
          while (i < left) {
              a[k++] = l[i++];
          }
          while (j < right) {
              a[k++] = r[j++];
          }
      }

      public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length - 1; i++)
            for (int j = 0; j < array.length - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }
}