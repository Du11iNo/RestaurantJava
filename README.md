**Restaurant Management System**

**Team Information**

* **Course**: Object-Oriented Programming
* **Project Type:** Sprint 2 – OOP Principles, Inheritance, Exception Handling, File I/O
* **Team Size**: 3 members
* **Submission Date**: December 16
* **Team Members:** Anja Balliu , Julian Rumi , Florian Rumi

### **Project Goal**

Sprint 2 builds upon Sprint 1 by applying **advanced Object-Oriented Programming (OOP) principles** to enhance system flexibility, maintainability, and robustness.

The main objectives include:

* Implementing **inheritance** and **polymorphism** to manage related entities efficiently.

* Using **abstract classes** to centralize shared behavior and enforce design consistency.

* Applying **exception handling** to ensure the system remains stable and user-friendly under unexpected situations.

* Introducing **File I/O** mechanisms for persistent storage, enabling data retention between application sessions.

This sprint transforms the Restaurant Management System from a basic object-based application into a **structured, extensible, and professional-grade OOP solution**, preparing the system for future enhancements such as reporting, advanced billing, and user role management.

**2\. Key Functionalities (Sprint 2 Scope)**

**1\. Inheritance & Polymorphism**

**Abstract Employee Class:**

The Employee class serves as an **abstract superclass** encapsulating attributes common to all types of employees, such as employee ID, name, birthdate, date of start, and paycheck. It defines abstract methods for paycheck calculation and employee detail display. By centralizing shared behavior, code duplication is minimized, and maintenance becomes easier.

**Specialized Subclasses:**

* **Chef:** A specialized employee role with a qualification level that affects paycheck calculation. Chefs can have various levels of experience, which are reflected in their compensation.

* **Waiter:** Includes a bonus component in paycheck calculation to reward performance. Waiters interact with tables and orders, making their role dynamic.

* **Cleaner:** Uses a base salary calculation and maintains restaurant hygiene standards.

**Polymorphic Behavior:**

Employees are managed through references to the abstract Employee class. When the system invokes paycheck calculation or detail display, the correct subclass method executes at runtime. This **dynamic method dispatch** demonstrates true polymorphism and allows the system to handle employees uniformly while respecting their specific behaviors.

**Advantages of this Approach:**

* Code reuse and reduced duplication

* Easier extension when adding new employee types

* Improved maintainability and readability

* Simplified management of diverse employee operations

**2\. Exception Handling Strategy**

To enhance system reliability, **exception handling is integrated across all critical operations**.

**Design Principles:**

* Methods that interact with files, parse user input, or manipulate collections are protected using **try-catch blocks**.

* A centralized utility, ExceptionHandler, ensures consistent error reporting and logging.

* The system provides **informative messages** to the user while preventing crashes.

**Common Scenarios Handled:**

* Missing data files, which may occur if a file is deleted or not created during system setup

* Invalid user input, such as entering text when a number is expected

* General input/output errors, including read/write failures due to system or hardware issues

**Benefits:**

* Ensures application stability under unexpected conditions

* Provides clear feedback for corrective action

* Facilitates easier debugging and maintenance

**3\. File I/O Integration**

**Persistent Data:**

Sprint 2 introduces data persistence for:

* **Employees:** Each employee’s role-specific attributes, including bonuses and qualifications, are stored externally.

* **Menu Items:** Product names, prices, and additional attributes are stored for reliable retrieval.

**File Handling Architecture:**

* A dedicated FileHandler class manages reading from and writing to files.

* High-level classes, such as Restaurant and Menu, delegate persistence responsibilities to the FileHandler, ensuring separation of concerns.

**System Integration:**

* At system startup, employees and menu items are loaded from their respective files, ensuring that all previously stored data is available.

* Whenever employees or menu items are added, removed, or updated, changes are automatically written back to the files.

**Advantages of File I/O:**

* Data consistency across application sessions

* Ability to recover from unexpected shutdowns

* Simplified system deployment without reliance on databases for Sprint 2


**3.Requirements Brief (User Actions → Entities)**

| User Action | Entities | Notes / Relationships |
| :---- | :---- | :---- |
| User Action | Entities | Notes / Relationships |
| Add employee | Restaurant, Employee | Uses polymorphism to add subclass instances. |
| Calculate paycheck | Employee, Chef, Waiter, Cleaner | Resolved dynamically at runtime. |
| Load employees | Restaurant, FileHandler | Reads employee data from file. |
| Save employees | Restaurant, FileHandler | Writes employee data to file. |
| Load menu | Menu, FileHandler | Reads menu items from file. |
| Save menu | Menu, FileHandler | Writes menu items to file. |
| Handle errors | ExceptionHandler | Centralized exception printing. |

**4\. Extended Functionalities (Sprint 2 Scope)**

| Module | Features Introduced |
| :---- | :---- |
| Employee Management | Inheritance-based roles, role-specific paycheck calculation, persistent storage |
| Menu Management | Persistent storage, validation for duplicates and invalid entries |
| Table & Order Handling | Orders linked to valid menu items, receipt generation, table state updates |
| Financial Operations | Cash register, earnings calculation, paycheck distribution |

**Details:**

* **Employee Management:** Employees are categorized into distinct types with specialized responsibilities, making management modular and scalable.

* **Menu Management:** The menu supports persistent storage and validation, ensuring accurate operations and preventing data corruption.

* **Table & Order Handling:** Orders are linked to valid menu items; the system updates table states automatically.

* **Financial Operations:** Earnings are calculated accurately, and paychecks are distributed according to role-specific rules, using polymorphic operations.

**5\. Sprint 2 Outcome**

By the end of Sprint 2, the system:

* Demonstrates correct use of **inheritance, abstraction, and polymorphism**

* Handles runtime errors gracefully through **exception handling**

* Persists data reliably using **File I/O** mechanisms

* Is scalable, maintainable, and ready for future extensions (such as advanced reporting, billing, and user roles)

* Follows **clean code practices** and professional OOP design principles

**Rubric Alignment:**

| Category | How Sprint 2 Meets Criteria |
| :---- | :---- |
| Project Defense | Team can explain inheritance, polymorphism, and exception handling |
| Design & Implementation | Abstract Employee class, specialized subclasses, clear modular structure |
| Exception Handling & File I/O | Exceptions handled gracefully; persistent storage implemented |
| Code Quality & Documentation | Proper encapsulation and professional documentation; consistent style |

