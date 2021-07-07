package com.example

import groovy.transform.CompileStatic
import io.micronaut.data.annotation.AutoPopulated
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import io.micronaut.runtime.Micronaut

@CompileStatic
class Application {
    static void main(String[] args) {
        Micronaut.run(Application, args)
    }
}

@CompileStatic
interface MyCrudRepository<E,PK> extends CrudRepository<E,PK> {
}

@JdbcRepository(dialect = Dialect.H2)
@CompileStatic
interface TestEntityRepository extends MyCrudRepository<TestEntity,UUID> {

}

@MappedEntity
@CompileStatic
class TestEntity {

    @Id
    @AutoPopulated
    UUID id

    String name
}

