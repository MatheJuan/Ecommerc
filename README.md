# E-commerce APIREST

# Sobre do Projeto
O projeto é uma API REST desenvolvida em Java 17 e Spring Boot que consiste em um sistema de comércio eletrônico centrado no gerenciamento de produtos, categorias e dados dos usuários através do controle de perfis. funcionalidades como registrar usuários, fazer consulta de produtos no banco de dados e outros.
# Modelo Conceitual

![uml](https://github.com/MatheJuan/assets/blob/main/UML-%20Ecommerce-1.png)

# Funcionalidades
* Administrador: CRUD de Produtos
CRUD de Categorias
Visualização de cadastro de clientes,
administradores possuem acesso a operações de CRUD para produtos e categorias, além da capacidade de visualizar os clientes cadastrados.

* Cliente: CRUD do Carrinho de Compras
Encerramento do pedido (salvo como "aguardando pagamento")
Cadastro, atualização e visualização de dados pessoais
Visualização de histórico de pedidos,
clientes podem modificar seus dados cadastrais e verificar o histórico de pedidos de compras, pesquisar produtos no banco de dados para fins de catalogo ou carrinho de compras.

* Catálogo de Produtos
Apresenta um catálogo de produtos,
possibilidade de filtrar produtos pelo nome, 
fluxo de compra, cliente pode incluir, remover, deletar e modificar a quantidade de produtos no carrinho,
ao encerrar o pedido, o status é salvo como "aguardando pagamento" no banco de dados

![casosdeuso](https://github.com/MatheJuan/assets/blob/main/Casos%20de%20uso-%20Ecommerce.png)
## Controle de Segurança

A aplicação utiliza Spring Security para controle de autenticação e autorização, com a adição do uso de JSON Web Token (JWT) e OAuth2. O JWT é utilizado para autenticação baseada em tokens, enquanto o OAuth2 proporciona uma camada adicional de segurança e controle de acesso.

# Tecnologias Utilizadas
* Java 17
* Spring Boot 4
* Hibernate
* JPA
* PostgreSQL (banco de dados principal)
* Spring Security
* JSON Web Token (JWT)
* OAuth2

## Configuração do Banco de Dados
PostgreSQL:  
 URL:jdbc:postgresql://localhost:5432/db_ecommerce  
 Usuário: postgres  
 Senha: admin  


## Como Executar
Antes de executar o projeto, certifique-se de ter as seguintes ferramentas instaladas na sua máquina:
 Java 17  
 Maven 4.0.0  
```bash
1. **Clone o Repositório:**
git clone https://github.com/MatheJuan/Ecommerce

2. **Entrar na pasta do projeto back end**
cd ecommercproject

3. **Compile o projeto**
 mvn clean install

4. **Execute o JAR Gerado**
java -jar target/ecommercproject.jar
```

# Executando Testes com postman
 Certifique-se de que a sua aplicação está em execução localmente antes de executar os testes.  
 
1. Abra o Postman.  
2. Importe a coleção de testes do Postman localizada no arquivo https://github.com/MatheJuan/Ecommerc/tree/master/docs/postman
3. Abra a coleção de testes no Postman.  
4. Execute a coleção para testar os endpoints da aplicação.

# AUTOR
Juan Matheus  
https://www.linkedin.com/in/ruan-matheus-446ab6285/
