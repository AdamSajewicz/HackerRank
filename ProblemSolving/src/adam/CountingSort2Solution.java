package adam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountingSort2Solution {
    
    // Complete the countingSort function below.
    static int[] countingSort(int[] arr) {
        int[] counting = new int[101];
        Arrays.fill(counting, 0);
        for(int i = 0; i < arr.length; i++){
            counting[arr[i]] += 1;
        }
        List<Integer> resulting = new ArrayList<>();
        for(int i = 0; i < 101; i++){
            if(counting[i] > 0){
                int j = 0;
                do {
                    resulting.add(i);
                    j++;
                }
                while(j < counting[i]);
            }
        }
        return resulting.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] arr = new int[n];
        
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        
        int[] result = countingSort(arr);
        
        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));
            
            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }
        
        bufferedWriter.newLine();
        
        bufferedWriter.close();
        
        scanner.close();
    }
}
