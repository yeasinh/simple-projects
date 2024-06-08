#include <iostream>
#include <string>
#include <vector>

using namespace std;

// Virtual class representing a Medicine
class Medicine {
public:
    Medicine(const string& name, double price) : name(name), price(price) {}

    // Pure virtual function
    virtual void displayInfo() const = 0;

protected:
    string name;
    double price;
};

// Derived class for a Tablet
class Tablet : public Medicine {
public:
    Tablet(const string& name, double price, int dosage) : Medicine(name, price), dosage(dosage) {}

    void displayInfo() const override {
        cout << "Tablet: " << name << "\nPrice: $" << price << "\nDosage: " << dosage << " mg\n";
    }

private:
    int dosage;
};

// Derived class for a Syrup
class Syrup : public Medicine {
public:
    Syrup(const string& name, double price, const string& flavor) : Medicine(name, price), flavor(flavor) {}

    void displayInfo() const override {
        cout << "Syrup: " << name << "\nPrice: $" << price << "\nFlavor: " << flavor << "\n";
    }

private:
    string flavor;
};

// Pharmacy class that manages a list of medicines
class Pharmacy {
public:
    void addMedicine(Medicine* med) {
        medicines.push_back(med);
    }

    void displayMedicines() const {
        cout << "Medicine List:\n";
        for (const auto& med : medicines) {
            med->displayInfo();
            cout << "------------------------\n";
        }
    }

private:
    vector<Medicine*> medicines;
};

int main() {
    // Creating instances of medicines
    Tablet tablet1("Paracetamol", 5.99, 500);
    Syrup syrup1("Cough Syrup", 8.49, "Cherry");

    // Creating a Pharmacy and adding medicines to it
    Pharmacy pharmacy;
    pharmacy.addMedicine(&tablet1);
    pharmacy.addMedicine(&syrup1);

    // Displaying the information of medicines
    pharmacy.displayMedicines();

    return 0;
}
