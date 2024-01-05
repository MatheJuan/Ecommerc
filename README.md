# E-commerce APIREST

# Sobre do Projeto
O projeto é uma API REST desenvolvida em Java 17 e Spring Boot que conciste em um sistema de comércio eletrônico centrado no gerenciamento de produtos, categorias e dados dos usuários através do controle de perfis. funcionalidades como registrar usuários, fazer consulta de produtos no banco de dados e outros

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

## Controle de Segurança

A aplicação utiliza Spring Security para controle de autenticação e autorização, com a adição do uso de JSON Web Token (JWT) e OAuth2. O JWT é utilizado para autenticação baseada em tokens, enquanto o OAuth2 proporciona uma camada adicional de segurança e controle de acesso.

# Tecnologias Utilizadas
* Java 17
* Spring Boot 3
* Hibernate
* JPA
* H2 (para testes)
* PostgreSQL (banco de dados principal)
* JUnit (para testes)
* Spring Security
* JSON Web Token (JWT)
* OAuth2

# Estrutura do Projeto
A estrutura do projeto está organizada da seguinte forma:

src/main/java/com.example.ecommerce: Contém as classes Java do projeto.
src/main/resources: Contém arquivos de configuração, como application.properties.
src/test: Contém classes de teste.
Configuração
Banco de Dados
H2 (para testes):

URL: jdbc:h2:mem:testdb
Usuário: sa
Senha: (não é necessária)
PostgreSQL:

Configurar as propriedades em application.properties para o banco de dados PostgreSQL.
# Como Executar
Clone o repositório: git clone https://github.com/seu-usuario/nome-do-repositorio.git
Importe o projeto em sua IDE preferida.
Configure o banco de dados conforme as instruções acima.
Execute o projeto.
Imagens da Aplicação
Imagem 1 - Tela Inicial:
