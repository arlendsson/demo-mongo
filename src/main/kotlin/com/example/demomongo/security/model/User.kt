package com.example.demomongo.security.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
data class User (
    @Id
    var id: String,
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    var email: String,
    var password: String,
    var fullname: String,
    var enabled: Boolean,
    @DBRef
    var roles: HashSet<Role>

)