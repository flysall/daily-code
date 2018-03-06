#include <iostream>
#include <cstring>

int main()
{
    using namespace std;
    char animal[20] = "bear";
    const char* bird = "wren";
    char* ps;
    cout << animal << " and ";
    cout << bird << "\n";
    // cout << ps << "\n";  // may display garbage, may cause a crash
    
    cout << "Enter a kind of animal: ";
    cin >> animal;  // ok if input < 20 chars
    // cin >> ps    // ps doesn't point ot allocated space

    ps = animal;
    cout << ps << "!\n";
    cout << "Before using strcp(): \n";
    cout << animal << " at " << (int*) animal << endl;
    cout << ps << " at " << (int*) ps << endl;

    ps = new char[strlen(animal) + 1];
    strcpy(ps, animal);
    cout << "After using strcpy():\n";
    cout << animal << " at " << (int*) animal << endl;
    cout << ps << " at " << (int*) ps << endl;
    delete []ps;
    return 0;
}
