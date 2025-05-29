# DELI-cious 🥪

A comprehensive Java console application for managing a delicatessen ordering system. Build custom sandwiches, add drinks and chips, and generate detailed receipts for your customers.

## Features

### 🥪 Sandwich Customization
- **Multiple bread types**: White, Wheat, Rye, Wrap
- **Three sizes**: 4", 8", 12" with size-based pricing
- **Premium meats**: Steak, Ham, Salami, Roast Beef, Chicken, Bacon
- **Cheese selection**: American, Provolone, Cheddar, Swiss
- **Fresh toppings**: Lettuce, Peppers, Onions, Tomatoes, Jalapeños, Cucumbers, Pickles, Guacamole, Mushrooms
- **Sauce variety**: Mayo, Mustard, Ketchup, Ranch, Thousand Islands, Vinaigrette
- **Toasted option**: Choose to have your sandwich toasted

### 🥤 Beverages & Sides
- **Drinks**: Small ($2.00), Medium ($2.50), Large ($3.00) with custom flavors
- **Chips**: Flat rate $1.50 with custom types

### 📋 Order Management
- Add multiple items to a single order
- Real-time order summary with itemized pricing
- Order confirmation system
- Automatic receipt generation with timestamps

### 📄 Receipt System
- Automatically saves receipts to `receipts/` directory
- Timestamped file names (format: `YYYYMMDD-HHMMSS.txt`)
- Detailed order breakdown with individual item pricing
- Professional receipt formatting

## Usage Guide

### Starting a New Order
1. Launch the application
2. Select "1) New Order" from the home screen
3. Choose from the order options:
   - Add Sandwich
   - Add Drink
   - Add Chips
   - Checkout
   - Cancel Order

### Building a Sandwich
1. Select bread type and size
2. Add meats (with optional extra portions)
3. Add cheeses (with optional extra portions)
4. Choose regular toppings (free)
5. Select sauces (free)
6. Decide if you want it toasted

### Completing Your Order
1. Review your order summary
2. Confirm the total price
3. Approve the order to generate a receipt
4. Receipt is automatically saved to the `receipts/` folder

## Pricing Structure

### Sandwich Base Prices
- 4" sandwich: $5.50
- 8" sandwich: $7.00
- 12" sandwich: $8.50

### Premium Add-ons

#### Meat Pricing
| Size | Base Price | Extra Price |
|------|------------|-------------|
| 4"   | $1.00      | +$0.50      |
| 8"   | $2.00      | +$1.00      |
| 12"  | $3.00      | +$1.50      |

#### Cheese Pricing
| Size | Base Price | Extra Price |
|------|------------|-------------|
| 4"   | $0.75      | +$0.30      |
| 8"   | $1.50      | +$0.60      |
| 12"  | $2.25      | +$0.90      |

### Other Items
- **Drinks**: $2.00 (Small), $2.50 (Medium), $3.00 (Large)
- **Chips**: $1.50 (all types)
- **Regular toppings and sauces**: Free

## Project Structure

```
DeliApp.java
├── DeliApp (Main Application Class)
├── OrderItem (Interface)
├── Order (Order Management)
├── Sandwich (Sandwich Builder)
├── Drink (Beverage Class)
├── Chips (Side Item Class)
├── Enums:
│   ├── BreadType
│   ├── SandwichSize
│   ├── MeatType
│   ├── CheeseType
│   ├── RegularTopping
│   ├── SauceType
│   └── DrinkSize
└── Premium Topping Classes:
    ├── MeatTopping
    └── CheeseTopping
```

## Technical Highlights

### Design Patterns Used
- **Strategy Pattern**: Different pricing strategies for different sandwich sizes
- **Builder Pattern**: Step-by-step sandwich construction
- **Interface Implementation**: Common `OrderItem` interface for all orderable items

### Key Features
- **Type Safety**: Extensive use of enums to prevent invalid input
- **Dynamic Pricing**: Size-based pricing calculations for premium toppings
- **File I/O**: Automatic receipt generation with error handling
- **Input Validation**: Robust user input handling with error recovery
- **Memory Management**: Efficient use of collections and stream operations

## File Output

Receipts are saved in the following format:
```
DELI-cious Receipt
Date: 2025-05-29 14:30:15
=====================================
12" White Sandwich
  Meats: Steak, Ham (extra)
  Cheeses: Provolone
  Toppings: Lettuce, Tomatoes, Onions
  Sauces: Mayo, Mustard
  (Toasted) - $12.00
Large Coke Drink - $3.00
Lays Chips - $1.50
=====================================
Total: $16.50
=====================================
Thank you for your business!
```
Interesting Code Highlight 🔍
One of the most interesting aspects of your code is the dynamic pricing system for premium toppings. Here's the clever implementation:

public double getPrice(SandwichSize size) {
    double basePrice = 0;
    double extraPrice = 0;
    
    switch (size) {
        case FOUR_INCH:
            basePrice = 1.00;
            extraPrice = 0.50;
            break;
        case EIGHT_INCH:
            basePrice = 2.00;
            extraPrice = 1.00;
            break;
        case TWELVE_INCH:
            basePrice = 3.00;
            extraPrice = 1.50;
            break;
    }
    
    return basePrice + (extra ? extraPrice : 0);
}

Why this is interesting:

Context-Aware Pricing: The same topping (like steak) costs different amounts based on sandwich size, which mirrors real-world deli pricing
Flexible Extra Portions: The boolean extra flag allows customers to get extra meat/cheese for an additional cost
Scalable Design: Adding new sizes only requires updating the switch statement
Business Logic Separation: Pricing logic is encapsulated in the topping classes rather than scattered throughout the application
