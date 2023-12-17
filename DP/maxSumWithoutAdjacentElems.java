import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class maxSumWithoutAdjacentElems {

    //lcn : last Column Number
    public static int maxSumAdjacent(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> dp, int lcn) {
        //base cases
        if(lcn == 0) {
            return Math.max(A.get(0).get(lcn), A.get(1).get(lcn));
        }
        if(lcn < 0) {
            return 0;
        }

        if (dp.get(lcn) != Integer.MIN_VALUE) return dp.get(lcn);

        int sum1 = A.get(0).get(lcn) + maxSumAdjacent(A, dp, lcn-2);
        int sum2 = A.get(1).get(lcn) + maxSumAdjacent(A, dp, lcn-2);
        int sum3 = maxSumAdjacent(A, dp, lcn-1);

        dp.set(lcn, Math.max(sum3, Math.max(sum1, sum2)));

        return dp.get(lcn);

    }
    
    public static void main(String[] args) {
        ArrayList<Integer> dpArray = new ArrayList<Integer>();

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        // // Row 1
        // ArrayList<Integer> row1 = new ArrayList<>();
        // row1.add(1);
        // row1.add(2);
        // row1.add(3);
        // row1.add(4);

        // // Row 2
        // ArrayList<Integer> row2 = new ArrayList<>();
        // row2.add(2);
        // row2.add(3);
        // row2.add(4);
        // row2.add(5);

        // // Add rows to the matrix
        // matrix.add(row1);
        // matrix.add(row2);

        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(16);
        row1.add(5);
        row1.add(54);
        row1.add(55);
        row1.add(36);
        row1.add(82);
        row1.add(61);
        row1.add(77);
        row1.add(66);
        row1.add(61);

        // Row 2
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(31);
        row2.add(30);
        row2.add(36);
        row2.add(70);
        row2.add(9);
        row2.add(37);
        row2.add(1);
        row2.add(11);
        row2.add(68);
        row2.add(14);

        // Add rows to the matrix
        matrix.add(row1);
        matrix.add(row2);

        for (int i=0; i < matrix.get(0).size()+2;i++) {
            dpArray.add(Integer.MIN_VALUE);
        }

        int ans = maxSumAdjacent(matrix, dpArray, matrix.get(0).size()-1);

        System.out.println(ans);
    }
}
