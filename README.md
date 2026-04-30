 Cadastro de Produtos - API REST
API completa de gerenciamento de produtores com autenticação JWT, seguindo padrões REST, boas práticas de segurança e tratamento global de exceções.

📋 Sobre o projeto
Este projeto consiste em uma API REST para cadastro e gerenciamento de produtores, desenvolvida com foco em:

* Segurança real com JWT

* Arquitetura limpa

* Tratamento robusto de erros com @RestControllerAdvice

* Autenticação stateless usando Spring Security

O objetivo vai além do básico: simula um sistema real onde apenas usuários autenticados podem manipular dados, com diferenciação clara entre rotas públicas e privadas.

⚙️ Funcionalidades
Autenticação 
Cadastro de usuários (/auth/register)

Login com geração de token JWT (/auth/login)

Senhas criptografadas com BCrypt

Gerenciamento de Produtores 
Listar todos os produtores (GET /producer)

Buscar produtor por ID (GET /producer/{id})

Cadastrar novo produtor (POST /producer)

Atualizar dados do produtor (PUT /producer/{id})

Remover produtor (DELETE /producer/{id})

Todas as rotas de produtor exigem token JWT — nada de acesso sem autorização.

## 🔒 Tecnologias utilizadas

| Camada | Tecnologia |
|--------|-------------|
| Linguagem | Java 21 |
| Framework | Spring Boot |
| Segurança | Spring Security + JWT |
| Persistência | Spring Data JPA |
| Banco de dados | PostgreSQL |
| Utilitários | Lombok |
| Gerenciador | Gradle |
