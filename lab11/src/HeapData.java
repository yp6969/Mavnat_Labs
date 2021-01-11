public class HeapData {

    public static int MIN_NUM = Integer.MIN_VALUE;

    int preority;

    public HeapData(){
        this(MIN_NUM);
    }

    public HeapData(int preority){
        this.preority = preority;
    }

    public int getPreority() {
        return preority;
    }

    public void setPreority(int preority) {
        this.preority = preority;
    }
}
