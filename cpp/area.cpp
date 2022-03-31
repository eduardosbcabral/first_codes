#include <iostream>
#include <iomanip>

using namespace std;

int main() {

    double r, pi = 3.14159, a;

    cin >> r;

    a = pi * (r*r);

    cout << setprecision(4) << "A = " << a << endl;

    return 0;
}
