package com._2array.day122Darray;

import java.util.*;

public class _06_A_MatrixTranspose {
    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        System.out.println("Row:");
        int row = sc.nextInt();
        System.out.println("Col:");
        int col = sc.nextInt();
        ArrayList<ArrayList<Integer>> twoDMatrix1 = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            twoDMatrix1.add(new ArrayList<>(Collections.nCopies(col, 0)));
        }
        fillMatrixWithRandomValues(twoDMatrix1);
        System.out.println(twoDMatrix1);*/

        ArrayList<ArrayList<Integer> > twoDMatrix1 = new ArrayList<>();
        twoDMatrix1.add(new ArrayList<>(Arrays.asList(21,62,16,44,55,100,16,86,29)));
        twoDMatrix1.add(new ArrayList<>(Arrays.asList(62,72,85,35,14,1,89,15,73)));
        twoDMatrix1.add(new ArrayList<>(Arrays.asList(42,44,30,56,25,52,61,23,54)));
        twoDMatrix1.add(new ArrayList<>(Arrays.asList(5,35,12,35,55,74,50,50,80)));
        twoDMatrix1.add(new ArrayList<>(Arrays.asList(2,65,65,82,26,36,66,60,1)));
        twoDMatrix1.add(new ArrayList<>(Arrays.asList(18,1,16,91,42,11,72,97,35)));
        twoDMatrix1.add(new ArrayList<>(Arrays.asList(23,57,9,28,13,44,40,47,98)));
        System.out.println(twoDMatrix1);
        System.out.println(new _06_A_MatrixTranspose().solve(twoDMatrix1));
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int column_size = A.size();
        int row_size = A.get(0).size();
        for(int row=0;row<row_size;row++){
            ArrayList<Integer> list = new ArrayList<>(Collections.nCopies(column_size,0));
            result.add(list);
        }
        for(int row=0;row<column_size;row++){
            for(int col=0;col<row_size;col++){
                result.get(col).set(row,A.get(row).get(col));
            }
        }
        return result;
    }


    private static void fillMatrixWithRandomValues(ArrayList<ArrayList<Integer>> matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.size(); i++) {
            ArrayList<Integer> row = matrix.get(i);
            for (int j = 0; j < row.size(); j++) {
                row.set(j, random.nextInt(100)); // Set random values to the elements of the row
            }
        }
    }
}
