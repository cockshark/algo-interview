//字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 
//输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 双指针 字符串 👍 215 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean oneEditAway(String first, String second) {
        int length1 = first.length(), length2 = second.length();
        int index1 = 0, index2 = 0, count = 0;
        if ((length1 - length2) > 1 || (length1 - length2) < -1) return false;
        if (length1 == length2){
            for (int i = 0; i < length1; i++){
                if (first.charAt(i) != (second.charAt(i))) count++;
                if (count > 1) return false;
            }
        }
        else if (length1 > length2){
            while (index1 < length1 && index2 < length2 ){
                if (first.charAt(index1) != (second.charAt(index2))) index1++;
                else {index1++;index2++;}
                if (index1 - index2 > 1) return false;
            }
        }else if (length1 < length2){
            while (index1 < length1 && index2 < length2) {
                if (first.charAt(index1) != (second.charAt(index2))) index2++;
                else {index1++;index2++;}
                if (index2 - index1 > 1) return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
