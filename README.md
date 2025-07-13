# 🔧 Desafio Backend - Processo seletivo SEA tecnologia
<p align="center">
    <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="Spring Boot" width="70" />
    <img src="https://www.vectorlogo.zone/logos/java/java-icon.svg" alt="Java" width="70" />
</p>
Desafio técnico proposto pela SEA como parte do processo seletivo
para a vaga de desenvolvedor Backend Júnior.

O projeto foi desenvolvido com o objetivo de demonstrar conhecimento em
autenticação de usuários, manipulação e persistência de dados, desenvolvimento
de APIs REST, consumo de APIs externas e boas práticas de desenvolvimento
utilizando Java, SpringBoot e outras tecnologias solicitadas.

# 📋 Descrição do Desafio
O sistema tem como objetivo gerenciar registros de clientes, respeitando regras
específicas de validação, autenticação e controle de acesso. 
O sistema conta com dois perfis de usuário:

- Admin: possui acesso total ao sistema (cadastrar cliente, excluir, atualizar e 
vizualizar os dados) 
- user: possui apenas permissão de vizualização de dados.

## Funcionalidades implementadas
- ✅  Autenticação de usuários com diferentes perfis (admin e user);
- ✅ Registro e visualização de clientes com os seguintes campos:

    1. Nome: obrigatório, 3 a 100 caracteres, apenas letras, espaços e números.

    2. CPF: obrigatório, salvo sem máscara no banco e exibido com máscara.

    3. Endereço: integração com API externa via CEP, campos obrigatórios e edição permitida.

    4. Telefones: múltiplos telefones com tipo e máscara por tipo.

    5. E-mails: múltiplos e-mails, com pelo menos um obrigatório e válido.

✅ Consumo de serviço de CEP externo (ViaCep);

✅ Separação entre projeto de serviço (backend) e projeto opcional de frontend.

# 🛠️ < Backend /> ☕

## 🚀 Tecnologias utilizadas
- Java 8: Linguagem de programação para desenvolver a aplicação.
- SpringBoot 2.7.18: Framework principal usado para
construção de aplicações Java baseadas em Spring.
- Maven: Ferramenta de automação de build e gerenciamento de
dependências.
- PostgreSQL 17 + Pgadmin4: Sistema de gerenciamento de
banco de dados relacional + interface gráfica para gerenciamento
do banco.
- Docker-compose: Ferramenta para definir e executar 
aplicativos Docker multi-contêiner.
(utilizado para criação dos containers do postgreSQL + Pgadmin4).

## 📦 Dependências
- Hypersistence: biblioteca para otimizações avançadas de JPA/hibernate
- Mapstruct: Gerador de mapeamento que converte entidade para Dto e vice-versa.
- Lombok: Biblioteca que reduz o boilerplate
(getters/setters, construtores e etc).
- Spring Security: Módulo do Spring usado para autenticação e autorização.
- Bean validation: Implementação da especificação de validação.
- Spring Data JPA: Abstração da JPA para acesso a dados.
- SpringBoot dev tools: ferramenta de desenvolvimento e outras funcionalidades.

### 📝 Pom.xml:

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.7.18</version>
		<relativePath/>
	</parent>
	<groupId>desafio.seatecnologia</groupId>
	<artifactId>backend</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>registroClientes</name>
	<description>Desafio técnico da SEA tecnologia</description>

	<developers>
		<developer>
			<name>Samuel Monteiro Ferreira</name>
			<organization>SEA tecnologia</organization>
		</developer>
	</developers>

	<properties>
		<java.version>8</java.version>
		<org.mapstruct.version>1.6.3</org.mapstruct.version>
		<lombok-mapstruct-binding.version>0.2.0</lombok-mapstruct-binding.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>io.hypersistence</groupId>
			<artifactId>hypersistence-utils-hibernate-55</artifactId>
			<version>3.9.5</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.mapstruct</groupId>
			<artifactId>mapstruct</artifactId>
			<version>${org.mapstruct.version}</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.38</version>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<configuration>
					<annotationProcessorPaths>
						<path>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
							<version>1.18.38</version>
						</path>
					</annotationProcessorPaths>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.1</version>
				<configuration>
					<source>${java.version}</source>
					<target>${java.version}</target>
					<annotationProcessorPaths>
						<path>
							<groupId>org.mapstruct</groupId>
							<artifactId>mapstruct-processor</artifactId>
							<version>${org.mapstruct.version}</version>
						</path>

						<path>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
							<version>${lombok.version}</version>
						</path>

						<path>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok-mapstruct-binding</artifactId>
							<version>${lombok-mapstruct-binding.version}</version>
						</path>
					</annotationProcessorPaths>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>
```



