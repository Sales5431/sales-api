# sales-api

Api Request:
curl --location --request POST 'http://localhost:8081/sales-v1/addUserData' \
--header 'Content-Type: application/json' \
--data-raw '{
"firstName" : "Akshay",
"middleName" : "Anil",
"lastName" : "Kenjale",
"dob" : "1996-10-30",
"gender" : "Male",
"phoneNumber" : "8381021291",
"emailAddress" : "def@gmail.com",
"currentAddress" : "Pune",
"aadharNumber" : "4456 1147 6644",
"panNumber" : "HHBRDS668F",
"aadharPath" : "Aadhar path 2",
"panPath" : "PAN path 2"

}'

curl --location --request GET 'http://localhost:8081/sales-v1/retrieveAllUsers' \
--header 'Content-Type: application/json'

curl --location --request GET 'http://localhost:8081/sales-v1/retrieveFilteredUser?searchParam=Rishikesh%20Krishna%20Sawant&searchBy=name' \
--header 'Content-Type: application/json'

curl --location --request POST 'http://localhost:8081/sales-v1/updateTransaction?userId=1&amount=20000' \
--header 'Content-Type: application/json' \
--data-raw ''