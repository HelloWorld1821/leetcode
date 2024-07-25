#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int len = prices.size();
        if (len < 2) return 0;
        int max_profit = 0;
        //维护两个指针，分别指向买入日和卖出日
        int i = 0, j = 1;
        while (j < len) {
            //当后一天的价格更高时，继续寻找卖出日
            while (j < len - 1 && prices[j] < prices[j + 1]) j++;
            //当后一天的价格更低时，继续寻找买入日
            while (i < j && prices[i] > prices[i + 1]) i++;
            if (prices[j] - prices[i] > 0)
                max_profit += prices[j] - prices[i];

            i = j;
            j++;
        }
        return max_profit;
    }
};
int main() {
    Solution s;
    vector<int> prices = {7, 1, 5, 3, 6, 4};
    cout << s.maxProfit(prices) << endl;
    return 0;
}
