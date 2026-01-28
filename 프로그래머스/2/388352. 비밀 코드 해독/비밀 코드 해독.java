class Solution {
    
    int answer = 0;
    int[] candidate = new int[5];
    
    public int solution(int n, int[][] q, int[] ans) {
        find(1, 0, n, q, ans);
        return answer;
    }
    
    void find(int start, int depth, int n, int[][] q, int[] ans){
        if(depth == 5){
            if(isCorrect(q, ans)) answer++;
            return;
        }
        
        for(int i = start; i <= n; i++){
            candidate[depth] = i;
            find(i + 1, depth + 1, n, q, ans);
        }
    }
    
    boolean isCorrect(int[][] q, int[] ans){
        for(int i = 0; i < q.length; i++){
            int match = 0;
            
            for(int num : q[i]){
                for(int c : candidate){
                    if(num == c){
                        match++;
                        break;
                    }
                }
            }
            if(match != ans[i]) return false;
        }
        return true;
    }
}