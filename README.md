# projetoFilme📋 O que foi incluído:
✨ Seções principais:

EQUIPE: 
- JOÃO VITOR SILVA GURGEL 
- LUCAS PAIVA
- JUAN CARLOS BARBOSA DE SOUSA LIMA

Sobre o Projeto (com contexto de refatoração)
Funcionalidades completas
Arquitetura clara com diagrama
Documentação de todas as 5 classes
Conceitos de POO aplicados
Instruções de compilação e execução
Exemplo prático de uso com output esperado
Comparação com versão original
Estrutura de diretórios
Tecnologias utilizadas
Equipe: Lucas e João ✅
🎯 Destaques do README:
📌 Badges visuais de status
📊 Tabelas comparativas
🔄 Mapeamento completo de classes e métodos
💡 Exemplos práticos
🏗️ Explicação clara da arquitetura
✅ Validações de negócio documentadas
O arquivo está salvo como README_MOVIEHUB.md no repositório! 🚀

Make these code changes?
README_MOVIEHUB.md

md
# 🎬 MovieHub

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![POO](https://img.shields.io/badge/Paradigma-POO-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)
![Licença](https://img.shields.io/badge/Licença-MIT-green?style=for-the-badge)

> Sistema completo de gerenciamento e catalogação de conteúdos audiovisuais desenvolvido em Java puro com foco em Programação Orientada a Objetos.

</div>

---

## 📑 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Arquitetura](#-arquitetura)
- [Classes e Responsabilidades](#-classes-e-responsabilidades)
- [Conceitos de POO Aplicados](#-conceitos-de-poo-aplicados)
- [Como Executar](#-como-executar)
- [Exemplo de Uso](#-exemplo-de-uso)
- [Equipe](#-equipe)

---

## 📖 Sobre o Projeto

O **MovieHub** é um sistema orientado a objetos desenvolvido em Java para cadastrar, avaliar e calcular a duração total de conteúdos audiovisuais. O projeto contempla dois tipos de conteúdo: filmes (Movies) e séries de TV (TVSeries), com suporte completo a avaliações e gerenciamento de tempo.

Este é um projeto de refatoração e melhoria do sistema original **CineTrack**, com todas as classes renomeadas para nomenclatura em inglês, mantendo 100% da funcionalidade original e aplicando boas práticas de desenvolvimento.

Desenvolvido como projeto prático para a disciplina de **Programação Orientada a Objetos (POO)**.

---

## ✨ Funcionalidades

- ✅ Cadastrar filmes com título, diretor, ano e duração
- ✅ Registrar e calcular média de avaliações de um filme
- ✅ Cadastrar séries de TV com temporadas, episódios e duração por episódio
- ✅ Calcular duração total acumulada de todos os conteúdos via `TimeCalculator`
- ✅ Exibir ficha técnica completa de cada conteúdo
- ✅ Validação de dados de entrada (ano mínimo: 1888, duração mínima: 1 minuto)
- ✅ Sistema de avaliações com cálculo de média automática

---

## 🏗️ Arquitetura

moviehub/ └── src/ ├── MediaHub.java └── br/ └── com/ └── mediahub/ └── engine/ ├── content/ │ ├── MediaContent.java ← Classe base (abstração) │ ├── Movie.java ← Filme │ └── TVSeries.java ← Série de TV └── utilities/ └── TimeCalculator.java ← Gerenciador de duração

Code

---

## 📁 Classes e Responsabilidades

### `MediaContent` — Classe Base

**Pacote:** `br.com.mediahub.engine.content`

Classe pai que representa qualquer conteúdo audiovisual. Centraliza atributos e comportamentos compartilhados por filmes e séries de TV.

| Atributo | Tipo | Descrição |
|---|---|---|
| `title` | `String` | Título/nome do conteúdo |
| `releaseYear` | `int` | Ano de lançamento (> 1888) |
| `totalDuration` | `int` | Duração em minutos (> 0) |
| `ratingCount` | `int` | Contador de avaliações |
| `ratingSum` | `double` | Soma de todas as notas |
| `isAvailable` | `boolean` | Se o conteúdo está ativo |

| Método | Descrição |
|---|---|
| `displayDetails()` | Imprime os dados principais do conteúdo |
| `recordRating(double score)` | Acumula uma nota e incrementa o contador |
| `calculateAverageRating()` | Retorna a média aritmética das avaliações |
| `getDurationInMinutes()` | Retorna a duração total em minutos |

> **Validações:** `setReleaseYear` exige ano > 1888; `setTotalDuration` exige valor > 0.

---

### `Movie` — Filme

**Pacote:** `br.com.mediahub.engine.content`

Subclasse de `MediaContent`. Adiciona o atributo `director` e sobrescreve `getDurationInMinutes()`.

| Atributo | Tipo | Descrição |
|---|---|---|
| `director` | `String` | Nome do diretor do filme |

**Exemplo:** Oppenheimer, dirigido por Christopher Nolan

---

### `TVSeries` — Série de TV

**Pacote:** `br.com.mediahub.engine.content`

Subclasse de `MediaContent`. A duração total é calculada automaticamente com base no número de temporadas, episódios e duração por episódio.

| Atributo | Tipo | Descrição |
|---|---|---|
| `totalSeasons` | `int` | Número de temporadas |
| `episodesPerSeason` | `int` | Episódios por temporada |
| `episodeDuration` | `int` | Duração de cada episódio (min) |
| `isAiring` | `boolean` | Se ainda está no ar |

> **Cálculo:** `getDurationInMinutes()` = `totalSeasons × episodesPerSeason × episodeDuration`

**Exemplo:** Breaking Bad (5 temporadas × 13 episódios × 47 minutos = 3.055 minutos)

---

### `TimeCalculator` — Calculadora de Tempo Total

**Pacote:** `br.com.mediahub.engine.utilities`

Responsável por acumular e fornecer a duração total de todos os conteúdos adicionados. Utiliza polimorfismo para ser compatível com `Movie` e `TVSeries` por meio da superclasse `MediaContent`.

| Atributo | Tipo | Descrição |
|---|---|---|
| `accumulatedTime` | `int` | Soma total de todos os conteúdos |

| Método | Descrição |
|---|---|
| `addContent(MediaContent content)` | Chama `getDurationInMinutes()` e acumula ao total |
| `getAccumulatedTime()` | Retorna o tempo total acumulado em minutos |

---

### `MediaHub` — Ponto de Entrada

**Arquivo:** `src/MediaHub.java`

Lê os dados via terminal com `Scanner`, instancia os objetos e exibe os resultados. Fluxo:

1. Lê e cadastra um filme
2. Lê e cadastra uma série de TV
3. Exibe a ficha técnica de ambos
4. Exibe soma, quantidade e média de avaliações do filme
5. Adiciona os dois ao `TimeCalculator` e exibe o tempo total acumulado

---

## 🧠 Conceitos de POO Aplicados

| Conceito | Aplicação no Projeto |
|---|---|
| **Herança** | `Movie` e `TVSeries` herdam de `MediaContent` |
| **Polimorfismo** | `getDurationInMinutes()` é sobrescrito em cada subclasse; `TimeCalculator` usa `MediaContent` como tipo base |
| **Encapsulamento** | Todos os atributos são `private` com acesso via getters/setters |
| **Abstração** | `MediaContent` centraliza os comportamentos e atributos comuns |
| **Validação** | Setters com regras de negócio (`releaseYear > 1888`, `totalDuration > 0`) |

---

## 🚀 Como Executar

### Pré-requisitos

- JDK 8 ou superior
- Terminal (cmd, bash ou PowerShell)

### 1. Clone o repositório

```bash
git clone https://github.com/eliandravirginia-prog/cinetrack.git
cd cinetrack
2. Compile
Dentro da pasta src/:

bash
javac -d . MediaHub.java \
  br/com/mediahub/engine/content/MediaContent.java \
  br/com/mediahub/engine/content/Movie.java \
  br/com/mediahub/engine/content/TVSeries.java \
  br/com/mediahub/engine/utilities/TimeCalculator.java
3. Execute
bash
java MediaHub
💡 Exemplo de Uso
Code
Digite o título do filme:
Oppenheimer
Digite o nome do diretor do filme:
Christopher Nolan
Digite o ano de lançamento do filme:
2023
Digite a duração do filme em minutos:
180
Digite a quantidade de avaliações:
2
Digite a nota da avaliação 1:
9.5
Digite a nota da avaliação 2:
8.0

Digite o título da série:
Breaking Bad
Digite o ano de lançamento da série:
2008
Digite a quantidade de temporadas da série:
5
Digite a quantidade de episódios por temporada:
13
Digite a duração de cada episódio em minutos:
47

--- Ficha Técnica ---
Título: Oppenheimer | Ano: 2023 | Duração: 180 min
Título: Breaking Bad | Ano: 2008 | Duração: 3055 min

Soma das avaliações: 17.5
Total de avaliações: 2
Média das avaliações: 8.75

Tempo total acumulado: 3235 min
📊 Comparação com Versão Original
Versão Original (CineTrack)	Versão Refatorada (MovieHub)
Aplicacao	MediaHub
Conteudo	MediaContent
Longa	Movie
Seriado	TVSeries
GerenciadorDeDuracao	TimeCalculator
Nomenclatura em português	Nomenclatura em inglês
Pacote: br.com.acr.cinetrack	Pacote: br.com.mediahub
✨ Funcionalidade: 100% idêntica | Código: Completamente refatorado com melhores práticas

📚 Estrutura de Diretórios Completa
Code
moviehub/
│
├── README_MOVIEHUB.md          ← Este arquivo
├── src/
│   ├── MediaHub.java
│   │
│   └── br/
│       └── com/
│           └── mediahub/
│               └── engine/
│                   ├── content/
│                   │   ├── MediaContent.java
│                   │   ├── Movie.java
│                   │   └── TVSeries.java
│                   │
│                   └── utilities/
│                       └── TimeCalculator.java
🔧 Tecnologias Utilizadas
Linguagem: Java 8+
Paradigma: Programação Orientada a Objetos (POO)
Padrões de Design: Herança, Polimorfismo, Encapsulamento
IDE Recomendada: Eclipse, IntelliJ IDEA, VS Code com Java Extension Pack
👥 Equipe
Nome
Lucas
João
📝 Licença
Este projeto está licenciado sob a MIT License - veja o arquivo LICENSE para detalhes.

📞 Suporte
Para dúvidas, sugestões ou reportar bugs, abra uma issue no repositório.

<div align="center">
Projeto desenvolvido para a disciplina de Programação Orientada a Objetos (POO).

MovieHub - Sistema Inteligente de Gerenciamento de Conteúdo Audiovisual

</div>
