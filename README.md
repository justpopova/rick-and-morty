***Rick-And-Morty***
**Features**
- Randomly shows information about some character
- Search characters by the part of their name
- Synchronization from API every 30 minutes

**QuickStart**

1. Clone repository
2. Configure application properties

```
spring.datasource.url=YOUR_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.properties.hibernate.dialect=DB_DIALECT
```

For example:

```
   spring.datasource.url=jdbc:postgresql://localhost:5432/rickandmorty
   spring.datasource.username=postgres
   spring.datasource.password=9691
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

3. Run the project.

