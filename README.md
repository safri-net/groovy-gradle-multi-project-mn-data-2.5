# Compile time error extending `io.micronaut.data.repository.CrudRepository`

Defining following classes:

```groovy
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
```

Produces following compile time error:

```
> Task :compileGroovy
startup failed:
/home/user/src/issues/groovy-gradle-multi-project-mn-data-2.5/src/main/groovy/com/example/Application.groovy: -1: Unable to implement Repository method: TestEntityRepository.findById(Object id). Parameter [java.lang.Object id] of method [findById] is not compatible with property [java.util.UUID id] of entity: com.example.TestEntity
 @ line -1, column -1.
```
