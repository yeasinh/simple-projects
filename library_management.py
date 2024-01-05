from abc import ABC, abstractmethod

class Book(ABC):
    def __init__(self, title, author, ISBN):
        self.title = title
        self.author = author
        self.ISBN = ISBN

    @abstractmethod
    def display_info(self):
        pass


class FictionBook(Book):
    def __init__(self, title, author, ISBN, genre):
        super().__init__(title, author, ISBN)
        self.genre = genre

    def display_info(self):
        super().display_info()
        print(f"Genre: {self.genre}\nType: Fiction")


class NonFictionBook(Book):
    def __init__(self, title, author, ISBN, topic):
        super().__init__(title, author, ISBN)
        self.topic = topic

    def display_info(self):
        super().display_info()
        print(f"Topic: {self.topic}\nType: Non-Fiction")


class Library:
    def __init__(self):
        self.books = []

    def add_book(self, book):
        self.books.append(book)
        print(f"Book '{book.title}' added to the library.")

    def display_books(self):
        if not self.books:
            print("No books in the library.")
        else:
            print("Books in the library:")
            for book in self.books:
                book.display_info()
                print("--------------")


def main():
    # Creating default books
    fiction_book = FictionBook("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565", "Classic")
    non_fiction_book = NonFictionBook("Sapiens", "Yuval Noah Harari", "978-0062316097", "History")

    # Creating a library and adding default books
    library = Library()
    library.add_book(fiction_book)
    library.add_book(non_fiction_book)

    # Displaying all books in the library
    library.display_books()

    # Example of method overloading
    overloaded_book = FictionBook("Overloaded Book", "Author", "123456789", "Mystery")
    library.add_book(overloaded_book)

    # Example of polymorphism
    for book in library.books:
        print(f"Polymorphic display for book '{book.title}':")
        book.display_info()
        print("--------------")


if __name__ == "__main__":
    main()
