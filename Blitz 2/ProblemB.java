import java.util.*;
import java.io.*;
public class ProblemB2 {
    static int lowerIndex(int arr[], int n, int x)
    {
        int l = 0, h = n - 1;
        while (l <= h)
        {
            int mid = (l + h) / 2;
            if (arr[mid] >= x)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    // function to find last index <= y
    static int upperIndex(int arr[], int n, int y)
    {
        int l = 0, h = n - 1;
        while (l <= h)
        {
            int mid = (l + h) / 2;
            if (arr[mid] <= y)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return h;
    }

    // function to count elements within given range
    static int countInRange(int arr[], int n, int x, int y)
    {
        // initialize result
        int count = 0;
        count = upperIndex(arr, n, y) -
                lowerIndex(arr, n, x) + 1;
        return count;
    }

    // Driver function
    public static void main (String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] arr  = new int[n];
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        // Preprocess array
        Arrays.sort(arr);

        // Answer queries
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int low = x - k;
            int high = x + k;
            out.println(countInRange(arr, n, low, high));
        }
        out.close();


    }
}
