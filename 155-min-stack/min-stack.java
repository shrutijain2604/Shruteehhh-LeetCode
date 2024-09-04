class MinStack {
    private ArrayList<Integer> list;
    private ArrayList<Integer> minList;
    private int size;
    
    public MinStack() {
        list = new ArrayList<>();
        minList = new ArrayList<>();
        size = 0;
    }
    
    public void push(int val) {
        list.add(val);
        if (size == 0) {
            minList.add(val);
        } else {
            minList.add(Math.min(val, minList.get(size - 1)));
        }
        size++;
    }
    
    public void pop() {
        if (size > 0) {
            list.remove(size - 1);
            minList.remove(size - 1);
            size--;
        }
    }
    
    public int top() {
        if (size > 0) {
            return list.get(size - 1);
        }
        return -1; 
    }
    
    public int getMin() {
        if (size > 0) {
            return minList.get(size - 1);
        }
        return -1; 
    }
}
