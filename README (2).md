# Library Management System

## Overview
This Library Management System is a console-based Java application designed to manage books within a library. It follows the MVC architecture and demonstrates the use of various design patterns including Singleton, Factory, Facade, Decorator, Strategy, and Command patterns.

## Features
- **Add a Book (Admin Mode)**: Allows an administrator to add new books to the library.
- **Remove a Book (Admin Mode)**: Allows an administrator to remove books from the library.
- **Borrow a Book**: Allows users to borrow books if they are available.
- **Return a Book**: Allows users to return previously borrowed books.
- **Display Available Books**: Lists all available books and allows sorting by title or author.
- **Load Books from File**: Loads an initial list of books from a JSON file.

## Design Patterns Used
### 1. **Singleton**
   - **Class**: `Library`
   - Ensures there is only one instance of the Library in the system, which manages the collection of books.

### 2. **Factory**
   - **Class**: `BookFactory`
   - Used to create instances of `Book` objects, which inherit from `LibraryItem`.

### 3. **Facade**
   - **Class**: `LibraryFacade`
   - Provides a simplified interface to the complex interactions within the library system (adding, borrowing, returning, and displaying books).

### 4. **Decorator**
   - **Class**: `FeaturedItemDecorator`
   - Allows adding extra features to a `LibraryItem` (e.g., marking an item as "Featured") without modifying its structure.

### 5. **Strategy**
   - **Classes**: `SortByTitle`, `SortByAuthor`
   - Used to implement different sorting strategies for displaying books by title or author.

### 6. **Command**
   - **Classes**: `AddBookCommand`, `BorrowBookCommand`, `ReturnBookCommand`
   - Encapsulates actions (adding, borrowing, returning books) as objects, allowing them to be executed and modified dynamically.

## Project Structure
```plaintext
src/
├── command/
│   ├── AddBookCommand.java
│   ├── BorrowBookCommand.java
│   ├── Command.java
│   └── ReturnBookCommand.java
├── controller/
│   └── LibraryController.java
├── decorator/
│   ├── FeaturedItemDecorator.java
│   └── LibraryItemDecorator.java
├── facade/
│   └── LibraryFacade.java
├── factory/
│   └── BookFactory.java
├── model/
│   ├── Book.java
│   ├── Library.java
│   └── LibraryItem.java
├── strategy/
│   ├── SortByAuthor.java
│   ├── SortByTitle.java
│   └── SortStrategy.java
├── view/
│   └── LibraryView.java
└── Main.java
