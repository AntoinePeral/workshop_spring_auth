-- Utilisateurs (mot de passe hashé avec BCrypt)
INSERT INTO users (email, password)
VALUES
    ('user1@example.com', '$2a$10$KIXQ5YsmxhqgxIRLjYQ45uhbGf3VNBAswQXfr6KKiKph05t6w5x0C'), -- "password123"
    ('admin@example.com', '$2a$10$Y3/fZ5H0zRSnYzRfNHmDRu7T/3DHyC3RQpAx4f8oeRkdzF8ZnLO5y'); -- "adminpass"

-- Rôles
INSERT INTO user_roles (user_id, roles)
VALUES
    (1, 'USER'),
    (2, 'ADMIN');

-- Factures
INSERT INTO invoice (id, description, amount, date, user_id)
VALUES
    (1, 'Facture Electricité Janvier', 89.99, '2024-01-15', 1),
    (2, 'Facture Eau Février', 42.50, '2024-02-10', 1),
    (3, 'Facture Internet Mars', 39.90, '2024-03-05', 1);
