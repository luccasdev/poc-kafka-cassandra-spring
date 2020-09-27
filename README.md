<h1 align="center">
  <br>
  <a href="https://github.com/luccasdev/log-manager-backend"><img src="https://i.imgur.com/IxjyJxy.png" alt="ArminC AutoExec"></a>
</h1>

<h4 align="center">Proof of Concept using Spring boot with Kafka and Cassandra (NoSQL) to manager orders.</h4>
<h5 align="center">With Integration Tests and Weblayer Tests using JUnit 5</h5>

<p align="center">
    <a href="https://github.com/luccasdev/log-manager-backend/commits/master">
    <img src="https://img.shields.io/github/last-commit/luccasdev/poc-kafka-cassandra-spring?style=flat-square&logo=github&logoColor=white"
         alt="GitHub last commit">
    <a href="https://github.com/luccasdev/log-manager-backend/issues">
    <img src="https://img.shields.io/github/issues-raw/luccasdev/poc-kafka-cassandra-spring?style=flat-square&logo=github&logoColor=white"
         alt="GitHub issues">
    <a href="https://github.com/luccasdev/log-manager-backend/pulls">
    <img src="https://img.shields.io/github/issues-pr-raw/luccasdev/poc-kafka-cassandra-spring?style=flat-square&logo=github&logoColor=white"
         alt="GitHub pull requests">
</p>
      
<p align="center">
  <a href="#technologies">Techonologies</a> •
  <a href="#features">Features</a> •
  <a href="#contact">Author Contact</a> •
  <a href="#license">License</a>
</p>

---

## Technologies

* **Back-end**
  * Java 11
  * Spring Boot
  * Spring Data
  * Cassandra
  * Kafka
  * Lombok
  * Maven
  * Slf4j
  * JUnit 5

## Features

1 - Find Order by Id

Example: 
<br>
**Request:**
```json
GET /order/v1/{orderId} HTTP/1.1
Path Parameter: Order id to find
```

**Success:**
```json
HTTP/1.1 200 OK
Content-Type: application/json

{
    "title": "Big Mac",
    "description": "Lanche do McDonalds :)"
}
```
2 - Find All Orders

Example: 
<br>
**Request:**
```json
GET /order/v1 HTTP/1.1
```

**Success:**
```json
HTTP/1.1 200 OK
Content-Type: application/json

[
    {
        "id": "39d9a682-0ecb-41fd-b38c-3f2469a028d0",
        "title": "Big Mac",
        "description": "Lanche do McDonalds :)"
    },
    {
        "id": "6a78e09b-5e86-4970-bc76-ecec06a95107",
        "title": "Milk Shake",
        "description": "Bem gelado!"
    }
]
```
3 - Creating New Order (Sending to Kafka Queue)

Example: 
<br>
**Request:**
```json
POST /order/v1 HTTP/1.1
Content-Type: application/json
Body: 
{
    "title": "Big Mac",
    "description": "Lanche do McDonalds :)"
}
 
```

**Success:**
```json
HTTP/1.1 200 OK
Content-Type: application/json

{
    "id": "18b57f64-2654-4084-97e9-d4b565e4abb2",
    "title": "Big Mac",
    "description": "Lanche do McDonalds :)"
}
```


## Contact
- [LinkedIn](https://www.linkedin.com/in/lucasrsouza-ti/)
- [Twitter](https://twitter.com/lucasrdev)
- Website at [luccas.dev](https://luccas.dev)
- E-Mail: **lucasrti@hotmail.com**

## License

[![License: CC BY-NC-SA 4.0](https://img.shields.io/badge/License-CC%20BY--NC--SA%204.0-orange.svg?style=flat-square)](https://creativecommons.org/licenses/by-nc-sa/4.0/)

- Copyright © [LuccasDev](https://luccas.dev "Luccas Directory Database").
