package com.example.demomongo.mongodb.model

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "company")
class Company (
        @Id
        val id: Int,
        val name: String,
        val products: List<Product>,
        val contact: Contact
) {
    override fun toString(): String {
        val mapper = ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        val jsonString = mapper.writeValueAsString(this)
        return jsonString
    }
}