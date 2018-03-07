CREATE TABLE token
(
  id TEXT NOT NULL,
  value TEXT NOT NULL,
  expiry_date TIMESTAMP NOT NULL,
  CONSTRAINT pk_token PRIMARY KEY (id)
);

GRANT SELECT, INSERT, DELETE ON token TO ${spring.datasource.username};
