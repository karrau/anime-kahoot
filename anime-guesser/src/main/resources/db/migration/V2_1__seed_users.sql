INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$10$yr0nLtEzWQaEf89cK3jXbOCSP7d6T4IDNVpGw/h6./0anY.F2iVlS', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$qedcoM/9PJBItb0KMprV/Oar21yOKS7SBZDgsNtrVFTfu3IHBQzrO', TRUE);


INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
