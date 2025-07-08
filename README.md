# Quantum Bookstore System

A comprehensive Java-based online bookstore management system that supports multiple book types and provides extensible architecture for future enhancements.

## 📋 Features

- **Multiple Book Types Support**:
  - **Paper Books**: Physical books with stock management and shipping
  - **EBooks**: Digital books with file type specification and email delivery
  - **Showcase Books**: Demo books that are not for sale

- **Inventory Management**:
  - Add books with complete details (ISBN, title, author, year, price)
  - Remove outdated books based on age criteria
  - Real-time stock tracking for paper books

- **Purchase System**:
  - Buy books with quantity, email, and address
  - Automatic stock reduction for paper books
  - Integrated shipping and email services
  - Comprehensive error handling

- **Extensible Architecture**:
  - Easy to add new book types without modifying existing code
  - Abstract base class design for scalability

## 🚀 Getting Started

### Prerequisites

- Java 8 or higher
- Java Development Kit (JDK) installed
- Text editor or IDE (IntelliJ IDEA, Eclipse, VS Code recommended)

### Installation & Setup

1. **Clone or Download**:
   ```bash
   # If using Git
   git clone <repository-url>
   
   # Or download the QuantumBookstore.java file directly
   ```

2. **Navigate to Project Directory**:
   ```bash
   cd quantum-bookstore
   ```

3. **Compile the Code**:
   ```bash
   javac QuantumBookstore.java
   ```

4. **Run the Application**:
   ```bash
   java QuantumBookstoreFullTest
   ```

### Alternative Setup Methods

#### Using an IDE

**IntelliJ IDEA**:
1. Open IntelliJ IDEA
2. Create new Java project
3. Copy the code into a new Java class file
4. Right-click on `QuantumBookstoreFullTest` → Run

**Eclipse**:
1. Create new Java project
2. Create new class file
3. Paste the code
4. Right-click in editor → Run As → Java Application

**VS Code**:
1. Install Java Extension Pack
2. Create new `.java` file
3. Paste the code
4. Press `Ctrl+F5` or click Run button

#### Online Compilers

You can also run the code online using:
- [Replit](https://replit.com)
- [OnlineGDB](https://onlinegdb.com)
- [JDoodle](https://jdoodle.com)

## 📖 Usage Guide

### Basic Operations

#### 1. Creating a Bookstore Instance

```java
QuantumBookstore bookstore = new QuantumBookstore();
```

#### 2. Adding Books

```java
// Add a Paper Book
PaperBook paperBook = new PaperBook("978-0134685991", "Effective Java", 2017, 45.99, "Joshua Bloch", 10);
bookstore.addBook(paperBook);

// Add an EBook
EBook ebook = new EBook("978-0135166307", "Clean Code", 2008, 29.99, "Robert C. Martin", "PDF");
bookstore.addBook(ebook);

// Add a Showcase Book
ShowcaseBook showcaseBook = new ShowcaseBook("978-0201633610", "Design Patterns", 1994, 54.99, "Gang of Four");
bookstore.addBook(showcaseBook);
```

#### 3. Buying Books

```java
try {
    // Buy a paper book (requires shipping address)
    double amount = bookstore.buyBook("978-0134685991", 2, "customer@example.com", "123 Main St, City, State");
    System.out.println("Total paid: $" + amount);
    
    // Buy an ebook (sent via email)
    double amount2 = bookstore.buyBook("978-0135166307", 1, "customer@example.com", "123 Main St, City, State");
    System.out.println("Total paid: $" + amount2);
    
} catch (Exception e) {
    System.out.println("Purchase failed: " + e.getMessage());
}
```

#### 4. Managing Inventory

```java
// Display current inventory
bookstore.displayInventory();

// Remove outdated books (older than 15 years)
List<Book> removedBooks = bookstore.removeOutdatedBooks(2024, 15);
System.out.println("Removed " + removedBooks.size() + " outdated books");

// Get specific book
Book book = bookstore.getBook("978-0134685991");
```

### Advanced Usage

#### Creating Custom Book Types

The system is designed to be easily extensible. Here's how to add a new book type:

```java
// Example: AudioBook class
class AudioBook extends Book {
    private String audioFormat;
    private int durationMinutes;
    
    public AudioBook(String isbn, String title, int year, double price, String author, 
                    String audioFormat, int durationMinutes) {
        super(isbn, title, year, price, author);
        this.audioFormat = audioFormat;
        this.durationMinutes = durationMinutes;
    }
    
    @Override
    public void handlePurchase(int quantity, String email, String address) {
        AudioService.sendAudio(this, quantity, email);
    }
    
    @Override
    public boolean isAvailableForPurchase() {
        return true;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Format: " + audioFormat + ", Duration: " + durationMinutes + " min";
    }
}
```

#### Error Handling

The system includes comprehensive error handling:

- **Book Not Found**: Throws exception when trying to buy non-existent book
- **Out of Stock**: Throws exception when requesting more than available stock
- **Not for Sale**: Throws exception when trying to buy showcase books
- **Invalid Quantity**: Handles negative or zero quantities

## 🏗️ Architecture

### Class Structure

```
Book (Abstract)
├── PaperBook
├── EBook
├── ShowcaseBook
└── AudioBook (Example extension)

QuantumBookstore (Main class)
├── addBook()
├── buyBook()
├── removeOutdatedBooks()
└── displayInventory()

Services
├── ShippingService
├── MailService
└── AudioService (Example)

QuantumBookstoreFullTest (Test class)
```

### Design Patterns Used

- **Template Method Pattern**: Abstract `Book` class with concrete implementations
- **Strategy Pattern**: Different purchase handling strategies for each book type
- **Factory Pattern**: Implicit in book creation
- **Observer Pattern**: Ready for notification systems

## 🧪 Testing

The system includes a comprehensive test class `QuantumBookstoreFullTest` that demonstrates:

1. **Adding Books**: Tests adding different book types
2. **Buying Books**: Tests successful purchases and error scenarios
3. **Inventory Management**: Tests removing outdated books
4. **Extensibility**: Shows how to add new book types
5. **Error Handling**: Demonstrates various error scenarios

### Running Tests

```bash
java QuantumBookstoreFullTest
```

### Expected Output

```
Quantum book store: Starting Full Test
=== Testing Adding Books ===
Quantum book store: Added book - ISBN: 978-0134685991, Title: Effective Java, Author: Joshua Bloch, Year: 2017, Price: $45.99, Stock: 10
...
Quantum book store: Purchase successful! Total amount: $91.98
Quantum book store: Shipping 2 copy(ies) of 'Effective Java' to address: 123 Main St, City, State
...
```

## 📝 API Reference

### QuantumBookstore Class Methods

| Method | Parameters | Returns | Description |
|--------|------------|---------|-------------|
| `addBook()` | `Book book` | `void` | Adds a book to inventory |
| `buyBook()` | `String isbn, int quantity, String email, String address` | `double` | Purchases a book and returns total amount |
| `removeOutdatedBooks()` | `int currentYear, int maxAge` | `List<Book>` | Removes and returns outdated books |
| `displayInventory()` | None | `void` | Displays current inventory |
| `getBook()` | `String isbn` | `Book` | Retrieves a specific book |

### Book Class Hierarchy

#### Abstract Book Class
- `getIsbn()`, `getTitle()`, `getAuthor()`, `getYear()`, `getPrice()`
- `handlePurchase()` (abstract)
- `isAvailableForPurchase()` (abstract)

#### PaperBook
- `getStock()`, `reduceStock()`
- Handles shipping via ShippingService

#### EBook
- `getFileType()`
- Handles email delivery via MailService

#### ShowcaseBook
- Not available for purchase
- Throws error on purchase attempts

## 🔧 Troubleshooting

### Common Issues

1. **Compilation Error**: 
   - Ensure Java is properly installed
   - Check classpath settings
   - Verify file name matches class name

2. **Runtime Errors**:
   - Check Java version compatibility
   - Ensure all classes are in the same file or package

3. **Purchase Failures**:
   - Verify ISBN exists in inventory
   - Check stock availability for paper books
   - Ensure showcase books are not being purchased

### Debug Tips

- Use `displayInventory()` to check current state
- Enable verbose output for detailed error messages
- Check console output for service calls

## 🤝 Contributing

To extend the system:

1. **Add New Book Types**: Extend the `Book` abstract class
2. **Add New Services**: Create service classes for new book types
3. **Enhance Features**: Add new methods to `QuantumBookstore`
4. **Improve Testing**: Add more test cases to `QuantumBookstoreFullTest`

## 📄 License

This project is created for educational purposes as part of the Fawry N² Dev Slope Challenge.

## 📞 Support

For questions or issues:
- Review the troubleshooting section
- Check the API reference
- Examine the test class for usage examples

---

**Note**: All print statements are prefixed with "Quantum book store" as per the requirements.
