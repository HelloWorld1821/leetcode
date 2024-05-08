#include <iostream>
#include <stack>

using namespace std;

int main() {
    string num;
    int k;
    cin >> num;
    cin >> k;
    stack<char> t;
    int len = num.length();
    for (int i = 0; i < len; i++) {
        if (t.empty())
            t.push(num[i]);
        else {
            while (!t.empty() && num[i] < t.top() && k > 0) {
                t.pop();
                k--;
            }
            t.push(num[i]);
        }
    }

    string answer;
    while (k > 0 && !t.empty()) {
        t.pop();
        k--;
    }
    while (!t.empty()) {
        answer.insert(0, 1, t.top());
        t.pop();
    }
    while (answer[0] == '0' && answer.length() > 1)
        answer.erase(0, 1);

    if (answer.size() == 0)
        answer += '0';
    cout << answer;
}
