import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int [] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;

        for (int i = 3; i <= n; i++) {
            result[i] = (result[i-1] + result[i-2]) % 10007;
        }

        System.out.println(result[n]);
    }
}

/**
 * 1. 아이디어
 * 점화식 : An = An-1 + An-2
 * N 값 구하기 위해, for문 3부터 N까지의 값을 구해주기
 * 이전값, 이전이전값 더해서, 10007로 나눠 저장
 *
 * 2. 시간복잡도
 * O(N)
 *
 * 3. 자료구조
 * DP 값 저장하는 (경우의수) 배열: int[]
 *      - 최대값 : 10007보다 작음 > INT
 */