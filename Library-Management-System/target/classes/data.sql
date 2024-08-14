-- Insert values into the Books table
INSERT INTO Books (title, author, publication_year, isbn)
VALUES ('The Catcher in the Rye', 'J.D. Salinger', 1951, '271-0-316-76948-1'),
       ('Interdocution to Java ', 'Karies Joe', 2000, '978-0-06-112660-7'),
       ('To Kill a Mockingbird', 'Ibream Mostafa', 2100, '772-0-05-112443-22'),
       ('To Kill a Mockingbird', 'Heabia  Kubder', 1960, '978-3-01-102508-4'),
       ('Santa Colaes ', 'Bouat ', 1949, '978-0-452-28423-4');

-- Insert values into the Patrons table
INSERT INTO Patrons (name, contact_info)
VALUES ('Ahmed ELhada', 'elgadal.ss@Hotanail.com'),
       ('Sara Omar', 'sara.Omar@Faaanail.com'),
       ('John Doe', 'john.doe@Hotanail.com'),
       ('Jane Smith', 'jane.smith@IEEE.com'),
       ('Alice Johnson', 'alice.johnson@SSSCS.com');

-- Insert values into the Borrowings table
INSERT INTO Borrowings (book_id, patron_id, borrow_date, return_date)
VALUES (1, 1, '2024-08-01', '2024-08-15'),
       (1, 2, '2024-08-03', '2024-09-15'),
       (2, 2, '2024-08-05', '2024-08-16'),
       (2, 4, '2024-08-05', '2024-10-10'),
       (4, 2, '2024-08-05', '2024-10-16'),
       (2, 1, '2024-08-15', '2024-09-16'),
       (3, 3, '2024-08-06', '2024-08-17'),
       (4, 4, '2022-08-05', '2022-10-16'),
       (3, 1, '2024-08-12', '2024-08-22'),
       (3, 2, '2024-08-30', '2024-09-07');
