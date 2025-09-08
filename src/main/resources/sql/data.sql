-- Authors
INSERT INTO authors (id, name) VALUES (1, 'Professor Carey Nachenberg');
INSERT INTO authors (id, name) VALUES (2, 'Professor Paul Eggert');

-- Books
INSERT INTO books (id, title, publisher, published_date) VALUES (1, 'Programming Languages (CS 131)', 'UCLA CS Department', '2023-01-25');
INSERT INTO books (id, title, publisher, published_date) VALUES (2, 'Computer Structure (CS 35L)', 'UCLA CS Department', '2023-01-20');

-- Reviews
INSERT INTO reviews (id, book_id, content, rating, created_date) VALUES (1, 1, 'Deep dive into functional and object-oriented languages.', 4.8, '2024-03-04');
INSERT INTO reviews (id, book_id, content, rating, created_date) VALUES (2, 2, 'Fundamentals explained clearly with great examples.', 4.7, '2024-03-03');

-- BooksAuthors
INSERT INTO books_authors (book_id, author_id) VALUES (1, 2); -- CS 131 - Eggert
INSERT INTO books_authors (book_id, author_id) VALUES (2, 1); -- CS 35L - Carey
