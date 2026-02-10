# Spring Boot RESTful API - Practical Questions

## Name: Gatete Vanessa

## id: 27274

---

**Question 1: Library Book Management API**

- Project: `question1-library-api`

| Endpoint                          | Method | Description              | Sample response                     | Screenshot                                                                  |
| --------------------------------- | -----: | ------------------------ | ----------------------------------- | --------------------------------------------------------------------------- |
| `/api/books`                      |    GET | Return list of all books | [{"id":1,"title":"Clean Code",...}] | [![get books](screenshoots/get%20books.png)](screenshoots/get%20books.png)      |
| `/api/books/{id}`                 |    GET | Get book by id           | {"id":1,"title":"Clean Code",...}   | [![library id](screenshoots/library%20id%20.png)](screenshoots/library%20id%20.png) |
| `/api/books/search?title={title}` |    GET | Search books by title    | [ ... ]                             | (no screenshot)                                                             |
| `/api/books`                      |   POST | Add new Book (JSON body) | 201 Created, created Book JSON      | (no screenshot)                                                             |
| `/api/books/{id}`                 | DELETE | Delete book by id        | 204 No Content                      | (no screenshot)                                                             |

---

**Question 2: Student Registration API**

- Project: `question2-student-api`

| Endpoint                            | Method | Description           | Screenshot                                                                                     |
| ----------------------------------- | -----: | --------------------- | ---------------------------------------------------------------------------------------------- |
| `/api/students`                     |    GET | Get all students      | [![Students list](screenshoots/Stugent%20get.png)](screenshoots/Stugent%20get.png)                 |
| `/api/students/{studentId}`         |    GET | Get student by ID     | [![get by id](screenshoots/getting%20student%20y%20id%20.png)](screenshoots/getting%20student%20y%20id%20.png) |
| `/api/students/major/{major}`       |    GET | Get students by major | [![by major](screenshoots/student%20by%20major%20.png)](screenshoots/student%20by%20major%20.png)          |
| `/api/students/filter?gpa={minGpa}` |    GET | Filter by min GPA     | [![by gpa](screenshoots/Students%20by%20gpa.png)](screenshoots/Students%20by%20gpa.png)                |
| `/api/students`                     |   POST | Register new student  | [![create](screenshoots/student%20creation%20.png)](screenshoots/student%20creation%20.png)            |
| `/api/students/{studentId}`         |    PUT | Update student info   | [![put](screenshoots/student%20Put.png)](screenshoots/student%20Put.png)                           |

---

**Question 3: Restaurant Menu API**

- Project: `question3-restaurant-api`

| Endpoint                             | Method | Description               | Screenshot                                                                                     |
| ------------------------------------ | -----: | ------------------------- | ---------------------------------------------------------------------------------------------- |
| `/api/menu`                          |    GET | Get all menu items        | [![all menu](screenshoots/get%20all%20menu.png)](screenshoots/get%20all%20menu.png)                    |
| `/api/menu/{id}`                     |    GET | Get menu item by id       | [![menu id](screenshoots/menu%20by%20id%20.png)](screenshoots/menu%20by%20id%20.png)                       |
| `/api/menu/category/{category}`      |    GET | Get items by category     | [![by category](screenshoots/menu%20by%20category%20.png)](screenshoots/menu%20by%20category%20.png)       |
| `/api/menu/available?available=true` |    GET | Get available items       | [![available](screenshoots/Menu%20if%20available%20.png)](screenshoots/Menu%20if%20available%20.png)       |
| `/api/menu/search?name={name}`       |    GET | Search menu items by name | [![search name](screenshoots/get%20name%20menu.png)](screenshoots/get%20name%20menu.png)               |
| `/api/menu`                          |   POST | Add new menu item         | [![add menu](screenshoots/add%20menu%20.png)](screenshoots/add%20menu%20.png)                          |
| `/api/menu/{id}/availability`        |    PUT | Toggle availability       | [![put available](screenshoots/put%20menu%20available%20.png)](screenshoots/put%20menu%20available%20.png) |
| `/api/menu/{id}`                     | DELETE | Remove menu item          | [![delete menu](screenshoots/delete%20menu%20item.png)](screenshoots/delete%20menu%20item.png)         |

---

**Question 4: E-Commerce Product API**

- Project: `question4-ecommerce-api`

| Endpoint                                              | Method | Description                                 | Screenshot                                                                                                               |
| ----------------------------------------------------- | -----: | ------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------ |
| `/api/products`                                       |    GET | Get all products (supports `?page=&limit=`) | [![all products](screenshoots/Get%20all%20products.png)](screenshoots/Get%20all%20products.png)                                  |
| `/api/products/{productId}`                           |    GET | Get product details                         | [![by id](screenshoots/get%20product%20by%20id%20.png)](screenshoots/get%20product%20by%20id%20.png)                                     |
| `/api/products/category/{category}`                   |    GET | Get products by category                    | [![by category](screenshoots/get%20product%20by%20category%20.png)](screenshoots/get%20product%20by%20category%20.png)                   |
| `/api/products/brand/{brand}`                         |    GET | Get products by brand                       | [![by brand](screenshoots/get%20products%20by%20brand%20.png)](screenshoots/get%20products%20by%20brand%20.png)                          |
| `/api/products/search?keyword={keyword}`              |    GET | Search products by keyword                  | [![search](screenshoots/search%20products%20by%20keyword.png)](screenshoots/search%20products%20by%20keyword.png)                    |
| `/api/products/price-range?min={min}&max={max}`       |    GET | Get products within price range             | [![price range](screenshoots/get%20product%20within%20product%20range%20.png)](screenshoots/get%20product%20within%20product%20range%20.png) |
| `/api/products/in-stock`                              |    GET | Products with stockQuantity > 0             | [![in stock](screenshoots/get%20pro%20in%20stock.png)](screenshoots/get%20pro%20in%20stock.png)                                      |
| `/api/products`                                       |   POST | Add new product                             | [![add product](screenshoots/add%20new%20product.png)](screenshoots/add%20new%20product.png)                                     |
| `/api/products/{productId}`                           |    PUT | Update product details                      | [![put product](screenshoots/put%20ptoduct%20details%20.png)](screenshoots/put%20ptoduct%20details%20.png)                           |
| `/api/products/{productId}/stock?quantity={quantity}` |  PATCH | Update stock quantity                       | (no screenshot)                                                                                                          |
| `/api/products/{productId}`                           | DELETE | Delete product                              | [![delete?](screenshoots/get%20product%20by%20id%20.png)](screenshoots/get%20product%20by%20id%20.png)                                   |

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
