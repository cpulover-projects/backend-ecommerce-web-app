## Back-end Development Process

### Spring Boot Setup
- Spring Data JPA
- REST Repository
- MySQL Driver
- Lombok
- Spring Boot DevTools (Optional)

### Database Setup - Hibernate/JPA
1. Create database for Entity 
[[create-database.sql]()]
2. Configure JDBC connection and Hibernate dialect in 
[[application.properties]()]
3. Create Entity classes 
[[Product]()] [[ProductCategory]()]


## Notes
- @CreationTimestamp & @UpdateTimestamp 
[[Product]()]
- Using @Data on both Entity classes in the OneToMany relationship may cause bug -> Use @Data for one side, @Getter and @Setter for the other.


















































