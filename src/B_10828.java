import java.util.ArrayList;
import java.util.Scanner;

public class B_10828 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String [] m = new String[n];
        int [] m_int = new int[n];
        for (int i = 0; i < n; i++) {
            m[i] = s.next();
            if(m[i].equals("push")) {
                m_int[i] = s.nextInt();
            }
        }

        ArrayList<Integer> stack = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (m[i].equals("push")) {
                stack.add(m_int[i]);
            } else if(m[i].equals("pop")) {
                if(stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.remove(stack.size() - 1));
                }
            } else if(m[i].equals("size")) {
                System.out.println(stack.size());
            } else if(m[i].equals("empty")) {
                if(stack.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if(m[i].equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.get(stack.size() - 1));
                }
            }
        }
    }
}
