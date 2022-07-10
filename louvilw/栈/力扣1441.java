class Solution {
    public List<String> buildArray(int[] target, int n) {
        /*
        题目意思是指:数组里面的数是从1开始到n，所以i<=n，然后数组索引是从0开始，所以index<target.length
        并且先把数放进栈里面，也就是先放进"Push"
        如果数组索引步数不等于下标的话就放进"Pop"把数以示弹出来，数组索引依然往前走
        循环次数为n次，后面无论是否还有数都停止
        */
         List<String> res = new ArrayList<>();
         int index = 0;
         for (int i = 1;i <= n && index < target.length; i++){
             //先把数放进去
             res.add("Push");
             //如果不相等，就把数Pop出来
             if(i != target[index]){
                 res.add("Pop");
             }else{
                 index++;
             }
         }
         return res;
    }
}