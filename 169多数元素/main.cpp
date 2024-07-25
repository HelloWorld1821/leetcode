#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int len = nums.size();
        sort(nums.begin(), nums.end());
        return nums[len / 2];
    }
};
int main() {
    Solution s;
    vector<int> nums = {2, 2, 1, 1, 1, 2, 2};
    cout << s.majorityElement(nums) << endl;
    return 0;
}
