// import java.util.*;

// class Solution {
//     public int solution(String[] storage, String[] requests) {
//         int answer = 0;
//         int n = storage.length; //세로
//         int m = storage[0].length(); //가로
//         boolean [][] remove = new boolean[n][m];
//         char [][] box = new char[n][m];
        
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 box[i][j] = storage[i].charAt(j);
//             }
//         }
        
//         List<int[]> crane = new ArrayList<>();
        
//         for (int x = 0; x < requests.length; x++) {
//             List<int[]> list = new ArrayList<>();
//             char c = requests[x].charAt(0);
            
//             if (requests[x].length() == 1) {
//                 for (int i = 0; i < n; i++) {
//                     for (int j = 0; j < m; j++) {
//                         if (remove[i][j] || box[i][j] != c) continue;
//                         boolean out = false;
//                         if (i-1 < 0 || i+1 >= n || j-1 < 0 || j+1 >= m) out = true;
//                         else if (remove[i-1][j] || remove[i+1][j] || remove[i][j-1] || remove[i][j+1]) out = true;
//                         if (out) {
//                             list.add(new int[]{i,j});
//                         }
//                     }
//                 }
                
//                 int len = list.size();
//                 for (int i = 0; i < len; i++) {
//                     int[] remove_box = list.get(0);
//                     remove[remove_box[0]][remove_box[1]] = true;
//                     list.remove(0);
//                 }
//             } else if (requests[x].length() == 2) {
//                 for (int i = 0; i < n; i++) {
//                     for (int j = 0; j < m; j++) {
//                         if (remove[i][j] || box[i][j] != c) continue;
                        
//                         int[] arr_c = {i, j};
//                         boolean found = crane.stream()
//                                    .anyMatch(arr -> Arrays.equals(arr, arr_c));
//                         if(!found) crane.add(arr_c);
//                     }
//                 }
//             }
            
//             int cLen = crane.size();
//             for (int y = 0; y < cLen; y++) {
//                 boolean out = false;
//                 int[] c_box = crane.get(0);
//                 int c_i = c_box[0];
//                 int c_j = c_box[1];
//                 crane.remove(0);
                
//                 if (c_i-1 < 0 || c_i+1 >= n || c_j-1 < 0 || c_j+1 >= m) out = true;
//                 else if (remove[c_i-1][c_j] || remove[c_i+1][c_j] || remove[c_i][c_j-1] || remove[c_i][c_j+1]) out = true;
//                 if(out) {
//                     list.add(new int[]{c_i, c_j});
//                 } else {
//                     crane.add(new int[]{c_i, c_j});
//                 }
//             }
            
//             if (!list.isEmpty()) {
//                 int len = list.size();
//                 for (int i = 0; i < len; i++) {
//                     int[] remove_box = list.get(0);
//                     remove[remove_box[0]][remove_box[1]] = true;
//                     list.remove(0);
//                 }
//             }
//         }
        
//         int cLen = 0;
//         if (!crane.isEmpty()) {
//             cLen = crane.size();
//         }
        
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (!remove[i][j]) answer++;
//             }
//         }
        
//         answer -= cLen;
        
//         return answer;
//     }
// }


// import java.util.*;

// class Solution {
//     public int solution(String[] storage, String[] requests) {
//         int answer = 0;
//         int n = storage.length; //세로
//         int m = storage[0].length(); //가로
//         boolean [][] remove = new boolean[n][m];
//         char [][] box = new char[n][m];
        
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 box[i][j] = storage[i].charAt(j);
//             }
//         }
        
//         List<int[]> crane = new ArrayList<>();
        
//         for (int x = 0; x < requests.length; x++) {
//             List<int[]> list = new ArrayList<>();
//             char c = requests[x].charAt(0);
            
//             if (requests[x].length() == 1) {
//                 for (int i = 0; i < n; i++) {
//                     for (int j = 0; j < m; j++) {
//                         if (remove[i][j] || box[i][j] != c) continue;
//                         boolean out = false;
//                         if (i-1 < 0 || i+1 >= n || j-1 < 0 || j+1 >= m) out = true;
//                         else if (remove[i-1][j] || remove[i+1][j] || remove[i][j-1] || remove[i][j+1]) out = true;
//                         if (out) {
//                             list.add(new int[]{i,j});
//                         }
//                     }
//                 }
                
//                 int len = list.size();
//                 for (int i = 0; i < len; i++) {
//                     int[] remove_box = list.get(0);
//                     remove[remove_box[0]][remove_box[1]] = true;
//                     list.remove(0);
//                 }
//             } else if (requests[x].length() == 2) {
//                 for (int i = 0; i < n; i++) {
//                     for (int j = 0; j < m; j++) {
//                         if (remove[i][j] || box[i][j] != c) continue;
                        
//                         int[] arr_c = {i, j};
//                         boolean found = crane.stream()
//                                    .anyMatch(arr -> Arrays.equals(arr, arr_c));
//                         if(!found) crane.add(arr_c);
//                     }
//                 }
//             }
            
//             int cLen = crane.size(); // 위부터 순차적으로 remove 처리하니까, 아래 게 remove 처리했을 때 위 거는 계속 remove가 안 됨. ["AAAA", "ABAA", "ABAA", "ACAA"], ["CC","BB","A"], 0 | 함수 따로 빼서, 연결된 crane 있으면 걔부터 탐색하게??
//             for (int y = 0; y < cLen; y++) {
//                 boolean out = false;
//                 int[] c_box = crane.get(0);
//                 int c_i = c_box[0];
//                 int c_j = c_box[1];
//                 crane.remove(0);
                
//                 if (c_i-1 < 0 || c_i+1 >= n || c_j-1 < 0 || c_j+1 >= m) out = true;
//                 else if (remove[c_i-1][c_j] || remove[c_i+1][c_j] || remove[c_i][c_j-1] || remove[c_i][c_j+1]) out = true;
//                 if(out) {
//                     remove[c_i][c_j] = true;
//                 } else {
//                     crane.add(new int[]{c_i, c_j});
//                 }
//             }
//         }
        
//         int cLen = 0;
//         if (!crane.isEmpty()) {
//             cLen = crane.size();
//         }
        
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (!remove[i][j]) answer++;
//             }
//         }
        
//         answer -= cLen;
        
//         return answer;
//     }
// }

import java.util.*;

class Solution {
    boolean [][] remove;
    char [][] box;
    boolean[][] crane;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int n = storage.length; //세로
        int m = storage[0].length(); //가로
        remove = new boolean[n][m];
        box = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = storage[i].charAt(j);
            }
        }
        
        crane = new boolean[n][m];
        
        for (int x = 0; x < requests.length; x++) {
            List<int[]> list = new ArrayList<>();
            char c = requests[x].charAt(0);
            
            if (requests[x].length() == 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (remove[i][j] || box[i][j] != c) continue;
                        boolean out = false;
                        if (i-1 < 0 || i+1 >= n || j-1 < 0 || j+1 >= m) out = true;
                        else if (remove[i-1][j] || remove[i+1][j] || remove[i][j-1] || remove[i][j+1]) out = true;
                        if (out) {
                            list.add(new int[]{i,j});
                        }
                    }
                }
                
                int len = list.size();
                for (int i = 0; i < len; i++) {
                    int[] remove_box = list.get(0);
                    remove[remove_box[0]][remove_box[1]] = true;
                    list.remove(0);
                }
            } else if (requests[x].length() == 2) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (remove[i][j] || box[i][j] != c) continue;
                        
                        if (!crane[i][j]) crane[i][j] = true;
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!crane[i][j]) continue;
                    crane_f(i, j, n, m);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!remove[i][j] && !crane[i][j]) answer++;
                if (remove[i][j] && crane[i][j]) answer++;
            }
        }
        
        return answer;
    }
    
    public void crane_f(int i, int j, int n, int m) {
        boolean out = false;
        
        if (i-1 < 0 || i+1 >= n || j-1 < 0 || j+1 >= m) out = true;
        else if (remove[i-1][j] || remove[i+1][j] || remove[i][j-1] || remove[i][j+1]) out = true;
        if(out) {
            remove[i][j] = true;
            crane[i][j] = false;
            if (i-1 >= 0 && crane[i-1][j]) crane_f(i-1, j, n, m);
            if (i+1 < n && crane[i+1][j]) crane_f(i+1, j, n, m);
            if (j-1 >= 0 && crane[i][j-1]) crane_f(i, j-1, n, m);
            if (j+1 < m && crane[i][j+1]) crane_f(i, j+1, n, m);
        }
    }
}