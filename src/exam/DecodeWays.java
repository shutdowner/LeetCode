package exam;

import org.junit.Test;

/**
 * @Description 91. Decode Ways
 * @Author zyj
 * @Date 2019/1/18 10:14
 **/
public class DecodeWays {
    public int numDecodings(String s) {
        if(s.length()==1){
            return Integer.parseInt(s)>=1&&Integer.parseInt(s)<=26?1:0;
        }
        if(s.length()==2){
            return getSecondStrRes(s);
        }
        int result[] = new int[s.length()];
        result[0] = Integer.parseInt(s.substring(0, 1))>=1&&Integer.parseInt(s.substring(0, 1))<=26?1:0;
        result[1] = getSecondStrRes(s.substring(0, 2));
        for(int i = 2;i<s.length();i++){
            String currentChar = s.substring(i, i+1);
            String lastChar = s.substring(i-1, i);
            String tempStr = s.substring(i-1, i+1);
            //如果当前字符和前一个字符满足条件
            if(Integer.parseInt(tempStr)<=26&&Integer.parseInt(tempStr)>0&&Integer.parseInt(lastChar)>0){
                result[i] += result[i-2];
            }
            //如果当前字符满足条件
            if(Integer.parseInt(currentChar)>0){
                result[i] += result[i-1];
            }
        }
        return result[s.length()-1];
    }

    int getSecondStrRes(String s){
        int tempRes = 0;
        int first = Integer.parseInt(s.substring(0, 1));
        int second = Integer.parseInt(s.substring(1, 2));
        if(first>0&&first<=26&&second>0&&second<=26){
            tempRes++;
        }
        if(Integer.parseInt(s)>0&&Integer.parseInt(s)<=26&&first>0){
            tempRes++;
        }
        return tempRes;
    }

    @Test
    public void test(){
        String data = "012";
        System.out.print(numDecodings(data));
    }
}
