#include <iostream>
#include <stack>

using namespace std;

int main() {
    string s;
    cin >> s;
    stack<char> t;
    int len = s.length();
    int book[30] = {0};
    bool flag[30];
    for (int i = 0; i < len; i++) {
        book[s[i] - 'a']++;
        flag[s[i] - 'a'] = false;
    }

    for (int i = 0; i < len; i++) {
        while (!t.empty() && s[i] < t.top() && book[t.top() - 'a'] > 1 && flag[s[i] - 'a'] == false) {
            book[t.top() - 'a']--;
            flag[t.top() - 'a'] = false;
            t.pop();
        }
        if (book[s[i] - 'a'] > 1 && flag[s[i] - 'a'] == true)
        {
            book[s[i] - 'a']--;
            continue;
        }
        t.push(s[i]);
        flag[s[i] - 'a'] = true;
    }

    string answer;
    while (!t.empty()) {
        answer.insert(0, 1, t.top());
        t.pop();
    }

    cout << answer;
    return 0;
}
