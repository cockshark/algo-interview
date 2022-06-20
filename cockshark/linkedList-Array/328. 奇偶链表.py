# Definition for singly-linked list.
from typing import Optional, Tuple

"""
    给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。

第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。

请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。

你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。

    """


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        """ 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题
        输入: head = [1,2,3,4,5]
        输出: [1,3,5,2,4]
        读题可以知道，只需要重新编排奇数和偶数的位置即可
        启动一个新的节点，用于接受奇数和偶数的节点编排

        原来的链表用双指针进行遍历，一个取奇数位置，一个取偶数位置，
        最后偶数的链表接到奇数的链表后面即可

        总结的：
        1. 申请两个结点作为奇链表，偶链表的dummy结点
        2. 遍历链表分别将奇偶结点接在刚刚申请的奇偶链表上
        3. 将偶链表接在奇链表末尾，完成~

        Args:
            head (Optional[ListNode]): _description_

        Returns:
            Optional[ListNode]: _description_
        """
        dum1, dum2 = ListNode(), ListNode()  # 利用虚拟节点，减去头节点的操作难度
        d1, d2 = dum1, dum2  # d1 奇  d2 偶
        cur = head
        # 遍历拼接
        while cur:
            d1.next = cur  # 拼接奇数位置
            cur = cur.next
            d1 = d1.next
            if cur:  # 防止奇数位置之后已经遍历完
                d2.next = cur
                d2 = d2.next
                cur = cur.next

        d2.next = None  # 偶数位置接在末尾
        # 拼接奇偶链表
        d1.next = dum2.next

        return head

    def oddEvenList_doubleStep(self, head: Optional[ListNode]) -> Optional[ListNode]:
        """
        直接跳两次，思路类似于分奇偶链表进行迭代
        一个从第一位 跳  偶数从第二位开始跳,每个节点只需要连接到下两个节点即可，
        最后将奇偶连接起来即可

        Args:
            head (Optional[ListNode]): _description_

        Returns:
            Optional[ListNode]: _description_
        """
        if head is None:
            return head
        odd = head
        even = head.next
        odd_p = odd
        even_p = even
        while even_p and even_p.next:
            odd_p.next = odd_p.next.next
            even_p.next = even_p.next.next

            odd_p = odd_p.next
            even_p = even_p.next
        # 连接奇偶链表
        odd_p.next = even

        return odd

    def oddEvenList_recursion(self, head: Optional[ListNode]) -> Optional[ListNode]:
        """
        由上面的直接迭代方法可知，每次的子操作都是一致的，因此符合递归的规律。

        每次都需要返回：
            1. 奇数节点的尾，奇数节点的尾巴用于拼接偶数节点头
            2. 偶数节点头
            3. 偶数节点尾
        """
        # 只有一个或者空链表，可直接返回
        if head is None or head.next is None:
            return head

        def dfs(head: Optional[ListNode]) -> Tuple[ListNode, ListNode, Optional[ListNode]]:
            if head.next is None:
                return head, head, None

            oddNode = head  # 奇
            evenNode = head.next  # 偶

            if head.next.next is None:
                return oddNode, oddNode, evenNode

            odd_head, odd_tail, even_head = dfs(evenNode.next)
            oddNode.next = odd_head  # 连接奇数系欸但
            evenNode.next = even_head  # 连接偶数节点

            return oddNode, odd_tail, evenNode

        # 整体拼接
        odd_head, odd_tail, even_head = dfs(head)
        odd_tail.next = even_head

        return odd_head
