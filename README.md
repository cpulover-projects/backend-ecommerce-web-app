# Back-end Development Process

### Spring Boot Setup
- Spring Data JPA
- REST Repository
- MySQL Driver
- Lombok

### Database Setup - Hibernate/JPA
1. Create database for Entities
[[create-database.sql]()] [[countries-and-states.sql]()]
2. Configure JDBC connection and Hibernate dialect in 
[application.properties]()
3. Create JPA Entity classes 
[[Product]()] [[ProductCategory]()] [[Country]()] [[State]()]

### Spring Data JPA/REST
1. Create Repositories 
[[ProductRepository]()] [[ProductCategoryRepository]()] [[CountryRepository]()] [[StateRepository]()]
   - Use @RepositoryRestResource to customize JSON entry and API endpoint
   - Create custom query methods by 
   [Query Methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)
2. Customize base path for REST API in 
[application.properties]()
3. Create Spring Data REST Configuration with @Configuration implements RepositoryRestConfigurer for custom configuration 
[[DataRestConfig]()] 
   - Disable certain HTTP methods for certain Entities
   - Expose Entity id fields for the API 
     - Inject JPA entity manager (recommend by the constructor): to retrieve list of all Entity types
     - Alternative method: declare field by uppercase ```Id``` instead of ```id```. However, this is not a documented feature -> not recommend


### Notes
- [Hibernate] @CreationTimestamp & @UpdateTimestamp 
[[Product]()]
- [SpringDataJPA&Lombok]Using @Data on both Entity classes in the OneToMany relationship may cause bug -> Use @Data for one side, @Getter and @Setter for the other.
- [SpringDataJPA] Add @CrossOrigin to Repositories to accept calls from web browser script for the origin (Angular app)
- [SpringDataJPA] Use @Query to define a custom query method in the JPA Repository
- [SpringDataJPA] JPA Repository method starts with ````findBy...```` will be exposed by Data REST as endpoint ```/search/findBy...``` 
[[ProductRepository]()] 
- [SpringDataREST] Spring Data REST API supports pagination
  - Returns 20 entries per page by default
  - Endpoint: ```<entities>?page=<number>&size=<number```
s- When working with Spring Data REST we should actually use @Param instead of @RequestParam.


        












































