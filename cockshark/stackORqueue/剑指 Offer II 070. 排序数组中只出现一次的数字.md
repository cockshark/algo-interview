### 剑指 Offer II 070. 排序数组中只出现一次的数字

给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。

你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。

输入: nums = [1,1,2,3,3,4,4,8,8]
输出: 2

输入: nums = [3,3,7,7,10,11,11]
输出: 10

- 1 <= nums.length <= 105
- 0 <= nums[i] <= 105

如果熟悉位运算：直接使用异或即可解决

```python
class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        res = 0
        for num in nums:
            res ^= num

        return res

```

go 版本

```go

func singleNonDuplicate(nums []int) int {
    res := 0
    for _,num := range nums {
        res ^= num
    }

    return res
}

```
