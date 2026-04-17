class Solution {
    static int[] diff = {0,1,0,-1,0};
    private int dfs(int[][] grid, int row, int col, int R, int C){
        grid[row][col] = 0;
        int area = 1;
        for(int di = 0 ; di < 4 ; di++){
            int adjR = row + diff[di], adjC = col + diff[di+1];
            if(adjR>=0 && adjR<R && adjC>=0 && adjC<C && grid[adjR][adjC] == 1){
                area += dfs(grid,adjR,adjC,R,C);
            }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int currarea = 0, maxarea = 0;
        for(int row = 0 ; row < R ; row++){
            for(int col = 0 ; col < C ; col++){
                if(grid[row][col] == 1){
                    currarea = dfs(grid,row,col,R,C);
                    maxarea = Math.max(maxarea,currarea);
                }
            }
        }
        return maxarea;
    }
}