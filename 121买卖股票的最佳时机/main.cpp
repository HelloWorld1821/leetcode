#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int len = prices.size();
        if (len < 2) return 0;
        int max_profit = 0;
        //当前最小价格
        int min_pirce = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] < min_pirce) {
                min_pirce = prices[i];
            }
            if (prices[i] - min_pirce > max_profit) {
                max_profit = prices[i] - min_pirce;
            }
        }
        //如果最大利润为负数，则说明没有交易机会，返回0
        max_profit = max(0, max_profit);
        return max_profit;
    }
};
int main() {
    Solution s;
    vector<int> prices = {7,1,5,3,6,4};
    cout << s.maxProfit(prices) << endl;
    return 0;
}
