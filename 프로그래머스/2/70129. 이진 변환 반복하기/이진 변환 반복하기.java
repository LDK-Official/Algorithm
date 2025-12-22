class Solution {
    public int[] solution(String s) {
        int countTransform = 0;
        int countZeros = 0;

        while (!s.equals("1")) {
            int originalLength = s.length();
            
            String filteredS = s.replace("0", "");
            int filteredLength = filteredS.length();
            
            countZeros += (originalLength - filteredLength);
            countTransform++;
            
            s = Integer.toBinaryString(filteredLength);
        }

        return new int[]{countTransform, countZeros};
    }
}