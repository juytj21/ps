import java.util.ArrayList;
import java.util.Scanner;

public class B_9012 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        String VPS [] = new String[T];
        for (int i = 0; i < T; i++) {
            VPS[i] = s.next();
        }

        for (int i = 0; i < T; i++) {
            boolean Y_N = true;
            String [] yn = VPS[i].split("");
            ArrayList <String> list = new ArrayList<String>();
            for (int j = 0; j < yn.length; j++) {
                if(yn[j].equals("(")) {
                    list.add("(");
                } else {
                    if(list.isEmpty()) {
                        Y_N = false;
                        break;
                    } else {
                        list.remove("(");
                    }
                }
            }
            if(!list.isEmpty()) {Y_N = false;}
            if(Y_N) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
