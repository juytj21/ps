import java.util.ArrayList;
import java.util.Scanner;

public class B_1158 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        System.out.print("<");
        int kk = 0;
        for (int i = 0; i < n; i++) {
            kk = (kk + k - 1) % list.size();
            if(i == n-1) {
                System.out.print(list.get(kk) + ">");
            } else {
                System.out.print(list.get(kk) + ", ");
            }
            list.remove(kk);
        }
    }
}
