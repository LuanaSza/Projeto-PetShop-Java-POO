# Projeto Java Vibe Coding - Sistema PetShop

**Disciplina:** Programação Orientada a Objetos (POO)  
**Professor:** Antonio Santos de Sousa  
**Data de Entrega:** 12/01/2026  
**Status:** Finalizado 🚀

## Identificação 
* **Membro 1:** Luana Cristina Silva Souza
* Curso: Análise e Desenvolvimento de Sistemas

## Descrição do Problema
O sistema resolve o problema de gerenciamento de um PetShop, permitindo o cadastro de clientes e seus respectivos animais de estimação. O software garante a persistência de dados e a integridade referencial entre donos e pets.

## Tecnologias e Padrões Utilizados
* **Linguagem:** Java com Interface Gráfica Swing.
* **Persistência:** JDBC com banco de dados SQLite (arquivo local `petshop.db`).
* **Padrões de Projeto (Design Patterns):** * **Singleton/Factory:** Gerenciamento único da conexão com o banco.
    * **DAO (Data Access Object):** Isolamento total do código SQL.
    * **MVC:** Separação de responsabilidades entre Model, View e Controller.
* **POO:** Aplicação de Herança (`Cliente extends Pessoa`), Encapsulamento e Polimorfismo.

## Como Executar
1. Certifique-se de ter o JDK 17 ou superior instalado.
2. Clone o repositório ou baixe o código.
3. Execute a classe `View.MenuPrincipal`. O banco de dados será criado automaticamente no primeiro acesso.

## Documentação Visual
### Diagrama de Classes (UML)
![Diagrama UML](./DiagramaPoo.png)

### Screenshot do Sistema
![Tela Principal](./DiagramaPoo.png)
