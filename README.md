# ecommerce-cigarettes
Project Ecommerce Cigarettes

1. Packages:
>Install npm 16.6.6. Past in terminal: **npm install**<br>

>To Install Angular CLI 15.2 locally:  Path cd frontend and after cd angular and Past **npm install @angular/cli@15.2** and **npm install @angular/core@15.2** <br>

>To Install Angular CLI 15.2 globally. Past in terminal: **npm install -g @angular/cli@15.2**<br><br>

2. Run the Angular:
>In your terminal locally, paste: **npx ng serve**<br>
>If the install was globlally: **ng serve**<br><br>

3. Configure Spring Boot:

> In application.properties, past: <br>
>>spring.jpa.hibernate.ddl-auto = update 
>>spring.datasource.url = jdbc:mysql://${MYSQL_HOST:localhost}:3306/**Name of your Database**
>>spring.datasource.username = root
>>spring.datasource.password = **Password of your MySQL** <br><br>

4. Signinup and Login User Spring Boot:
  >Create user and login. Past in Postman in the router: **http://localhost:8080/auth/signup** and complete the JSON bellow:<br>

  >>{  
  >>"fullName": "",
  >>"email": "",
  >>"phoneNumber": "",
  >>"cpf":"",
  >>"password": "",
  >>"address":"",
  >>"role":"USER" <br>
  
  >After this, do login: **http://localhost:8080/auth/login** and complete the JSON bellow, with user created:<br>
   >>"email": "",
   >>"password": "",

}
