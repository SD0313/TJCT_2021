/*********************************
 * Sauman Das
 * November 7th, 2020
 * TJCT Long 1: Amrita's Autocorrect
 * All Correct! :)
 **********************************/
import java.util.*;
import java.io.*;
public class ProblemB {
    public static void main(String[] args) throws IOException{

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(sc.readLine());
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(sc.readLine());
            int type = Integer.parseInt(st.nextToken());
            String word = st.nextToken();
            if (type == 1) {
                String curr = "";
                for (int j = 0; j < word.length(); j++){
                    curr += (word.charAt(j)+"");
                    if (!map.containsKey(curr)) map.put(curr, 1);
                    else {
                        map.put(curr, map.get(curr) + 1);
                    }
                }
            }
            if (type == 2) {
                System.out.println(map.get(word));
            }

        }

        sc.close();
    }
}
