import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by alexander on 06.12.14.
 */
class Main {
    /**
     * Created by alexander on 06.12.14.
     */
    public static class HeapList<T extends Comparable<T>> {
        //    private int[] heap;
        private ArrayList<T> heap;
        private int size;

        HeapList() {
            this(0);
        }

        HeapList(int n) {
            heap = new ArrayList<>(n);
            size = 0;
        }

        public void insert(T elem) {
            heap.add(size, elem);
            siftUp(size++);
        }

        public void remove(int pos) {

        }

        public T getMin() {
            return heap.get(0);
        }

        public T extractMax() {
            if (size == 0) throw new ArrayIndexOutOfBoundsException("the array is already empty");
            T head = heap.get(0);
            heap.set(0, heap.get(--size));
            siftDown(0);
            return head;
        }

        public void changePriority() {
        }

        private void siftUp(int pos) {
            if (pos == 0) return;
            if (heap.get(pos).compareTo(heap.get(pos / 2)) > 0) {
                swap(pos, pos / 2);
                siftUp(pos / 2);
            }
        }

        private void siftDown(int pos) {
            if (2 * pos >= size) return;
            int maxI = getMaxInd(2 * pos, 2 * pos + 1);
            if (heap.get(maxI).compareTo(heap.get(pos)) > 0) {
                swap(pos, maxI);
                siftDown(maxI);
            }
        }

        private int getMinInd(int pos1, int pos2) {
            return heap.get(pos1).compareTo(heap.get(pos2)) >= 0 ? pos2 : pos1;
        }

        private int getMaxInd(int pos1, int pos2) {
            if (Math.min(pos1, pos2) >= size)
                throw new ArrayIndexOutOfBoundsException(String.format(
                        "Invalid data: %d, %d", pos1, pos2));
            if (Math.max(pos1, pos2) >= size) return Math.min(pos1, pos2);
            return heap.get(pos1).compareTo(heap.get(pos2)) > 0 ? pos1 : pos2;
        }

        private void swap(int pos1, int pos2) {
            T tmp = heap.get(pos1);
            heap.set(pos1, heap.get(pos2));
            heap.set(pos2, tmp);
        }

    }

    private static class Scanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public Scanner(Reader reader) {
            this.reader = new BufferedReader(reader);
            this.tokenizer = new StringTokenizer("");
        }

        public boolean hasNext() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                String line = reader.readLine();
                if (line == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(line);
            }
            return true;
        }

        public String next() throws IOException {
            hasNext();
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        private long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            tokenizer = new StringTokenizer("");
            return reader.readLine();
        }

        public int[] nextInts(int n) throws IOException {
            int[] res = new int[n];
            for (int i = 0; i < n; ++i) {
                res[i] = nextInt();
            }
            return res;
        }

        public long[] nextLongs(int n) throws IOException {
            long[] res = new long[n];
            for (int i = 0; i < n; ++i) {
                res[i] = nextLong();
            }
            return res;
        }

        public double[] nextDoubles(int n) throws IOException {
            double[] res = new double[n];
            for (int i = 0; i < n; ++i) {
                res[i] = nextDouble();
            }
            return res;
        }

        public String[] nextStrings(int n) throws IOException {
            String[] res = new String[n];
            for (int i = 0; i < n; ++i) {
                res[i] = next();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int n = 0;
        Scanner in = new Scanner(new InputStreamReader(System.in));
        try {
            n = in.nextInt();
            HeapList<Integer> heap = new HeapList<>(n);
            for (int i = 0; i < n; i++) {
                String cmd = in.next();
                if ("Insert".equals(cmd)) {
                    heap.insert(in.nextInt());
                } else {
                    System.out.println(heap.extractMax());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    private static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//    private static Scanner in = new Scanner(new InputStreamReader(System.in));

}
