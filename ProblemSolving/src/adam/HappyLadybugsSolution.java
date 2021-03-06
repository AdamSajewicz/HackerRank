package adam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HappyLadybugsSolution {
    
    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        if(b.length() == 0){
            return "YES";
        }
        if(b.length() == 1){
            if(!b.equals("_")){
                return "NO";
            }
            else {
                return "YES";
            }
        }
        Map<String, Integer> ladyBugs = new HashMap<>();
        for(char c : b.toCharArray()){
            if(ladyBugs.containsKey("" +  c)){
                ladyBugs.put("" + c, ladyBugs.get("" + c) + 1);
            }
            else {
                ladyBugs.put("" + c, 1);
            }
        }
        if(ladyBugs.containsKey("_")){
            if(ladyBugs.size() == 1){
                return "YES";
            }
        }
        else {
            if(ladyBugs.containsValue(1)){
                return "NO";
            }
            char[] zoom = b.toCharArray();
            for(int i = 1; i < zoom.length - 1; i++){
                if(zoom[i - 1] != zoom[i] && zoom[i + 1] != zoom[i]){
                    return "NO";
                }
            }
        }
        
        ladyBugs.remove("_");
        if(ladyBugs.containsValue(1)){
            return "NO";
        }
        return "YES";
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            String b = scanner.nextLine();
            
            String result = happyLadybugs(b);
            
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }
        
        bufferedWriter.close();
        
        scanner.close();
    }
}
