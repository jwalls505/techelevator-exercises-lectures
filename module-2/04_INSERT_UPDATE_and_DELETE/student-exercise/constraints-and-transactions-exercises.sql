-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
        SELECT * FROM actor;
        INSERT INTO actor (actor_id, first_name, last_name)
        VALUES(201, 'HAMPTON', 'AVENUE');
        INSERT INTO actor (actor_id, first_name, last_name)
        VALUES(202, 'LISA', 'BYWAY');
              
      

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
        SELECT * FROM film;
        INSERT INTO film (film_id, title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating)
        VALUES(1001, 'EUCLIDEAN PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, null, 0, 4.99, 198, 25.99, 'NC-17');
        
-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
        SELECT * FROM film_actor;
        INSERT INTO film_actor(actor_id, film_id)
        VALUES (201, 1001),
               (202, 1001);

-- 4. Add Mathmagical to the category table.
        SELECT * FROM category;
        INSERT INTO category(category_id, name)
        VALUES (17, 'Mathmagical');

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
        SELECT * FROM film WHERE title IN('EUCLIDEAN PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'Young Language');
        SELECT * FROM film_category WHERE film_id IN(274, 494, 714);
CREATE TRANSACTION
        INSERT INTO film_category(film_id, category_id)
        VALUES (1001, 17);
        UPDATE film_category SET category_id = 17
        WHERE film_id IN(274, 494, 714, 996);
ROLLBACK;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)
        SELECT title, rating FROM film IN(SELECT category_id WHERE category_id = 17);
CREATE Transaction
        UPDATE film SET rating = 'G'
        WHERE film_id IN(SELECT film_id FROM film_category where category_id = 17);
ROLLBACK;

-- 7. Add a copy of "Euclidean PI" to all the stores.
        SELECT * FROM inventory;
        INSERT INTO inventory (inventory_id, film_id, store_id)
        VALUES (4582, 1001, 1),
               (4583, 1001, 2);

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
        DELETE FROM film WHERE title = 'EUCLIDEAN PI'; --it violates the fk constraint "film_actor_film_id_fkey" on table "film_actor"
-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
        DELETE FROM category WHERE category.name = 'Mathmagical'; --violates film_category_category_id_fkey on table film_category

-- 10. Delete all links to Mathmagical in the film_category table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
        DELETE FROM film_category WHERE category_id = 17;--DElETE was successful, there is no foreign key constraints on that column in film_category
        

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE>
        DELETE FROM category WHERE category.name = 'Mathmagical'; --no longer foreign key constraint from film_category table
        DELETE FROM film WHERE title = 'EUCLIDEAN PI'; -- film table has foreign key constraints

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
        SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE; --film_id still has fk constraint to film_actor_film_id_fkey and film_category_film_id_fkey
        --and inventory_film_id_fkey
        --deleting the connectiong category and actors and delete from inventory will allow the Film to be removed
