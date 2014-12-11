package stepic.algosAndStructs.Structs.heaps;

/**
 * Created by alexander on 07.12.14.
 */
public class HeapArr {
    private int[] heap;
    private int size;

    private void siftUp(int pos) {
        if (pos == 0)
            return;
        else if (heap[pos] > heap[pos / 2]) {
            swap(pos, pos / 2);
            siftUp(pos / 2);
        }

    }

    private void siftDown(int pos) {
        if (2 * pos >= size)
            return;
        else {
            int maxIndex = getMaxInd(2 * pos, 2 * pos + 1);
            if (heap[maxIndex] > heap[pos]) {
                swap(maxIndex, pos);
                siftDown(maxIndex);
            }
        }
    }

    private void swap(int pos1, int pos2) {
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    private int getMinInd(int pos1, int pos2) {
        return heap[pos1] <= heap[pos2] ? pos1 : pos2;
    }

    private int getMaxInd(int pos1, int pos2) {
        if (Math.min(pos1, pos2) >= size)
            throw new ArrayIndexOutOfBoundsException(String.format(
                    "Invalid data: %d, %d", pos1, pos2));
        if (Math.max(pos1, pos2) >= size)
            return Math.min(pos1, pos2);
        return heap[pos1] < heap[pos2] ? pos2 : pos1;
    }

    public int size(){
        return size;
    }

    public void insert(int p) {
        heap[size] = p;
        siftUp(size++);
    }

    public int extract() {
        if (size == 0) throw new ArrayIndexOutOfBoundsException("the array is already empty");
        int max = heap[0];
        heap[0] = heap[size-- - 1];
        siftDown(0);
        return max;
    }

    public HeapArr(int size) {
        heap = new int[size];
        this.size = 0;
    }

}
