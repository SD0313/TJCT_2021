/***************************************
 * Sauman Das
 * November 8th, 2020
 * TJCT Long 1
 * Problem C: Amrita's Fear of Spiders
 * All Correct! :)
 ****************************************/

import java.util.*;
import java.io.*;
public class ProblemC{
    static int[][] grid;
    static int n;
    static int currentSize;
    static HashMap<Integer, Integer> size = new HashMap<>();
    static HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken())-1;
        int x = Integer.parseInt(st.nextToken())-1;
        grid = new int[n][n];
        for (int i = 0; i < n; i++){
            String line = f.readLine();
            for (int j = 0; j < n; j++){
                if (line.charAt(j) == 'o') {
                    grid[i][j] = 0;
                }
                else{
                    grid[i][j] = -1;
                }
            }
        }
        int curr_spd = -2;
        int curr_ept = 1;
        currentSize = 0;
        spraySpd(x, y, 0, 1);
        size.put(1, currentSize);
        curr_ept++;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 0){
                    currentSize = 0;
                    spraySpd(i, j, 0, curr_ept);
                    size.put(curr_ept, currentSize);
                    curr_ept++;
                }
            }
        }
        for (int i = 0 ;i < n ;i++){
            for (int j = 0 ;j < n; j++){
                if (grid[i][j] == -1 && nextToN(i, j, 1)){
                    currentSize = 0;
                    spraySpd2(i, j, -1, curr_spd);
                    size.put(curr_spd, currentSize);
                    curr_spd--;
                }
            }
        }
        int max = 0;
        for (int i = -2; i > curr_spd; i--){
            int total = size.get(1);
            total += size.get(i);
            if (adj.containsKey(i)) {
                for (int j : adj.get(i)) {
                    total += size.get(j);
                }
            }
            max = Math.max(total, max);
        }
        if (max == 0){
            out.println(n*n);
        }
        else {
            out.println(max);
        }
        f.close();
        out.close();
    }
    public static void spraySpd(int r, int c, int key, int replace){
        Stack<Pair> dfs = new Stack<Pair>();
        dfs.push(new Pair(r, c));
        while (!dfs.isEmpty()) {
            Pair next = dfs.pop();
            int r1 = next.r;
            int c1 = next.c;
            if (!inBound(r1, c1)) continue;
//            if (next >= n*n) continue;
            if (grid[r1][c1] != key) continue;
            if (grid[r1][c1] == replace) continue;
//        visited[r][c] = true;
            currentSize++;
            grid[r1][c1] = replace;
            dfs.push(new Pair(r1+1, c1));
            dfs.push(new Pair(r1-1, c1));
            dfs.push(new Pair(r1, c1+1));
            dfs.push(new Pair(r1, c1-1));
        }

    }
    public static void spraySpd2(int r, int c, int key, int replace){
        Stack<Pair> dfs = new Stack<Pair>();
        dfs.push(new Pair(r, c));
        while(!dfs.isEmpty()) {
            Pair next = dfs.pop();

            int r1 = next.r;
            int c1 = next.c;
            if (!inBound(r1, c1)) continue;
            if (grid[r1][c1] == replace) continue;
            if (grid[r1][c1] != key && grid[r1][c1] > 0 && grid[r1][c1] != 1) {
                if (!adj.containsKey(replace)) {
                    adj.put(replace, new HashSet<Integer>());
                }
                adj.get(replace).add(grid[r1][c1]);
                continue;
            }
            if (grid[r1][c1] != key) continue;

            currentSize++;
            grid[r1][c1] = replace;
            dfs.push(new Pair(r1+1, c1));
            dfs.push(new Pair(r1-1, c1));
            dfs.push(new Pair(r1, c1+1));
            dfs.push(new Pair(r1, c1-1));
        }

    }
    public static boolean inBound(int r, int c){
        return !(r < 0 || r >= n || c < 0 || c >= n);
    }
    public static boolean nextToN(int r, int c, int n){
        if (inBound(r+1, c)){
            if (grid[r+1][c] == n) return true;
        }
        if (inBound(r, c+1)) {
            if (grid[r][c+1] == n) return true;
        }
        if (inBound(r-1, c)){
            if (grid[r-1][c] == n) return true;
        }
        if (inBound(r, c-1)) {
            if (grid[r][c-1] == n) return true;
        }
        return false;
    }
}
class Pair{
    int r, c;
    public Pair(int r, int c){this.r = r; this.c = c;}
}