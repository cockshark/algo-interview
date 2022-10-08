### 剑指 Offer 56 - II. 数组中数字出现的次数 II

在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

输入：nums = [3,4,3,3]
输出：4

输入：nums = [9,1,7,9,7,9,7]
输出：1

状态机没搞明白。。采用遍历的方法吧

1. 使用 与运算 ，可获取二进制数字 num 的最右一位 n1： n1 = num&i
2. 配合 无符号右移操作 ，可获取 num 所有位的值（即 n1 ~ n32）： num = num >>> 1

建立一个长度为 32 的数组 counts ，通过以上方法可记录所有数字的各二进制位的 11 的出现次数。

位运算：

- 相同的数异或等于 0
- 不同的数异或等于 1
- 0 和非零数异或等于它本身
  若 a&0001=1 ，则 aa 的第一位为 1；
  若 a&0010=1 ，则 aa 的第二位为 1 ；

```java
int[] counts = new int[32];
for(int i = 0; i < nums.length; i++) {
    for(int j = 0; j < 32; j++) {
        counts[j] += nums[i] & 1; // 更新第 j 位
        nums[i] >>>= 1; // 第 j 位 --> 第 j + 1 位
    }
}

```

将 counts 各元素对 33 求余，则结果为 “只出现一次的数字” 的各二进制位。

```java
for(int i = 0; i < 32; i++) {
    counts[i] %= 3; // 得到 只出现一次的数字 的第 (31 - i) 位
}

```

利用 **左移操作** 和 **或运算** ，可将 counts 数组中各二进位的值恢复到数字 res 上（循环区间是 i∈[0,31] ）。

```java
for(int i = 0; i < counts.length; i++) {
    res <<= 1; // 左移 1 位
    res |= counts[31 - i]; // 恢复第 i 位的值到 res
}

```

> 由于 Python 的存储负数的特殊性，需要先将 0 - 32 位取反（即 res ^ 0xffffffff ），再将所有位取反（即 ~ ）。
> 两个组合操作实质上是将数字 32 以上位取反， 0 - 32 位不变。

复杂度分析：

- 时间复杂度 O(N) ： 其中 N 位数组 nums 的长度；遍历数组占用 O(N) ，每轮中的常数个位运算操作占用 O(1) 。
- 空间复杂度 O(1) ： 数组 counts 长度恒为 32 ，占用常数大小的额外空间。

实际上，只需要修改求余数值 m ，即可实现解决 除了一个数字以外，其余数字都出现 m 次 的通用问题。

```python
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        counts = [0] * 32
        for num in nums:
            for j in range(32):
                counts[j] += num & 1
                num >>= 1
        res, m = 0, 3
        for i in range(32):
            res <<= 1
            res |= counts[31 - i] % m
        return res if counts[31] % m == 0 else ~(res ^ 0xffffffff)


```

go 版本

```go
func singleNumber(nums []int) int {
	res := 0
	for i := 0; i < 32; i++ {
		bit := 0     //记录该位上的和
		for _, num := range nums {
			bit += ((num >> i) & 1)
		}
		res += ((bit % 3) << i)
	}
	return res
}
```

python 简化

```python

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        res = 0
        for i in range(31):
            bit = 0
            for num in nums:
                bit +=((num>>i) & 1)  # 每位上的1 的和
            else：
                res += ((bit%3) << i) # 每位上都先对3 求余数

        return res


```
