#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int len = nums.size();
        //临时数组
        vector<int> temp(len);
        for(int i=0; i<len; i++) {
            // 将nums[i]放入temp的对应位置
            temp[(i+k)%len] = nums[i];
        }
        for(int i=0; i<len; i++) {
            nums[i] = temp[i];
        }
        return;
    }
};
int main() {
    Solution s;
    vector<int> nums = {1,2,3,4,5,6,7};
    int k = 3;
    s.rotate(nums, k);
    for(int i=0; i<nums.size(); i++) {
        cout<<nums[i]<<" ";
    }
    return 0;
}
