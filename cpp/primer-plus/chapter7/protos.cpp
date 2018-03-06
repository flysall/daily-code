#include <iostream>

void cheers(int);   // prototype
double cube(double x);  // prototype

int main()
{
    using namespace std;
    cheers(5);      // function call
    cout << "Given me a number: ";
    double side;
    cin >> side;
    double volume = cube(side);  // function call
    cout << "A " << side << "-foot cube hash a volume of ";
    cout << volume << " cubic feet.\n";
    cheers(cube(2));
    return 0;
}

void cheers(int n)
{
    using namespace std;
    for (int i = 0; i < n; i++)
        cout << "Cheers! ";
    cout << endl;
}

double cube(double x) 
{
    return x * x * x;
}

