Java CLI Task Manager (Layered Architecture)
A professional-grade, terminal-based Task Management System built with Java 17. This project demonstrates Clean Architecture principles, Data Persistence, and a strong Separation of Concerns.

📖 Overview
The goal of this project was to build a robust CRUD application that survives application restarts. By implementing a Model-Service-Repository pattern, the application separates user interaction from business logic and data storage.

🛠️ Key Technical Features
1. Persistent Data Layer
Unlike most basic CLI apps, this project includes a dedicated Persistence Layer.

Repository Pattern: The TaskRepository handles raw File I/O (reading/writing to tasks.txt).

Data Serialization: Implements custom parsing logic to map pipe-separated text (|) back into Java Objects.

2. Business Logic & Validation
The TaskService acts as the engine room of the application:

Unique ID Generation: Automatically calculates the next available ID based on existing data, ensuring integrity even if the file is modified manually.

Early Validation: The system validates task existence before prompting users for additional data, providing a smooth User Experience (UX).

Dependency Injection: The Service receives its Repository via the constructor, making the code decoupled and testable.

3. Modern Java Implementation
Switch Expressions: Utilizes Java 17 switch syntax for cleaner, more readable menu logic.

Robust Input Handling: Manages the Scanner buffer correctly to prevent common CLI input skipping bugs.

🏗️ Architecture Design
The project follows the Single Responsibility Principle:

Model: Defines the data structure (Task) and states (TaskStatus).

Repository: Manages the physical storage (tasks.txt).

Service: Handles logic (Adding, Updating, Deleting).

Main: The Controller/View that interacts with the user.

🚀 Getting Started
Prerequisites
Java 17 or higher

Installation & Execution
Clone the repository:

Bash
git clone https://github.com/YourUsername/TaskManager.git
Compile the project:

Bash
javac com/KarimAhmed/TaskManager/Main.java
Run the application:

Bash
java com.KarimAhmed.TaskManager.Main
🧠 Design Decisions
UI Independence: I intentionally excluded Scanner from the Service layer. This ensures that if I decide to add a Web or GUI interface later, I can reuse 100% of the Service and Repository logic.

Atomic Commits: The project history follows the Conventional Commits standard (feat:, fix:, refactor:) to reflect a professional development workflow.
