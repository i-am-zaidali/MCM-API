# MissionChief Metrics API

A simple API written in JAVA using Spring Boot that offers MissionChief user data through various endpoints.

Currently supported endpoints include:
1. `/alliances/info` - Returns information about an alliance.
   - Query Parameters:
     - `id` - The ID of the alliance.
2. `/alliances/all` - Returns a list of all alliances.
   - Query Parameters:
     - `page` - The page number to return.
       - must be greater than 0
       - defaults to 1
     - `per_page` - The number of alliances to return per page.
       - must be greater than 5
       - defaults to 10
     - `sort` - The order to sort in.
       - must be either `ascending`, `descending`, or `random`
       - defaults to `random`
     - `sort_by` - The field to sort by.
       - must be either `id`, `credits` or `position` (credits and position might have the same result)
       - defaults to `id`
3. `/alliances/membercount` - Returns the number of members in an alliance.
   - Query Parameters:
     - `id` - The ID of the alliance.
4. `/alliances/members/all` - Returns a list of all members in an alliance.
   - Query Parameters:
     - `id` - The ID of the alliance.
     - `page` - The page number to return.
       - must be greater than 0
       - defaults to 1
     - `per_page` - The number of members to return per page.
       - must be greater than 5
       - defaults to 10
     - `sort` - The order to sort in.
       - must be either `ascending`, `descending`, or `random`
       - defaults to `random`
     - `sort_by` - The field to sort by.
       - must be either `id` or `credits`
       - defaults to `id`
5. `/alliances/members/info` - Returns information about a member in an alliance.
    - Query Parameters:
      - `id` - The ID of the member.

## Running the application

To run the application, you need to have Java>=11 installed on your machine. You can download it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
You can then run the application by running the following command in the root directory of the project:

```shell
./mvnw spring-boot:run
```