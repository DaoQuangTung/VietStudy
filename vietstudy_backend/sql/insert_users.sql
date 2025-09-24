-- SQL script to insert sample roles and users into the database.
-- Assumptions:
-- 1) MySQL database.
-- 2) Table names: `roles` and `users` (as defined in entities).
-- 3) Column names:
--    users.avatar_url, users.name, users.email, users.gender, users.dob,
--    users.native_language, users.points, users.created_at, users.updated_at, users.role_id
--    (created_at/updated_at use snake_case; role_id column is named as in @JoinColumn)
-- If your actual column names differ, adapt them accordingly.

/* Insert roles if they don't exist */
INSERT INTO roles (code, name)
SELECT 'ROLE_USER', 'User'
FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM roles WHERE code = 'ROLE_USER');

INSERT INTO roles (code, name)
SELECT 'ROLE_ADMIN', 'Admin'
FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM roles WHERE code = 'ROLE_ADMIN');

/* Insert sample users referencing roles by code so we don't need hard-coded role ids */
INSERT INTO users (avatar_url, name, email, gender, dob, native_language, points, created_at, updated_at, role_id)
SELECT
  'https://example.com/avatars/alice.png' AS avatar_url,
  'Alice Nguyen' AS name,
  'alice@example.com' AS email,
  'Female' AS gender,
  '1990-05-20' AS dob,
  'Vietnamese' AS native_language,
  120 AS points,
  NOW() AS created_at,
  NOW() AS updated_at,
  (SELECT id FROM roles WHERE code = 'ROLE_USER') AS role_id
FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'alice@example.com');

INSERT INTO users (avatar_url, name, email, gender, dob, native_language, points, created_at, updated_at, role_id)
SELECT
  'https://example.com/avatars/bob.png' AS avatar_url,
  'Bob Tran' AS name,
  'bob@example.com' AS email,
  'Male' AS gender,
  '1985-11-02' AS dob,
  'English' AS native_language,
  300 AS points,
  NOW() AS created_at,
  NOW() AS updated_at,
  (SELECT id FROM roles WHERE code = 'ROLE_ADMIN') AS role_id
FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'bob@example.com');

-- Add more sample inserts below as needed. Replace values and date formats as appropriate for your DB.
