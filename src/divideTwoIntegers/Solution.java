package divideTwoIntegers;

/**
 * Created by donglongcheng01 on 2018/5/7.
 *
 * 除法操作，但是规定不让用乘除和取余运算，所以只能回归除法的本质——位运算
 * 例如28/3，除法的本质就是CPU的逻辑运算单元（ALU）把除数3左移直到刚好小于被除数28（24），然后进行减法操作（4），再回到ALU继续移位和减法
 * 最后计数器记下移位操作记录结果
 */
public class Solution {

    /**
     * 989 / 989 test cases passed.
     *  Status: Accepted
     *  Runtime: 46 ms
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int result = 0;
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            // 被除数如果是最小的int，除以-1变号
            // 因为MIN_VALUE是-2147483648，除以-1变号刚好溢出（MAX_VALUE是2147483647），导致结果还是-2147483648
            return Integer.MAX_VALUE;
        }

        /**
         * 因为要进行位运算，所以负数（补码）要算绝对值统一成正数
         * 同上，因为Math.abs(Integer.MIN_VALUE)还是-2147483648，没办法只能扩展为long（或者负数用另一套逻辑处理？）
         * 这里其实这么搞不太合适，为了迁就MIN_VALUE一个特殊数字，占用额外的空间了
         */
        long dividendL = Math.abs((long)dividend);
        long divisorL = Math.abs((long)divisor);

        while (dividendL >= divisorL) {
            int shiftNum = 0;
            long temp = divisorL;
            while (dividendL >= temp) {
                temp <<= 1;
                shiftNum++;
            }
            temp >>= 1;
            dividendL -= temp;
            result += (1 << (shiftNum - 1));
        }

        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            return result;
        } else {
            return -result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(28, 3));
    }

}
