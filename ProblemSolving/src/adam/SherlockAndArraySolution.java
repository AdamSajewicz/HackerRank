package adam;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Original problem is described there:
 * https://www.hackerrank.com/challenges/sherlock-and-array/problem
 */
public class SherlockAndArraySolution {
    
    // Complete the balancedSums function below.
    static String balancedSums(List<Integer> arr) {
        if(arr.size() == 1){
            return "YES";
        }
        int leftSum = 0;
        int rightSum = 0;
        int j = arr.size() - 1;
        int i = 0;
        int toCheck = arr.size();
        do{
            if(leftSum == rightSum && toCheck == 1){
                return "YES";
            }
            if(leftSum == rightSum){
                if(arr.get(i) < arr.get(j)){
                    leftSum+=arr.get(i);
                    i++;
                    toCheck--;
                }
                else if(arr.get(i) > arr.get(j)){
                    rightSum+=arr.get(j);
                    j--;
                    toCheck--;
                }
                else {
                    leftSum+=arr.get(i);
                    i++;
                    toCheck--;
                    rightSum+=arr.get(j);
                    j--;
                    toCheck--;
                }
            }
            else if(leftSum < rightSum){
                leftSum+=arr.get(i);
                i++;
                toCheck--;
            }
            else {
                rightSum+=arr.get(j);
                j--;
                toCheck--;
            }
        }
        while(i < j);
        if(leftSum == rightSum) {
            return "YES";
        }
        return "NO";
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int T = Integer.parseInt(bufferedReader.readLine().trim());
        
        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());
                
                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());
                
                String result = balancedSums(arr);
                
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        bufferedReader.close();
        bufferedWriter.close();
    }
}
