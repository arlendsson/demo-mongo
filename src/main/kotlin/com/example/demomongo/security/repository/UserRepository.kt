package com.example.demomongo.security.repository

import com.example.demomongo.security.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, String> {
    fun findByEmail(email: String): User
}