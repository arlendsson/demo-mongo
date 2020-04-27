package com.example.demomongo.mongodb.service

import com.example.demomongo.mongodb.model.Book
import com.example.demomongo.mongodb.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*
import javax.xml.ws.Response

@Service
class BookService {
    @Autowired
    private lateinit var repository: BookRepository

    fun getAllBooks(): List<Book> {
        return repository.findAll()
    }

    fun createBook(book: Book): Book {
        return repository.save(book)
    }

    fun getBook(id: String): ResponseEntity<Book> {
        val bookData: Optional<Book> = repository.findById(id)

        if (bookData.isPresent) {
            return ResponseEntity(bookData.get(), HttpStatus.OK)
        } else {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    fun updateBook(id: String, book: Book): ResponseEntity<Book> {
        val bookData: Optional<Book> = repository.findById(id)

        if (bookData.isPresent) {
            var savedBook: Book = bookData.get()
            savedBook.title = book.title
            savedBook.author = book.author
            savedBook.description = book.description
            savedBook.published = book.published

            val updateBook: Book = repository.save(savedBook)
            return ResponseEntity(updateBook, HttpStatus.OK)
        } else {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    fun deleteBook(id: String): ResponseEntity<String> {
        try {
            repository.deleteById(id)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResponseEntity("Fail to delete!", HttpStatus.EXPECTATION_FAILED)
        }
        return ResponseEntity("Book has been deleted", HttpStatus.OK)
    }

    fun deleteAllBooks(): ResponseEntity<String> {
        try {
            repository.deleteAll()
        } catch (e: Exception) {
            e.printStackTrace()
            return ResponseEntity("Fail to delete!", HttpStatus.EXPECTATION_FAILED)
        }
        return ResponseEntity("All Books has been deleted", HttpStatus.OK)

    }

}