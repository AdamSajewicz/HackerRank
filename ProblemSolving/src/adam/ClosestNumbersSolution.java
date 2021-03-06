package adam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ClosestNumbersSolution {
    
    // Complete the closestNumbers function below.
    static int[] closestNumbers(int[] arr) {
        Arrays.sort(arr);
        TreeMap<Integer, Map<Integer, Integer>> matrix = new TreeMap<>();
        int difference = 0;
        for(int i = 0; i < arr.length - 1; i++){
            difference = Math.abs(arr[i + 1] - arr[i]);
            if(matrix.containsKey(difference)){
                matrix.get(difference).put(arr[i], arr[i + 1]);
            }
            else {
                Map<Integer, Integer> newPair = new HashMap<>();
                newPair.put(arr[i], arr[i + 1]);
                matrix.put(difference, newPair);
            }
        }
        if(arr.length % 2 == 1){
            difference = Math.abs(arr[arr.length - 1] - arr[arr.length - 2]);
            if(matrix.containsKey(difference)){
                matrix.get(difference).put(arr[arr.length - 2], arr[arr.length - 1]);
            }
            else {
                Map<Integer, Integer> newPair = new HashMap<>();
                newPair.put(arr[arr.length - 2], arr[arr.length - 1]);
                matrix.put(difference, newPair);
            }
        }
        int smallestDifference = matrix.firstKey();
        
        int[] resultPairs = new int[matrix.get(smallestDifference).size() * 2];
        int i = 0;
        for(Map.Entry<Integer, Integer> pair : matrix.get(smallestDifference).entrySet()){
            resultPairs[i] = pair.getKey();
            i++;
            resultPairs[i] = pair.getValue();
            i++;
        }
        Arrays.sort(resultPairs);
        return resultPairs;
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
        
        int[] result = closestNumbers(arr);
        
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
