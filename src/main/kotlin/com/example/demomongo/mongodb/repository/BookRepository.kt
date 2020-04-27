package com.example.demomongo.mongodb.repository

import com.example.demomongo.mongodb.model.Book
import org.springframework.data.mongodb.repository.MongoRepository

interface BookRepository: MongoRepository<Book, String> {
}