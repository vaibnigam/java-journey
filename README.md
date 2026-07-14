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
| `ControlFlow` | Switch statements & jumping statements | Menu-driven program with 12 switch-case problems, break/continue/return |
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

## 🎯 SwitchCase_Practice — 12 Problems

Same menu-driven structure as `IfElse_Practice`, this time solved using `switch`:
- Day of week / month name lookup
- Grade calculator using switch instead of if-else chains
- Simple calculator (arithmetic operations on switch)
- Season identifier based on month
- Vowel/consonant check using switch
- Menu-driven cases grouped with intentional fall-through (empty cases)
- Traffic signal / direction-based problems
- Default case handling for invalid input

Also covers jumping statements (`break`, `continue`, `return`) as used inside switch and loops.

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
- **Switch fall-through**: forgetting `break` silently runs into the next case — but empty cases without `break` are also a legit way to group multiple labels for the same logic
- **Switch case labels must be compile-time constants**: no ranges, no variables — if the check needs a range, switch is the wrong tool
- **String comparison in switch/if**: always `.equals()`, never `==`, or the match silently fails

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

- [x] Switch statements
- [ ] Loops (for, while, do-while)
- [ ] Arrays
- [ ] Object-Oriented Programming

---

*This repo is a living document — it grows as I learn.* 🌱