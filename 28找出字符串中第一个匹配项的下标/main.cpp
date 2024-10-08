#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    int strStr(string haystack, string needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len2 == 0) {
            return 0;
        }
        for (int i = 0; i <= len1 - len2; i++) {
            if (haystack.substr(i, len2) == needle) {
                return i;
            }
        }
        return -1;
    }
};

int main() {
    Solution s;
    string haystack = "leetcode";
    string needle = "code";
    cout << s.strStr(haystack, needle) << endl;
    return 0;
}
