#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    string reverseWords(string s) {
        string result = "";
        int start = s.length() - 1, end = s.length() - 1;
        while (end >= 0 && start >= 0) {
            while (s[end] == ' ' && end > 0) end--;
            start = end;
            while (s[start]!=' ' && start > 0) start--;
            if (start == 0 && s[start] != ' ')
                result += s.substr(start, end - start + 1);
            else
                result += s.substr(start + 1, end - start) + " ";
            end = start - 1;
        }
        end = result.length() - 1;
        while (end >= 0 && result[end] ==' ') {
            result.pop_back();
            end--;
        }
        return result;
    }
};

int main() {
    Solution s;
    string str = "  hello world  ";
    cout << s.reverseWords(str) << endl;
    return 0;
}
