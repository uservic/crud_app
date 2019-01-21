# curl commands for rest-api testing

#### create user with role USER
curl -s -X POST -d '{"login":"NewUser000", "password":"00000"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/crud_app/rest/users

#### create user with role ADMIN
curl -s -X POST -d '{"login":"NewUser111", "password":"00000"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/crud_app/rest/users?admin=1

#### get user 1
curl -s http://localhost:8080/crud_app/rest/users/1

#### update user 3
curl -s -X PUT -d '{"login":"Ann_UPDATED", "password":"updated"}' -H 'Content-Type:application/json' http://localhost:8080/crud_app/rest/users/3

#### delete user 2
curl -s -X DELETE http://localhost:8080/crud_app/rest/users/2

#### get all users
curl -s http://localhost:8080/crud_app/rest/users

------------------------------------------------------------------------------

#### create role 
curl -s -X POST -d '{"dictType":"Role", "name": "NewRole", "ext_id": "333"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/crud_app/rest/dicts

#### get role 1
curl -s http://localhost:8080/crud_app/rest/dicts/1

#### update role 2
curl -s -X PUT -d '{"dictType":"Role", "name": "ADMIN_ROLE_UPDATED", "ext_id":"2"}' -H 'Content-Type:application/json' http://localhost:8080/crud_app/rest/dicts/2

#### delete role 1 (linked fields in user-table are set to NULL)
curl -s -X DELETE http://localhost:8080/crud_app/rest/dicts/1

#### get all dictionaries
curl -s http://localhost:8080/crud_app/rest/dicts