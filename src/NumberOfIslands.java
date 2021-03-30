import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
//    public int numIslands(char[][] grid) {
//        // do four connectedness
//        // we check left right up and down
//        // we zero frame the grid
//        // we check left and up and see if there is a 1, if there is then we change the label
//        // this is from top to bottom
//        // we then go from the bottom to top and do a right top and itself
//
//        // we start off with a label
//
//        // convert it to a number
//        int[][] array = convert(grid);
//    }
//
//    // we can create a helper function that checks the connectedness
//
//    public int[][] convert(char[][] grid) {
//        int[][] array = new int[grid.length][grid[0].length];
//        for ( int i = 0; i < grid.length; i++ ) {
//            for ( int j = 0; j < grid[i].length; j++ ) {
//                if ( grid[i][j].equals("1") ) array[i][j] = 1;
//            }
//        }
//        return array;
//    }
//
//    public void passOne(int[][] m) { // m for mirror
//        int label = 1;
//        for ( int i = 1; i < m.length-1; i++ ) {
//            for ( int j = 1; j < m[i].length-1; j++ ) {
//                if ( m[i][j] > 0 ) {
//
//                    int top = m[i-1][j];
//                    int left = m[i][j-1];
//                    int min = Math.min(top, left);
//
//                    if ( top == 0 && left == 0 ) m[i][j] = minLabel;
//                    else if ( top > 0 && left > 0)
//                }
//            }
//        }
//    }
//
//    public void passTwo() {
//
//    }

    // check top and left

    public int numIslands(char[][] grid) {
        int numIslandsCount = 0;

        int m = grid.length;
        int n = grid[0].length;

        boolean[] existIsland = new boolean[n];

        for ( int i = 0; i < m; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                // if it's 1st row, no need to look at existsIsland
                // if i > 0 : check existsIsland's truth value,
                // if true, don't increment numIslands
                // otherwise, increment
                if ( i == 0 ) {
                    // System.out.println("Got here");
                    if ( grid[i][j] == '1' ) { // this is an island // check for consecutive ones
                        if ( j == 0 )
                            numIslandsCount++;
                        else if ( grid[i][j-1] != '1' )
                            numIslandsCount++;

                        existIsland[j] = true;
                    } else {
                        existIsland[j] = false;
                    }
                } else {
                    if ( grid[i][j] == '1' ) {
                        if ( !existIsland[j] ) {
                            numIslandsCount++;
                        }
                        existIsland[j] = grid[i][j] == '1' ? true : false;
                    }
                }
            }
        }

        return numIslandsCount;
    }

    public int numIslands2(char[][] grid) {
        Queue<Island> queue = new LinkedList<>();

        int numOfIslands = 0;
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[i].length; j++ ) {
                if ( grid[i][j] == '1' ) {
                    // bfs
                    numOfIslands++;
                    grid[i][j] = '!';
//                    dfs(i, j, grid); // dfs stuff
                    queue.add(new Island (i, j));

                    while ( !queue.isEmpty() ) {
                        Island current = queue.poll();
                        if ( current.col > 0 && grid[current.row][current.col - 1] == '1' ) { // left
                            queue.offer(new Island(current.row, current.col-1) );
                            grid[current.row][current.col - 1] = '!';
                        }
                        if ( current.row > 0 && grid[current.row - 1][current.col] == '1' ) { // up
                            queue.offer(new Island(current.row-1, current.col) );
                            grid[current.row - 1][current.col] = '!';

                        }
                        if ( current.row < grid.length-1 && grid[current.row+1][current.col] == '1' ) { // down
                            queue.offer(new Island(current.row+1, current.col) );
                            grid[current.row+1][current.col] = '!';

                        }
                        if ( current.col < grid[i].length-1 && grid[current.row][current.col + 1] == '1' ) { // right
                            queue.offer(new Island(current.row, current.col+1) );
                            grid[current.row][current.col+1] = '!';
                        }

                    }

                }
            }
        }

        return numOfIslands;
    }

    public class Island{
        public int row, col;

        public Island(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
/*
[["1","1","1"],
["0","1","0"],
["0","1","0"]]

*/
// bfs go through each island until there are no more islands: num++
// keep checking queue
/*
numIslandsCount = 3
boolean[] existsIsland = new int[m];
[false, false, false, false, false]
[
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
*/
/*
numIslandsCount = 3
boolean[] existsIsland = new int[m];
[false, false, false, false, false]
[
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
*/
}