### 剑指 Offer 53 - II. 0 ～ n-1 中缺失的数字

一个长度为 n-1 的**递增排序数组**中的所有数字都是**唯一**的，并且每个数字都在范围**0 ～ n-1**之内。在范围 0 ～ n-1 内的 n 个数字中有且只有一个数字不在该数组中，请找出这个数字。

输入: [0,1,3]
输出: 2

输入: [0,1,2,3,4,5,6,7,9]
输出: 8

限制
1 <= 数组长度 <= 10000

按照感觉，这种题应该还是**二分法**的考点

#### 方法一：迭代遍历

需要遍历数组，时间复杂度 O(N)

```python
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        """
            数组有序，且递增，且数据一定在 0 - n-1 之内，如果缺失中间的数据，大部分数据肯定是有一个萝卜一个坑
            排除首尾元素缺失的情况即可

        """
        if nums[0] == 1:  # 说明缺失的是 第一个
            return 0
        l = len(nums)

        for i in range(l):
            if nums[i] != i:
                return i  # 第一个就确认缺失的是 索引等于元素的下标
        else:
            return l  # 否则就是缺失最后一个元素 ？ 这里其实跟题目描述不一致，说了在 0 - n-1范围内。。最后一个应该一定不会缺失的
```

`go`版本
不需要遍历数组，时间复杂度 O(logN)

```go
func missingNumber(nums []int) int {
    l := len(nums)
    if nums[0] == 1 {
        return 0
    }
    for i:=0;i<l;i++{
        if nums[i] == i {
            return i
        }
    }
    return l
}

```

#### 方法一：二分法

```python
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        """ 只要出现错位，那后续的元素全部都会错位"""
        start, end = 0, len(nums) - 1
        while start <= end:
            print(start, end)
            mid = (end + start) >> 1
            print("mid:", mid)
            print(f"nums[mid] == mid :{nums[mid] == mid}")
            if nums[mid] == mid:
                start = mid + 1
            else:
                end = mid - 1

        return start

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        i, j = 0, len(nums) - 1
        while i <= j:
            m = (i + j) // 2
            if nums[m] == m:
                i = m + 1
            else:
                j = m - 1
        return i

```

go 版本

```go
func missingNumber(nums []int) int {
    start := 0
    end := len(nums) - 1
    for start <= end {
        mid = (end + start) >> 1
        if nums[mid] == mid {
            start = mid + 1
        }else {
            end = mid - 1
        }
    }
    return start

}
```
