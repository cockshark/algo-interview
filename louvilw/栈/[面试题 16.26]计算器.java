//给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。 
//
// 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 数学 字符串 👍 76 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    遇到‘+’、‘-’时候直接入栈（‘-’时候要是负数）
    遇到‘*’、‘/‘优先级高的出栈一个数运算在加入栈；
    最后栈中剩下的全部相加即可
     */
    public int calculate(String s) {
        //去除空格
        s = s.replaceAll(" ","");
        Deque<Integer> q = new ArrayDeque<>();
        //开始默认是+法
        char flag = '+';
        int num = 0;
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                //拼接数字
                num = num*10 + (s.charAt(i) - '0');
            }
            //i == s.length()-1要把最后一个数字也压进栈里
            if(!Character.isDigit(s.charAt(i)) || i == s.length()-1){
                switch(flag){
                    case '+':
                        q.push(num);
                        break;
                    case '-':
                        q.push(-num);
                        break;
                    case '*':
                        q.push(q.pop()*num);
                        break;
                    case '/':
                        q.push(q.pop()/num);
                        break;
                }
                flag = s.charAt(i);
                num = 0;
            }
        }
        //把所有数加起来即可
        while(!q.isEmpty()){
            num += q.pop();
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
