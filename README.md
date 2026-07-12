# ☕ Java Journey

Learning Java from scratch — daily code, concepts, and progress tracked here.

This repository documents my hands-on Java learning journey through a structured coaching program. Every concept is learned by writing code, making mistakes, debugging, and iterating.

---

## 📁 Repository Structure

| Folder | Topic | Highlights |
|--------|-------|------------|
| `Day1_HelloWorld` | First Java programs | Hello World, command-line arguments calculator |
| `Day2_Literals_Identifiers_keywords` | Java building blocks | Literals, identifiers, keywords |
| `Day3_DataTypes` | Data types | Primitives, ranges, type behavior |
| `Day4_Variables` | Variables | Declaration, initialization, scope |
| `Day5_Operators` | Operators | Arithmetic, relational, logical + real-world tasks (Bonus Calculator, Movie Ticket Pricing) |
| `IfElse_Practice` | Conditional statements | Menu-driven program with 17 practice problems |
| `PracticeTest` | Mixed practice | Various programs combining learned concepts |

---

## 🎯 IfElse_Practice — 17 Problems

A single menu-driven program covering:

- Number checks (equal, even/odd, positive/negative)
- Leap year (nested conditions)
- Voting eligibility, height categorization
- Largest of three (with tie handling)
- Quadratic equation roots (with discriminant)
- Student result & grade calculator (with input validation)
- Temperature messages, triangle classification & validity
- Character type, vowel/consonant detection
- Profit/loss calculator, max/min, square check

---

## 🐛 Key Lessons Learned (The Hard Way)

Real bugs I hit and fixed — documented so I never repeat them:

- **Integer division trap**: `int / int` always gives `int` — use `100.0`, `2f`, or explicit cast
- **Scanner buffer**: `nextLine()` after `nextInt()` picks up leftover `\n` — clear the buffer first
- **Operator precedence**: `-b / 2 * a` ≠ `-b / (2 * a)` — parentheses matter
- **`=` vs `==`**: assignment inside a condition compiles but breaks logic
- **Stray semicolon**: `if (x > 5);` creates an empty body — silent logic killer
- **Strict `>` vs `>=`**: "at least 2 years" means `>=`, and ties need special handling
- **De Morgan's Law**: negating `A && B` gives `!A || !B` — used in triangle validity
- **Early `return`**: exit a method immediately on invalid input (guard clauses)
- **ASCII gaps**: characters 91–96 sit between 'Z' and 'a' — never assume a continuous letter range

---

## 🛠️ Tools & Setup

- **Language**: Java 17
- **IDE**: Eclipse (with auto-compile on save)
- **Version Control**: Git + GitHub (commits via Eclipse & command line)
- **OS**: Windows

---

## 🔄 Daily Workflow

1. Learn concept in coaching class
2. Write code independently in Eclipse
3. Debug through iterative review cycles
4. Commit with meaningful messages
5. Push to GitHub

```bash
git add .
git commit -m "Meaningful message about what changed"
git push origin main
```

---

## 🚧 Up Next

- [ ] Switch statements
- [ ] Loops (for, while, do-while)
- [ ] Arrays
- [ ] Object-Oriented Programming

---

*This repo is a living document — it grows as I learn.* 🌱
