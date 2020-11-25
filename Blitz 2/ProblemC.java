import java.io.*;
import java.util.*;
public class ProblemC {
    static ArrayList<Cuts> cut;
    public static int binSearchLow(long n){
        int lo = 0;
        int hi = cut.size()-1;
        int indOut = -1;
        while (lo <= hi){
            int mid = (lo+hi)/2;
            Cuts c = cut.get(mid);
            if (c.contains(n)){
                indOut = mid;
                hi = mid-1;

            }
            else if (n < c.low){
                hi = mid-1;
            }
            else if (n > c.high){
                lo = mid+1;
            }
        }
        return indOut;
    }
    public static int binSearchHigh(long n){
        int lo = 0;
        int hi = cut.size()-1;
        int indOut = -1;
        while (lo <= hi){
            int mid = (lo+hi)/2;
            Cuts c = cut.get(mid);
            if (c.contains(n)){
                indOut = mid;
                lo = mid+1;

            }
            else if (n < c.low){
                hi = mid-1;
            }
            else if (n > c.high){
                lo = mid+1;
            }
        }
        return indOut;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(f.readLine());
        long n = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());
        cut = new ArrayList<>();
        st = new StringTokenizer(f.readLine());
        for (long i = 0; i < n; i++) {
            cut.add(new Cuts(Long.parseLong(st.nextToken())));
        }
        Collections.sort(cut);
//        System.out.println(binSearchLow(4));
        for (long i = 0; i < q; i++){
            long p = Long.parseLong(f.readLine());
            int lo = binSearchLow(p);
            int hi = binSearchHigh(p);
            if (lo == -1 || hi == -1){
                out.println(0);
            }
            else{
                out.println(hi-lo+1);
            }
//            long count = 0;
//            for (Cuts c: cut){
//                if (c.contains(p)){
//                    count++;
//                }
//            }
//            out.println(count);
        }

        out.close();
    }
    static class Cuts implements Comparable<Cuts>{
        long n, low, high;
        public Cuts(long n){
            this.n = n;
            this.high = (long)(0.5*(n*n+n+2));
            this.low = n+1;
        }
        public boolean contains(long i){
            return i >= low && i <= high;
        }

        @Override
        public int compareTo(Cuts o) {
            return Long.compare(n, o.n);
        }
    }
}
