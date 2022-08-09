class TripleInOne {
    private int[] arr;
    private int[] size;
    private int stackSize;
    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        arr = new int[3*stackSize];
        size = new int[]{0,0,0};
    }
    
    public void push(int stackNum, int value) {
        int length = size[stackNum];
        if (length< stackSize){
            arr[stackNum*stackSize+length] = value;
            size[stackNum] = length + 1;
        }
    }
    
    public int pop(int stackNum) {
        int topVal = peek(stackNum);
        if (size[stackNum] > 0) size[stackNum] -= 1;
        return topVal;
    }
    
    public int peek(int stackNum) {
        if (size[stackNum] == 0) return -1;
        return arr[stackNum*stackSize+size[stackNum]-1];
    }
    
    public boolean isEmpty(int stackNum) {
        if (size[stackNum] == 0) return true;
        return false;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */

//runtime:8 ms
//memory:50.8 MB
