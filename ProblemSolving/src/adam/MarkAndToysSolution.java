package adam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class MarkAndToysSolution {
    
    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        LinkedList<Integer> sortedAndFiltered = new LinkedList<>();
        for(int c : prices){
            if(c <= k){
                sortedAndFiltered.add(c);
            }
        }
        Collections.sort(sortedAndFiltered);
        int numberOfToys = 0;
        int amount = k;
        
        if(sortedAndFiltered.size() > 0){
            //boolean end = false;
            
            Integer nextToy = sortedAndFiltered.pollFirst();
            if(nextToy == null){
                nextToy = amount + 1;
            }
            
            while(amount > 0 && amount >= nextToy){
                amount -= nextToy;
                numberOfToys++;
                nextToy = sortedAndFiltered.pollFirst();
                if(nextToy == null){
                    nextToy = amount + 1;
                }
            }
        }
        
        return numberOfToys;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        String[] nk = scanner.nextLine().split(" ");
        
        int n = Integer.parseInt(nk[0]);
        
        int k = Integer.parseInt(nk[1]);
        
        int[] prices = new int[n];
        
        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }
        
        int result = maximumToys(prices, k);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedWriter.close();
        
        scanner.close();
    }
}
