package zigzagConvertion;

public class Solution {
    public String convert(String s, int numRows) {
        if(s.length() == 0){
            return "";
        }
        if(numRows < 2){
            return s;
        }
        else{
        	//计算获得矩阵的行数和列数
            int divider = numRows + (numRows - 2);
            int numCols = s.length() / divider * (numRows - 1);
            int remainder = s.length() % divider;
            if(remainder > 0 && remainder <= numRows){
                numCols++;
            }
            else if(remainder > numRows){
                numCols++;
                remainder -= numRows;
                numCols += remainder;
            }
            
            char zigzag[][] = new char[numRows][numCols];
            int cur = 0;
            int i = 0, j = 0;
            boolean downOrRightup = true;
            while(cur < s.length()){
                if(downOrRightup){
                    if(i == numRows){
                        downOrRightup = false;
                        //roll back
                        i--;
                        //go next position
                        i--;
                        j++;
                        continue;
                    }
                    zigzag[i][j] = s.charAt(cur);
                    cur++;
                    i++;
                }
                else{
                    if(i < 0){
                        downOrRightup = true;
                        //roll back
                        i++;
                        j--;
                        //go next position
                        i++;
                        continue;
                    }
                    zigzag[i][j] = s.charAt(cur);
                    cur++;
                    i--;
                    j++;
                }
            }
            
            String result = "";
            for(i = 0; i < numRows; i++){
                for(j = 0; j < numCols; j++){
                    if(zigzag[i][j] != '\0'){
                        result += zigzag[i][j];
                    }
                }
            }
            return result;
        }
    }
    
    public static void main(String argv[]){
    	Solution solution = new Solution();
    	String s = solution.convert("AB", 2);
    	System.out.println(s);
    }
}