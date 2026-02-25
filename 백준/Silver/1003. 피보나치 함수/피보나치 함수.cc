#include <iostream>
#include <vector>

using namespace std;

pair<int, int> memo[41];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    memo[0] = {1, 0};
    memo[1] = {0, 1};

    for (int i = 2; i <= 40; i++) {
        memo[i].first = memo[i - 1].first + memo[i - 2].first;
        memo[i].second = memo[i - 1].second + memo[i - 2].second;
    }

    while (T--) {
        int n;
        cin >> n;
        cout << memo[n].first << " " << memo[n].second << "\n";
    }

    return 0;
}