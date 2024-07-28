#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        vector<string> result;
        int i = 0;
        while (i < words.size()) {
            int len = 0;
            int j = i;
            while (j < words.size() && len + words[j].size() + (j - i) <= maxWidth) {
                len += words[j].size();
                j++;
            }
            //一行中空格的数量
            int space = maxWidth - len;
            if (j == i + 1) { //单词太长，单独占一行
                result.push_back(words[i] + string(maxWidth - words[i].size(), ' '));
            }

            else if (j != i && j != words.size()){ //一行可以放下所有单词并且不是最后一行
                string line = words[i];
                int curSpace = (space / (j - i - 1));
                for (int k = i + 1; k < j; k++) {
                    int extraSpace = space % (j - i - 1);
                    if (k - i <= extraSpace)
                        line += string(1,' ');
                    line += string(curSpace,' ');
                    line += words[k];
                }
                result.push_back(line);
            }

            else { //最后一行，左对齐
                string line = words[i];
                for (int k = i + 1; k < j; k++) {
                    line += string(1,' ');
                    line += words[k];
                }
                line += string(maxWidth - line.size(),' ');
                result.push_back(line);
            }
            i = j;
        }
        return result;
    }
};

int main() {
    Solution s;
    vector<string> words = {"This", "is", "an", "example", "of", "text", "justification."};
    int maxWidth = 16;
    vector<string> result = s.fullJustify(words, maxWidth);
    for (string str : result) {
        cout << str << endl;
    }
    return 0;
}
