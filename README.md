# RiseJourney – Fawry Full Stack Internship Challenge

Welcome! This repository contains my solution for the **Fawry Rise Journey Full Stack Development Internship Challenge**. The project demonstrates my skills in designing robust, maintainable, and testable e-commerce systems using Java.

---

## 🚀 Project Overview

**Objective:**  
Develop an e-commerce system with the following features, as outlined in the Fawry internship challenge:

- Define products (name, price, quantity).
- Handle expirable products (e.g., Cheese, Biscuits) and non-expirable products (e.g., TV, Mobile).
- Support shippable products (with weight) and non-shippable products (e.g., Mobile scratch cards).
- Customers can add products to a cart (with quantity validation).
- Checkout process includes:
  - Printing checkout details (subtotal, shipping fees, paid amount, customer balance).
  - Error handling for empty carts, insufficient balance, out-of-stock, or expired products.
  - Shipping service integration for shippable items via a defined interface.

---

## 🏗️ Technical Approach

- **Language:** Java
- **OOP Principles:** Used interfaces and class inheritance for expirable and shippable products.
- **Input Validation:** Centralized validation of quantities, stock, expiration, and customer balance.
- **Extensibility:** Designed for easy addition of new product types and business rules.
- **Console Output:** Matches the format specified in the challenge PDF.

---

## 📦 Features

- Add products to cart with validation against current stock.
- Track product expiration and shippable items.
- Graceful error handling with clear messages.
- Shipping service processes all items needing shipment using an interface-based contract.
- Example usage and test scenarios included in code.

---

## 🧑‍💻 Example Usage

```java
Cheese cheese = new Cheese("Cheddar", 100, 200, LocalDate.of(2026, 1, 1), 400);
TV tv = new TV("Samsung TV", 5000, 1000, 1500);
ScratchCard scratchCard = new ScratchCard("Scratch Card", 50, 20);

Customer customer = new Customer("Bishoy", 10000);
Cart cart = new Cart();

cart.add(cheese, 2);
cart.add(tv, 1);
cart.add(scratchCard, 2);

CheckoutService.checkout(customer, cart);
```

**Sample Console Output:**
```
** Shipment notice **
2x Cheddar 400g
1x Samsung TV 1.5kg
Total package weight 2.3kg

** Checkout receipt **
2x Cheddar 200
1x Samsung TV 5000
2x Scratch Card 100
----------------------
Subtotal	5300
Shipping	30
Amount		5330
----------------------
Balance		4670
```

---

## 📝 Code Structure

- `models/` – Contains all product classes: `Product`, `Cheese`, `TV`, `ScratchCard`.
- `interfaces/` – Interfaces for `Shippable` and `Expirable` product types.
- `utils/` – Contains `InputValidator` for validation logic.
- `services/` – Contains `ShippingService` and `CheckoutService`.
- `Cart.java` – Manages the shopping cart logic.
- `Customer.java` – Represents a customer with balance management.
- `Main.java` – Entry point with usage example.
