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
            //����λ�÷����ֵ����
            if(i > 0 && (c < '0' || c > '9')){
                return 0;
            }
            //��λ�÷����ֵ����
            //���������
            if(i == 0 && c == '-'){
                //�����һ�����ţ�ɶ��û��
                if(str.length() == 1){
                    return 0;
                }
                //�ж��Ƿ����
                if(outOfBounds){
                    //���������˶��ڸ�����˵ֻ�������������
                    //��һ���Ӹ��ź�Ҳ�����ˣ��Ǿͷ���MIN_VALUE��
                    //�ڶ����ӷ��ź�û���磬�Ǿ͸պò��ߣ���MIN_VALUE����Ҳ�Ƿ���MIN_VALUE
                    return Integer.MIN_VALUE;
                }
                return (int) -result;
            }
            //��TM�����ŵ��������
            if(i == 0 && c == '+'){
                if(str.length() == 1){
                    return 0;
                }
                return (int) result;
            }
            //�����0��λ���Ƿ�����
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
