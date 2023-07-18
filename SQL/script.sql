CREATE DATABASE CrudJava;

USE CrudJava;

CREATE TABLE Cliente (
	id INT AUTO_INCREMENT,
    nome VARCHAR(90),
    endereco VARCHAR(200),
    telefone CHAR(11),
    PRIMARY KEY(id)
);

ALTER TABLE cliente 
ADD COLUMN total_pedidos INT;

CREATE TABLE Pedido (
	id INT AUTO_INCREMENT,
    pedido VARCHAR(200),
    preco DECIMAL(6,2),
    id_cliente INT,
    PRIMARY KEY(id, id_cliente),
    FOREIGN KEY(id_cliente) REFERENCES Cliente(id)
);

SELECT * FROM Cliente;
SELECT * FROM Pedido;

DELETE FROM Pedido WHERE id = 1;

