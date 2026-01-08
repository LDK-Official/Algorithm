class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total =  brown + yellow;
        
        for(int i = 3; i <= Math.sqrt(total); i++){
            if(total % i == 0){
                int w = total / i;
                
                if((w - 2) * (i - 2) == yellow){
                    answer[0] = w;
                    answer[1]= i;
                    break;
                }
            }
        }        
        return answer;
    }
}