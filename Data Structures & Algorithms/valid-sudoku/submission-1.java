class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();

        // row
        for(int i = 0 ; i < board.length ; i++) {
            set.clear();
            for(int j = 0 ; j < board[i].length ; j++) {
                if(board[i][j] == '.') continue;

                if(set.contains(board[i][j])) {
                    return false;
                } 
                set.add(board[i][j]);
            }
        }

        // column
        for(int j = 0 ; j < board[0].length ; j++) {
            set.clear();
            for(int i = 0 ; i < board.length ; i++) {
                if(board[i][j] == '.') continue;

                if(set.contains(board[i][j])) {
                    return false;
                } 
                set.add(board[i][j]);
            }
        }

        // rect
        for(int x = 0; x < 3 ; x++) {
            for(int y = 0 ; y < 3 ; y++) {
                set.clear();
                for(int i = x*3 ; i < x*3+3 ; i++) {
                    for(int j = y*3 ; j < y*3+3 ; j++) {
                        if(board[i][j] == '.') continue;

                        if(set.contains(board[i][j])) {
                            return false;
                        } 
                        set.add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }
}
