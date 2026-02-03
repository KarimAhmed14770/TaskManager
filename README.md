**Task Manager API (CLI-Based):**

A robust Task Management System implementing Clean Architecture and Data Persistence. This project demonstrates the transition from basic scripting to professional-grade software design in Java.

🏗 **System Architecture:**

The application follows a Decoupled Layered Architecture, ensuring that business logic is independent of the user interface and the data storage mechanism.

Layer	Responsibility	Key Component
Presentation:	Handles User Input/Output and Menu Navigation	Main.java
Service: Logic & Validation	TaskService.java
Persistence:	Manages Serialization & File I/O	TaskRepository.java
Domain: Defines the Core Data Structures	Task.java, TaskStatus.java

🛠 **Key Features:**

Persistent Storage: Data is serialized to a pipe-separated (|) flat-file system, ensuring persistence across application restarts.

Atomic ID Generation: A custom algorithm calculates the next unique identifier on startup to maintain data integrity.

Early Validation: Implements checks to verify resource existence before prompting for user input, optimizing UX flow.

Safety Features: Graceful handling of invalid inputs and scanner buffer management.
                
🚀 **Getting Started:**

Prerequisites

JDK 17 or higher.

A terminal/command prompt.

Installation
Clone the repository:

Bash

git clone https://github.com/KarimAhmed14770/TaskManager.git
Navigate to the source directory:

Bash

cd TaskManager/src

Running the Application
Compile and run using the following commands:

Bash

javac com/KarimAhmed/TaskManager/Main.java
java com.KarimAhmed.TaskManager.Main

🧠 Design Decisions & Best Practices

**Dependency Injection**: The TaskService receives its repository through the constructor. This allows for easier unit testing and future-proofs the app for database migration (e.g., SQL).

**Separation of Concerns (SoC)**: I strictly kept UI logic (Scanner, System.out) out of the Service and Repository layers. This allows the core logic to be reused for a Web API or Desktop GUI without modification.

**Conventional Commits**: I utilized the Conventional Commits standard (feat:, fix:) to maintain a clean and readable version history.

👤 Author
Karim Ahmed

LinkedIn:https://www.linkedin.com/in/karim-ahmed-9130271b1/

GitHub:https://github.com/KarimAhmed14770
