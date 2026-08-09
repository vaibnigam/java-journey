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
| `Loops_Practice` | for, while, do-while | Loop variants, nested loops, pattern printing, labeled break/continue |
| `Arrays` | Arrays | 1D & 2D arrays, matrix operations (`ArrayHW`, `ArrayPractice`, `MatrixPractice`) |
| `String` | Strings & Regex | Core String methods, StringBuilder, StringTokenizer, regex basics (`StringHW`, `RegexHW`, `RegexNegationDemo`, `RegexQues`, `EmailRegexDemo`) |
| `DateTime` | Date-Time API | `LocalDate`, `LocalDateTime`, `Period`, `Duration`, `DateTimeFormatter` (`DateTime.java`) |
| `Scanner_Practice` | Scanner class | Input handling across int/String/mixed reads |
| `Methods` | Methods | Overloading, overriding, static vs instance, generics, functional interfaces, method references, exception handling in methods |
| `Recursion_Practice` | Recursion | Recursive problem solving, base case / recursive case design |
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

## 🎯 Loops_Practice — for, while, do-while

Covers all three loop types and where each one actually fits:
- **for loop** — fixed number of iterations, counting problems, table generation, sum/factorial/reverse-number type programs
- **while loop** — condition-first, used where iteration count isn't known upfront (input-driven loops, digit extraction)
- **do-while loop** — body-first execution, used for menu-driven programs that must run at least once
- **Nested loops** — inner loop completing fully for every outer iteration, used for 2D traversal and pattern generation
- **Pattern printing** — number/star/character patterns using nested for loops (triangles, pyramids, diamonds, inverted patterns)
- **Labeled break/continue** — breaking or skipping a specific outer loop from inside a nested loop instead of just the innermost one
- **Loop-based collection traversal** — iterating over arrays/collections with for and enhanced-for
- Performance-oriented patterns — avoiding recomputation inside loop conditions

---

## 🎯 Arrays — ArrayHW, ArrayPractice, MatrixPractice

Covers 1D and 2D arrays using plain loop-based logic:
- **ArrayHW** — array declaration, initialization, traversal, basic operations (sum, max/min, search)
- **ArrayPractice** — array manipulation problems (reverse, sort-by-hand, frequency count, duplicates)
- **MatrixPractice** — 2D array operations: matrix traversal, row/column sum, transpose, matrix addition using nested loops

---

## 🎯 String — StringHW, RegexHW, RegexNegationDemo, RegexQues, EmailRegexDemo

Covers String as a class and regex-based validation:
- **StringHW** — core String methods (length, charAt, substring, indexOf, equals vs equalsIgnoreCase, concat), String immutability, String Pool behavior, StringBuilder for mutable strings, StringTokenizer and split() for tokenizing input
- **RegexHW** — regex basics, pattern matching using `matches()`
- **RegexNegationDemo** — negated character classes in regex (`[^...]`)
- **RegexQues** — regex-based practice problems
- **EmailRegexDemo** — real-world regex use case: validating email format

---

## 🎯 DateTime — Date-Time API

Covers `java.time` package for date/time handling:
- `LocalDate`, `LocalTime`, `LocalDateTime` — creation, extraction of parts
- `Period.between()` and `Duration.between()` for calculating gaps
- `plusDays()`, `minusMonths()` and similar methods — immutable date objects
- `DateTimeFormatter` — custom date formatting patterns
- `Instant` — UTC-based timestamp handling, relevant for database storage patterns

---

## 🎯 Scanner_Practice — Scanner class

Covers input handling using `java.util.Scanner`:
- Reading `int`, `double`, `String` inputs individually
- Mixed-type input reads (numbers followed by strings) and buffer handling
- Reading multiple values on a single line vs multiple lines
- Validating input before further processing

---

## 🎯 Methods — Overloading, Overriding, Static vs Instance, Generics, Functional Interfaces

Covers methods as a complete topic, not just syntax:
- Method declaration, parameters, return types, `void` methods
- **Overloading** — same method name, different parameter lists (compile-time)
- **Overriding** — subclass redefining a parent method (runtime, `@Override`)
- **Static vs Instance methods** — when each is appropriate, calling rules
- **Varargs** — variable-length argument methods
- **Generics in methods** — type-parameterized methods
- **Functional interfaces & method references** — lambda-compatible method design
- **Exception handling in methods** — throws, try-catch inside methods, propagation

---

## 🎯 Recursion_Practice — Recursion

Covers recursive problem solving:
- Base case and recursive case identification
- Classic recursion problems (factorial, Fibonacci, sum of digits, reverse)
- Recursion vs iteration — when recursion is the cleaner fit
- Stack behavior during recursive calls

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
- **while vs do-while**: picking `while` for a menu-driven program means the menu never shows on the first run unless the condition is pre-seeded — `do-while` avoids that entirely
- **Nested loop variable shadowing**: reusing the same loop variable name in nested loops doesn't compile — inner loop needs its own variable
- **Pattern printing off-by-one**: row/column boundaries in star patterns break easily if the inner loop condition uses `<` instead of `<=` (or vice versa) — always trace one row by hand first
- **Labeled break scope**: a label has to sit directly above the loop it targets — putting it in the wrong place either doesn't compile or breaks the wrong loop
- **Infinite loop from unchanged condition variable**: forgetting to update the loop variable inside a `while` (unlike `for`, where it's forced into the loop header) silently hangs the program
- **String Pool vs `new String()`**: two string literals with the same value point to the same Pool object, but `new String("x")` forces a separate heap object — `==` breaks silently here even when `.equals()` still works
- **StringBuilder vs String in loops**: concatenating in a loop with `+` creates a new String object every iteration — StringBuilder avoids that overhead
- **split() vs StringTokenizer**: `split()` takes a regex and can return empty strings for consecutive delimiters, StringTokenizer doesn't — mixing them up gives different array lengths for the same input
- **Regex escaping**: characters like `.` and `\` need to be escaped inside a regex pattern — an unescaped `.` matches any character, not a literal dot
- **Matrix row vs column confusion**: `matrix[i][j]` — mixing up which index is row and which is column silently gives wrong sums/transpose without throwing an error
- **`java.time` immutability**: `plusDays()`, `minusMonths()` etc. return a new object — calling them without reassigning the result leaves the original date unchanged
- **`Period.between(start, end)` argument order**: swapping start and end gives a negative period instead of throwing an error — easy to miss silently
- **`DateTimeFormatter` case sensitivity**: `M` (month) vs `m` (minute), `d` (day) vs `D` (day of year), `y` vs `Y` — using the wrong case parses/formats completely different values without an error
- **Top-level class access modifiers**: a top-level class can only be `public` or default (package-private) — `private`/`protected` on a top-level class doesn't compile
- **Overload resolution ambiguity**: symmetric widening (e.g. passing an `int` where both `long` and `float` overloads exist) can be ambiguous at compile time depending on exact match availability

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

*This repo is a living document — it grows as I learn.* 🌱