package com.example.demomongo.mongodb.controller

import com.example.demomongo.mongodb.model.Book
import com.example.demomongo.mongodb.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import javax.validation.Valid
import javax.xml.ws.Response

@CrossOrigin(origins = arrayOf<String>("http://localhost:8081"))
@RestController
@RequestMapping("/api/books")
class BookController {
    @Autowired
    private lateinit var service: BookService

    @GetMapping("/")
    fun getAllBooks(): List<Book> {
        println("Get all books")
        return service.getAllBooks()
    }

    @PostMapping("/")
    fun createBook(@RequestBody book: Book): Book {
        println("Create Book: " + book.toString())
        return service.createBook(book)
    }

    @GetMapping("/{id}")
    fun getBook(@PathVariable("id") id: String): ResponseEntity<Book> {
        println("Get Book by Id " + id)
        return service.getBook(id)
    }

    @PutMapping("/{id}")
    fun updateBook(@PathVariable("id") id: String, @RequestBody book: Book): ResponseEntity<Book> {
        println("Update Book with Id " + id)
        return service.updateBook(id, book)
    }

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable("id") id: String): ResponseEntity<String> {
        println("Delete Book with Id " + id)
        return service.deleteBook(id)
    }

    @DeleteMapping("/")
    fun deleteAllBooks(): ResponseEntity<String> {
        println("Delete all Books")
        return service.deleteAllBooks()
    }
}