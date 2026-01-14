import java.io.*;
import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();
        
        for(char c : new_id.toCharArray()){
            if(Character.isUpperCase(c)){
                c = Character.toLowerCase(c);
            }
            
            if(Character.isLowerCase(c) || Character.isDigit(c) || c == '-'
              || c == '_' || c == '.'){
                if(c == '.'){
                if(answer.length() > 0 && answer.charAt(answer.length() - 1) != '.'){
                    answer.append(c);
                    }
                }else {
                    answer.append(c);
                }   
            }
            
         
        }
        String result = answer.toString();
        if(result.startsWith(".")) result = result.substring(1);
        if(result.endsWith(".")) result = result.substring(0, result.length() - 1);
            
        if(result.equals("")) result = "a";
            
        if(result.length() >= 16){
            result = result.substring(0, 15);
            if(result.endsWith(".")) result = result.substring(0, 14);
        }
            
        while(result.length() < 3){
            result += result.charAt(result.length() - 1);
        }
        
        return result;
    }
}