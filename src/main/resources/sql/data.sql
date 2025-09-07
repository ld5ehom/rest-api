-- Authors
INSERT INTO authors (id, name) VALUES (1000, 'Professor Carey Nachenberg');
INSERT INTO authors (id, name) VALUES (2000, 'Professor Paul Eggert');

-- Books
INSERT INTO books (id, title, publisher, published_date) VALUES (1000, 'Computer Structure (CS 35L)', 'UCLA CS Department', '2023-01-20');
INSERT INTO books (id, title, publisher, published_date) VALUES (2000, 'Programming Languages (CS 131)', 'UCLA CS Department', '2023-01-25');

-- Reviews
INSERT INTO reviews (id, book_id, content, rating, created_date) VALUES (1000, 1000, 'Fundamentals explained clearly with great examples.', 4.7, '2024-03-03');
INSERT INTO reviews (id, book_id, content, rating, created_date) VALUES (2000, 2000, 'Deep dive into functional and object-oriented languages.', 4.8, '2024-03-04');

-- BooksAuthors - many-to-many relationship between books and authors
INSERT INTO books_authors (book_id, author_id) VALUES (1000, 1000);
INSERT INTO books_authors (book_id, author_id) VALUES (2000, 2000);
