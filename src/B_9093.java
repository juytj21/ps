import java.util.Scanner;

public class B_9093 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();

        String [] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = s.nextLine();
        }

        for (int i = 0; i < n; i++) {
            String[] words = str[i].split(" ");
            for (int j = 0; j < words.length; j++) {
                StringBuilder sb = new StringBuilder(words[j]);
                System.out.print(sb.reverse().toString());

                if (j != words.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
