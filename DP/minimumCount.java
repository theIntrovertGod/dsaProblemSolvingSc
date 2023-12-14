package dsaProblemSolvingSc.DP;

import java.util.ArrayList;
import java.util.Collections;

/**
 * minimumCount
 */
public class minimumCount {
    // DP solution - Top-Down Approach
    public static ArrayList<Integer> dpArray = new ArrayList<>(Collections.nCopies(10000, Integer.MIN_VALUE));
    public static int mC(int N) {
        // base case
        if( N==0 ) return 0;

        // dp array usage
        if (dpArray.get(N) != Integer.MIN_VALUE) return dpArray.get(N);

        // operations

        // recursive call
        int min = Integer.MAX_VALUE;
        for(int i = 1; i*i <= N; i++) {
            min = Math.min(min,1 + mC(N - i*i));
           
        }
        // dp.set(N, 1+ min);
        dpArray.set(N, min);
        return dpArray.get(N);
    }

    public static void main(String[] args) {
        System.out.println(mC(12));
        return;
    }

    
    
}