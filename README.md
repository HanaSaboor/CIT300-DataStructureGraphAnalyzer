# Data Structure & Graph Performance Analyzer

**Course:** CIT300 – Data Structures and Algorithms  
**Assessment:** Graded Practical Assignment 2 (Week 12)  
**Application type:** Java console application  
**Programming language:** Java  
**Repository:** `CIT300-DataStructureGraphAnalyzer`

> Before submission, replace the repository placeholder in this README with the live GitHub repository URL.

---

## 1. Project Overview

The **Data Structure & Graph Performance Analyzer** is a menu-driven Java console application demonstrating fundamental data structures, searching algorithms, graph representation and traversal, and algorithmic complexity. Users can perform operations on arrays, stacks, queues, linked lists, and graphs through one integrated application.

The application includes two performance comparisons:

- **Search Performance:** compares Linear Search and Binary Search, reporting the result, comparison count, measured execution time, and theoretical time complexity.
- **Graph Traversal Performance:** compares Breadth-First Search (BFS) and Depth-First Search (DFS), reporting traversal order, vertices visited, a defined traversal-step count, measured execution time, and theoretical time complexity.

The project is intended to demonstrate both correct implementation and the ability to explain data structures, algorithms, performance measurements, and collaboration practices.

## 2. Group Members and Task Allocation

The following table records the group's planned responsibilities. Individual contribution statements and Git history must accurately reflect the work each member actually completes.

| No. | Group member | Student ID | Assigned responsibility |
|---:|---|---|---|
| 1 | STF. Hana Rif-uth | 23DA2-0839 | Array operations and searching algorithms |
| 2 | MJ. Fathima Zuha | 23DA2-0841 | Stack and queue operations, including empty-structure handling |
| 3 | SF. Nusrath | 23DA2-0984 | Singly linked list operations and Performance Analyzer |
| 4 | MN. Aaysha Jainum | 23DA2-1035 | Graph representation and traversal, plus main-menu integration |

### 2.1 Individual contribution details

#### Member 1 — STF. Hana Rif-uth (23DA2-0839)

**Assigned responsibility:** Array and Searching components.

- Implement and verify array insertion, deletion, searching, and display.
- Implement Linear Search and Binary Search and report search results and comparison counts.
- Ensure Binary Search works on sorted data and identify the relevant index in its search array.
- Test successful searches, unsuccessful searches, and representative array inputs.
- Explain the difference between `O(n)` Linear Search and `O(log n)` Binary Search on sorted data.

#### Member 2 — MJ. Fathima Zuha (23DA2-0841)

**Assigned responsibility:** Stack and Queue components.

- Implement stack Push, Pop, Peek, and Display operations.
- Implement queue Enqueue, Dequeue, Front/Peek, and Display operations.
- Handle attempts to pop from an empty stack and dequeue from an empty queue safely.
- Test the Last In, First Out (LIFO) behaviour of a stack and the First In, First Out (FIFO) behaviour of a queue.
- Explain the data structures, operations, and typical time complexities.

Testing Results:

Stack Operations

* Push: Successfully added values to the stack.
* Display: Displayed the stack values in the correct order, from bottom to top.
* Pop: Successfully removed 23 and then 10, following the Last In, First Out (LIFO) principle.
* Empty Stack Handling: Displayed “Stack underflow stack is empty” when Pop was attempted on an empty stack.
* Peek: Displayed the top value correctly and showed “Stack is empty” when Peek was attempted on an empty stack.

Queue Operations

* Enqueue: Successfully added 10 and 20 to the queue.
* Display: Displayed 10, 20 from front to rear.
* Front/Peek: Correctly displayed 10 without removing it.
* Dequeue: Successfully removed 10 and then 20, following the First In, First Out (FIFO) principle.
* Empty Queue Handling: Displayed “Queue is empty cannot dequeue” when Dequeue was attempted on an empty queue.
* Empty Queue Peek: Displayed “Queue is empty” when Peek was attempted on an empty queue.

#### Member 3 — SF. Nusrath (23DA2-0984)

**Assigned responsibility:** Linked List and Performance Analyzer components.

- Implement a singly linked list with Insert, Delete, Search, and Display operations.
- Handle search and deletion requests for values that are not present in the list.
- Implement the Performance Analyzer's search and graph traversal comparison functions in coordination with the graph module.
- Display comparison counts, traversal results, execution time in nanoseconds, and time-complexity information.
- Explain why measured execution time can vary and why comparison counts and theoretical complexity are useful for analysis.

#### Testing Results

**1. Linked List Testing**
- Tested Insert, Delete, Search, and Display operations.
- Display output: `10 -> 30 -> 10 -> null`.
- Tested linked list operations using sample values.

**2. Search Performance Comparison**
- Original array: `[5, 15, 25]`
- Search value: `15`
- Linear Search: Found at index 1, with 2 comparisons. Execution time: 500 ns. Time complexity: `O(n)`.
- Binary Search: Found at sorted-array index 1, with 1 comparison. Execution time: 400 ns. Time complexity: `O(log n)`.
- Result: Binary Search used fewer comparisons in this test.
- Sorting time is excluded from Binary Search timing.

**3. Graph Traversal Performance**
- Starting vertex: `A`
- BFS traversal: `[A, B]`
- Vertices visited: 2
- Traversal steps: 4
- Execution time: 50,800 ns
- Time complexity: `O(V + E)`
- DFS traversal: `[A, B]`
- Vertices visited: 2
- Traversal steps: 4
- Execution time: 87,100 ns
- Time complexity: `O(V + E)`

**4. Performance Analysis**
- Execution times can vary between runs and depend on factors such as system activity and graph size.
- Comparison counts and traversal steps help compare the amount of work performed.
- Theoretical time complexity explains how an algorithm's work grows as the input size increases.
#### Member 4 — MN. Aaysha Jainum (23DA2-1035)

**Assigned responsibility:** Graph component and main application integration.

- Implement the graph using an adjacency-list representation.
- Implement vertex and edge creation, graph display, Breadth-First Search (BFS), and Depth-First Search (DFS).
- Validate graph operations, including checking that vertices exist before an edge is added and rejecting duplicate edges.
- Provide traversal-step counting for the Performance Analyzer.
- Integrate the graph and performance features with the main application menu and test the complete application.
- Explain graph representation, BFS, DFS, and traversal complexity.

**Graph test results:**

| Test | Input | Output |
|---|---|---|
| Add vertex | A, B, C, D | Vertex added: A (B, C, D too) |
| Add duplicate vertex | A | Vertex already exists. |
| Add edge, missing vertex | A, Z | Both vertices must exist first. |
| Display Graph | none | A -> [B, D], B -> [A, C], C -> [B], D -> [A] |
| BFS from A | A | BFS: [A, B, D, C] |
| DFS from A | A | DFS: [A, B, C, D] |

### 2.2 Shared responsibilities

All four members should participate in final integration and quality checks. Each member should test their own module, review the integrated application, contribute to documentation where appropriate, create genuine commits for their work, and present their contribution in the demonstration video. Update this section if actual group contributions differ from the planned allocation above.

## 3. Technologies Used

- **Java:** application implementation.
- **Java Development Kit (JDK):** compilation and execution.
- **Visual Studio Code:** development environment.
- **Git:** source control.
- **GitHub:** repository hosting and collaboration evidence.

The current console implementation uses Java's standard library and does not require external Java libraries.

## 4. Features

### 4.1 Array Operations

- Insert elements into the array.
- Delete elements.
- Search for a value.
- Display the array contents.

### 4.2 Stack Operations

- Push an element onto the stack.
- Pop the top element.
- Peek at the top element without removing it.
- Display stack contents from bottom to top.
- Handle empty-stack operations safely.

The stack follows **Last In, First Out (LIFO)**: the most recently pushed item is removed first.

### 4.3 Queue Operations

- Enqueue an element at the rear.
- Dequeue an element from the front.
- View the front element without removing it.
- Display queue contents from front to rear.
- Handle empty-queue operations safely.

The queue follows **First In, First Out (FIFO)**: the earliest enqueued item is removed first.

### 4.4 Linked List Operations

- Insert an element at the end of a singly linked list.
- Delete a matching element.
- Search for a value.
- Display the linked list.
- Handle requests for missing values without crashing.

### 4.5 Searching Algorithms

- **Linear Search:** checks elements sequentially until a match is found or the data ends.
- **Binary Search:** repeatedly halves the search interval and requires sorted data.
- Report search results, comparison counts, measured execution time, and time complexity in the relevant search/performance features.

### 4.6 Graph Operations

The current graph is an **undirected graph** represented using an adjacency list.

- Add vertices.
- Add edges between existing vertices.
- Reject duplicate vertices and duplicate edges.
- Display the graph as an adjacency list.
- Traverse the graph using BFS.
- Traverse the graph using DFS.
- Validate starting vertices for traversal and report when no traversal can be performed.

Traversal order can depend on the order in which vertices and edges are added. BFS uses a queue, while DFS uses a stack.

### 4.7 Performance Analyzer — Updated

The Performance Analyzer has a submenu with the following options:

1. **Search Performance Comparison**
2. **Graph Traversal Performance**
0. **Return to Main Menu**

#### Search Performance Comparison

The analyzer compares Linear Search and Binary Search using the current array values. It reports:

- Whether the target value was found and its index in the relevant array.
- Number of element comparisons.
- Measured search execution time in nanoseconds.
- Theoretical time complexity (`O(n)` for Linear Search and `O(log n)` for Binary Search on sorted data).
- A short comparison based on the number of comparisons performed.

For Binary Search, the analyzer sorts a copy of the original array. The original array remains unchanged, and sorting time is excluded from the reported Binary Search time. Include sorting time separately when analysing a complete sort-and-search workflow.

#### Graph Traversal Performance

The analyzer runs BFS and DFS from a user-provided starting vertex and reports:

- Traversal order.
- Number of vertices visited.
- Traversal-step count.
- Measured execution time in nanoseconds.
- Theoretical time complexity, `O(V + E)` for adjacency-list traversal.

The traversal-step count is a **defined measurement used for comparison**, not a count of every Java instruction. In the current implementation it counts processed queue/stack vertex entries and inspected neighbours. BFS and DFS use the same general categories of work, but the number of steps depends on the graph structure and traversal behaviour. Execution times can vary between runs, particularly for small graphs, and should not be treated as a guaranteed speed ranking.

## 5. Main Menu

The integrated application provides these options:

```text
==================================
 DATA STRUCTURE & GRAPH ANALYZER
==================================
1. Array Operations
2. Stack Operations
3. Queue Operations
4. Linked List Operations
5. Searching Operations
6. Graph Operations
7. Performance Analyzer
0. Exit
==================================
```

Select a number to open the corresponding module. Each module provides its own submenu.

## 6. Project Structure

```text
CIT300-DataStructureGraphAnalyzer/
├── src/
│   ├── Main.java
│   ├── ArrayManager.java
│   ├── StackManager.java
│   ├── QueueManager.java
│   ├── LinkedListManager.java
│   ├── SearchingAlgorithms.java
│   ├── GraphManager.java
│   ├── PerformanceAnalyzer.java
│   └── InputHelper.java
├── README.md
└── .gitignore
```

The `out/` directory is generated when the Java files are compiled. It does not need to be committed because `.gitignore` should exclude it and compiled `.class` files.

Recommended `.gitignore` contents:

```gitignore
# Compiled Java output
out/
*.class

# VS Code workspace settings
.vscode/
```

## 7. Algorithm and Data Structure Complexity

The table gives typical time complexity for the current implementation. Actual behaviour depends on the operation and input size.

| Component | Operation | Typical time complexity | Notes |
|---|---|---|---|
| Array | Search | `O(n)` | Linear scan |
| Array | Display | `O(n)` | Visits each element |
| Array | Insert/Delete | `O(n)` worst case | Shifting or resizing may be required |
| Stack | Push | `O(1)` amortized | Uses a resizable collection |
| Stack | Pop/Peek | `O(1)` | Operates on the top element |
| Stack | Display | `O(n)` | Visits the elements |
| Queue | Enqueue/Dequeue/Front | `O(1)` typical/amortized | Uses a deque-based implementation |
| Queue | Display | `O(n)` | Visits the elements |
| Singly linked list | Search | `O(n)` | May visit every node |
| Singly linked list | Insert at end | `O(n)` | Traverses to the last node when no tail reference is maintained |
| Singly linked list | Delete by value | `O(n)` | Must locate the target node |
| Singly linked list | Display | `O(n)` | Visits each node |
| Linear Search | Search | `O(n)` | Best case `O(1)`; worst case `O(n)` |
| Binary Search | Search | `O(log n)` | Requires sorted data |
| Graph | BFS/DFS | `O(V + E)` | Adjacency-list representation |
| Graph | Display | `O(V + E)` | Lists vertices and adjacency information |

**Notation:** `n` is the number of elements, `V` is the number of graph vertices, and `E` is the number of graph edges.

## 8. Requirements

- Install a JDK that provides both `java` and `javac`.
- Open a terminal in the project root directory.
- Keep the Java source files inside `src/` as shown in the project structure.

Check the installation:

```cmd
java -version
javac -version
```

## 9. Compile and Run on Windows

Run the commands below in Command Prompt or the VS Code terminal from the project root directory, for example `E:\chrome\CIT300-DataStructureGraphAnalyzer`.

### Step 1 — Create the output directory if needed

```cmd
if not exist out mkdir out
```

### Step 2 — Compile all Java source files

```cmd
javac -d out src\*.java
```

### Step 3 — Run the application

```cmd
java -cp out Main
```

If compilation reports an error, check that the terminal is in the project root and that every required `.java` file is present under `src/`.

## 10. Testing and Validation

The team has manually tested core operations and selected edge cases during development. Rerun the checks below against the final integrated version before submission and record any fixes made.

- [ ] Array insert, delete, display, existing-value search, and missing-value search.
- [ ] Stack Push, Pop, Peek, and Display, including Pop and Peek on an empty stack.
- [ ] Queue Enqueue, Dequeue, Front/Peek, and Display, including Dequeue and Front/Peek on an empty queue.
- [ ] Linked-list insert, delete, search, and display, including searching for and deleting a missing value.
- [ ] Linear Search and Binary Search with existing and missing targets.
- [ ] Search Performance Comparison displays results, comparison counts, execution-time output, and complexity.
- [ ] Graph vertex and edge creation, graph display, BFS, and DFS.
- [ ] Duplicate vertex/edge handling and attempts to create edges with nonexistent vertices.
- [ ] Graph Traversal Performance displays BFS/DFS traversal order, vertices visited, counted steps, execution time, and complexity.
- [ ] Input validation for non-integer choices where an integer is expected.
- [ ] Return from every submenu to the main menu and exit cleanly.
- [ ] Compile the complete project from a clean `out/` directory.

## 11. GitHub Collaboration

The project must be maintained in the group's GitHub repository. The repository history should provide evidence of genuine individual contributions.

Recommended workflow:

1. Keep the `main` branch as the integrated version.
2. Create a feature branch for a member's real task or improvement.
3. Make small, meaningful commits with messages describing the actual change.
4. Push feature branches to GitHub.
5. Open pull requests against `main`, review the changes, test them, and merge when correct.
6. Use GitHub Issues to track tasks or defects if useful.
7. Keep README descriptions consistent with the latest code and actual contributions.

Example branch names:

```text
feature/array-searching
feature/stack-queue
feature/linked-list-performance
feature/graph-integration
```

Example commit messages (use only when they describe work actually performed):

```text
feat: improve array and searching operations
feat: improve stack and queue operations
feat: refine linked list and performance analysis
feat: validate graph operations and system integration
```

Each member should commit their own work using their own Git identity and GitHub account. Do not fabricate commits or claim another member's work as your own.


## 12. Submission Checklist

- [ ] Complete Java source project is present in the GitHub repository.
- [ ] Array, Stack, Queue, Linked List, Searching, and Graph components are implemented.
- [ ] BFS and DFS graph traversal are available.
- [ ] Search and graph traversal performance/complexity demonstrations are included.
- [ ] The main console application integrates the required components.
- [ ] Group-member names and student IDs are correct.
- [ ] Responsibilities and individual contributions accurately reflect the work completed.
- [ ] README contains project information and run instructions.
- [ ] Commits, branches, and pull requests provide genuine collaboration evidence where applicable.
- [ ] One merged demonstration video is prepared and is shorter than 15 minutes.
- [ ] Each member's contribution is demonstrated, with their face clearly visible during their section.
- [ ] The final project is submitted through the required LMS process.

### Google Drive submission (only if required)

If the project files are too large for direct LMS upload, follow the assignment brief:

1. Upload the complete project to a Google Drive folder.
2. Copy the folder link.
3. Paste the link into a Notepad `.txt` file.
4. Submit the TXT file through the designated LMS submission link.
5. Before submission, give **Editor** access to both required addresses and verify the permissions:
   - `asanka.r@sltc.ac.lk`
   - `kaushika.w@sltc.ac.lk`

Follow the lecturer's and LMS's submission instructions and deadline. The assignment brief states that late email submissions are not accepted as substitutes for successful LMS submission.

## 13. Conclusion

The Data Structure & Graph Performance Analyzer brings arrays, stacks, queues, linked lists, searching algorithms, graph traversal, and performance comparison into one Java console application. The project demonstrates implementation, input and edge-case handling, performance measurements, complexity analysis, and collaborative development practices.
Graph integration completed.
