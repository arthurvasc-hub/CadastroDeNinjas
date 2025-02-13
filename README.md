# Cadastro de Ninjas 🥷

## 📌 Visão Geral do Projeto  
Este sistema foi desenvolvido para gerenciar **ninjas e suas missões**.  
Cada ninja pode ser atribuído a uma única missão, enquanto uma missão pode ser associada a vários ninjas.  

### ✨ Funcionalidades  
- **Cadastro de ninjas** com nome, idade, email e rank.  
- **Atribuição de missões** para os ninjas.  
- **Gerenciamento de missões** e dos ninjas associados.  

## 🛠️ Tecnologias Utilizadas  
- **Spring Boot** → Framework para criação da aplicação web e gerenciamento de dependências.  
- **Banco de Dados H2** → Banco de dados em memória para desenvolvimento e testes.  
- **Flyway** → Gerenciamento de migrações do banco de dados.  
- **JPA (Java Persistence API)** → Mapeamento objeto-relacional (ORM).  
- **Spring Data JPA** → Interação com o banco de dados.  
- **Git & GitHub** → Controle de versão e hospedagem do repositório.  
- **Maven** → Build e gerenciamento de dependências.   
- **SQL** → Manipulação do banco de dados.  

## 🗄️ Design do Banco de Dados  
O esquema do banco de dados segue as seguintes relações:  

- **`Ninja`** → Contém atributos: `id`, `nome`, `idade`, `email` e `rank`.  
- **`Missão`** → Contém atributos: `id`, `título` e `descrição`.  
- 📌 **Relação**: Um **Ninja pode ter apenas uma Missão**, mas uma **Missão pode ser atribuída a vários Ninjas**.  

## 🚀 Como Executar o Projeto  

```sh
# 📥 Clonar o repositório
git clone https://github.com/arthurvasc-hub/CadastroDeNinjas.git

# 📂 Navegar até o diretório do projeto
cd CadastroDeNinjas

# 🔨 Construir o projeto
mvn clean install

# ▶️ Executar a aplicação
mvn spring-boot:run

🌐 Acessar a Aplicação
Abra seu navegador e acesse:
🔗 http://localhost:8080

📜 Licença
Este projeto é de código aberto e está disponível sob a licença MIT.

👨‍💻 Autor
Desenvolvido por Arthur Vasconcelos 🥷🚀

🤝 Contribuição
Sinta-se à vontade para contribuir com melhorias, relatando issues ou abrindo pull requests.
