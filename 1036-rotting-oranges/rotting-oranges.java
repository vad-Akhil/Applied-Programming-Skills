class Solution {
    public int orangesRotting(int[][] grid) {
        int[] diff = {0,1,0,-1,0};
        int R = grid.length, C = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshoranges = 0;
        for(int row = 0 ; row < R ; row++){
            for(int col = 0 ; col < C ; col++){
                if(grid[row][col] == 2){
                    queue.add(new int[]{row,col});
                }
                if(grid[row][col] == 1) freshoranges++;
            }
        }
        int time = 0;
        while(!queue.isEmpty()){
            boolean anyorangesaroundmethatirottedrightnow = false;
            int cellcount = queue.size();
            for(int ctr = 0 ; ctr < cellcount ; ctr++){
                int[] val = queue.poll();
                int currentrow = val[0], currentcol = val[1];
                for(int di = 0 ; di < 4 ; di++){
                    int adjR = currentrow + diff[di], adjC = currentcol + diff[di+1];
                    if(adjR>=0 && adjR<R && adjC>=0 && adjC<C && grid[adjR][adjC] == 1){
                        freshoranges--;
                        grid[adjR][adjC] = 2;
                        queue.add(new int[]{adjR,adjC});
                        anyorangesaroundmethatirottedrightnow = true;
                    }
                }
            }
            if(anyorangesaroundmethatirottedrightnow) time++;
        }

        return (freshoranges==0) ? time : -1;
    }
}