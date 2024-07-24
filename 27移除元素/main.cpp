#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int len = nums.size();
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                nums[i] = 101;
                k++;
            }
        }
        int i = 0, j = len -1;
        while (i < j) {
            while (i < j && nums[i] != 101) {
                i++;
            }
            while (i < j && nums[j] == 101) {
                j--;
            }
            if (i < j) {
                swap(nums[i], nums[j]);
                i++;
                j--;
            }
        }
        return len - k;
    }
};
int main() {
    Solution s;
    vector<int> nums = {0, 1, 2, 2, 3, 0, 4, 2};
    int val = 2;
    int k = s.removeElement(nums, val);
    cout << "k = " << k << endl;
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i] << " ";
    }
    cout << endl;
    return 0;
}
