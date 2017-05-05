package stringToInteger;

public class Solution {
    public int myAtoi(String str) {
        long result = 0;
        long index = 1;
        boolean outOfBounds = false;
        str = trim(str);
        if(str == null){
            return 0;
        }
        for(int i = str.length() - 1; i >= 0; i--){
            char c = str.charAt(i);
            //非零位置非数字的情况
            if(i > 0 && (c < '0' || c > '9')){
                return 0;
            }
            //零位置非数字的情况
            //负数的情况
            if(i == 0 && c == '-'){
                //如果就一个负号，啥都没有
                if(str.length() == 1){
                    return 0;
                }
                //判断是否出界
                if(outOfBounds){
                    //正数出界了对于负号来说只能有两种情况，
                    //第一，加负号后也出界了，那就返回MIN_VALUE，
                    //第二，加符号后没出界，那就刚好踩线，是MIN_VALUE，那也是返回MIN_VALUE
                    return Integer.MIN_VALUE;
                }
                return (int) -result;
            }
            //还TM有正号的情况，草
            if(i == 0 && c == '+'){
                if(str.length() == 1){
                    return 0;
                }
                return (int) result;
            }
            //如果第0个位置是非数字
            if(i == 0 && (c < '0' || c > '9')){
                if(c == ' '){
                    c = '0';
                }
                else{
                    return 0;
                }
            }
            long factor = c - '0';
            if(!outOfBounds){
                if(result + factor * index > Integer.MAX_VALUE){
                    result = Integer.MAX_VALUE;
                    outOfBounds = true;
                    continue;
                }
                result += factor * index;
                index *= 10;
            }
        }
        return (int) result;
    }

    public String trim(String str){
        String result = "";
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == ' '){
                continue;
            }
            if(c == '+' || c == '-'){
                if(i + 1 == str.length()){
                    return null;
                }
                if(str.charAt(i+1) < '0' || str.charAt(i+1) > '9'){
                    return null;
                }
                result += c;
                continue;
            }
            if(c >= '0' && c <= '9'){
                result += c;
                if(i+1 < str.length() && (str.charAt(i+1) < '0' || str.charAt(i+1) > '9')){
                    return result;
                }
            }
            else{
                return null;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        //2147483647
        System.out.println(sol.myAtoi("    10522545459"));
    }

}
