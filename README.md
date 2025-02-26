
## Sistema de Gerenciamento de Sobreviventes e Recursos
Centro Federal de Educação Tecnológica de Minas Gerais - CEFET-MG
Aluno: João Paulo Cruz de Faria

---

# 🔖 Sumário

1. [Introdução](#1-introdu%C3%A7%C3%A3o)
2. [Decisões de Implementação](#2-decis%C3%B5es-de-implementa%C3%A7%C3%A3o)
3. [Casos de Teste](#3-casos-de-teste)
   - [Cadastro de Sobreviventes](#cadastro-de-sobreviventes)
   - [Cadastro de Recursos](#cadastro-de-recursos)
   - [Registro de Recursos e Sobreviventes](#registro-de-recursos-e-sobreviventes)
   - [Gerenciamento de Missões](#gerenciamento-de-miss%C3%B5es)
   - [Gerenciamento de Sobreviventes em Missões](#gerenciamento-de-sobreviventes-em-miss%C3%B5es)
4. [Análise dos Resultados](#4-an%C3%A1lise-dos-resultados)

---

# 1. Introdução

🔎 *Objetivo:* Este trabalho tem como objetivo aplicar os conhecimentos de Programação Orientada a Objetos (POO), como diagramas de classes, abstrações e heranças.

Foi desenvolvido um sistema para gerenciar recursos, sobreviventes e missões de forma eficiente, atendendo às necessidades de organização e controle em um cenário apocalíptico. O usuário, como gestor do Vault, pode monitorar todas as demandas e administrar recursos de forma eficaz.

---

# 2. Decisões de Implementação

### Principais desafios:

1. *Validação de entradas de usuário:*

   - Foi implementado um sistema para garantir que o usuário escolha habilidades ou recursos apenas de um conjunto predefinido. Se a entrada não for válida, o sistema solicita correção até que um valor apropriado seja fornecido.

2. *Limitação de habilidades:*

   - Para gerenciar as três habilidades permitidas por sobrevivente, foi criado um vetor fixo de três posições. Um atributo adicional rastreia o número de habilidades inseridas, permitindo bloqueios adequados para novas entradas.

---

# 3. Casos de Teste

## Cadastro de Sobreviventes

Um administrador insere informações como nome, idade, habilidades e status dos sobreviventes:

*Saída esperada:*

Nome: Pedro, Idade: 21, Identificador: 123, Status: Ativo
Habilidades: [Engenharia, Medicina, Combate]

Nome: Eduardo, Idade: 32, Identificador: 122, Status: Doente
Habilidades: [Engenharia, Hacking, Furtividade]

Nome: Matheus, Idade: 25, Identificador: 121, Status: Morto
Habilidades: [Engenharia, null, null]


## Cadastro de Recursos

Informações sobre os recursos do Vault são cadastradas:

*Saída esperada:*

Recursos do Vault:
Nome: Água, Quantidade: 100
Nome: Comida, Quantidade: 20
Nome: Remédios, Quantidade: 10


## Registro de Recursos e Sobreviventes

Cadastro conjunto de recursos e sobreviventes:

*Saída esperada:*

Sobreviventes do Vault:
Nome: Pedro, Idade: 21, Identificador: 123, Status: Ativo
Habilidades: [Engenharia, Medicina, Combate]

Nome: Eduardo, Idade: 32, Identificador: 122, Status: Doente
Habilidades: [Engenharia, Hacking, Furtividade]

Recursos do Vault:
Nome: Água, Quantidade: 100
Nome: Comida, Quantidade: 20
Nome: Remédios, Quantidade: 10


## Gerenciamento de Missões

Permite criar e monitorar missões para buscar suprimentos:

*Saída esperada:*

Nome da Missão: Mike Papa
Descrição: Buscar suprimentos e roupas.
Local: Bairro Sidil
Status: Em andamento


## Gerenciamento de Sobreviventes em Missões

Adiciona e remove sobreviventes de missões:

*Saída esperada:*

Sobreviventes da missão Mike Papa:
Pedro, Idade: 21, Identificador: 123, Status: Ativo


---

# 4. Análise dos Resultados

🔬 *Resultados alcançados:* O sistema cumpriu seus objetivos, demonstrando eficiência na aplicação de conceitos de POO. As funcionalidades básicas foram bem implementadas e os casos de teste confirmaram a robustez do código.

### Pontos de melhoria:

1. Expandir a funcionalidade para permitir gerenciar inventários detalhados.
2. Implementar interface gráfica para melhorar a experiência do usuário.
3. Criar relatórios detalhados sobre o uso de recursos e status das missões
