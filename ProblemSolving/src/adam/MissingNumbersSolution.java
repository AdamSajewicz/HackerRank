package adam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Original problem is described here:
 * https://www.hackerrank.com/challenges/missing-numbers/problem
 */
public class MissingNumbersSolution {
    
    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Integer> bMap = new HashMap<>();
        for(int i : brr){
            if(bMap.containsKey(i)){
                bMap.replace(i, bMap.get(i) + 1);
            }
            else{
                bMap.put(i, 1);
            }
        }
        for(int i : arr){
            if(bMap.containsKey(i)){
                bMap.replace(i, bMap.get(i) - 1);
                if(bMap.get(i) == 0){
                    bMap.remove(i);
                }
            }
            
        }
        TreeSet<Integer> sortedSetOfMissingNumbers = new TreeSet<>();
        for(Integer n : bMap.keySet()){
            sortedSetOfMissingNumbers.add(n);
        }
        return sortedSetOfMissingNumbers.stream().mapToInt(Integer::intValue).toArray();
        
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
        
        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] brr = new int[m];
        
        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }
        
        int[] result = missingNumbers(arr, brr);
        
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
