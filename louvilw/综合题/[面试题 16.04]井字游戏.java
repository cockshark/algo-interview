//设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。 
//
// 以下是井字游戏的规则： 
//
// 
// 玩家轮流将字符放入空位（" "）中。 
// 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。 
// "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。 
// 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。 
// 当所有位置非空时，也算为游戏结束。 
// 如果游戏结束，玩家不允许再放置字符。 
// 
//
// 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 
//"Pending"。 
//
// 示例 1： 
//
// 输入： board = ["O X"," XO","X O"]
//输出： "X"
// 
//
// 示例 2： 
//
// 输入： board = ["OOX","XXO","OXO"]
//输出： "Draw"
//解释： 没有玩家获胜且不存在空位
// 
//
// 示例 3： 
//
// 输入： board = ["OOX","XXO","OX "]
//输出： "Pending"
//解释： 没有玩家获胜且仍存在空位
// 
//
// 提示： 
//
// 
// 1 <= board.length == board[i].length <= 100 
// 输入一定遵循井字棋规则 
// 
// Related Topics 数组 计数 矩阵 👍 34 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String tictactoe(String[] board) {
        //n*n的棋盘，再一次遍历中，对行列左右对角线进行求和
        //如果求和=n个x或者n个o即为获胜,否则则为平局或待定
        int N = board.length, bsize = board.length;
        int sum_row = 0, sum_col = 0, sum_dia_right = 0, sum_dia_left = 0;
        Boolean isFull = false;
        for (int i = 0; i < bsize; i++){
            //清零横竖的求和
            sum_row = 0;
            sum_col = 0;
            for (int j = 0; j < bsize; j++){
                sum_row += board[i].charAt(j); //行相加
                sum_col += board[j].charAt(i); //列相加
                if (board[i].charAt(j) == ' ') isFull = true; //既棋盘未满
            }
            sum_dia_left += board[i].charAt(i); //左对角线相加
            sum_dia_right += board[i].charAt(bsize-i-1); //右对角线相加
            //通过横竖左右来判断是否达到N个棋子胜利
            if (sum_col == ('X') * N || sum_row == ('X') * N) return "X";
            if (sum_col == ('O') * N || sum_row == ('O') * N) return "O";
            if (sum_dia_left == ('O') * N || sum_dia_right == ('O') * N) return "O";
            if (sum_dia_left == ('X') * N || sum_dia_right == ('X') * N) return "X";
        }
        if (isFull) return "Pending"; //如果还有空位，则为待定
        return "Draw"; //如果没有空位，则为打平
    }
}
//leetcode submit region end(Prohibit modification and deletion)
