#include <iostream>
#include <vector>
#include <cmath>
#include <climits>
#include <algorithm>

#define FastIO ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr)

using namespace std;

int BT(int p, vector<bool>& isSelected, vector<int>& start, vector<vector<int>>& s)
{
    int n = s.size();
    int k = start.size();

    if (p >= n)
        return INT_MAX;

    if (k == n / 2)
    {
        vector<int> link;
        for (int i = 0; i < n; i++)
        {
            if (!isSelected[i])
                link.push_back(i);
        }

        int result = 0;
        for (int i = 0; i < k; i++)
        {
            for (int j = 0; j < k; j++)
            {
                result += s[start[i]][start[j]];
                result -= s[link[i]][link[j]];
            }
        }
        return abs(result);
    }

    int result = BT(p + 1, isSelected, start, s);
    isSelected[p] = true;
    start.push_back(p);
    result = min(result, BT(p + 1, isSelected, start, s));
    start.pop_back();
    isSelected[p] = false;

    return result;
}

int MinDiff(vector<vector<int>>& s)
{
    int n = s.size();

    vector<bool> isSelected(n, false);
    vector<int> start;
    return BT(0, isSelected, start, s);
}

int main()
{
    FastIO;

    int n;
    cin >> n;

    vector<vector<int>> s(n, vector<int>(n));
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
            cin >> s[i][j];
    }

    int result = MinDiff(s);
    cout << result << '\n';
}