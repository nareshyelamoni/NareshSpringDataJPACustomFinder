# Spring Data JPA – Custom Finder Methods and Projections

## Project Overview

This project demonstrates how to implement **Custom Finder Methods and Projections** using Spring Data JPA in a Spring Boot application.

Spring Data JPA provides the ability to create database queries automatically based on method names. Instead of writing SQL queries manually, we can define finder methods in a repository interface.

This project also demonstrates **Interface-Based Projections** and **Dynamic Projections**, which allow us to retrieve only the required fields from database records rather than fetching the complete entity.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Eclipse IDE

## Features

- Implementing Spring Data JPA custom finder methods.
- Retrieving records using `findBy` query methods.
- Filtering records based on vaccine cost.
- Using `LessThan` and `GreaterThan` comparison operators.
- Implementing interface-based projections.
- Implementing dynamic projections using generic methods.
- Retrieving only selected columns from the database.

## Project Structure

```text
SpringDataJPACustomFinder
│
├── src/main/java
│   └── com.naresh
│       │
│       ├── model
│       │   └── Vaccine.java
│       │
│       ├── repo
│       │   └── IvaccineRepo.java
│       │
│       ├── service
│       │   ├── IVaccineService.java
│       │   └── VaccineService.java
│       │
│       ├── view
│       │   ├── ResultView.java
│       │   ├── ResultView1.java
│       │   ├── ResultView2.java
│       │   └── View.java
│       │
│       └── SpringDataJpaCustomFinderApplication.java
│
├── src/main/resources
│   └── application.properties
│
├── pom.xml
└── README.md
```

## Entity Class

The `Vaccine` entity represents the vaccine table in the database.

**Entity Attributes:**

| Attribute | Data Type | Description |
|---|---|---|
| id | Integer | Primary key |
| vaccineName | String | Name of the vaccine |
| vaccineCompany | String | Vaccine manufacturing company |
| cost | Double | Vaccine cost |

The entity uses the following JPA annotations:

- `@Entity` – Marks the class as a JPA entity.
- `@Table` – Maps the entity to a database table.
- `@Id` – Specifies the primary key.
- `@GeneratedValue` – Generates the primary key automatically.

## Custom Finder Methods

Custom finder methods allow developers to retrieve records by defining method names in the repository interface.

Spring Data JPA automatically generates the required queries based on the method name.

### 1. Find By Cost Less Than

```java
findByCostLessThan(Double cost);
```

This method retrieves vaccine records whose cost is less than the specified amount.

**Example:**

```java
fetchByCost(1500.2);
```

### 2. Find By Cost Greater Than

```java
<T> List<T> findByCostGreaterThan(
    Double cost,
    Class<T> type
);
```

This method retrieves vaccine records whose cost is greater than the specified amount.

It also supports dynamic projections, allowing the caller to specify which fields should be retrieved.

**Example:**

```java
fetchByCostGreaterThan(1500.3, ResultView2.class);
```

## Projections in Spring Data JPA

Projections are used to retrieve only the required fields from an entity instead of fetching all the entity attributes.

This helps reduce unnecessary data retrieval.

### 1. Interface-Based Projection

An interface-based projection defines getter methods for the fields that need to be retrieved.

For example, `ResultView` exposes:

- `getVaccineName()`
- `getVaccineCompany()`

Spring Data JPA uses these getter methods to retrieve the corresponding fields.

### 2. Dynamic Projection

Dynamic projections allow us to select the required projection at runtime.

In this project:

- `View` is used as a marker interface.
- `ResultView2` extends `View`.
- `ResultView2` exposes vaccine name and cost.

Example:

```java
fetchByCostGreaterThan(
    1500.3,
    ResultView2.class
);
```

The projection type is passed as a method argument, making the repository method reusable with different projection interfaces.

## Service Layer

The service layer acts as an intermediate layer between the application and repository.

It contains methods that delegate database operations to the repository.

The main operations include:

- Fetching vaccine details based on cost less than a specified value.
- Fetching vaccine details based on cost greater than a specified value using dynamic projections.

## Application Execution

The application demonstrates the following operations:

**Operation 1:**

```java
fetchByCost(1500.2);
```

Fetches vaccine details where the cost is less than `1500.2`.

**Operation 2:**

```java
fetchByCostGreaterThan(1500.3, ResultView2.class);
```

Fetches vaccine details where the cost is greater than `1500.3`, retrieving only the vaccine name and cost through the selected projection.

## Configuration

Configure your database connection in `src/main/resources/application.properties`.

Example MySQL configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Replace the database name, username and password with your actual MySQL configuration.

## How to Run the Project

1. Clone the repository.

```bash
git clone https://github.com/nareshyelamoni/NareshSpringDataJPACustomFinder.git
```

2. Open the project in Eclipse or IntelliJ IDEA.

3. Configure MySQL database credentials in `application.properties`.

4. Make sure MySQL is running.

5. Update Maven dependencies.

6. Run the Spring Boot main application class.

7. Check the console output to see the results of custom finder methods and projections.

## Key Concepts Learned

Through this project, I learned:

- How Spring Data JPA generates queries using method names.
- How to use comparison keywords such as `LessThan` and `GreaterThan`.
- How to implement custom finder methods.
- How to create interface-based projections.
- How to implement dynamic projections using generics.
- How to retrieve selected columns instead of complete entity objects.
- How to separate repository and service layer responsibilities.

## Author

**Naresh Yelamoni**

Java Full Stack Developer Aspirant

GitHub: [nareshyelamoni](https://github.com/nareshyelamoni)

---

If you find this project useful, feel free to explore the repository and learn more about Spring Data JPA.
