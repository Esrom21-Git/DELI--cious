# 🥪 DELI-cious Point of Sales System

A robust Java-based Point of Sales application for a custom sandwich shop, implementing comprehensive Object-Oriented Programming principles.

## 📋 Table of Contents
- [Features](#features)
- [System Requirements](#system-requirements)
- [Installation & Setup](#installation--setup)
- [File Structure](#file-structure)
- [How to Use](#how-to-use)
- [Pricing Structure](#pricing-structure)
- [Technical Implementation](#technical-implementation)
- [Future Enhancements](#future-enhancements)
- [Screenshots](#screenshots)

## ✨ Features

### Core Functionality
- **Complete Order Management**: Create, modify, and process customer orders
- **Sandwich Customization**: Full sandwich builder with bread, size, toppings, and extras
- **Multiple Item Types**: Sandwiches, drinks, and chips support
- **Dynamic Pricing**: Automatic price calculation based on size and premium toppings
- **Receipt Generation**: Automated receipt creation with timestamps
- **Input Validation**: Robust error handling and user input validation

### Technical Features
- **Object-Oriented Design**: Proper use of classes, interfaces, inheritance, and polymorphism
- **Type Safety**: Extensive use of enums for menu options
- **File I/O Operations**: Automatic receipt saving with organized file structure
- **Memory Management**: Efficient use of collections and data structures
- **Modular Architecture**: Clean separation of concerns across multiple files

## 🔧 System Requirements

- **Java Version**: Java 8 or higher
- **Operating System**: Windows, macOS, or Linux
- **Memory**: Minimum 256MB RAM
- **Storage**: 50MB free space for application and receipts

## 🚀 Installation & Setup

### Step 1: Clone or Download
```bash
# If using Git
git clone <repository-url>
cd deli-pos-system

# Or download and extract the ZIP file
```

### Step 2: Compile the Application
```bash
# Compile all Java files
javac *.java

# Verify compilation (should show .class files)
ls *.class
```

### Step 3: Run the Application
```bash
# Start the POS system
java DeliApp
```

### Step 4: First Run Setup
- The application will automatically create a `receipts/` folder
- No additional configuration required

## 📁 File Structure

```
DELI-cious-POS/
│
├── DeliApp.java          # Main application & user interface
├── DeliModels.java       # Business logic & data models
├── DeliEnums.java        # Enums & constants
├── README.md             # Documentation (this file)
├── SignatureSandwiches.java  # Bonus feature implementation
│
└── receipts/             # Auto-generated receipt storage
    ├── 20231215-143022.txt
    ├── 20231215-144135.txt
    └── ...
```

## 🎯 How to Use

### Starting the Application
1. Run `java DeliApp`
2. You'll see the welcome screen with main menu options

### Creating an Order
1. Select "1) New Order" from the home screen
2. Choose from the order menu:
   - **Add Sandwich**: Build custom sandwiches step-by-step
   - **Add Drink**: Select size and flavor
   - **Add Chips**: Choose chip type
   - **Checkout**: Review and confirm order

### Building a Sandwich
1. **Select Bread**: White, Wheat, Rye, or Wrap
2. **Choose Size**: 4", 8", or 12"
3. **Add Meats**: Premium toppings with extra options
4. **Add Cheese**: Premium toppings with extra options
5. **Add Toppings**: Free regular toppings
6. **Add Sauces**: Free sauce options
7. **Toasted Option**: Yes or No

### Completing an Order
1. Review your order summary
2. Confirm the total price
3. Confirm or cancel the order
4. Receipt automatically saved to `receipts/` folder

## 💰 Pricing Structure

### Sandwich Base Prices
| Size | Price |
|------|-------|
| 4"   | $5.50 |
| 8"   | $7.00 |
| 12"  | $8.50 |

### Premium Toppings

#### Meats
| Size | Regular | Extra |
|------|---------|-------|
| 4"   | $1.00   | +$0.50|
| 8"   | $2.00   | +$1.00|
| 12"  | $3.00   | +$1.50|

#### Cheese
| Size | Regular | Extra |
|------|---------|-------|
| 4"   | $0.75   | +$0.30|
| 8"   | $1.50   | +$0.60|
| 12"  | $2.25   | +$0.90|

### Other Items
- **Regular Toppings**: FREE (lettuce, tomatoes, onions, etc.)
- **Sauces**: FREE (mayo, mustard, ranch, etc.)
- **Drinks**: Small ($2.00), Medium ($2.50), Large ($3.00)
- **Chips**: $1.50 (all types)

## 🛠 Technical Implementation

### Object-Oriented Principles Used

#### Encapsulation
- Private fields with public methods for controlled access
- Data hiding in all model classes

#### Inheritance
- `OrderItem` interface implemented by `Sandwich`, `Drink`, and `Chips`
- Common behavior defined in interface

#### Polymorphism
- Different item types handled uniformly through `OrderItem` interface
- Method overriding for specific item behaviors

#### Abstraction
- Interface defines contract without implementation details
- Complex pricing logic abstracted in individual classes

### Design Patterns
- **Strategy Pattern**: Different pricing strategies for different item types
- **Builder Pattern**: Step-by-step sandwich construction
- **Factory Pattern**: Order item creation

### Data Structures Used
- `ArrayList<>` for dynamic item storage
- `enum` types for type-safe menu options
- `StringBuilder` for efficient string building

## 🔮 Future Enhancements

### Planned Features
- **Signature Sandwiches**: Pre-configured sandwich templates
- **Customer Management**: Customer profiles and order history
- **Inventory Tracking**: Real-time ingredient availability
- **Online Ordering**: Web interface integration
- **Payment Processing**: Multiple payment method support
- **Reporting System**: Sales analytics and reporting

### Technical Improvements
- **Database Integration**: Persistent data storage
- **GUI Interface**: Swing or JavaFX user interface
- **Multi-threading**: Concurrent order processing
- **API Development**: RESTful service endpoints
- **Unit Testing**: Comprehensive test coverage

## 📸 Screenshots

### Home Screen
```
=== DELI-cious Home ===
1) New Order
0) Exit
Please choose an option:
```

### Order Screen
```
=== Order Screen ===
1) Add Sandwich
2) Add Drink
3) Add Chips
4) Checkout
0) Cancel Order
Please choose an option:
```

### Sample Receipt
```
DELI-cious Receipt
Date: 2023-12-15 14:30:22
=====================================
Large Pepsi Drink - $3.00
8" White Sandwich
  Meats: Steak, Bacon (extra)
  Cheeses: Cheddar
  Toppings: Lettuce, Tomatoes, Onions
  Sauces: Mayo, Ranch
  (Toasted) - $12.50
Doritos Chips - $1.50
Total: $17.00
=====================================
Thank you for your business!
```


