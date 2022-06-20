# Definition for singly-linked list.
from operator import le
import statistics

import fastapi
from pip import main


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def isPalindrome_recursion(self, head: ListNode) -> bool:
        """单向链表，天生具有递归性， 但是这题需要处理每次递归返回比较值的细节
        实际上考察了对递归的理解深度，在系统栈逐层返回值

        我们每次把需要对比的值传递到递归的函数里去进行比较

        时间复杂度 n
        空间复杂度 n  因为需要使用到系统栈

        Args:
            head (ListNode): _description_

        Returns:
            bool: _description_
        """
        self.left = head  # 用来传递需要比较的值

        def recursion(node):
            # 边界 条件
            if node is None:
                return True
            new = recursion(node.next)
            if new.val != self.left.val:
                return False
            self.left = self.left.next

            return new

        return recursion(head)

    def isPalindrome_iteration(self, head: ListNode) -> bool:
        """
        可以进行递归比较简单，但迭代就稍微复杂
        总体思路，将后半部分节点进行逆序，然后比较前后两部分是否相等，整体难度不大
        1. 找到中点
        2. 将中点之后的链表进行反转
        3. 遍历前，后，两部分链表，依次比较值是否相等
        4. 还原链表（是否可以省略则这一步？）

        时间复杂度仍旧是 n
        空间复杂度 为 1  由于没有增加额外的空间，在原来的链表上进行操作，in-place
        Args:
            head (ListNode): _description_

        Returns:
            bool: _description_
        """
        # 1. 找到中点
        midNode = self._findMidNode(head)

        # 2. 将中点之后的链表进行反转
        secondLink = self._reverseLinkList(head.next)

        # 比较前后两个链表是否相等
        start = head
        cur = secondLink
        while cur is not None:
            if cur.val != start.val:
                return False
            cur = cur.next
            start = start.next

        return True

    @staticmethod
    def _findMidNode(head: ListNode) -> ListNode:
        slow = head
        fast = head
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next

        return slow

    @staticmethod
    def _reverseLinkList(head: ListNode) -> ListNode:
        pre = None
        cur = head

        while cur is not None:
            cur.next, pre, cur = pre, cur, cur.next

        return pre

    def isPalindrome_hash(self, head: ListNode) -> bool:
        """
        属于数学解法
        12321    类似于回文对称， 我们往left的右边插入值， 往right的左边插入值
        left    right
        1           1
        12         21
        123       321
        ...       ...   但是可以乘以倍数， 如果是回文数，left和right左右最终会相等

        """
        left = right = 0
        mod = 100000007  # 根据base和mul  取适当的，避免溢出
        base = 11  # 可以是任意值
        mul = 1

        while head is not None:
            left = (left * base + head.val) % mod
            right = (right + head.val * mul) % mod
            mul = mul * base % mod

        return left == right
