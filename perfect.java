import java.io.*;
import java.util.*;

class Solution {
    public ArrayList<Integer> perfect(int n) {
        ArrayList<Integer> perfectNumbers = new ArrayList<>();
        findPerfectNumbers(1, n, perfectNumbers);
        return perfectNumbers;
    }

    public void findPerfectNumbers(int num, int n, ArrayList<Integer> perfectNumbers) {
        if (num > n) {
            return;
        }

        if (isPerfectNumber(num, 1, 0)) {
            perfectNumbers.add(num);
        }

        findPerfectNumbers(num + 1, n, perfectNumbers);
    }

    public boolean isPerfectNumber(int num, int divisor, int sum) {
        if (divisor >= num) {
            return num == sum;
        }

        if (num % divisor == 0) {
            sum += divisor;
        }

        return isPerfectNumber(num, divisor + 1, sum);
    }
}

public class perfect {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Reading N
        String str = bufferedReader.readLine().trim();
        int n = Integer.parseInt(str);

        Solution solution = new Solution();
        ArrayList<Integer> result = solution.perfect(n);
        System.out.println(result);
    }
}