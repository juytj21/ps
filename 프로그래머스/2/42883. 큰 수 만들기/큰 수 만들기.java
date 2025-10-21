public class Solution {
    public String solution(String number, int k) {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            while (k > 0 && s.length() > 0 && s.charAt(s.length() - 1) < c) {
                s.deleteCharAt(s.length() - 1);
                k--;
            }

            s.append(c);
        }

        return s.substring(0, s.length() - k);
    }
}
