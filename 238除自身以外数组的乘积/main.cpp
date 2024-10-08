#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        //前缀积
        vector<int> res(n, 1);
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        //后缀积
        int right = 1;
        for (int i = n-1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
};

int main() {
    Solution s;
    vector<int> nums = {1, 2, 3, 4};
    vector<int> res = s.productExceptSelf(nums);
    for (int i = 0; i < res.size(); i++) {
        cout << res[i] << " ";
    }
    return 0;
}
