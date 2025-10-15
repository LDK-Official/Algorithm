class Solution {
    private long getTotalTime(int[] diffs, int[] times, int level) {
        long totalTime = 0;
        int n = diffs.length;
        
        // 첫 번째 퍼즐 처리
        totalTime += times[0];
        
        // 두 번째 퍼즐부터 처리
        for (int i = 1; i < n; i++) {
            int diff = diffs[i];
            long timeCur = times[i];
            long timePrev = times[i-1]; 
            
            if (diff <= level) {
                // 숙련도가 충분해 틀리지 않는 경우
                totalTime += timeCur;
            } else {
                // 숙련도가 부족해 틀리는 경우
                long mistakes = diff - level;
                
                // 틀릴 때마다 소요 시간
                long timePerMistake = timeCur + timePrev;
                
                // 총 소요 시간
                long timeSpent = (mistakes * timePerMistake) + timeCur;
                
                totalTime += timeSpent;
            }
        }
        
        return totalTime;
    }
    public int solution(int[] diffs, int[] times, long limit) {
        
        // 숙련도의 최대 난이도 찾기
        int maxDiff = 0;
        for (int diff : diffs) {
            maxDiff = Math.max(maxDiff, diff);
        }
        
        // 숙련도 탐색 범위 설정
        int low = 1;
        int high = maxDiff; 
        int minLevel = maxDiff; // 최솟값 저장할 변수 최댓값으로 초기화

        // 이분 탐색 수행
        while (low <= high) {
            int midLevel = low + (high - low) / 2;
            
            // 총 시간 계산
            long currentTime = getTotalTime(diffs, times, midLevel);
            
            if (currentTime <= limit) {
                minLevel = midLevel;
                high = midLevel - 1;
            } else {
                low = midLevel + 1;
            }
        }
        
        return minLevel;
    }
}