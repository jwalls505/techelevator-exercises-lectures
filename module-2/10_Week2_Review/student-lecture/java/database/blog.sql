/*
        Create a database named blog. The database should be able to hold blog posts and blog posts should be able 
        to have many comments associated with them.
*/


CREATE TABLE "user" (
        user_id SERIAL PRIMARY KEY,
        first_name VARCHAR(50) NOT NULL,
        last_name VARCHAR(50) NOT NULL,
        username VARCHAR(100) UNIQUE NOT NULL,
        password VARCHAR(100) NOT NULL,
        date_joined DATE NOT NULL,
        isActive BOOLEAN NOT NULL DEFAULT(TRUE)
);

CREATE TABLE post ( 
        post_id SERIAL PRIMARY KEY,
        user_id INTEGER REFERENCES "user" (user_id),
        title VARCHAR(50) NOT NULL,
        content TEXT NOT NULL,
        date_posted TIMESTAMP NOT NULL DEFAULT(current_timestamp),
        isActive BOOLEAN NOT NULL DEFAULT(TRUE)
);

CREATE TABLE post_comments (
        comment_id SERIAL PRIMARY KEY,
        user_id INTEGER REFERENCES "user" (user_id),
        post_id INTEGER REFERENCES post (post_id),
        date_commented TIMESTAMP NOT NULL DEFAULT(current_timestamp),
        comment TEXT NOT NULL,
        isActive BOOLEAN NOT NULL DEFAULT(TRUE)
);


