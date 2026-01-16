import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int[][] pos = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
        
        
        int[] left = {3,0};
        int[] right = {3,2};
        
        for(int num : numbers){
            if(num == 1 || num == 4 || num == 7){
                sb.append("L");
                left = pos[num];
            } else if(num == 3 || num == 6 || num == 9){
                sb.append("R");
                right = pos[num];
            } else {
                int dL = getDist(left, pos[num]);
                int dR = getDist(right, pos[num]);
                
                if(dL < dR){
                    sb.append("L");
                    left = pos[num];
                } else if(dR < dL){
                    sb.append("R");
                    right = pos[num];
                } else {
                    if(hand.equals("right")){
                        sb.append("R");
                        right = pos[num];
                    } else {
                        sb.append("L");
                        left = pos[num];
                    }
                }
            }
        }
        
        return sb.toString();
    }
    
    public int getDist(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}