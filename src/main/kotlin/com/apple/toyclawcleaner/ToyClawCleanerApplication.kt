package com.apple.toyclawcleaner

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class ToyClawCleanerApplication

fun main(args: Array<String>) {
    runApplication<ToyClawCleanerApplication>(*args)
}
