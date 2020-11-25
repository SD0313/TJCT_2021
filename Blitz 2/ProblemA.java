import java.io.*;
import java.util.*;
public class ProblemA {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(f.readLine());
        int numOdd = 0;
        int numEven = 0;
        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n ;i++){
            int x = Integer.parseInt(st.nextToken());
            if (x%2==0){
                numEven++;
            }
            else{
                numOdd++;
            }
        }
        out.println(Math.min(numOdd, numEven));


        out.close();
    }
}
