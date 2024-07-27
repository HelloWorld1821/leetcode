#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int trap(vector<int>& height) {
        int len = height.size();
        if (len < 3) return 0;
        int left = 0, right = 1, water = 0, max_right = 0;
        while (right < len - 1) {
            //寻找能接水的V字形的两端
            while (right < len - 1 && height[right] < height[left]) right++;
            //如果找不到比左侧高的右侧，那就从剩下部分找最高点作为右侧
            if (right == len - 1 && height[right] < height[left]) {
                right = left + 1;
                max_right = right;
                while (right < len) {
                    if (height[right] > height[max_right]) max_right = right;
                    right++;
                }
                right = max_right;
            }
            if (left < right) {
                int h = min(height[left], height[right]);
                for (int i = left + 1; i < right; i++) {
                    water += max(0, h - height[i]);
                }
            }
            left = right;
            right = left + 1;
        }
        return water;
    }
};

int main() {
    Solution s;
    vector<int> height = {2, 8, 5, 5, 6, 1, 7, 4, 5};
    cout << s.trap(height) << endl;
    return 0;
}
