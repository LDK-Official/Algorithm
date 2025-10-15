class Solution {
    // 타겟 넘버를 만드는 방법의 수를 저장할 변수
    private int answer = 0;
    // 사용할 숫자가 담긴 배열
    private int[] numbers;
    // 목표 타겟 넘버
    private int target;
    // 배열의 길이
    private int n;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        this.n = numbers.length;

        // 0번 인덱스부터 시작하며 초기 누적 합계는 0
        dfs(0, 0);

        return this.answer;
    }

    private void dfs(int index, int currentSum) {
        // 종료 조건
        // 모든 숫자를 다 사용했을 때 (numbers 배열의 끝에 도달했을 때)
        if (index == n) {
            // 최종 합계가 타겟 넘버와 일치하는지 확인
            if (currentSum == target) {
                answer++; // 방법의 수 증가
            }
            return;
        }

        // 재귀 호출
        // numbers[index]를 더하는 경우 (+)
        dfs(index + 1, currentSum + numbers[index]);
        
        // numbers[index]를 빼는 경우 (-)
        dfs(index + 1, currentSum - numbers[index]);
    }
}