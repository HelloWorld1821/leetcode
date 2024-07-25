#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int hIndex(vector<int>& citations) {
        int len = citations.size();
        sort(citations.begin(), citations.end(), greater<int>());
        int h = 0;
        for (int i = 0; i < len; i++) {
            //由大到小排序后i+1即表示大于等于citations[i]引用的论文数量
            if (citations[i] >= i + 1)
                h = i + 1;
        }
        return h;
    }
};

int main() {
    Solution s;
    vector<int> citations = {1, 3, 1};
    cout << s.hIndex(citations) << endl;
    return 0;
}
