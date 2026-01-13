import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> allPaths = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, 0);
        
        return allPaths.get(0).split(" ");
    }
    
    public void dfs(String current, String path, String[][] tickets, int count){
        if(!allPaths.isEmpty()) return;
        
        if(count == tickets.length) {
            allPaths.add(path);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(current)){
                visited[i] = true;
                
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, count + 1);
                
                visited[i] = false;
            }
        }
    }
}