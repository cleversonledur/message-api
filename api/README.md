# message-api

This is a simple message api that was constructed using Java Spring Boot. This project uses Spring Data to communicate with a MongoDB instance. Also, you must authenticate with OAuth method.

## Authentication

This API uses OAuth2 authentication method that is managed by Spring Security. You must follow the next steps in order to obtain an access and refresh token. 

[logo]: https://assets.digitalocean.com/articles/oauth/abstract_flow.png test

1. For obtaining the access and refresh token, you must request a POST for http://localhost:8080/oauth/token with the following username and password for a Basic Auth:

    - Username: `api-client`
    - Password: `api-secret`
2. Additionally, you must insert a valid user information as a payload. Insert the following data:

    ```
    grant_type:password
    username:admin@admin.com 
    password:12345
    ```

3. You will receive the access and refresh token. Something like the following:

    ```JSON
    {
        "access_token": "c3fd8113-c620-4117-a4b4-8c33910e8b98",
        "token_type": "bearer",
        "refresh_token": "300302d4-e6e2-4c08-9589-113d3c816b61",
        "expires_in": 4999,
        "scope": "read write trust"
    }
    ```
    
4. With `access_token` and `refresh_token` you can call the api endpoints. The access_code will be usable during the first 2 minutes. After 2 minutes, access-token gets expired, your further resource requests will fail.

5. To get a new `access_token` you can use the refresh_token changing the request of step 2 for the following data:

    ```
    grant_type:refresh_token
    refresh_token:[INSERT REFRESH TOKEN HERE] 
    ```
    
> Refresh-token expires too[10 minutes]. After that, you should see your refresh request getting failed.
  
