### 剑指 Offer 53 - I. 在排序数组中查找数字 I

统计一个数字在**排序数组**中出现的次数。

输入: nums = [5,7,7,8,8,10], target = 8
输出: 2

输入: nums = [5,7,7,8,8,10], target = 6
输出: 0

题目考察应该是要 "二分法" 代码的（不过个人觉得完全没必要）

- 0 <= nums.length <= 105
- -109 <= nums[i] <= 109
- nums  是一个非递减数组
- -109 <= target <= 109

ps: 和这题一样：[34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/)

#### 方法一：collections.Counter

`return Counter(nums)[target]`

#### 方法二：迭代优化

数组有序是一个很好的优化信号（如果无序可以看另外的题）

```python
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        """
        数组是排序的，相同的元素一定是相邻的，可以直接进行循环统计，设置一个标志，命中了开始计数， 直到出现不同的值
        :param nums:
        :param target:
        :return:
        """
        flag = True
        count = 0
        for num in nums:
            if num == target:
                flag = False
                count += 1
            else:
                if flag is False:
                    return count

        return count
```

#### 方法三：考虑位运算

```python
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        i = 0
        j = len(nums)-1
        def helper(target,start,end):
            while start<=end:
                mid = end+start >>1
                if nums[mid] <= target:  #查找右边界
                    start = mid+1
                else:
                    end = mid -1
            return start
        return helper(target,i,j) - helper(target-1,i,j)

```

#### 方法四：面试官喜欢的二分法

```python
import bisect
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = bisect.bisect_left(nums, target)
        right = bisect.bisect_right(nums, target)
        return right - left
```

go 内置

```go
func search(nums []int, target int) int {
	return sort.SearchInts(nums, target+1) - sort.SearchInts(nums, target)
}

```

```python
class Solution:
    def search(self, nums: [int], target: int) -> int:
        # 搜索右边界 right
        i, j = 0, len(nums) - 1
        while i <= j:
            m = (i + j) // 2  # 其他语言考虑是否有边界溢出  改成 i+(j - i) // 2 或者 i+((j-i) >> 1)
            if nums[m] <= target:
                i = m + 1
            else:
                j = m - 1
        if i > 1 and nums[i - 1] != target:
            return 0

        right = i
        # 若数组中无 target ，则提前返回
        if j >= 0 and nums[j] != target:
            return 0
        # 搜索左边界 left
        i = 0
        while i <= j:
            m = (i + j) // 2
            if nums[m] < target:
                i = m + 1
            else:
                j = m - 1
        left = j
        return right - left - 1

```

```go
func search(nums []int, target int) int {
	l := helper(nums, 0, len(nums)-1, target)
	r := helper(nums, l, len(nums)-1, target+1)
	return r - l
}

func helper(nums []int, l, r, target int) int {
	for l <= r {
		// mid := (l + r) / 2
        mid := l + ((r - l) >> 1)
		if nums[mid] < target {
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	return l
}

```

```go
func search(nums []int, t int) int {
    N := len(nums)
    bisearch := func(cond func(int, int) bool) int{
        l, r := -1, N
        for l + 1 != r {
            mid := l + ((r - l) >> 1)
            if cond(m,t) { l = m } else { r = m }
        }
        return l
    }
    r := bisearch(func(m,t int) bool { return nums[m] <= t} )
    l := bisearch(func(m,t int) bool { return nums[m] < t} )
    return r - l
}
```

优化

```python
class Solution:
    def search(self, nums: [int], target: int) -> int:
        def helper(tar):
            i, j = 0, len(nums) - 1
            while i <= j:
                m = (i + j) // 2
                if nums[m] <= tar: i = m + 1
                else: j = m - 1
            return i
        return helper(target) - helper(target - 1)
```
