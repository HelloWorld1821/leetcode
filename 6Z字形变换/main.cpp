#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        string result = "";
        //间隔的长度
        int cycle = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += cycle) {
                result += s[j];
                if (i != 0 && i != numRows - 1 && j + cycle - 2 * i < s.length()) {
                    //对角线元素
                    result += s[j + cycle - 2 * i];
                }
            }
        }
        return result;
    }
};

int main() {
    Solution s;
    string str = "PAYPALISHIRING";
    int numRows = 3;
    string result = s.convert(str, numRows);
    cout << result << endl;
    return 0;
}
