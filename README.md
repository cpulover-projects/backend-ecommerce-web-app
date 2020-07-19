# Back-end Development Process

### Spring Boot Setup
- Spring Data JPA
- REST Repository
- MySQL Driver
- Lombok

### Database Setup - Hibernate/JPA
1. Create database for Entity 
[[create-database.sql]()]
2. Configure JDBC connection and Hibernate dialect in 
[application.properties]()
3. Create Entity classes 
[[Product]()] [[ProductCategory]()]

### Spring Data JPA/REST
1. Create Repositories 
[[ProductRepository]()] [[ProductCategoryRepository]()]
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
- @CreationTimestamp & @UpdateTimestamp 
[[Product]()]
- Using @Data on both Entity classes in the OneToMany relationship may cause bug -> Use @Data for one side, @Getter and @Setter for the other.
- Add @CrossOrigin to Repositories to accept calls from web browser script for the origin (Angular app)
- Use @Query to define a custom query method in the JPA Repository
- JPA Repository method starts with ````findBy...```` will be exposed by Data REST as endpoint ```/search/findBy...``` 
[[ProductRepository]()] 
- REST API returns 20 entries per page by default
















































