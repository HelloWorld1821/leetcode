#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int len = gas.size();
        //油剩下的量为正值的起始点
        int pos_start = 0, gas_sum = 0, total_sum = 0;
        for (int i = 0; i < len; i++) {
            int remain = gas[i] - cost[i];
            total_sum += remain;
            gas_sum += remain;
            if (gas_sum < 0) {
                gas_sum = 0;
                pos_start = i + 1;
            }
        }
        if (total_sum < 0)
            return -1;
        else
            return pos_start;
    }
};

int main() {
    Solution s;
    vector<int> gas = {1, 2, 3, 4, 5};
    vector<int> cost = {3, 4, 5, 1, 2};
    cout << s.canCompleteCircuit(gas, cost) << endl;
    return 0;
}
