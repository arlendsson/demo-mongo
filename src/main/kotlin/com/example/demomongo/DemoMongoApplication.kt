package com.example.demomongo

import com.example.demomongo.mongodb.model.Company
import com.example.demomongo.mongodb.model.Contact
import com.example.demomongo.mongodb.model.Product
import com.example.demomongo.mongodb.repository.CompanyRepository
import lombok.extern.slf4j.Slf4j
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@Slf4j
@SpringBootApplication
class DemoMongoApplication
/*

@Bean
fun imageProcess(companyRepo: CompanyRepository) = CommandLineRunner {
    // clear database
    println("==========Delete all company entities==========");
    companyRepo.deleteAll()

    // save Documents to MongoDB
    println("==========Save list of company entities==========");
    companyRepo.saveAll(
            listOf(
                    Company(1, "Apple"
                            , listOf(
                                Product("A-123", "Iphone 7", "Price: 649.00 USD & FREE shipping")
                                , Product("A-456", "IPadPro", "Price: 417.67 USD & FREE shipping")
                            )
                            , Contact("Cupertino, CA 95014", "1-408-996-1010")
                    )
                    , Company(2, "Samsung",

                        // list of products
                        listOf(Product("S-012", "GalaxyJ7", "Price: 219.00 USD & FREE shipping"),
                                Product("S-456", "GalaxyTabA", "Price: 299.99 USD & FREE shipping")),
                        // contact
                        Contact("Seocho District, Seoul, South Korea", "+82-2-2053-3000")
                    )
            )
    )

    // fetch all documents
    println("==========Fetch aLL companies:==========")
    var companies = companyRepo.findAll()
    companies.forEach {
        println(it)
    }

    // find Company by address
    println("==========Find a company by address:==========")
    companies = companyRepo.findByAddress("Cupertino, CA 95014")
    companies.forEach {
        println(it)
    }
}
*/


fun main(args: Array<String>) {
//    runApplication<DemoMongoApplication>(*args)
    SpringApplication.run(DemoMongoApplication::class.java, *args)
}
