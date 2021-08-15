# Coffee-Products
Assessment for Accenture a <i style="color:#f32ce1"><u>Coffee product</u></i>  

### Coffee Assignment
Assignment: <b>Coffee Assignment</b><br>
Prerequisite:
<b>Java JDK 15</b><br>
Multithreading - <b>optimistic locking</b><br>

#### Spring boot Testing
<p>The application is made with the spring of TDD, and that is the reason it contains a lot of unit tests. Integration test are also added. Unit and integration tests both are added in seperate directories you can find.</p>

#### Technologies
- Java 15
- Spring boot
- Integration testing using MockMvc
- Junit5
- Lombok
- Builder Pattern
- Single Responsibilities
- Thread safety

For thread safety, i am using java 1.8 StampedLock, in which we have optimistic read lock. Which make synchronization overhead is very low.

#### Built With
- Java
- Spring Boot
- Maven
- Clean And Build
- mvn clean install
- Build And Test
- mvn clean test
#### Authors
- Aqib Javed
- Thanks to Accenture for this assignment