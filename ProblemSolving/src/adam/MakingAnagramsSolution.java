package adam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakingAnagramsSolution {
    
    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> mapStr1 = new HashMap<>();
        Map<Character, Integer> mapStr2 = new HashMap<>();
        for(char c : abc.toCharArray()){
            mapStr1.put(c, 0);
            mapStr2.put(c, 0);
        }
        for(char c : s1.toCharArray()){
            mapStr1.put(c, mapStr1.get(c) + 1);
        }
        for(char c : s2.toCharArray()){
            mapStr2.put(c, mapStr2.get(c) + 1);
        }
        int result = 0;
        for(char c : abc.toCharArray()){
            result += Math.abs(mapStr2.get(c) - mapStr1.get(c));
        }
        return result;
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        String s1 = scanner.nextLine();
        
        String s2 = scanner.nextLine();
        
        int result = makingAnagrams(s1, s2);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedWriter.close();
        
        scanner.close();
    }
}
