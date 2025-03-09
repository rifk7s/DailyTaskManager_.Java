# Daily Task Manager

A Java-based command-line task management application that helps users organize and track their daily tasks.

## Challenge 

Here are some challenge:

1. **Out Of Memory**
   - take a look at .vscode/settings.json, i add jvm arguments for more memory in the jvm since i got the OOM
   - ![IMG](https://github.com/rifk7s/DailyTaskManager_.Java/blob/main/images/OOM_ERROR.jpg?raw=true)
   - ![IMG](https://github.com/rifk7s/DailyTaskManager_.Java/blob/main/images/OOM.jpg?raw=true)

2. **ChatGPT Support**
   - Im sorry but 50% of the code are ChatGPT (its hard i cant do it alone)
## Features

- View predefined tasks with completion status
- Update existing tasks
- Add new tasks dynamically
- Delete tasks
- Mark tasks as completed
- Undo task completion (with stack-based history)
- Check overall task completion status
- Clean console-based UI

## Data Structures Used

1. **Array-based Task Storage**
   - Dynamic resizing for task addition/deletion
   - Parallel boolean array for completion tracking

2. **Stack Implementation**
   - Used for undo functionality
   - Fixed-size stack with overflow/underflow protection

## Technical Analysis

### Strengths
- O(1) access time for task operations
- Memory-efficient boolean tracking
- Robust input validation
- Clean separation of concerns (F_Array, F_Stack, DailyTaskManager)

### Areas for Improvement
- Fixed-size stack limitation (100 items)
- No persistence between sessions
- Linear search O(n) for undo operations

## Error Handling
- Input validation for task indices
- Stack overflow/underflow protection
- Null checks for task operations
- Graceful exit handling

## Getting Started

1. Clone the repository
2. Compile the Java files:
   ```bash
   javac src/*.java
   ```
3. Run the application:
   ```bash
   java -cp src DailyTaskManager
   ```

## Class Structure

- `DailyTaskManager`: Main application controller
- `F_Array`: Task storage and management
- `F_Stack`: Undo history implementation

## Contributing

Feel free to implement any of the challenge extensions or suggest new features!

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

# Code Citations (References)

## License: unknown
https://github.com/rahmadnet/CRUD-Java-Berbasis-teks/tree/e95a1860925552eeff1912729013b66e12f6adca/apk/GIT/BELAJAR-CRUD-JAVA-TEKS-PART1-master/CRUD/main.java

```
{
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System
```

## License: unknown
https://github.com/achmadsy/atm-simulation/tree/fee9e9412c233908d02a4fae191b6e1d3bb0c4cc/stage3/src/main/java/com/mycompany/atmstage3/service/MenuService.java

```
("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J"
```

## License: MIT
https://github.com/jakobkhansen/SoNe/tree/6af5f16aa466912a978bb5eb03c6c5a90e49a1e2/Client/src/main/java/com/SoNe/Client/Utils.java

```
/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception
```

