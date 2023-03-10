
public class DynamicArraysClasses {
    
    private int[] arr;
    private int nextIndex;

    public DynamicArraysClasses(){
        arr = new int[5];
        nextIndex = 0;
    }

    public void add(int element){
        if(nextIndex == arr.length){
            reconstruct();
        }
        arr[nextIndex] = element;
        nextIndex++;
    }

    public int size(){
        return nextIndex;
    }

    public void set(int index, int element){
        if(index > nextIndex){
            return;
        }
        if(index < nextIndex){
            arr[index] = element;
        }else{
            add(element);
        }
    }

    public int get(int index) {
        if(index >= nextIndex){
            return -1;
        }
        return arr[index];
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int removeLast(){
        if (size() == 0){
            return -1;
        }
        int val = arr[nextIndex - 1];
        arr[nextIndex - 1] = 0;
        nextIndex--;
        return val;
    }

    private void reconstruct(){
        int[] temp = arr;
        arr = new int[arr.length * 2];
        System.arraycopy(temp, 0, arr, 0, temp.length);
    }

    public void printArrays(){
        if (size() == 0){
            return;
        }
        for (int i = 0; i < nextIndex; i++) {
            if(i == 0){
                System.out.print("[");
            }
            if (i > 0) {
                System.out.print(", ");
            }

            System.out.print(arr[i]);

            if (i == nextIndex-1) {
                System.out.print("]");
            }
        }
        System.out.println();
    }
}
