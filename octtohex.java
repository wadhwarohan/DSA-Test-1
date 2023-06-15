import java.io.*;
import java.util.*;
class Solution {


    public String convert(int n) {
        if (n==0) {
            return "0";
        }
        else {
            int decimal = octalToDecimal(n);
            return decimalToHexadecimal(decimal);
        }
    }


    private int octalToDecimal(int octal) {
        int decimal = 0;
        int power = 0;
        while (octal != 0) {
            int lastDigit = octal % 10;
            decimal += lastDigit * Math.pow(8,power);
            power++;
            octal /= 10;
        }
        return decimal;
    }

    private String decimalToHexadecimal(int decimal) {
        if(decimal ==0) {
            return "";
        } else {
            int remainder = decimal % 16;
            String hexDigit = getHexDigit(remainder);
            return decimalToHexadecimal(decimal / 16) + hexDigit;
        }
    }

    private String getHexDigit(int value) {
        if (value < 10) {
            return String.valueOf(value);
        } else {
            char ch = (char) ('A' + (value - 10));
            return String.valueOf(ch);
        }
    }
}

public class octtohex {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Reading N and K
        String str = bufferedReader.readLine().trim();
        int n = Integer.parseInt(str);

        Solution solution = new Solution();
        String result = solution.convert(n);
        System.out.println(result);
    }
}