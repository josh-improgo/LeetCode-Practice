import java.util.ArrayList;
import java.util.HashSet;

/**
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeroes {
    /** Brute Force **/
    public void setZeroes(int[][] matrix) {
        // get all the rows with 0's
        // get all the columns with 0's

        ArrayList<Integer> rowsWithZeroes = new ArrayList<>();
        ArrayList<Integer> colsWithZeroes = new ArrayList<>();

        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[i].length; j++ ) {
                if ( matrix[i][j] == 0 ) {
                    rowsWithZeroes.add(i);
                    colsWithZeroes.add(j);
                }
            }
        }

        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[i].length; j++ ) {
                for ( int r = 0; r < rowsWithZeroes.size(); r++ ) {
                    if ( i == rowsWithZeroes.get(r) ) {
                        matrix[i][j] = 0;
                    }
                }
                for ( int c = 0; c < rowsWithZeroes.size(); c++ ) {
                    if ( j == colsWithZeroes.get(c) ) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

    }

    /** Slightly Better solution **/
    public void setZeroes2(int[][] matrix) {
        // get all the rows with 0's
        // get all the columns with 0's

        ArrayList<Integer> rowsWithZeroes = new ArrayList<>();
        ArrayList<Integer> colsWithZeroes = new ArrayList<>();

        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[i].length; j++ ) {
                if ( matrix[i][j] == 0 ) {
                    rowsWithZeroes.add(i);
                    colsWithZeroes.add(j);
                }
            }
        }

        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[i].length; j++ ) {
                if ( rowsWithZeroes.contains(i) || colsWithZeroes.contains(j) ) matrix[i][j] = 0;

            }
        }
    }

    /** Even faster using Hashset **/
    public void setZeroes3(int[][] matrix) {
        // get all the rows with 0's
        // get all the columns with 0's

        HashSet<Integer> rowsWithZeroes = new HashSet<>();
        HashSet<Integer> colsWithZeroes = new HashSet<>();

        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[i].length; j++ ) {
                if ( matrix[i][j] == 0 ) {
                    rowsWithZeroes.add(i);
                    colsWithZeroes.add(j);
                }
            }
        }

        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[i].length; j++ ) {
                if ( rowsWithZeroes.contains(i) || colsWithZeroes.contains(j) ) matrix[i][j] = 0;
            }
        }

    }

    /** Flagging **/
    public void setZeroes4(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        boolean setCol = false;

        // flagging
        for ( int i = 0; i < rowLength; i++ ) {
            if ( matrix[i][0] == 0 ) setCol = true;
            for ( int j = 1; j < colLength; j++ ) {
                if ( matrix[i][j] == 0 ) {
                    matrix[i][0] = 0; // set row i at column 0 to 0
                    matrix[0][j] = 0; // set column j at row 0 to 0
                }
            }
        }

        for ( int row = 1; row < rowLength; row++ ) {
            for ( int col = 1; col < colLength; col++ ) {
                if ( matrix[row][0] == 0 || matrix[0][col] == 0 ) {
                    matrix[row][col] = 0;
                }
            }
        }

        if ( matrix[0][0] == 0 ) {
            for ( int col = 0; col < colLength; col++ ) {
                matrix[0][col] = 0;
            }
        }

        if ( setCol ) {
            for ( int row = 0; row < rowLength; row++ ) {
                matrix[row][0] = 0;
            }
        }
    }
}
