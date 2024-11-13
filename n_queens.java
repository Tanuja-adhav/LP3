import java.util.*;

 class NQueens {
    private int n; // Size of the chessboard (n x n)
    private int[][] board; // Board to represent the n-Queens positions
    // Constructor
    public NQueens(int n) {
        this.n = n;
        this.board = new int[n][n];
    }

    // Function to print the board
    private void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    // Function to check if it's safe to place a queen at board[row][col]
    private boolean isSafe(int row, int col) {
        // Check this column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Function to solve the n-Queens problem using backtracking
    public boolean solveNQueens(int row) {
        // If all queens are placed, return true
        if (row == n) {
            return true;
        }

        // Try placing the queen in all columns of the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1; // Place the queen

                // Recur to place the rest of the queens
                if (solveNQueens(row + 1)) {
                    return true; // If placing queen leads to a solution
                }

                // Backtrack: If placing queen doesn't lead to a solution, remove the queen
                board[row][col] = 0;
            }
        }

        return false; // If no safe position is found, return false
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the board (n): ");
        int n = scanner.nextInt();
        
        NQueens nQueens = new NQueens(n);

        // Place the first queen at (0, 0) (first row, first column)
        nQueens.board[0][0] = 1;

        // Try solving for the rest of the queens starting from row 1
        if (nQueens.solveNQueens(1)) {
            System.out.println("Solution:");
            nQueens.printBoard();
        } else {
            System.out.println("No solution found.");
        }

        scanner.close();
    }
}
