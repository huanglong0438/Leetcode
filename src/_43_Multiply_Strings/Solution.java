package _43_Multiply_Strings;

/**
 * Created by donglongcheng01 on 2018/5/20.
 */
public class Solution {

    /**
     * 311 / 311 test cases passed.
     *  Status: Accepted
     *  Runtime: 37 ms
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder res = new StringBuilder(num1.length() + num2.length());
        int max_len = num1.length() + num2.length();
        int carry = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            for (int j = num1.length() - 1; j >= 0; j--) {
                int tmp = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                tmp = tmp + carry;
                if (res.length() <= max_len - i - j - 2) {
                    res.append((char) ('0' + tmp % 10));
                } else {
                    int cur = res.charAt(max_len - i - j - 2) - '0';
                    tmp += cur;
                    res.setCharAt(max_len - i - j - 2, (char) ('0' + tmp % 10));
                }
                carry = tmp / 10;
            }
            if (carry != 0) {
                res.append((char) ('0' + carry));
                carry = 0;
            }
        }
        return res.reverse().toString();
    }

    public String multiply2(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length()==0 || num2.length()==0)
            return "";
        if(num1.charAt(0)=='0')
            return "0";
        if(num2.charAt(0)=='0')
            return "0";
        StringBuilder res = new StringBuilder();
        int num = 0;
        for(int i=num1.length()+num2.length();i>0;i--)
        {
            for(int j=Math.min(i-1,num1.length());j>0;j--)
            {
                if(i-j<=num2.length())
                {
                    num += (int)(num1.charAt(j-1)-'0')*(int)(num2.charAt(i-1-j)-'0');
                }
            }
            if(i!=1 || num>0)
                res.append(num%10);
            num = num/10;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("9", "99"));
    }

}
