#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class RandomizedSet {
public:
    RandomizedSet() {}

    bool insert(int val) {
        //如果映射pos中找到了val，说明已经存在，返回false
        if (pos.find(val) != pos.end())
            return false;
        nums.push_back(val);
        //存储val的位置
        pos[val] = nums.size() - 1;
        return true;
    }

    bool remove(int val) {
        if (pos.find(val) == pos.end())
            return false;
        int last = nums.back();
        //将原来val位置的元素替换为最后一个元素
        nums[pos[val]] = last;
        //原来最后一个元素的位置更新为val的位置
        pos[last] = pos[val];
        nums.pop_back();
        pos.erase(val);
        return true;
    }

    int getRandom() {
        return nums[rand() % nums.size()];
    }

private:
    vector<int> nums;
    unordered_map<int, int> pos;
};

int main() {
    RandomizedSet *obj = new RandomizedSet();
    bool test = obj->insert(1);
    cout << test << endl;
    return 0;
}
