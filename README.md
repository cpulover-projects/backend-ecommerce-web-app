## Back-end Development Process

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
2. Customer base path for REST API in 
[application.properties]()
3. Disable certain HTTP methods for certain Entities: create Spring Data REST Configuration with @Configuration implements RepositoryRestConfigurer 
[[DataRestConfig]()] 

## Notes
- @CreationTimestamp & @UpdateTimestamp 
[[Product]()]
- Using @Data on both Entity classes in the OneToMany relationship may cause bug -> Use @Data for one side, @Getter and @Setter for the other.


















































