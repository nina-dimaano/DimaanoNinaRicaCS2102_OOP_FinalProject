# KnowTify: Your Personal Learning Companion

---

![KnowTify Logo](https://via.placeholder.com/800x200?text=KnowTify+Logo)

## **Project Overview**
**KnowTify** is a Java-based application designed to help students streamline their academic life. It integrates advanced object-oriented programming (OOP) principles to create a cohesive, modular system for managing tasks, schedules, and subjects. The application empowers students by offering task analysis, time management recommendations, and a structured way to organize their academic responsibilities.

### **Key Features**:
- Manage and analyze tasks with due dates, complexity levels, and recommended daily prep times.
- Organize and view detailed class schedules that automatically changes based on the day.
- Seamlessly handle register and login processes.
- Navigate a dynamic dashboard tailored to student needs.
- Subject analysis function that customizes study times based on the complexity of the material.
- Profile system that tracks individual study problems and suggests appropriate study method.

---

## **Object-Oriented Programming (OOP) Principles**
### **1. Abstraction**
The **Manager** class is an abstract class that provides a unified interface for managing different entities, such as tasks and subjects. Each subclass, such as **TaskManager** and **SubjectManager**, implements specific behaviors while hiding the implementation details from the user. Additionally, helper methods like `ordinalSuffix()` abstract complex logic for formatting user inputs.

### **2. Inheritance**
Core functionality is reused across the application by extending abstract classes. For instance, **SubjectManager** and **TaskManager** inherit methods and attributes from the **Manager** superclass, reducing code redundancy and enhancing scalability. Similarly, **ConcreteUser** extends the **User** class to implement specific functionality for login and registration processes.

### **3. Polymorphism**
The **Manager** class allows its subclasses to override methods like `addItem()` and `viewItems()`. This ensures that each manager (e.g., TaskManager) behaves differently based on its specific requirements while adhering to the same method signature. Polymorphism is also evident in the handling of input validation and user interaction methods across different manager classes.

### **4. Encapsulation**
Classes like **User** and **Dashboard** encapsulate their data, ensuring that sensitive information (e.g., login credentials) is accessed only through controlled methods, maintaining data integrity and security. Methods such as `addItem()` and `getDayOfWeekString()` ensure that only valid inputs are processed, shielding internal data structures from corruption.

---

## **Supporting Sustainable Development Goal (SDG 4: Quality Education)**
**KnowTify** directly aligns with the United Nations' Sustainable Development Goal 4, which focuses on ensuring inclusive and equitable quality education for all. By providing students with an efficient system to manage their studies, KnowTify:
- Promotes effective learning habits.
- Helps students keep track of school works and deadlines.
- Reduces stress associated with disorganized schedules.
- Empowers students to achieve academic success, contributing to lifelong learning opportunities.

---

## **Running the Application**
### **Requirements**
- **Java Development Kit (JDK)** version 11 or higher.
- A code editor or IDE (e.g., IntelliJ IDEA, Eclipse, or Visual Studio Code).
- Git (for cloning the repository).

### **Setup Instructions**
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/YourUsername/KnowTify.git
   cd KnowTify
   ```

2. **Compile the Code**:
   Use your preferred IDE or run the following command in the terminal:
   ```bash
   javac -d bin src/*.java
   ```

3. **Run the Application**:
   Execute the main class from the compiled `bin` directory:
   ```bash
   java -cp bin Main
   ```

4. **Interact with the Application**:
   Follow the on-screen instructions to explore the various features of KnowTify, such as managing tasks and subjects.

---

## **File Structure**
```
KnowTify/
├── src/
│   ├── Main.java
│   ├── User.java
│   ├── ConcreteUser.java
│   ├── Dashboard.java
│   ├── Manager.java
│   ├── SubjectManager.java
│   ├── TaskManager.java
│   └── StyleAppName.java
├── bin/
│   └── [Compiled Files]
├── README.md
└── LICENSE
```

---

![Footer Graphic](https://via.placeholder.com/800x100?text=Achieve+More+with+KnowTify)
