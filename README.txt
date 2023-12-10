API
------------------------------------------------------------------------------------------------------------------------
Creation of user without any authentication (added encoder for password) - just creates record in users table
POST
http://localhost:8080/user/create
request body
{
    "name":"varvara",
    "email":"vs@ya.com",
    "password":"admin"
}
------------------------------------------------------------------------------------------------------------------------
Adding of quote. As we don`t have any authentication we receive userId from request body
POST
http://localhost:8080/quote/add
{
    "content":"Всем привет",
    "userId" : "1"
}
------------------------------------------------------------------------------------------------------------------------
Deleting quote, add quoteId as path variable (delete quote with id = 2)
DELETE
http://localhost:8080/quote/delete/2
------------------------------------------------------------------------------------------------------------------------
Editing quote content. All information in json of request body
POST
http://localhost:8080/quote/edit
{
    "content":"Всем пока",
    "userId" : "1",
    "id":"3"
}
------------------------------------------------------------------------------------------------------------------------
View quote with id = 3
GET
http://localhost:8080/quote/get/3
------------------------------------------------------------------------------------------------------------------------
View random quote
GET
http://localhost:8080/quote/get/random
------------------------------------------------------------------------------------------------------------------------
Upvote quote with id = 2
POST
http://localhost:8080/quote/2/upvote
------------------------------------------------------------------------------------------------------------------------
Downvote quote with id = 2
POST
http://localhost:8080/quote/2/downvote
------------------------------------------------------------------------------------------------------------------------
View top 10 best quotes
GET
http://localhost:8080/statistic/quote/top/best
------------------------------------------------------------------------------------------------------------------------
View top 10 worst quotes
GET
http://localhost:8080/statistic/quote/top/worst
------------------------------------------------------------------------------------------------------------------------
View evolution by time of quote with id = 2
GET
http://localhost:8080/statistic/quote/2/evolution