/*********************************
 * Sauman Das
 * November 7th, 2020
 * TJCT Long 1: Amrita's Bacteria
 * All Correct! :)
 **********************************/

import java.util.*;
import java.io.*;
public class ProblemF {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());//num bacteria
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Bacteria> bacs = new ArrayList<>();
        for (int i = 0; i < m; i++){
            Bacteria b = new Bacteria();
            for (int j = 0; j < k; j++){
                b.addLine(f.readLine());
            }
            bacs.add(b);
        }
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(f.readLine());
            ArrayList<Integer> toks = new ArrayList<>();
            for (int j = 0; j < n; j++){
                toks.add(Integer.parseInt(st.nextToken())-1);
            }
            for (int j = 0; j < k; j++){
                for (int x = 0; x < n; x++){
                    int l = toks.get(x);
                    out.print(bacs.get(l).lines.get(j));
                }
                out.println();
            }
        }

        f.close();
        out.close();
    }
}
class Bacteria{
    ArrayList<String> lines = new ArrayList<>();
    public Bacteria(){}
    public void addLine(String line){
        lines.add(line);
    }
}