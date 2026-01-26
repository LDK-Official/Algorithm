class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i = 1; i < arrayA.length; i++){
            int a = gcdA;
            int b = arrayA[i];
            while(b != 0){
                int r = a % b;
                a = b;
                b = r;
            }
            gcdA = a;
            
            int c = gcdB;
            int d = arrayB[i];
            while(d != 0){
                int r = c % d;
                c = d;
                d = r;
            }
            gcdB = c;
        }
        
        boolean canA = true;
        for(int x : arrayB){
            if(x % gcdA == 0){
                canA = false;
                break;
            }
        }
        if(canA){
            answer = Math.max(answer, gcdA);
        }
        
        boolean canB = true;
        for(int x : arrayA){
            if(x % gcdB == 0){
                canB = false;
                break;
            }
        }
        if(canB){
            answer = Math.max(answer, gcdB);
        }
        
        return answer;
    }
}