package aigo.com.yz;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<String>();
        // 读题：给定一个数组，我们要从 1 遍历到 n ，通过push 或者 pop 操作，构造出和数组一样的数据元素
        // 从 1 到 n 遍历，是从1 开始的，但目标数组的下标是从 0 开始的，所以我们要分别两个指针
        // 当从 1 到 n 遍历,并且 index 下标 小于 最后一个数组元素
        // 什么时候才算？数组下标移动？当真正完成了一个目标数组元素的时候
        for(int i =1,index = 0; i<= n && index < target.length ;i++){
            if(i == target[index]){
                result.add("Push");
                index++;
            }else{
                // 不属于数组元素
                result.add("Push");
                result.add("Pop");
            }
        }
        return result;
    }
}