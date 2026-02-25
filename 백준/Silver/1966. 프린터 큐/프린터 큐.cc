#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int T;
    cin >> T;

    while (T--) {
        int N, M;
        cin >> N >> M;

        queue<pair<int, int>> q;
        priority_queue<int> pq;

        for (int i = 0; i < N; i++) {
            int priority;
            cin >> priority;
            q.push({priority, i});
            pq.push(priority);
        }

        int count = 0;
        while (!q.empty()) {
            int current_p = q.front().first;
            int current_idx = q.front().second;
            q.pop();

            if (current_p == pq.top()) {
                count++;
                pq.pop();
                
                if (current_idx == M) {
                    cout << count << endl;
                    break;
                }
            } else {
                q.push({current_p, current_idx});
            }
        }
    }
    return 0;
}