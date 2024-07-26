#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    int romanToInt(string s) {
        int result = 0;
        //记录前一个值
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = 0;
            switch (s[i]) {
                case 'I':
                    curr = 1;
                    break;
                case 'V':
                    curr = 5;
                    break;
                case 'X':
                    curr = 10;
                    break;
                case 'L':
                    curr = 50;
                    break;
                case 'C':
                    curr = 100;
                    break;
                case 'D':
                    curr = 500;
                    break;
                case 'M':
                    curr = 1000;
                    break;
            }
            //如果当前值比前一个值小，即为减法，需要减去前一个值的两倍
            if (curr > prev) {
                result -= prev * 2;
            }
            result += curr;
            prev = curr;
        }
        return result;
    }
};

int main() {
    Solution solution;
    string s = "MCMXCIV";
    int result = solution.romanToInt(s);
    cout << result << endl;
    return 0;
}
