                                Comment Assignment Application.

    In this assignment, I'm using MySQL as a database and created rest services. I'm also sharing the swagger documentation URL  
    and postman collection for better understanding.


1 : To save the comment in database.

    A : Pass comment's data as a request body.
    B : If I have to store any comment then it simply stores and If I have to store any comment with corresponding comment then in that case
    I have to pass reference comment_id in the request param with same API.
    C : It returns response based on the request.

2 : Api to fetch all comments.

    A : No need to pass anything with request.
    B : It fetch all the mapped and unmapped comments.

3 : Get all the child's comments and sibblings related to parent comment.

    A : I need to pass the parent comment id in request param to extract information.
    B : It returns all the corresponding comments including parent comment itself.

Other configurations : 

1 : Swagger URL : http://localhost:9091/assignment/swagger-ui.html#/
2 : Github repository URL : https://github.com/karanchutani/Comment-Repository

Run : 

1 : Simple run the main java file as standalone application.
2 : Main file is located in the main folder of comment application.
3 : You can change configurations in application.properties.
