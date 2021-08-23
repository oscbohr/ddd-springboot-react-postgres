SET search_path = public;

\c testdb;        


CREATE TABLE orders(
   id_order SERIAL PRIMARY KEY,
   customer_name VARCHAR NOT NULL,
   customer_email VARCHAR NOT NULL,
   customer_mobile VARCHAR NOT NULL,
   status VARCHAR NOT NULL,
   created_at timestamp NOT NULL DEFAULT CURRENT_DATE,
   update_at timestamp NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE transaccion_orders(
   id_tran SERIAL PRIMARY KEY,
   request_id integer NOT NULL,
   id_order_fk integer NOT NULL,    
   status VARCHAR NOT NULL,
   CONSTRAINT fk_order
      FOREIGN KEY(id_order_fk)
       REFERENCES orders(id_order)
);

CREATE TABLE articulo(
   id SERIAL PRIMARY KEY,
   nombre VARCHAR NOT NULL,
   valor real NOT NULL
);

insert into articulo (nombre, valor) values ('LLANTAS', 50000);
insert into articulo (nombre, valor) values ('RINES', 7000);
insert into articulo (nombre, valor) values ('TAPETES', 100000);
insert into articulo (nombre, valor) values ('NEUMATICOS', 88000);