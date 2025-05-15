import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[j][moves[i] - 1] == 0) continue;
                else {
                    s.push(board[j][moves[i] - 1]);
                    board[j][moves[i] - 1] = 0;
                    
                    if(s.size() > 1) {
                        int top = s.pop();
                        int under = s.peek();
                        if (top == under) {
                            answer += 2;
                            s.pop();
                        } else {
                            s.push(top);
                        }
                    }
                    
                    break;
                }
            }
        }
        
        return answer;
    }
}