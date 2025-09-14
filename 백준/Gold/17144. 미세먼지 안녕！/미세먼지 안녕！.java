import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int[][] air = new int[2][2];
    static int[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        A = new int[R][C];
        boolean top = true;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if(A[i][j] == -1) {
                    if (top) {
                        air[0][0] = i;
                        air[0][1] = j;
                        top = false;
                    } else {
                        air[1][0] = i;
                        air[1][1] = j;
                    }
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spread();
            cycle();
        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] != -1) {
                    sum += A[i][j];
                }
            }
        }

        System.out.println(sum);

    }

    static void spread() {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] <= 0) continue;
                int x = A[i][j];
                int n = 0;
                boolean top = false, bottom = false, left = false, right = false;
                if (i-1 >= 0 && A[i-1][j] != -1) {
                    n++;
                    top = true;
                }
                if (i+1 < R && A[i+1][j] != -1) {
                    n++;
                    bottom = true;
                }
                if (j-1 >= 0 && A[i][j-1] != -1) {
                    n++;
                    left = true;
                }
                if (j+1 < C && A[i][j+1] != -1) {
                    n++;
                    right = true;
                }

                int k = x - ((x/5) * n);
                list.add(new int[]{i, j, k});
                if (top) list.add(new int[]{i-1, j, x/5});
                if (bottom) list.add(new int[]{i+1, j, x/5});
                if (left) list.add(new int[]{i, j-1, x/5});
                if (right) list.add(new int[]{i, j+1, x/5});
            }
        }

        int[][] B = new int[R][C];
        int len = list.size();
        for (int x = 0; x < len; x++) {
            int[] arr = list.get(x);
            int i = arr[0];
            int j = arr[1];
            int k = arr[2];
            B[i][j] += k;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] != -1) {
                    A[i][j] = B[i][j];
                }
            }
        }
    }

    static void cycle() {
        int top_x = air[0][0];
        int bot_x = air[1][0];
        int[][] B = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                B[i][j] = A[i][j];
            }
        }
        for (int i = 0; i <= top_x; i++) {
            if (i == 0) {
                for (int j = 0; j < C-1; j++) {
                    B[i][j] = A[i][j+1];
                }
                B[i][C-1] = A[i+1][C-1];
            } else if (i < top_x) {
                B[i][0] = A[i-1][0];
                B[i][C-1] = A[i+1][C-1];
            } else {
                if (A[i][0] != -1) {
                    B[i][0] = A[i-1][0];
                } else {
                    B[i][0] = -1;
                }

                for (int j = 1; j < C; j++) {
                    if (A[i][j-1] != -1) {
                        B[i][j] = A[i][j-1];
                    } else {
                        B[i][j] = 0;
                    }
                }
            }
        }

        for (int i = bot_x; i < R; i++) {
            if (i == bot_x) {
                for (int j = 1; j < C; j++) {
                    if (A[i][j-1] == -1) {
                        B[i][j] = 0;
                    } else if (A[i][j-1] != -1) {
                        B[i][j] = A[i][j-1];
                    }
                }
                if (A[i][0] != -1) {
                    B[i][0] = A[i+1][0];
                }
            } else if (i < R-1) {
                B[i][0] = A[i+1][0];
                B[i][C-1] = A[i-1][C-1];
            } else {
                for (int j = 0; j < C-1; j++) {
                    B[i][j] = A[i][j+1];
                }
                B[i][C-1] = A[i-1][C-1];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                A[i][j] = B[i][j];
            }
        }

    }

}
