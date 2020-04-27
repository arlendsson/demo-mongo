package com.example.demomongo.mongodb.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "books")
data class Book (
    @Id
    var id: String = "",
    var title: String,
    var description: String,
    var author: String,
    var published: Int
)