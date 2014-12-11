package util.io;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by alexander on 06.12.14.
 */
public class Main{

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
    }

    private Scanner in = new Scanner(new InputStreamReader(System.in));
    private PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
}