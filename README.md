# FitApp — Fitness Management System

> Object-Oriented Programming project (POO) · University of Minho · 2023/2024

A Java console application for managing users, workout plans, and physical activities, with calorie tracking and user statistics.

---

## Features

- **User registration** with three profile types:
  - `Amador` — casual fitness enthusiast
  - `PraticanteOcasional` — occasional practitioner
  - `Profissional` — professional athlete
- **Activity logging** — supports distance-based (`Distancia`) and repetition-based (`Repeticoes`) activities
- **Workout plans** — create and assign training plans to users
- **Calorie statistics** — compute calories burned per activity and per plan
- **Persistent state** — save and load application state via Java serialization (`Info.obj`)

---

## Architecture

The project follows the **MVC (Model-View-Controller)** pattern:

```
src/
├── Main.java                  # Entry point
├── Controlador.java           # Controller — orchestrates model and view
├── Modelo.java                # Model — business logic and data
├── Menu.java                  # View — console menus and input
│
├── Utilizador.java            # Base user class
├── Amador.java                # User subtype: Amateur
├── PraticanteOcasional.java   # User subtype: Occasional Practitioner
├── Profissional.java          # User subtype: Professional
│
├── Atividade.java             # Base activity class
├── Distancia.java             # Activity subtype: Distance-based
├── Repeticoes.java            # Activity subtype: Repetition-based
│
├── PlanoTreino.java           # Workout plan
└── Estatistica.java           # Statistics and calorie computation
```

---

## How to Run

**Requirements:** Java 11+

```bash
# Clone the repository
git clone https://github.com/tomasmeireles22/POO.git
cd POO

# Compile
javac src/*.java -d out/

# Run
java -cp out/ Main
```

> On first run, no saved state exists. Use the menu to register users and create workout plans, then save with option 4.

---

## OOP Concepts Applied

- **Inheritance** — `Utilizador` → `Amador`, `PraticanteOcasional`, `Profissional`
- **Polymorphism** — activity types share a common `Atividade` interface with different calorie calculations
- **Encapsulation** — all fields private with getter/setter access
- **Serialization** — full application state persisted via `ObjectOutputStream`
- **MVC pattern** — clean separation between data, logic, and presentation

---

*Developed as part of the Object-Oriented Programming (POO) course.*
