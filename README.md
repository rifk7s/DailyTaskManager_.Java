# Daily Task Manager

A robust Java-based task management system featuring dual data structure implementation (Array/LinkedList) with undo capability. Perfect for managing and tracking daily tasks through a clean command-line interface.

## 📸 Preview
```
==============================
Which menu do you want to see?
(0 to exit)
1. Array
2. Linked List
==============================
Please enter : 1
```
```
******************************
Welcome to Daily Task Manager!
******************************

=== Menu Options ===
1. View tasks
2. Update task
3. Add new task
4. Delete task
5. Mark task as completed
6. Undo task completion
7. Check if all tasks are completed
8. Change data structure
9. Exit
```

## 🛠️ Technologies Used
#### Development Environment
  [![Oracle Java 23](https://img.shields.io/badge/Oracle%20Java%2023-ED8B00?style=flat&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
  [![Git Bash](https://img.shields.io/badge/Gitbash%20--f14e32?logo=git)](https://git-scm.com/downloads)
  [![VSCode](https://img.shields.io/badge/VSCode-0086d1?style=flat&logo=internetcomputer&logoColor=white)](https://code.visualstudio.com/download) 
  [![GitHub](https://img.shields.io/badge/GitHub%20-ts?logo=github&logoColor=black&labelColor=white&color=54a5e3)](https://github.com)

## ✨ Key Features
- **Dual Implementation**: Choose between Array or LinkedList based storage
- **Task Management**:
  - Add, update, and delete tasks
  - Mark tasks as complete/incomplete
  - View all tasks with completion status
- **Undo Functionality**: Stack-based history for undoing task completions
- **Data Structure Switching**: Switch between implementations at runtime
- **Input Validation**: Robust error handling and input validation
- **Clean UI**: Console-based interface with clear navigation

## 🚀 Getting Started

### Prerequisites
- Java JDK 23 or higher
- Git (optional)
- VSCode or any Java IDE

### Installation
1. Clone the repository:
```bash
git clone https://github.com/rifk7s/DailyTaskManager_.Java.git
cd DailyTaskManager_.Java
```

2. Compile the project:
```bash
javac src/*.java
```

3. Run the application:
```bash
java -cp src DailyTaskManager
```

## 📖 Usage Examples

1. **Adding a Task**:
```
Enter new task: Complete Java assignment
Task added successfully!
```

2. **Marking as Complete**:
```
1. [ ] Complete Java assignment
Enter task index to mark as completed (1-1): 1
Task "Complete Java assignment" completed!
```

## 🏗️ Project Structure
```
DailyTaskManager_.Java/
├── src/                      # Source code directory
│   ├── DailyTaskManager.java # Main application controller
│   ├── F_Array.java         # Array-based implementation
│   └── F_Stack.java         # Stack for undo functionality
├── bin/                      # Compiled class files
│   ├── DailyTaskManager.class
│   ├── F_Array.class
│   └── F_Stack.class
├── images/                   # Documentation images
│   ├── OOM_ERROR.jpg        # Out of memory error screenshot
│   └── OOM.jpg              # Fixed memory settings screenshot
├── .vscode/
│   └── settings.json        # VSCode configuration
└── README.md                # Project documentation
```

## 🔧 Technical Implementation

### Data Structures
- **Array Implementation**:
  - Dynamic resizing for flexible storage
  - O(1) access time for operations
  - Parallel boolean array for completion tracking

- **LinkedList Implementation**:
  - Dynamic size management
  - Efficient insertions and deletions
  - Integrated completion tracking

- **Stack (Undo Feature)**:
  - Fixed-size implementation (100 items)
  - LIFO operation for task completion history
  - Overflow/underflow protection

### Performance Analysis
- Array operations: O(1) for access, O(n) for resizing
- LinkedList operations: O(1) for insertions/deletions
- Stack operations: O(1) for all operations
- Undo search: O(n) worst case

## 🐛 Known Issues & Solutions
1. **Out Of Memory Error**
   - Solution: Added JVM arguments in `.vscode/settings.json`
   - Before: ![OOM Error](https://github.com/rifk7s/DailyTaskManager_.Java/blob/main/images/OOM_ERROR.jpg?raw=true)
   - After: ![OOM Fixed](https://github.com/rifk7s/DailyTaskManager_.Java/blob/main/images/OOM.jpg?raw=true)

> [!NOTE]  
> I use ChatGPT mostly for explaining the code and fixing bugs, and I have also talked to a few friends of mine for help and code references.

## 🤝 Contributing
Contributions are welcome! Please feel free to:
- Report bugs
- Suggest new features
- Submit pull requests

## 📚 References
- Java Collections Framework Documentation
- Data Structures & Algorithms resources
- Code citations as listed in original implementation

## 📝 License
This project is open source and available under the MIT License.

