package RecursionDpBacktracking;

import java.util.ArrayList;

public class QueensPermutation {
	public static void main(String[] args) {

//		queenCombinationBoxRespect(new boolean[4], 0, 0, 2, "");
//		coinChangePermutationBoxRespect(new int[] {1,2,4,5}, 0, 10, "");
		queenCombination2Dkill(new boolean[3][4], 0, 0, 0, 3, "");

	}

	public static void queenPermutation(boolean[] boxes, int qpsf, int tq, String ans) {
		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;
				queenPermutation(boxes, qpsf + 1, tq, ans + "q" + (qpsf + 1) + "b" + i);
				boxes[i] = false;
			}
		}

	}

	public static void queenCombination(boolean[] boxes, int qpsf, int tq, String ans, int lastboxused) {
		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}
		for (int i = lastboxused + 1; i < boxes.length; i++) {
			if (boxes[i] == false) {
				boxes[i] = true;
				queenCombination(boxes, qpsf + 1, tq, ans + "q" + (qpsf + 1) + "b" + i, i);
				boxes[i] = false;
			}
		}

	}

	public static void coinChangeCombination(int[] domination, int amount, String ans, int lastDomIndex) {
		if (amount == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = lastDomIndex; i < domination.length; i++) {
			if (amount >= domination[i]) {
				coinChangeCombination(domination, amount - domination[i], ans + domination[i], i);
			}
		}
	}

	public static void coinChangePermutation(int[] domination, int amount, String ans) {
		if (amount == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = 0; i < domination.length; i++) {
			if (amount >= domination[i]) {
				coinChangePermutation(domination, amount - domination[i], ans + domination[i]);
			}
		}
	}

	public static void queenCombinationBoxRespect(boolean[] board, int col, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		if (col == board.length) {
			return;
		}
		board[col] = true;
		queenCombinationBoxRespect(board, col + 1, qpsf + 1, tq, ans + "B" + col);
		board[col] = false;

		queenCombinationBoxRespect(board, col + 1, qpsf, tq, ans);
	}

	public static void coinChangePermutationBoxRespect(int[] denomination, int index, int amount, String ans) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}
		if (amount < 0) {
			return;
		}
		if (index == denomination.length) {
			return;
		}
		coinChangePermutationBoxRespect(denomination, index, amount - denomination[index], ans + denomination[index]);
		coinChangePermutationBoxRespect(denomination, index + 1, amount, ans);
	}

	public static void queenCombination2D(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		if (col == board[0].length) {
			row++;
			col = 0;
		}
		if (row == board.length) {
			return;
		}
		board[row][col] = true;
		queenCombination2D(board, row, col + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
		board[row][col] = false;

		queenCombination2D(board, row, col + 1, qpsf, tq, ans);
	}

	public static void queenCombination2Dkill(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		if (col == board[0].length) {
			row++;
			col = 0;
		}
		if (row == board.length) {
			return;
		}
		if (isItSaveToPlaceTheQueen(board, row, col)) {
			board[row][col] = true;
			queenCombination2Dkill(board, row, col + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
			board[row][col] = false;
		}

		queenCombination2Dkill(board, row, col + 1, qpsf, tq, ans);
	}

	public static boolean isItSaveToPlaceTheQueen(boolean[][] board, int row, int col) {

		int r = row - 1;
		int c = col;

		while (r >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
		}

		r = row;
		c = col - 1;
		while (c >= 0) {
			if (board[r][c]) {
				return false;
			}
			c--;
		}
		r = row - 1;
		c = col - 1;
		while (r >= 0 && c >= 0) {
			if (board[r][c]) {
				return false;
			}
			c--;
			r--;
		}

		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}
			r--;
			c++;
			
		}
		return true;
	}
}
