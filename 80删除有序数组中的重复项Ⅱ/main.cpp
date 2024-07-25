#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int len = nums.size();
        if (len < 3) return len;
        int k = 0;
        int mmax = 1e4+5;
        for (int i = 2; i < len; i++) {
            if (nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) {
                k++;
                nums[i - 2] = mmax;
            }
        }
        if (k == 0) return len;
        int i = 0, j = 0;
        while(i < len - k && j < len) {
            while(i < len - k && nums[i] != mmax)
            {
                i++;
                j = i;
            }
            while(j < len && nums[j] == mmax) j++;
            swap(nums[i], nums[j]);
            i++;
            j++;
        }
        j = len - 1;
        while(j >= 0 && nums[j] == mmax)
        {
            nums.pop_back();
            j--;
        }
        return len - k;
    }
};
int main() {
    Solution s;
    vector<int> nums = {1, 1, 1, 2, 2, 3};
    cout << s.removeDuplicates(nums) << endl;
    for (int i = 0; i < nums.size(); i++) {
        cout << nums[i] << " ";
    }
    return 0;
}
