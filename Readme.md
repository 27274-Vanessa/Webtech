# Spring Boot RESTful API - Practical Questions

This repository contains separate Spring Boot projects for Questions 1–5 and a bonus. This README documents endpoints, sample requests/responses, how to run the projects, and screenshots (Q1–Q4). Question 5 and Bonus: endpoints only (screenshots pending).

---

**How to run**:

- Open the project folder for a question (e.g., `question1-library-api/question1-library-api`).
- Run using Maven wrapper on Windows:

```powershell
cd question1-library-api\question1-library-api
mvnw spring-boot:run
```

- Or run the packaged jar in `target`:

```powershell
java -jar target\<artifact>.jar
```

---

**Question 1: Library Book Management API**

- Project: `question1-library-api`

| Endpoint                          | Method | Description              | Sample response                     | Screenshot                                  |
| --------------------------------- | -----: | ------------------------ | ----------------------------------- | ------------------------------------------- |
| `/api/books`                      |    GET | Return list of all books | [{"id":1,"title":"Clean Code",...}] | ![get books](screenshoots/get books.png)    |
| `/api/books/{id}`                 |    GET | Get book by id           | {"id":1,"title":"Clean Code",...}   | ![library id](screenshoots/library id .png) |
| `/api/books/search?title={title}` |    GET | Search books by title    | [ ... ]                             | (no screenshot)                             |
| `/api/books`                      |   POST | Add new Book (JSON body) | 201 Created, created Book JSON      | (no screenshot)                             |
| `/api/books/{id}`                 | DELETE | Delete book by id        | 204 No Content                      | (no screenshot)                             |

---

**Question 2: Student Registration API**

- Project: `question2-student-api`

| Endpoint                            | Method | Description           | Screenshot                                           |
| ----------------------------------- | -----: | --------------------- | ---------------------------------------------------- |
| `/api/students`                     |    GET | Get all students      | ![Students list](screenshoots/Stugent get.png)       |
| `/api/students/{studentId}`         |    GET | Get student by ID     | ![get by id](screenshoots/getting student y id .png) |
| `/api/students/major/{major}`       |    GET | Get students by major | ![by major](screenshoots/student by major .png)      |
| `/api/students/filter?gpa={minGpa}` |    GET | Filter by min GPA     | ![by gpa](screenshoots/Students by gpa.png)          |
| `/api/students`                     |   POST | Register new student  | ![create](screenshoots/student creation .png)        |
| `/api/students/{studentId}`         |    PUT | Update student info   | ![put](screenshoots/student Put.png)                 |

---

**Question 3: Restaurant Menu API**

- Project: `question3-restaurant-api`

| Endpoint                             | Method | Description               | Screenshot                                             |
| ------------------------------------ | -----: | ------------------------- | ------------------------------------------------------ |
| `/api/menu`                          |    GET | Get all menu items        | ![all menu](screenshoots/get all menu.png)             |
| `/api/menu/{id}`                     |    GET | Get menu item by id       | ![menu id](screenshoots/menu by id .png)               |
| `/api/menu/category/{category}`      |    GET | Get items by category     | ![by category](screenshoots/menu by category .png)     |
| `/api/menu/available?available=true` |    GET | Get available items       | ![available](screenshoots/Menu if available .png)      |
| `/api/menu/search?name={name}`       |    GET | Search menu items by name | ![search name](screenshoots/get name menu.png)         |
| `/api/menu`                          |   POST | Add new menu item         | ![add menu](screenshoots/add menu .png)                |
| `/api/menu/{id}/availability`        |    PUT | Toggle availability       | ![put available](screenshoots/put menu available .png) |
| `/api/menu/{id}`                     | DELETE | Remove menu item          | ![delete menu](screenshoots/delete menu item.png)      |

---

**Question 4: E-Commerce Product API**

- Project: `question4-ecommerce-api`

| Endpoint                                              | Method | Description                                 | Screenshot                                                         |
| ----------------------------------------------------- | -----: | ------------------------------------------- | ------------------------------------------------------------------ |
| `/api/products`                                       |    GET | Get all products (supports `?page=&limit=`) | ![all products](screenshoots/Get all products.png)                 |
| `/api/products/{productId}`                           |    GET | Get product details                         | ![by id](screenshoots/get product by id .png)                      |
| `/api/products/category/{category}`                   |    GET | Get products by category                    | ![by category](screenshoots/get product by category .png)          |
| `/api/products/brand/{brand}`                         |    GET | Get products by brand                       | ![by brand](screenshoots/get products by brand .png)               |
| `/api/products/search?keyword={keyword}`              |    GET | Search products by keyword                  | ![search](screenshoots/search products by keyword.png)             |
| `/api/products/price-range?min={min}&max={max}`       |    GET | Get products within price range             | ![price range](screenshoots/get product within product range .png) |
| `/api/products/in-stock`                              |    GET | Products with stockQuantity > 0             | ![in stock](screenshoots/get pro in stock.png)                     |
| `/api/products`                                       |   POST | Add new product                             | ![add product](screenshoots/add new product.png)                   |
| `/api/products/{productId}`                           |    PUT | Update product details                      | ![put product](screenshoots/put ptoduct details .png)              |
| `/api/products/{productId}/stock?quantity={quantity}` |  PATCH | Update stock quantity                       | (no screenshot)                                                    |
| `/api/products/{productId}`                           | DELETE | Delete product                              | ![delete?](screenshoots/get product by id .png)                    |

---

**Question 5: Task Management API (endpoints only, screenshots pending)**

- Project: `question5-taskmanagement-api`

Endpoints:

- GET `/api/tasks`
- GET `/api/tasks/{taskId}`
- GET `/api/tasks/status?completed={true|false}`
- GET `/api/tasks/priority/{priority}`
- POST `/api/tasks`
- PUT `/api/tasks/{taskId}`
- PATCH `/api/tasks/{taskId}/complete`
- DELETE `/api/tasks/{taskId}`

---

**Bonus: User Profile API (endpoints only, screenshots pending)**

- Project: `bonus-userprofile-api`

Endpoints (examples):

- GET `/api/users`
- GET `/api/users/{userId}`
- POST `/api/users` (create)
- PUT `/api/users/{userId}` (update)
- DELETE `/api/users/{userId}`
- GET `/api/users/search?username={username}`
- GET `/api/users/country/{country}`
- GET `/api/users/age-range?min={min}&max={max}`
- PUT `/api/users/{userId}/activate`
- PUT `/api/users/{userId}/deactivate`

---

Notes:

- Screenshot files are stored in the project's root `screenshoots/` folder and referenced above. Filenames were used as-is — spaces and typos kept to match filenames.
- When you provide the screenshots for Question 5 and Bonus, tell me and I will add them into the README in the appropriate table cells.

---

If you'd like, I can also:

- Generate a Postman collection from these endpoints,
- Add exact sample request bodies for POST/PUT/PATCH operations,
- Or insert the screenshots inline as full-sized images instead of small thumbnails.

Tell me which next step you want.
