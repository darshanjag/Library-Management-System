
Library Management System

Library Management System for Portfolio created with SpringBoot and Hibernate using MVC architecture


## API Reference

#### Get all items

```http
  POST /student/add
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| | `string` | Adds Student to the Database |

#### Get item

```http
  GET student/find-by-email
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| email     | `string` | Fetches the student by Email |

```http
  POST transaction/issue
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|    | `string` | Issues Book to the user, saves transaction. sends email to the user. |

```http
  POST book/add
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|    | `string` | posts Book |

```http
  PUT student/update_mob
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|    | `string` |Updates Student Phone|

#### add(num1, num2)

Takes two numbers and returns the sum.


## Demo

Insert gif or link to demo


## Features

-adds student

-finds student by 

-updates student email

-adds books

-adds authors

-issues a book to user and sends mail

## 🚀 About Me
I'm a full stack developer...


## Installation
change application properties, update mysql username and password.
create database.

and update the spring.datasource.url in application properties


    