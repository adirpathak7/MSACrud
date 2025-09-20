//
//# Custom Exception for Salary Restriction
//class SalaryTooLowException(Exception):
//    def __init__(self, message="Salary too low to view car details."):
//        super().__init__(message)
//
//
//# Car Class (Encapsulation)
//class Car:
//    def __init__(self, brand, model, price, fuel_type, transmission, color):
//        self.__brand = brand
//        self.__model = model
//        self.__price = price
//        self.__fuel_type = fuel_type
//        self.__transmission = transmission
//        self.__color = color
//
//    def get_model(self):
//        return self.__model
//
//    def display_details(self, salary):
//        if salary < 100000:   # Salary-based access control
//            raise SalaryTooLowException()
//        return (f"Brand: {self.__brand}, Model: {self.__model}, Price: ₹{self.__price}, "
//                f"Fuel: {self.__fuel_type}, Transmission: {self.__transmission}, Color: {self.__color}")
//
//
//# Showroom Class (Inheritance used later if needed)
//class Showroom:
//    def __init__(self):
//        self.inventory = []   # Store Car objects
//
//    def add_car(self, car):
//        self.inventory.append(car)
//        print(f"{car.get_model()} added to showroom.")
//
//    def remove_car(self, model):
//        for car in self.inventory:
//            if car.get_model().lower() == model.lower():
//                self.inventory.remove(car)
//                print(f"{model} sold and removed from showroom.")
//                return
//        print("Car not found in inventory!")
//
//    def view_available_cars(self):
//        if not self.inventory:
//            print("No cars available in showroom.")
//        else:
//            print("\nAvailable Cars:")
//            for car in self.inventory:
//                print(f"- {car.get_model()}")
//
//    def display_car_details(self, model, salary):
//        for car in self.inventory:
//            if car.get_model().lower() == model.lower():
//                try:
//                    print(car.display_details(salary))
//                except SalaryTooLowException as e:
//                    print(f"Access Denied: {e}")
//                return
//        print("Car not found in showroom!")
//
//
//# ---------------- MAIN PROGRAM ----------------
//def main():
//    showroom = Showroom()
//
//    # Pre-loaded cars
//    showroom.add_car(Car("Toyota", "Innova", 1500000, "Diesel", "Manual", "White"))
//    showroom.add_car(Car("Honda", "City", 1200000, "Petrol", "Automatic", "Black"))
//    showroom.add_car(Car("Tata", "Nexon", 900000, "Petrol", "Manual", "Blue"))
//
//    while True:
//        print("\n----- Car Showroom Menu -----")
//        print("1. View Available Cars")
//        print("2. Display Car Details")
//        print("3. Sell a Car")
//        print("4. Buy a Car")
//        print("5. Exit")
//
//        choice = input("Enter your choice: ")
//
//        if choice == "1":
//            showroom.view_available_cars()
//
//        elif choice == "2":
//            model = input("Enter model name: ")
//            salary = int(input("Enter your salary: "))
//            showroom.display_car_details(model, salary)
//
//        elif choice == "3":
//            model = input("Enter model name to sell: ")
//            showroom.remove_car(model)
//
//        elif choice == "4":
//            brand = input("Enter brand: ")
//            model = input("Enter model: ")
//            price = int(input("Enter price: "))
//            fuel = input("Enter fuel type: ")
//            transmission = input("Enter transmission: ")
//            color = input("Enter color: ")
//            showroom.add_car(Car(brand, model, price, fuel, transmission, color))
//
//        elif choice == "5":
//            print("Exiting Showroom System. Thank you!")
//            break
//        else:
//            print("Invalid choice. Please try again.")
//
//
//# Run program
//if __name__ == "__main__":
//    main()
//Innova added to showroom.
//City added to showroom.
//Nexon added to showroom.
//
//----- Car Showroom Menu -----
//1. View Available Cars
//2. Display Car Details
//3. Sell a Car
//4. Buy a Car
//5. Exit
//Available Cars:
//- Innova
//- City
//- Nexon
//
//----- Car Showroom Menu -----
//1. View Available Cars
//2. Display Car Details
//3. Sell a Car
//4. Buy a Car
//5. Exit
//Access Denied: Salary too low to view car details.
//
//----- Car Showroom Menu -----
//1. View Available Cars
//2. Display Car Details
//3. Sell a Car
//4. Buy a Car
//5. Exit
//Nexon sold and removed from showroom.
//
//----- Car Showroom Menu -----
//1. View Available Cars
//2. Display Car Details
//3. Sell a Car
//4. Buy a Car
//5. Exit
//Available Cars:
//- Innova
//- City
//
//----- Car Showroom Menu -----
//1. View Available Cars
//2. Display Car Details
//3. Sell a Car
//4. Buy a Car
//5. Exit
// 
// "nbformat": 4,
// "nbformat_minor": 5
//}
//
//
//📂 File Handling in Python
//1. File Open karna
//# syntax: open("filename", "mode")
//# modes: "r" = read, "w" = write, "a" = append, "x" = create, "b" = binary
//f = open("demo.txt", "r")   # read mode
//
//2. File me Likhna (Write)
//f = open("demo.txt", "w")   # "w" = purani file delete karke naya likhega
//f.write("Hello World\n")
//f.write("Python me file handling easy h.")
//f.close()
//
//3. File me Add karna (Append)
//f = open("demo.txt", "a")   # "a" = purane data ko delete nahi karega
//f.write("\nNew line added.")
//f.close()
//
//4. File Read karna
//f = open("demo.txt", "r")
//print(f.read())       # pura file ek sath read
//f.close()
//
//
//👉 Sirf kuch characters read karna:
//
//f = open("demo.txt", "r")
//print(f.read(10))     # sirf 10 characters
//f.close()
//
//
//👉 Line by line read karna:
//
//f = open("demo.txt", "r")
//print(f.readline())   # pehli line
//print(f.readline())   # dusri line
//f.close()
//
//
//👉 Loop me read karna:
//
//f = open("demo.txt", "r")
//for line in f:
//    print(line.strip())
//f.close()
//
//5. with open (Best practice ✅)
//
//with open use karne se close() karna nahi padta.
//
//with open("demo.txt", "r") as f:
//    data = f.read()
//    print(data)
//
//6. File Delete karna
//import os
//
//if os.path.exists("demo.txt"):
//    os.remove("demo.txt")
//    print("File deleted ✅")
//else:
//    print("File not found ❌")
//
//🔑 Important Points (yaad rakhne ke liye)
//
//"r" → read mode (default)
//
//"w" → write mode (purana data mita ke naya likhega)
//
//"a" → append mode (purane data me add karega)
//
//"x" → create new file (agar file pehle se hai to error dega)
//
//"b" → binary mode (image, pdf, etc ke liye)
//
//with open(...) use karna best practice hai