package com.example.demomongo.mongodb.repository

import com.example.demomongo.mongodb.model.Company
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface CompanyRepository: MongoRepository<Company, String> {
    fun findByName(name: String): List<Company>

    @Query("{'contact.address': ?0}")
    fun findByAddress(address: String): List<Company>
}