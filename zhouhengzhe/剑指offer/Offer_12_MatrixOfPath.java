package com.zhz.SwordOffer;

/**
 * 矩阵中的路径
 */
public class Offer_12_MatrixOfPath {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[k]) {
            return true;
        }
        if (k == words.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, words, i + 1, j, k + 1) ||
                dfs(board, words, i - 1, j, k + 1) ||
                dfs(board, words, i, j + 1, k + 1) ||
                dfs(board, words, i, j - 1, k + 1);
        board[i][j] = words[k];
        return res;
    }

    public static void main(String[] args) {
//        char[][] boar = {'A', 'B', 'C', 'E'} {
//            "S", "F", "C", "S"
//        }、{
//            "A", "D", "E", "E"
//        } ;

    }
}
