### 剑指 Offer II 036. 后缀表达式

**和逆波兰表达式是同一题**

根据 逆波兰表示法，求该后缀表达式的计算结果。

有效的算符包括 +、-、\*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

- 整数除法只保留整数部分。
- 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

输入：tokens = ["2","1","+","3","*"]
输出：9
解释：该算式转化为常见的中缀算术表达式为：((2 + 1) \* 3) = 9

输入：tokens = ["4","13","5","/","+"]
输出：6
解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6

输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
输出：22
解释：
该算式转化为常见的中缀算术表达式为：
((10 _ (6 / ((9 + 3) _ -11))) + 17) + 5
= ((10 _ (6 / (12 _ -11))) + 17) + 5
= ((10 _ (6 / -132)) + 17) + 5
= ((10 _ 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

1 <= tokens.length <= 104
tokens[i] 要么是一个算符（"+"、"-"、"\*" 或 "/"），要么是一个在范围 [-200, 200] 内的整数、

python 版本

```python
class Solution:
    def _isnumber(self, target: str) -> bool:
        if target.isdigit() or re.match(r"^[+|-]\d+$", target):
            return True
        return False

    def evalRPN(self, tokens: List[str]) -> int:
        """
        遇到符号则取出两个数字进行计算即可
        :param tokens:
        :return:
        """
        nums = []  # 用来存储数字
        for char in tokens:
            if self._isnumber(char):  # 处理数字
                nums.append(int(char))
            else:  # 处理符号
                second = nums.pop()
                first = nums.pop()
                if char == "+":
                    result = first + second
                elif char == "-":
                    result = first - second
                elif char == "*":
                    result = first * second
                else:
                    result = int(first / second)

                nums.append(result)

        return nums.pop()

```
