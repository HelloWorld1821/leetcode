#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    int lengthOfLastWord(string s) {
        int len = s.length();
        int i = len - 1;
        while (i >= 0 && s[i] ==' ') {
            i--;
        }
        int j = i;
        while (j >= 0 && s[j]!=' ') {
            j--;
        }
        return i - j;
    }
};

int main() {
    Solution s;
    string str = "Hello World";
    cout << s.lengthOfLastWord(str) << endl;
    return 0;
}
