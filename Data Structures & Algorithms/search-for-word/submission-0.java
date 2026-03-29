class Solution {
    int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,-1,1};
    int len;
    int col;
    int row;
    boolean[][] visit;
    public boolean exist(char[][] board, String word) {
        char first = word.charAt(0);
        col = board[0].length;
        row = board.length;
        len = word.length();
        visit = new boolean[row][col];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                char ch = board[i][j];
                if(ch==first) {
                    if(len==1) return true;
                    visit[i][j] = true;
                    if(dfs(board, word, 1, j, i)) return true;
                    visit[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int p, int q) {
        boolean isTrue = false;
        for(int i=0; i<4; i++) {
            int _x = dx[i] + p;
            int _y = dy[i] + q;
            if(0<=_x && _x <col && 0<=_y && _y<row && !visit[_y][_x]) {
                char ch = board[_y][_x];
                if(ch==word.charAt(index)) {
                    if(index==len-1) return true;    
                    visit[_y][_x] = true;
                    if(dfs(board, word, index+1, _x, _y)) return true;
                    visit[_y][_x] = false;
                }
            }
        }
        return isTrue;
    } 
}