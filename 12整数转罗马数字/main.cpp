#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    string intToRoman(int num) {
        string answer = "";
        num_M = num / 1000;
        for (int i = 0; i < num_M; i++) {
            answer += "M";
        }
        num %= 1000;
        if (num >= 900) {
            answer += "CM";
            num -= 900;
        }
        else if (num >= 500) {
            answer += "D";
            num -= 500;
        }
        else if (num >= 400) {
            answer += "CD";
            num -= 400;
        }
        num_C = num / 100;
        for (int i = 0; i < num_C; i++) {
            answer += "C";
        }
        num %= 100;
        if (num >= 90) {
            answer += "XC";
            num -= 90;
        }
        else if (num >= 50) {
            answer += "L";
            num -= 50;
        }
        else if (num >= 40) {
            answer += "XL";
            num -= 40;
        }
        num_X = num / 10;
        for (int i = 0; i < num_X; i++) {
            answer += "X";
        }
        num %= 10;
        if (num == 9) {
            answer += "IX";
            num -= 9;
        }
        else if (num >= 5) {
            answer += "V";
            num -= 5;
        }
        else if (num == 4) {
            answer += "IV";
            num -= 4;
        }
        num_I = num;
        for (int i = 0; i < num_I; i++) {
            answer += "I";
        }
        return answer;
    }
private:
    int num_M, num_C, num_X, num_I;
};

int main() {
    Solution solution;
    int num = 3749;
    string answer = solution.intToRoman(num);
    cout << answer << endl;
    return 0;
}
