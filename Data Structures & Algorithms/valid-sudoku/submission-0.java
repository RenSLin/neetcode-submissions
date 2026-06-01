class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check row
        for (char[] row : board) {
            Set<Character> rowSet = new HashSet<>();
            for (char number : row) {
                if (number != '.' && !rowSet.add(number)) {
                    return false;  // add() returns false if already exists
                }
            }
        }
        //check col
        for (int i = 0; i < 9; i++) {
            Set<Character> colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.' && !colSet.add(board[j][i])) {
                    return false;  // add() returns false if already exists
                }
            }
        }

        //check box
        Map<Integer, Set<Character>> boxMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int boxIndex = (i/3) * 3 + (j/3); //give us which key we do
                Set<Character> boxSet = boxMap.getOrDefault(boxIndex, new HashSet<>());
                if (board[i][j] != '.' && !boxSet.add(board[i][j])) {
                    return false;
                }
                boxMap.put(boxIndex, boxSet);
            }
        }

        return true;
    }
}
