public class LibraryManagementSystem {

    // Linear Search
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Not found
    }
}


import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagementSystem {

    // Linear Search
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Not found
    }

    // Binary Search (Assumes the array is sorted by title)
    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);
            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Not found
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Catcher in the Rye", "J.D. Salinger"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(4, "1984", "George Orwell"),
            new Book(5, "Moby-Dick", "Herman Melville")
        };

        // Sort the array by title for binary search
        Arrays.sort(books, Comparator.comparing(Book::getTitle));

        // Linear Search Test
        System.out.println("Linear Search:");
        Book foundBook = linearSearch(books, "1984");
        System.out.println(foundBook != null ? foundBook : "Book not found");

        // Binary Search Test
        System.out.println("\nBinary Search:");
        foundBook = binarySearch(books, "1984");
        System.out.println(foundBook != null ? foundBook : "Book not found");
    }
}
