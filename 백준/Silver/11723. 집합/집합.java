import java.io.*;

public class Main {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            int num = 0;
            while (c > ' ') {
                num = num * 10 + (c - '0');
                c = read();
            }
            return num;
        }

        int nextCommand() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            if (c == 'a') { // add or all
                int c2 = read(); // 'd' or 'l'

                if (c2 == 'd') { // add
                    while ((c = read()) != ' ') { }
                    return 1;
                } else { // all
                    while ((c = read()) > ' ') { }
                    return 5;
                }
            } else if (c == 'r') { // remove
                while ((c = read()) != ' ') { }
                return 2;
            } else if (c == 'c') { // check
                while ((c = read()) != ' ') { }
                return 3;
            } else if (c == 't') { // toggle
                while ((c = read()) != ' ') { }
                return 4;
            } else { // empty
                while ((c = read()) > ' ') { }
                return 6;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = fs.nextInt();

        int mask = 0;
        final int FULL = (1 << 21) - 2;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int cmd = fs.nextCommand();

            switch (cmd) {
                case 1: { // add
                    int x = fs.nextInt();
                    mask |= (1 << x);
                    break;
                }
                case 2: { // remove
                    int x = fs.nextInt();
                    mask &= ~(1 << x);
                    break;
                }
                case 3: { // check
                    int x = fs.nextInt();
                    if ((mask & (1 << x)) != 0) {
                        sb.append('1').append('\n');
                    } else {
                        sb.append('0').append('\n');
                    }

                    if (sb.length() >= 1 << 15) {
                        bw.write(sb.toString());
                        sb.setLength(0);
                    }
                    break;
                }
                case 4: { // toggle
                    int x = fs.nextInt();
                    mask ^= (1 << x);
                    break;
                }
                case 5: // all
                    mask = FULL;
                    break;
                case 6: // empty
                    mask = 0;
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}