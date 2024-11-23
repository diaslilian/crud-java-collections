# Sistema de Gerenciamento de Clientes (CRUD)

## 📝 Descrição
Sistema desenvolvido em Java para gerenciamento de clientes, implementando operações CRUD (Create, Read, Update, Delete) utilizando ArrayList como estrutura de dados para armazenamento em memória.

## 🚀 Funcionalidades

- ✨ Cadastro de novos clientes
- 📋 Listagem de todos os clientes
- ✏️ Atualização de dados do cliente
- 🗑️ Remoção de clientes
- 🔍 Busca de cliente por ID

## 📁 Estrutura do Projeto

```
src/
   model/
     Cliente.java
   repository/
     ClienteRepository.java
   service/
     ClienteService.java
   ui/
     ClienteUI.java
   Main.java
```

### Descrição das pastas / packages

- **Model**: Contém a entidade Cliente com seus atributos e métodos
- **Repository**: Responsável pelo acesso e manipulação dos dados
- **Service**: Implementa a lógica de negócio e validações
- **UI**: Interface com usuário via console
- **Main**: Classe principal que inicializa o sistema

## 🛠️ Tecnologias Utilizadas

- Java 23
- IntelliJ IDEA CE
- ArrayList para armazenamento de dados
- Scanner para interface com usuário
- Arquitetura em camadas

## 📋 Pré-requisitos

- JDK 17 ou superior
- IDE Java (Eclipse, IntelliJ IDEA, etc.) ou editor de texto
- Maven (opcional, se utilizar gerenciamento de dependências)

## ⚙️ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/diaslilian/crud-java-collections
```

2. Navegue até o diretório do projeto:
```bash
cd crud-java-collections
```

3. Compile o projeto:
```bash
javac src/Main.java
```

4. Execute o programa:
```bash
java src.Main
```

## 📌 Como Usar

### Menu Principal
```
=== MENU ===
1. Cadastrar Cliente
2. Listar Clientes
3. Atualizar Cliente
4. Remover Cliente
5. Buscar Cliente por ID
6. Sair
```

### Exemplos de Uso

#### 1. Cadastrar Cliente
```
=== Cadastro de Cliente ===
ID: 1
Nome: Lilian Dias
Email: lilian@email.com
Telefone: (81) 99999-9999
```

#### 2. Buscar Cliente
```
=== Buscar Cliente por ID ===
Digite o ID do cliente: 1

Cliente encontrado:
ID: 1
Nome: Lilian Dias
Email: lilian@email.com
Telefone: (81) 99999-9999
```

## 🏗️ Estrutura da Classe Cliente

```java
public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String telefone;
}
```

## 🔍 Validações Implementadas

- ID único para cada cliente
- E-mail deve conter @
- Nome não pode ser vazio
- Telefone não pode ser vazio

## 🤝 Contribuindo

1. Faça um Fork do projeto
2. Crie uma Branch para sua Feature (`git checkout -b feature/NewFeature`)
3. Faça commit das suas alterações (`git commit -m 'Add some NewFeature'`)
4. Faça Push para a Branch (`git push origin feature/NewFeature`)
5. Abra um Pull Request

## 📝 Futuras Melhorias

- [ ] Implementar persistência em banco de dados
- [ ] Adicionar interface gráfica
- [ ] Implementar busca por nome/email
- [ ] Adicionar validações mais robustas
- [ ] Implementar testes unitários
- [ ] Adicionar logging
- [ ] Implementar autenticação de usuários

## ✨ Boas Práticas Utilizadas

- Arquitetura em camadas
- Princípios SOLID
- Clean Code
- Tratamento de exceções
- Validações de dados

## Informações Adicionais

### 📌 Versão
- **Versão:** 1.0
- **Data:** Novembro 2024

### 📞 Contato
- **Email:** [lilian.dias25@gmail.com]
- **GitHub:** [diaslilian](https://github.com/diaslilian/)

---
Desenvolvido com ❤️ por [Lilian](https://www.linkedin.com/in/dias-lilian/)
---
