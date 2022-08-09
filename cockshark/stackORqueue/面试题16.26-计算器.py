class Solution:
    def calculate(self, s: str) -> int:
        """
        直接举例分析：  1 + 2*3 - 12//3
         假设我们 只做  加减法， 把 1  +2*3  -12//3  分别作为三个整体。 最近进行累加即可完成答案
        """
        # 为了方便  在最前面 添加一个 + 号  统一格式  (理解为添加哨兵)
        sign = "+"
        s = s + sign
        # num1 表示遍历到某个 ”整体“ 之前的和
        # num2 表示当前“整体”， 因为当前整体，也是需要通过计算的
        # num  表示当前的值，必须是连续的~
        num1, num2, num = 0, 0, 0
        for char in s:  # 逐步遍历
            if char.isdigit():  # 如果是数字， 需要转化成一个 完整的数字
                num = num * 10 + int(char)
            else:  # 一个完整的数字扫描完，就是符号了，符号需要挨个处理就可以
                # 先处理  + 或者 -
                if sign in ("+", "-"):
                    num1 += num2  # 先保存之前的“整体之和”
                    num2 = num if sign == "+" else -num
                elif sign == "*":  # 处理 乘法 *， 则需要和当前整体 num2 进行相乘  num
                    num2 *= num
                else:  # 剩下除法

                    num2 = int(num2/num)
                sign = char
                num = 0

        return num1 + num2


if __name__ == '__main__':
    print(Solution().calculate("14-3/2"))
