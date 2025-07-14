# 🔧 Desafio Backend - Processo seletivo SEA tecnologia
<p align="center">
    <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="Spring Boot" width="70" />
    <img src="https://www.vectorlogo.zone/logos/java/java-icon.svg" alt="Java" width="70" />
    <img src="https://www.vectorlogo.zone/logos/reactjs/reactjs-icon.svg" alt="Java" width="70" />
</p>
Desafio técnico proposto pela SEA como parte do processo seletivo
para a vaga de desenvolvedor Backend Júnior.

O projeto foi desenvolvido com o objetivo de demonstrar conhecimento em
autenticação de usuários, manipulação e persistência de dados, desenvolvimento
de APIs REST, consumo de APIs externas e boas práticas de desenvolvimento
utilizando Java, SpringBoot e outras tecnologias solicitadas.

# 📋 Descrição do Desafio
O sistema tem como objetivo gerenciar registros de clientes, respeitando regras
específicas de validação, autenticação e controle de acesso 
(Optei por utilizar HttpBasic que já sanava a autenticação de ADMIN E USER e suas permissões). 
O sistema conta com dois perfis de usuário:

- **Admin:** possui acesso total ao sistema (cadastrar cliente, excluir, atualizar e 
vizualizar os dados) 
- **user:** possui apenas permissão de vizualização de dados.

## Funcionalidades implementadas
- ✅ Autenticação de usuários com diferentes perfis (admin e user);
- ✅ Registro e visualização de clientes com os seguintes campos:

1. **Nome:** obrigatório, 3 a 100 caracteres, apenas letras, espaços e números. 
2. **CPF:** obrigatório, salvo sem máscara no banco e exibido com máscara.
3. **Endereço:** integração com API externa via CEP, campos obrigatórios e edição permitida.
4. **Telefones:** múltiplos telefones com tipo e máscara por tipo.
5. **E-mails:** múltiplos e-mails, com pelo menos um obrigatório e válido.

✅ Consumo de serviço de CEP externo (ViaCep);

✅ Separação entre projeto de serviço (backend) e projeto opcional de frontend.

---
## 🚀 Como executar
### 🛢️ Banco de dados (Docker-compose.yml)
#### passo 1:
No terminal, navegue até a pasta do projeto onde está o docker-compose.yml e execute:
```
docker compose up -d
e quando ja estiver criado: docker compose start
```
Isso criará dois containers
- PostgreSQL (porta 5433)
- Pgadmin4 (porta 5050)

#### passo 2: acessar o Pgadmin4
1. no navegador: `http://localhost:5050`

2. Faça login:
    - Email: admin@admin.com
    - senha: admin
3. Conecte ao servidor PostgreSQL:
    - clique em **"Add new Server"**
    - nome: PostgreSQL17
    - na aba **"Connection"**, preencha:
```
Host: postgres
Port: 5432
maintenance database: cadastro-clientes
Username: postgres
Password: 123456
```
Salve e conecte.
#### Obs: as tabelas são criadas na hora da inicialização do container e os usuários admin e user ja são criados automaticamente. (para vizualização das tabelas, vá na raiz do projeto na pasta "db" e no arquivo "init.sql")

---
### ☕ Aplicação
Siga os passos abaixo para realizar a configuração
do projeto:
### Clone o repositório
`git clone https://github.com/smfmo/desafio-Backend-SeaTecnologia`
### Pasta
Navegue até a pasta `backend` e abra o projeto.
### Instale as dependências
`mvn clean install`
### Execute a aplicação
`mvn spring-boot:run`
### Porta
A aplicação estará disponível na porta `8080`
#### Obs: Suba a aplicação depois de incializar/startar os containers do banco de dados.

---

# 🛠️ < Backend /> ☕

## 🚀 Tecnologias utilizadas
- **Java 8:** Linguagem de programação para desenvolver a aplicação.
- **SpringBoot 2.7.18:** Framework principal usado para
construção de aplicações Java baseadas em Spring.
- **Maven:** Ferramenta de automação de build e gerenciamento de
dependências.
- **PostgreSQL 17 + Pgadmin4:** Sistema de gerenciamento de
banco de dados relacional + interface gráfica para gerenciamento
do banco.
- **Docker-compose:** Ferramenta para definir e executar 
aplicativos Docker multi-contêiner.
(utilizado para criação dos containers do postgreSQL + Pgadmin4).

## ⚙️ Dependências
- **Spring Data JPA:** Abstração da JPA para acesso a dados.
- **Hypersistence:** biblioteca para otimizações avançadas de JPA/hibernate
- **Mapstruct:** Gerador de mapeamento que converte entidade para Dto e vice-versa.
- **Lombok:** Biblioteca que reduz o boilerplate
(getters/setters, construtores e etc).
- **Spring Security:** Módulo do Spring usado para autenticação e autorização.
- **Bean validation:** Implementação da especificação de validação.
- **SpringBoot dev tools:** ferramenta de desenvolvimento e outras funcionalidades.
- **SpringWeb:** Módulo do Spring que contém ferramentas 
para criar aplicações Web e serviços web RESTful.
- **Junit:** Framework para escrever testes automatizados, utilizado na 
aplicação para os testes de integração.
- **Open-Api/Swagger:** Para documentação da API 
(Endpoints, requests, respostas e etc.)

### 📝 Pom.xml:

```
<dependencies>
		<!--Spring Data JPA-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<!--Hypersistence-->
		<dependency>
			<groupId>io.hypersistence</groupId>
			<artifactId>hypersistence-utils-hibernate-55</artifactId>
			<version>3.9.5</version>
		</dependency>
		
		<!-- Open api - Swagger-->
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-ui</artifactId>
			<version>1.6.9</version>
		</dependency>

		<!--Bean Validation-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

		<!--Spring starter web-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<!--Mapstruct-->
		<dependency>
			<groupId>org.mapstruct</groupId>
			<artifactId>mapstruct</artifactId>
			<version>${org.mapstruct.version}</version>
		</dependency>

		<!--SpringBoot devtools-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>

		<!--Spring Security-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

		<!--PostgreSQL-->
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>

		<!--Lombok-->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.38</version>
			<optional>true</optional>
		</dependency>

		<!--SpringBoot starter Test-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```

## 📦 Estrutura do projeto:
```
📦 registro-clientes-backend
├── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java
│   │   │   └── 📁 desafio
│   │   │       └── 📁 seatecnologia
│   │   │            └── 📁 backend
│   │   │                 ├── 📁 configuration          
│   │   │                 ├── 📁 controller         
│   │   │                 │    ├── 📁 dto
│   │   │                 │    └── 📁 mappers
│   │   │                 ├── 📁exceptions
│   │   │                 ├── 📁 model
│   │   │                 │    └── 📁 enums
│   │   │                 ├── 📁 repository 
│   │   │                 ├── 📁 security
│   │   │                 ├── 📁 service     
│   │   │                 ├── 📁 util.json 
                          │    ├── 📁 deserializer
                          │    └── 📁 serializer
│   │   │                 └── 📄 RegistroClientesApplication.java 
│   │   └── 📁 resources
│   │        └── 📄 application.yml           
│
├── 📁 test  
│    ├── 📁 java
│    │     └── 📁 desafio              
│    │          └── 📁 seatecnologia 
│    │               └── 📁 backend 
│    │                     └── 📁 repository
│    └── 📁 resources
│         └── 📄 application-test.yml
├── 📄 docker-compose.yml                             
├── 📄 pom.xml                     

```
---
## 🌐 Documentação da API
A API esta documentada com Swagger, que permite vizualizar e testar todos
os endpoints interativamente.

### 🔗 Acessar o Swagger UI
Após startar o projeto, será possível acessar a documentação da API:
- **Local:** `http://localhost:8080/swagger-ui.html`
#### credenciais para teste 
- **Admin:**
    - Usuario: admin
    - senha: 123qwe!@# (acesso total)
- **Usuário padrão:**
    - Usuario: user
    - 123qwe123 (somente leitura)

#### Obs: Para os testes de salvar e deletar utilize o Json:
```
{
    "nome": "Samuel Monteiro Ferreira",
    "cpf": "035.322.501-01",
    "telefones": [
        {
            "tipo": "CELULAR",
            "numero": "61 98336-3598"
        },
        {
            "tipo": "RESIDENCIAL",
            "numero": "61 3628-3376"
        }
    ],
    "emails": [
        "smf.ferreira1901@gmail.com",
        "smf.monteiro1701@gmail.com"
    ],
    "endereco": {
        "cep": "72860-515",
        "logradouro": "Rua Exemplo",
        "bairro": "Centro",
        "localidade": "Brasília",
        "uf": "DF",
        "complemento": ""
    }
}
```
- Os dados são digitados com a máscara e salvos no banco sem máscara
e na busca pelos dados são retornados com as respectivas máscaras.
---
## ✔️ Testes
### Documentação dos testes de integração
#### Visão geral:
O projeto inclui testes de integração para validar
o comportamento do sistema em um ambiente próximo ao real,
interagindo com o banco de dados e testando as camadas de 
persistência.
Embora não fosse exigido, adicionei testes no Repository para garantir 
que a comunicação com o banco de dados estava funcionando corretamente.

#### Configurações do ambiente de teste
Os teste utilizam o mesmo servidor do banco de dados da aplicação,
apenas criei um novo database chamado cadastro-clientes-teste
```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5433/cadastro-clientes-test
    username: postgres
    password: 123456
```
#### Testes implementados:
### 1. Testes de Cliente (ClienteRepositoryTest)

Testes para operação CRUD de clientes, incluindo os 
relacionamentos com endereço, telefones e emails.
#### métodos de teste:
1. deveSalvarClienteComSucesso()
   - Testa o cadastro completo de um cliente com todos os atributos
   - Verifica se os dados foram persistidos corretamente

2. deveBuscarClientePorId()
   - Testa a recuperação de um cliente pelo ID
   - Verifica se os dados retornados correspondem aos salvos

3. deveAtualizarCliente()
   - Testa a atualização dos dados de um cliente existente
   - Verifica se as alterações são persistidas

4. deveExcluirCliente()
   - Testa a exclusão de um cliente
   - Verifica se o cliente foi removido do banco de dados

#### Dados do teste:
- Cria um cliente com:
    - nome
    - cpf
    - Endereço completo
    - Dois telefones (comercial, celular)
    - dois emails
  
### 2. testes de usuário (UsuarioRepositoryTest)
Testes para operações de usuário, incluindo autenticação e roles
#### métodos de teste:
1. deveSalvarUsuarioComSucesso()
    - Testa o cadastro de um usuário ADMIN
    - Verifica se a senha foi criptografada
    - Valida a role do usuário

2. findByUsernameTest()
   - Testa a busca de usuário pelo username
   - Verifica a autenticação com senha criptografada
   - Valida a role do usuário

#### Dados do teste:
- Cria dois tipos de usuário:
  - ADMIN: username "admin", senha "123qwe!@#"
  - USER: username "user", senha "123qwe123"
---










