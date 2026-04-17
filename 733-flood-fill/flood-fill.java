class Solution {
    static int[] diff = {0,1,0,-1,0};
    private void dfs(int[][] image, int sr, int sc, int R, int C, int og, int newcolor){
        if(image[sr][sc] == newcolor) return;
        image[sr][sc] = newcolor;
        for(int di = 0 ; di < 4 ; di++){
            int adjR = sr + diff[di], adjC = sc + diff[di+1];
            if(adjR>=0 && adjR<R && adjC>=0 && adjC<C && image[adjR][adjC] == og){
                dfs(image,adjR,adjC,R,C,og,newcolor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int R = image.length, C = image[0].length;
        dfs(image,sr,sc,R,C,image[sr][sc],color);
        return image;
    }
}