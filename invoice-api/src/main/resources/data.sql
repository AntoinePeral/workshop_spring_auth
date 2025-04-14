-- Utilisateurs (mot de passe hashé avec BCrypt)
INSERT INTO users (email, password)
VALUES
    ('user1@example.com', '$2y$10$PftwhbG.G.6h6f21ZP7EVe.kkfLs9GoKUTwEME7pPyPlLWJql5iQy'), -- "password123"
    ('admin@example.com', '$2y$10$RrxgTBQWMqg3yGYYp3Azi.Fcc9yVYYHsu8aJDCmFf1igxcvGjNKh.'); -- "adminpass"

-- Rôles
INSERT INTO user_roles (user_id, roles)
VALUES
    (1, 'ROLE_USER'),
    (2, 'ROLE_ADMIN');

-- Factures
INSERT INTO invoice ( description, amount, date, user_id)
VALUES
    ( 'Facture Electricité Janvier', 89.99, '2024-01-15', 1),
    ( 'Facture Eau Février', 42.50, '2024-02-10', 1),
    ( 'Facture Internet Mars', 39.90, '2024-03-05', 1);
