# curl commands for rest-api testing

#### create user
curl -s -X POST -d '{"role":"USER_ROLE_CREATED"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/crud_app/rest/users

#### get user 1
curl -s http://localhost:8080/crud_app/rest/users/1

#### update user 3
curl -s -X PUT -d '{"role":"USER_ROLE_UPDATED"}' -H 'Content-Type:application/json' http://localhost:8080/crud_app/rest/users/3

#### delete user 1
curl -s -X DELETE http://localhost:8080/crud_app/rest/users/2

#### get all users
curl -s http://localhost:8080/crud_app/rest/users