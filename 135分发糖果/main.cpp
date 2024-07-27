#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int candy(vector<int>& ratings) {
        int len = ratings.size();
        vector<int> candies(len, 1);
        //保证从左往右满足条件
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;
        }
        //保证从右往左满足条件
        for (int i = len-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1])
                candies[i] = max(candies[i], candies[i+1] + 1);
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += candies[i];
        }
        return sum;
    }
};

int main() {
    Solution s;
    vector<int> ratings = {1, 0, 2};
    cout << s.candy(ratings) << endl;
    return 0;
}
