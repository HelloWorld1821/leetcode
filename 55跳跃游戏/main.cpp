#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool canJump(vector<int> &nums) {
        int len = nums.size();
        if (len == 1) return true;
        //当前位置和下一步能到达的最远位置
        int now_loca = 0, next_loca = nums[0];
        bool flag = false;
        while (now_loca < len) {
            //更新下一步可以到达的最远位置
            int mmax_i = 0, max_loca = 0;
            for (int i = now_loca; i <= min(next_loca, len - 1); i++) {
                if (i + nums[i] >= max_loca) {
                    max_loca = i + nums[i];
                    mmax_i = i;
                }
            }
            now_loca = mmax_i;
            next_loca = max_loca;
            //如果下一步可以到达终点
            if (next_loca >= len - 1) {
                flag = true;
                break;
            }
            //如果当前位置不能跳跃，则必不能到达终点
            if (nums[now_loca] == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
};

int main() {
    Solution s;
    vector<int> nums = {2, 0, 0};
    cout << s.canJump(nums) << endl;
    return 0;
}
