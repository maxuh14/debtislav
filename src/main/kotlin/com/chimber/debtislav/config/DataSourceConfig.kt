package com.chimber.debtislav.config

import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource


@Configuration
class DataSourceConfig {
    @Bean
    fun getDataSource(): DataSource {
        val connectionUrl = System.getenv("JDBC_DATABASE_URL")
        val dataSourceBuilder = DataSourceBuilder.create()
        if (connectionUrl != null) {
            dataSourceBuilder.url(connectionUrl)
            dataSourceBuilder.driverClassName("org.postgresql.Driver")
        } else {
            dataSourceBuilder.url("jdbc:postgresql://localhost:5432/debtislav_db?createDatabaseIfNotExist=true&currentSchema=public&allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&stringtype=unspecified")
            dataSourceBuilder.driverClassName("org.postgresql.Driver")
            dataSourceBuilder.username("postgres")
            dataSourceBuilder.password("postgres")
        }
        return dataSourceBuilder.build()
    }
}
