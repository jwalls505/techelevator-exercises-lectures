CREATE TABLE customer (
        customer_id SERIAL PRIMARY KEY,
        first_name varchar(50) NOT NULL,
        last_name varchar(50) NOT NULL,
        address_line1 varchar(50) NOT NULL,
        address_line2 varchar(50),
        city varchar(50) NOT NULL,
        state varchar(50) NOT NULL,
        zip character(5) NOT NULL,
        phone varchar(15) NOT NULL,
        
        CONSTRAINT check_customer_state CHECK (state IN ('NY', 'PA'))
);

ALTER TABLE customer DROP CONSTRAINT check_customer_state;
ALTER TABLE customer ADD CONSTRAINT check_customer_state CHECK (state IN ('NY', 'PA', 'WV'));


CREATE TABLE customer_purchase (
        purchase_id SERIAL PRIMARY KEY,
        customer_id INTEGER,
        art_id INTEGER,
        price NUMERIC(10,2) NOT NULL,
        purchase_date DATE NOT NULL,
        
        CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES (customer)
);





/*
  Customer
  customer_id PK
  Name
  Address
  Phone

customer_purchase
  Purchase_id PK
  customer_id FK
  art_id FK
  Price
  purchase_date

Art
  art_id PK
  artist_id FK
  artwork_title

Artist
 artist_id
 artist_name
*/