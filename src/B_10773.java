import java.util.Scanner;

public class B_10773 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();

        int [] num = new int[k];

        for (int i = 0; i < k; i++) {
            num[i] = s.nextInt();
        }

        int sum = 0;
        int [] list = new int[k];
        int c = 0;

        for (int i = 0; i < k; i++) {
            if (num[i] != 0) {
                sum += num[i];
                list[c] = num[i];
                c++;
            } else if (num[i] == 0) {
                c--;
                sum -= list[c];
            }
        }

        System.out.println(sum);
    }
}
