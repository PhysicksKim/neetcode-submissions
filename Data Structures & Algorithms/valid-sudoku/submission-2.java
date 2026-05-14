class Solution {
    public boolean isValidSudoku(char[][] board) {
        int bit = 0;
        for(int i = 0 ; i < board.length ; i++) {
            bit = 0;
            for(int j = 0 ; j < board[i].length ; j++) {
                if(board[i][j]=='.') continue;
                int prevBit = bit;
                bit = maskBit(board[i][j],bit);
                if(bit == prevBit) return false;
            }
        }
        for(int j = 0 ; j < board[0].length ; j++) {
            bit = 0;
            for(int i = 0 ; i < board.length ; i++) {
                if(board[i][j]=='.') continue;
                int prevBit = bit;
                bit = maskBit(board[i][j], bit);
                if(bit == prevBit) return false;
            }
        }

        for(int a = 0 ; a < 3 ; a++) {
            for(int b = 0 ; b < 3 ; b++) {
                bit = 0;
                for(int i = a*3 ; i < a*3+3 ; i++) {
                    for(int j = b*3 ; j < b*3+3 ; j++) {
                        if(board[i][j]=='.') continue;
                        int prevBit = bit;
                        bit = maskBit(board[i][j], bit);
                        if(bit == prevBit) return false;
                    }
                }
            }
        }

        return true;
    }

    private int maskBit(char in, int bit) {
        return bit | 1 << (in-'1');
    }
}
