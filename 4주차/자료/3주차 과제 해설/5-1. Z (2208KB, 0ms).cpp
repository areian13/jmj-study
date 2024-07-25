#include <iostream>
#include <cmath>

#define FastIO ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr)

using namespace std;

int Z(int k, int r, int c)
{
    if (k == 1)
        return 0;

    k /= 2;

    if (r < k && c < k)
        return Z(k, r, c);
    if (r < k && c >= k)
        return Z(k, r, c - k) + k * k * 1;
    if (r >= k && c < k)
        return Z(k, r - k, c) + k * k * 2;
    return Z(k, r - k, c - k) + k * k * 3;
}

int main()
{
    FastIO;

    int n, r, c;
    cin >> n >> r >> c;

    int k = pow(2, n);
    int result = Z(k, r, c);
    cout << result << '\n';
}