### 剑指 Offer 31. 栈的压入、弹出序列

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
输出：false
解释：1 不能在 2 之前弹出。

做这种题：隐隐感觉总是有某个规律的..但就是想不起来

#### 方法一：还原二叉树思路

```markdown
这里有一个事实 那就是一组合法的入栈序列和出栈序列对应着一个二叉树的前序和中序 （应该是来源于 2000 多年浙大的一道考研真题） 即**入栈序列对应一个二叉树的前序遍历**
即**出栈序列对应一个二叉树的中序遍历**
（可以自己按照案列那个合法的例子按照二叉树的前中序还原一下就可以理解一些）
现在判断**是否为合法的出入栈序列**就可以转换为**判断给一个树的前序和中序，判断这棵树能否还原为一个二叉树**

如果能够还原那么就是合法的 如果不能那么就是非法的
```

参考 cpp 的做法

```cpp
class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        function<bool(int,int,int)> valid =
        [&](int left,int right,int rootPos){
            if(left > right) return true;
            int rootVal = pushed[rootPos];
            int pos = -1;
            for(int i = left; i <= right; ++i){
                if(popped[i] == rootVal){
                    pos = i;
                    break;
                }
            }
            if(pos == -1) return false;
            return
                valid(left,pos - 1,rootPos + 1) &&
                valid(pos + 1,right,rootPos + pos - left + 1);
        };
        return valid(0,pushed.size() - 1,0);
    }
};
```

java 版本的：

```java
class Solution {
    // 保存中序节点值 -> 下标映射关系
    Map<Integer, Integer> map = new HashMap<>();
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        for (int i = 0; i < popped.length; i++) {
            map.put(popped[i], i);
        }
        return isValidTree(pushed, 0, pushed.length - 1, popped, 0, popped.length - 1);
    }

    // pushed 作为前序序列，popped 作为中序序列是否可以构成二叉树
    private boolean isValidTree(int[] pushed, int pushl, int pushr, int[] popped, int popl, int popr) {
        // 空树，返回 true
        if (pushl > pushr || popl > popr) {
            return true;
        }

        // 根节点
        int root = pushed[pushl];
        // 找到根节点值在中序序列下标
        int idx = map.get(root);
        // 若下标不在中序序列区间，则无法构成二叉树，返回 false
        if (idx < popl || idx > popr) {
            return false;
        }

        // 左子树有效 && 右子树有效
        return isValidTree(pushed, pushl + 1, pushl + idx - popl, popped, popl, idx - 1) && isValidTree(pushed, pushl + idx - popl + 1, pushr, popped, idx + 1, popr);
    }
}


```

```python
class Solution:
    indexMap = {}

    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        """
        现在判断**是否为合法的出入栈序列**就可以转换为**判断给一个树的前序和中序，判断这棵树能否还原为一个二叉树**
        如果能够还原那么就是合法的 如果不能那么就是非法的

        :param pushed:
        :param popped:
        :return:
        """
        for idx, node in enumerate(popped):
            self.indexMap[popped[idx]] = idx

        return self._isValidTree(pushed, 0, len(pushed) - 1, popped, 0, len(popped) - 1)

    def _isValidTree(self, pushed: List[int], pushl: int, pushr: int, poped: List[int], popl: int, popr: int) -> bool:
        """
        递归判断是可还原一棵二叉树
        pushed 作为前序序列，popped 作为中序序列是否可以构成二叉树
        :param pushed:
        :param pushl:
        :param pushr:
        :param poped:
        :param popl:
        :param popr:
        :return:
        """
        # tree  是 空的
        if pushl > pushr or popl > popr:
            return True

        # 根节点
        root = pushed[pushl]
        # 找到根节点值在中序序列下标
        idx = self.indexMap.get(root)
        # 如果下标不在中序列的区间， 表示无法构成二叉树
        if idx < popl or idx > popr:
            return False
        #  左子树有效 && 右子树有效
        return self._isValidTree(pushed, pushl + 1, pushl + idx - popl, poped, popl, idx - 1) and self._isValidTree(
            pushed, pushl + idx - popl + 1, pushr, poped, idx + 1, popr)
```

#### 方法二：辅助栈

push:1 ,2 ,3 ,4 ,5
pop :4 ,5 ,3 ,2 ,1

题目就是和栈的性质有关系，所以我们按照 push 进行压栈，然后和 pop 做比较，挨个进行就可以

```python
class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        stack = []
        i = 0
        for num in pushed:
            stack.append(num)
            while stack and stack[-1] == popped[i]:  # 本来应该是栈底元素
                # 符合pop序列值
                stack.pop()
                i += 1

        return len(stack) == 0

```

补充题目： [105. 从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

[从前序与中序遍历序列构造二叉树](../二叉树/105.%20从前序与中序遍历序列构造二叉树.md)
