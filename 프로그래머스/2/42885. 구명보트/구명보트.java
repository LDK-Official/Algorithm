import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        
        // 사람들의 몸무게를 오름차순으로 정렬
        Arrays.sort(people);
        
        int boats = 0;         // 필요한 구명보트의 수
        int start = 0;         // 가장 가벼운 사람
        int end = people.length - 1; // 가장 무거운 사람

        // 투 포인터 방식으로 탐색 시작
        while (start <= end) {
            
            boats++;
            
            // 가장 무거운 사람과 가장 가벼운 사람 (people[start])을 같이 태울 수 있는지 확인
            if (people[start] + people[end] <= limit) {
                // 같이 태울 수 있다면 가장 가벼운 사람도 구출된 것이므로 start 포인터를 다음 사람으로 옮김
                start++;
            }
            
            // 가장 무거운 사람은 보트에 탔으므로 end 포인터를 다음 무거운 사람으로 옮김
            end--;
        }
        
        return boats;
    }
}