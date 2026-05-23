# 🎬 MovieHub


👥 Equipe
Nome
Lucas
João

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![POO](https://img.shields.io/badge/Paradigma-POO-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)
![Licença](https://img.shields.io/badge/Licença-MIT-green?style=for-the-badge)

> Sistema de gerenciamento e catalogação de conteúdos audiovisuais desenvolvido em Java puro com foco em Programação Orientada a Objetos. Refatoração completa do projeto CineTrack com novas estruturas de classe e nomenclaturas em inglês.

</div>

---

## 📑 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Arquitetura](#-arquitetura)
- [Classes e Responsabilidades](#-classes-e-responsabilidades)
- [Mapeamento de Refatoração](#-mapeamento-de-refatoração)
- [Conceitos de POO Aplicados](#-conceitos-de-poo-aplicados)
- [Como Executar](#-como-executar)
- [Exemplo de Uso](#-exemplo-de-uso)
- [Equipe](#-equipe)

---

## 📖 Sobre o Projeto

O **MovieHub** é um sistema orientado a objetos desenvolvido em Java para cadastrar, avaliar e calcular a duração total de conteúdos audiovisuais. Trata-se de uma refatoração completa do projeto **CineTrack**, mantendo toda a funcionalidade original mas com:

✅ **Nomenclatura em inglês** para melhor internacionalização  
✅ **Estrutura de pacotes reorganizada** (modelos em `content/`, utilitários em `utilities/`)  
✅ **Nomes de classes mais descritivos** (`MediaContent`, `Movie`, `TVSeries`, `TimeCalculator`)  
✅ **Mesma lógica de negócio** e validações  
✅ **Polimorfismo e herança** preservados  

O projeto contempla **dois tipos de conteúdo**: filmes (movies) e séries (TV series), com cálculos inteligentes de duração total.

Desenvolvido como projeto prático para a disciplina de **Programação Orientada a Objetos (POO)**.

---

## ✨ Funcionalidades

- ✅ Cadastrar filmes com título, diretor, ano e duração
- ✅ Registrar e calcular média de avaliações de um filme
- ✅ Cadastrar séries com temporadas, episódios e duração por episódio
- ✅ Calcular duração total acumulada de todos os conteúdos via `TimeCalculator`
- ✅ Exibir ficha técnica completa de cada conteúdo
- ✅ Validação de dados (ano > 1888, duração > 0)
- ✅ Polimorfismo para cálculos de duração por tipo

---

## 🏗️ Arquitetura

moviehub/ └── src/ ├── MediaHub.java └── br/ └── com/ └── mediahub/ └── engine/ ├── content/ │ ├── MediaContent.java ← Classe base (abstração) │ ├── Movie.java ← Filme │ └── TVSeries.java ← Série de TV └── utilities/ └── TimeCalculator.java ← Gerenciador de duração

Code

---

## 📁 Classes e Responsabilidades

### `MediaContent` — Classe Base

**Pacote:** `br.com.mediahub.engine.content`

Classe pai que representa qualquer conteúdo audiovisual. Centraliza atributos e comportamentos compartilhados por filmes e séries.

| Atributo | Tipo | Descrição |
|---|---|---|
| `title` | `String` | Nome/título do conteúdo |
| `releaseYear` | `int` | Ano de lançamento (> 1888) |
| `totalDuration` | `int` | Duração em minutos (> 0) |
| `ratingCount` | `int` | Contador de avaliações |
| `ratingSum` | `double` | Soma de todas as notas |
| `isAvailableOnPlatform` | `boolean` | Se o conteúdo está ativo |

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
2. Lê e cadastra uma série
3. Exibe a ficha técnica de ambos
4. Exibe soma, quantidade e média de avaliações do filme
5. Adiciona os dois ao `TimeCalculator` e exibe o tempo total acumulado

---

## 🔄 Mapeamento de Refatoração

### Comparação: CineTrack → MovieHub

| CineTrack | MovieHub | Tipo |
|---|---|---|
| `Aplicacao` | `MediaHub` | Classe Principal |
| `Conteudo` | `MediaContent` | Classe Base |
| `Longa` | `Movie` | Subclasse |
| `Seriado` | `TVSeries` | Subclasse |
| `GerenciadorDeDuracao` | `TimeCalculator` | Utilitária |

### Mapeamento de Atributos

| CineTrack | MovieHub |
|---|---|
| `designacao` | `title` |
| `anoDeEstreia` | `releaseYear` |
| `duracaoTotal` | `totalDuration` |
| `quantidadeDeAvaliacoes` | `ratingCount` |
| `somaDeNotas` | `ratingSum` |
| `disponivelNaPlataforma` | `isAvailableOnPlatform` |
| `realizador` | `director` |
| `totalDeTemporadas` | `totalSeasons` |
| `episodiosPorTemp` | `episodesPerSeason` |
| `duracaoPorEpisodio` | `episodeDuration` |
| `emExibicao` | `isAiring` |

### Mapeamento de Métodos

| CineTrack | MovieHub |
|---|---|
| `exibirDetalhes()` | `displayDetails()` |
| `registrarAvaliacao()` | `recordRating()` |
| `calcularMedia()` | `calculateAverageRating()` |
| `obterDuracaoEmMinutos()` | `getDurationInMinutes()` |
| `adicionarConteudo()` | `addContent()` |
| `getDuracaoAcumulada()` | `getAccumulatedTime()` |

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
Input (Entrada do Usuário)
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
Output (Saída Esperada)
Code
--- Ficha Técnica do Filme ---
Título: Oppenheimer
Ano de Lançamento: 2023
Duração em minutos: 180

--- Ficha Técnica da Série ---
Título: Breaking Bad
Ano de Lançamento: 2008
Duração em minutos: 3055

--- Avaliações do Filme ---
Soma das avaliações: 17.5
Total de avaliações: 2
Média das avaliações: 8.75

--- Tempo Total ---
Tempo total acumulado: 3235 minutos
📊 Estrutura de Diretórios Completa
Code
moviehub/
├── README.md
└── src/
    ├── MediaHub.java
    └── br/
        └── com/
            └── mediahub/
                └── engine/
                    ├── content/
                    │   ├── MediaContent.java
                    │   ├── Movie.java
                    │   └── TVSeries.java
                    └── utilities/
                        └── TimeCalculator.java
🛠️ Tecnologias Utilizadas
Linguagem: Java 8+
Paradigma: Programação Orientada a Objetos (POO)
Conceitos: Herança, Polimorfismo, Encapsulamento, Abstração
IDE Recomendada: Eclipse, IntelliJ IDEA, VSCode com Java Extension Pack
📝 Notas de Desenvolvimento
Funcionalidades Preservadas da Versão Original
✅ Sistema de gerenciamento de conteúdos audiovisuais
✅ Cálculo inteligente de duração por tipo de conteúdo
✅ Sistema de avaliações com média aritmética
✅ Validações de dados de entrada
✅ Polimorfismo para compatibilidade de tipos
✅ Encapsulamento com getters/setters

Melhorias Implementadas
✨ Nomenclatura em inglês para melhor compreensão internacional
✨ Estrutura de pacotes mais organizada (engine/content/ e engine/utilities/)
✨ Nomes de classes mais descritivos e intuitivos
✨ Classe principal com nome mais significativo (MediaHub)
✨ Documentação completa em português

👥 Equipe
Nome
Lucas
João
📜 Licença
Este projeto está sob a licença MIT. Veja detalhes em LICENSE.

<div align="center">
Projeto desenvolvido para a disciplina de Programação Orientada a Objetos (POO).

MovieHub © 2026 - Refatoração do projeto CineTrack

</div> ```
<button onclick="navigator.clipboard.writeText(`# 🎬 MovieHub

<div align=\"center\">
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) ![POO](https://img.shields.io/badge/Paradigma-POO-blue?style=for-the-badge) ![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge) ![Licença](https://img.shields.io/badge/Licença-MIT-green?style=for-the-badge)

Sistema de gerenciamento e catalogação de conteúdos audiovisuais desenvolvido em Java puro com foco em Programação Orientada a Objetos. Refatoração completa do projeto CineTrack com novas estruturas de classe e nomenclaturas em inglês.

</div>
📑 Índice
Sobre o Projeto
Funcionalidades
Arquitetura
Classes e Responsabilidades
Mapeamento de Refatoração
Conceitos de POO Aplicados
Como Executar
Exemplo de Uso
Equipe
📖 Sobre o Projeto
O MovieHub é um sistema orientado a objetos desenvolvido em Java para cadastrar, avaliar e calcular a duração total de conteúdos audiovisuais. Trata-se de uma refatoração completa do projeto CineTrack, mantendo toda a funcionalidade original mas com:

✅ Nomenclatura em inglês para melhor internacionalização
✅ Estrutura de pacotes reorganizada (modelos em `content/`, utilitários em `utilities/`)
✅ Nomes de classes mais descritivos (`MediaContent`, `Movie`, `TVSeries`, `TimeCalculator`)
✅ Mesma lógica de negócio e validações
✅ Polimorfismo e herança preservados

O projeto contempla dois tipos de conteúdo: filmes (movies) e séries (TV series), com cálculos inteligentes de duração total.

Desenvolvido como projeto prático para a disciplina de Programação Orientada a Objetos (POO).

✨ Funcionalidades
✅ Cadastrar filmes com título, diretor, ano e duração
✅ Registrar e calcular média de avaliações de um filme
✅ Cadastrar séries com temporadas, episódios e duração por episódio
✅ Calcular duração total acumulada de todos os conteúdos via `TimeCalculator`
✅ Exibir ficha técnica completa de cada conteúdo
✅ Validação de dados (ano > 1888, duração > 0)
✅ Polimorfismo para cálculos de duração por tipo
🏗️ Arquitetura
``` moviehub/ └── src/ ├── MediaHub.java └── br/ └── com/ └── mediahub/ └── engine/ ├── content/ │ ├── MediaContent.java ← Classe base (abstração) │ ├── Movie.java ← Filme │ └── TVSeries.java ← Série de TV └── utilities/ └── TimeCalculator.java ← Gerenciador de duração ```

📁 Classes e Responsabilidades
`MediaContent` — Classe Base
Pacote: `br.com.mediahub.engine.content`

Classe pai que representa qualquer conteúdo audiovisual. Centraliza atributos e comportamentos compartilhados por filmes e séries.

Atributo	Tipo	Descrição
`title`	`String`	Nome/título do conteúdo
`releaseYear`	`int`	Ano de lançamento (> 1888)
`totalDuration`	`int`	Duração em minutos (> 0)
`ratingCount`	`int`	Contador de avaliações
`ratingSum`	`double`	Soma de todas as notas
`isAvailableOnPlatform`	`boolean`	Se o conteúdo está ativo
Método	Descrição
`displayDetails()`	Imprime os dados principais do conteúdo
`recordRating(double score)`	Acumula uma nota e incrementa o contador
`calculateAverageRating()`	Retorna a média aritmética das avaliações
`getDurationInMinutes()`	Retorna a duração total em minutos
Validações: `setReleaseYear` exige ano > 1888; `setTotalDuration` exige valor > 0.

`Movie` — Filme
Pacote: `br.com.mediahub.engine.content`

Subclasse de `MediaContent`. Adiciona o atributo `director` e sobrescreve `getDurationInMinutes()`.

Atributo	Tipo	Descrição
`director`	`String`	Nome do diretor do filme
`TVSeries` — Série de TV
Pacote: `br.com.mediahub.engine.content`

Subclasse de `MediaContent`. A duração total é calculada automaticamente com base no número de temporadas, episódios e duração por episódio.

Atributo	Tipo	Descrição
`totalSeasons`	`int`	Número de temporadas
`episodesPerSeason`	`int`	Episódios por temporada
`episodeDuration`	`int`	Duração de cada episódio (min)
`isAiring`	`boolean`	Se ainda está no ar
Cálculo: `getDurationInMinutes()` = `totalSeasons × episodesPerSeason × episodeDuration`

`TimeCalculator` — Calculadora de Tempo Total
Pacote: `br.com.mediahub.engine.utilities`

Responsável por acumular e fornecer a duração total de todos os conteúdos adicionados. Utiliza polimorfismo para ser compatível com `Movie` e `TVSeries` por meio da superclasse `MediaContent`.

Atributo	Tipo	Descrição
`accumulatedTime`	`int`	Soma total de todos os conteúdos
Método	Descrição
`addContent(MediaContent content)`	Chama `getDurationInMinutes()` e acumula ao total
`getAccumulatedTime()`	Retorna o tempo total acumulado em minutos
`MediaHub` — Ponto de Entrada
Arquivo: `src/MediaHub.java`

Lê os dados via terminal com `Scanner`, instancia os objetos e exibe os resultados. Fluxo:

Lê e cadastra um filme
Lê e cadastra uma série
Exibe a ficha técnica de ambos
Exibe soma, quantidade e média de avaliações do filme
Adiciona os dois ao `TimeCalculator` e exibe o tempo total acumulado
🔄 Mapeamento de Refatoração
Comparação: CineTrack → MovieHub
CineTrack	MovieHub	Tipo
`Aplicacao`	`MediaHub`	Classe Principal
`Conteudo`	`MediaContent`	Classe Base
`Longa`	`Movie`	Subclasse
`Seriado`	`TVSeries`	Subclasse
`GerenciadorDeDuracao`	`TimeCalculator`	Utilitária
Mapeamento de Atributos
CineTrack	MovieHub
`designacao`	`title`
`anoDeEstreia`	`releaseYear`
`duracaoTotal`	`totalDuration`
`quantidadeDeAvaliacoes`	`ratingCount`
`somaDeNotas`	`ratingSum`
`disponivelNaPlataforma`	`isAvailableOnPlatform`
`realizador`	`director`
`totalDeTemporadas`	`totalSeasons`
`episodiosPorTemp`	`episodesPerSeason`
`duracaoPorEpisodio`	`episodeDuration`
`emExibicao`	`isAiring`
Mapeamento de Métodos
CineTrack	MovieHub
`exibirDetalhes()`	`displayDetails()`
`registrarAvaliacao()`	`recordRating()`
`calcularMedia()`	`calculateAverageRating()`
`obterDuracaoEmMinutos()`	`getDurationInMinutes()`
`adicionarConteudo()`	`addContent()`
`getDuracaoAcumulada()`	`getAccumulatedTime()`
🧠 Conceitos de POO Aplicados
Conceito	Aplicação no Projeto
Herança	`Movie` e `TVSeries` herdam de `MediaContent`
Polimorfismo	`getDurationInMinutes()` é sobrescrito em cada subclasse; `TimeCalculator` usa `MediaContent` como tipo base
Encapsulamento	Todos os atributos são `private` com acesso via getters/setters
Abstração	`MediaContent` centraliza os comportamentos e atributos comuns
Validação	Setters com regras de negócio (`releaseYear > 1888`, `totalDuration > 0`)
🚀 Como Executar
Pré-requisitos
JDK 8 ou superior
Terminal (cmd, bash ou PowerShell)
1. Clone o repositório
```bash git clone https://github.com/eliandravirginia-prog/cinetrack.git cd cinetrack ```

2. Compile
Dentro da pasta `src/`:

```bash javac -d . MediaHub.java \ br/com/mediahub/engine/content/MediaContent.java \ br/com/mediahub/engine/content/Movie.java \ br/com/mediahub/engine/content/TVSeries.java \ br/com/mediahub/engine/utilities/TimeCalculator.java ```

3. Execute
```bash java MediaHub ```

💡 Exemplo de Uso
Input (Entrada do Usuário)
``` Digite o título do filme: Oppenheimer Digite o nome do diretor do filme: Christopher Nolan Digite o ano de lançamento do filme: 2023 Digite a duração do filme em minutos: 180 Digite a quantidade de avaliações: 2 Digite a nota da avaliação 1: 9.5 Digite a nota da avaliação 2: 8.0

Digite o título da série: Breaking Bad Digite o ano de lançamento da série: 2008 Digite a quantidade de temporadas da série: 5 Digite a quantidade de episódios por temporada: 13 Digite a duração de cada episódio em minutos: 47 ```

Output (Saída Esperada)
``` --- Ficha Técnica do Filme --- Título: Oppenheimer Ano de Lançamento: 2023 Duração em minutos: 180

--- Ficha Técnica da Série --- Título: Breaking Bad Ano de Lançamento: 2008 Duração em minutos: 3055

--- Avaliações do Filme --- Soma das avaliações: 17.5 Total de avaliações: 2 Média das avaliações: 8.75

--- Tempo Total --- Tempo total acumulado: 3235 minutos ```

📊 Estrutura de Diretórios Completa
``` moviehub/ ├── README.md └── src/ ├── MediaHub.java └── br/ └── com/ └── mediahub/ └── engine/ ├── content/ │ ├── MediaContent.java │ ├── Movie.java │ └── TVSeries.java └── utilities/ └── TimeCalculator.java ```

🛠️ Tecnologias Utilizadas
Linguagem: Java 8+
Paradigma: Programação Orientada a Objetos (POO)
Conceitos: Herança, Polimorfismo, Encapsulamento, Abstração
IDE Recomendada: Eclipse, IntelliJ IDEA, VSCode com Java Extension Pack
📝 Notas de Desenvolvimento
Funcionalidades Preservadas da Versão Original
✅ Sistema de gerenciamento de conteúdos audiovisuais
✅ Cálculo inteligente de duração por tipo de conteúdo
✅ Sistema de avaliações com média aritmética
✅ Validações de dados de entrada
✅ Polimorfismo para compatibilidade de tipos
✅ Encapsulamento com getters/setters

Melhorias Implementadas
✨ Nomenclatura em inglês para melhor compreensão internacional
✨ Estrutura de pacotes mais organizada (`engine/content/` e `engine/utilities/`)
✨ Nomes de classes mais descritivos e intuitivos
✨ Classe principal com nome mais significativo (`MediaHub`)
✨ Documentação completa em português

👥 Equipe
Nome
Lucas
João
📜 Licença
Este projeto está sob a licença MIT. Veja detalhes em LICENSE.

<div align=\"center\">
Projeto desenvolvido para a disciplina de Programação Orientada a Objetos (POO).

MovieHub © 2026 - Refatoração do projeto CineTrack

</div>`); alert('README copiado com sucesso! 📋')" style="padding: 12px 24px; font-size: 16px; background: #238636; color: white; border: none; border-radius: 6px; cursor: pointer; font-weight: bold;"> 📋 Copiar README Completo </button>
Make these code changes?
README.md

md
# 🎬 MovieHub

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![POO](https://img.shields.io/badge/Paradigma-POO-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)
![Licença](https://img.shields.io/badge/Licença-MIT-green?style=for-the-badge)

> Sistema de gerenciamento e catalogação de conteúdos audiovisuais desenvolvido em Java puro com foco em Programação Orientada a Objetos. Refatoração completa do projeto CineTrack com novas estruturas de classe e nomenclaturas em inglês.

</div>

---

## 📑 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Arquitetura](#-arquitetura)
- [Classes e Responsabilidades](#-classes-e-responsabilidades)
- [Mapeamento de Refatoração](#-mapeamento-de-refatoração)
- [Conceitos de POO Aplicados](#-conceitos-de-poo-aplicados)
- [Como Executar](#-como-executar)
- [Exemplo de Uso](#-exemplo-de-uso)
- [Equipe](#-equipe)

---

## 📖 Sobre o Projeto

O **MovieHub** é um sistema orientado a objetos desenvolvido em Java para cadastrar, avaliar e calcular a duração total de conteúdos audiovisuais. Trata-se de uma refatoração completa do projeto **CineTrack**, mantendo toda a funcionalidade original mas com:

✅ **Nomenclatura em inglês** para melhor internacionalização  
✅ **Estrutura de pacotes reorganizada** (modelos em `content/`, utilitários em `utilities/`)  
✅ **Nomes de classes mais descritivos** (`MediaContent`, `Movie`, `TVSeries`, `TimeCalculator`)  
✅ **Mesma lógica de negócio** e validações  
✅ **Polimorfismo e herança** preservados  

O projeto contempla **dois tipos de conteúdo**: filmes (movies) e séries (TV series), com cálculos inteligentes de duração total.

Desenvolvido como projeto prático para a disciplina de **Programação Orientada a Objetos (POO)**.

---

## ✨ Funcionalidades

- ✅ Cadastrar filmes com título, diretor, ano e duração
- ✅ Registrar e calcular média de avaliações de um filme
- ✅ Cadastrar séries com temporadas, episódios e duração por episódio
- ✅ Calcular duração total acumulada de todos os conteúdos via `TimeCalculator`
- ✅ Exibir ficha técnica completa de cada conteúdo
- ✅ Validação de dados (ano > 1888, duração > 0)
- ✅ Polimorfismo para cálculos de duração por tipo

---

## 🏗️ Arquitetura

moviehub/ └── src/ ├── MediaHub.java └── br/ └── com/ └── mediahub/ └── engine/ ├── content/ │ ├── MediaContent.java ← Classe base (abstração) │ ├── Movie.java ← Filme │ └── TVSeries.java ← Série de TV └── utilities/ └── TimeCalculator.java ← Gerenciador de duração

Code

---

## 📁 Classes e Responsabilidades

### `MediaContent` — Classe Base

**Pacote:** `br.com.mediahub.engine.content`

Classe pai que representa qualquer conteúdo audiovisual. Centraliza atributos e comportamentos compartilhados por filmes e séries.

| Atributo | Tipo | Descrição |
|---|---|---|
| `title` | `String` | Nome/título do conteúdo |
| `releaseYear` | `int` | Ano de lançamento (> 1888) |
| `totalDuration` | `int` | Duração em minutos (> 0) |
| `ratingCount` | `int` | Contador de avaliações |
| `ratingSum` | `double` | Soma de todas as notas |
| `isAvailableOnPlatform` | `boolean` | Se o conteúdo está ativo |

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
2. Lê e cadastra uma série
3. Exibe a ficha técnica de ambos
4. Exibe soma, quantidade e média de avaliações do filme
5. Adiciona os dois ao `TimeCalculator` e exibe o tempo total acumulado

---

## 🔄 Mapeamento de Refatoração

### Comparação: CineTrack → MovieHub

| CineTrack | MovieHub | Tipo |
|---|---|---|
| `Aplicacao` | `MediaHub` | Classe Principal |
| `Conteudo` | `MediaContent` | Classe Base |
| `Longa` | `Movie` | Subclasse |
| `Seriado` | `TVSeries` | Subclasse |
| `GerenciadorDeDuracao` | `TimeCalculator` | Utilitária |

### Mapeamento de Atributos

| CineTrack | MovieHub |
|---|---|
| `designacao` | `title` |
| `anoDeEstreia` | `releaseYear` |
| `duracaoTotal` | `totalDuration` |
| `quantidadeDeAvaliacoes` | `ratingCount` |
| `somaDeNotas` | `ratingSum` |
| `disponivelNaPlataforma` | `isAvailableOnPlatform` |
| `realizador` | `director` |
| `totalDeTemporadas` | `totalSeasons` |
| `episodiosPorTemp` | `episodesPerSeason` |
| `duracaoPorEpisodio` | `episodeDuration` |
| `emExibicao` | `isAiring` |

### Mapeamento de Métodos

| CineTrack | MovieHub |
|---|---|
| `exibirDetalhes()` | `displayDetails()` |
| `registrarAvaliacao()` | `recordRating()` |
| `calcularMedia()` | `calculateAverageRating()` |
| `obterDuracaoEmMinutos()` | `getDurationInMinutes()` |
| `adicionarConteudo()` | `addContent()` |
| `getDuracaoAcumulada()` | `getAccumulatedTime()` |

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
Input (Entrada do Usuário)
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
Output (Saída Esperada)
Code
--- Ficha Técnica do Filme ---
Título: Oppenheimer
Ano de Lançamento: 2023
Duração em minutos: 180

--- Ficha Técnica da Série ---
Título: Breaking Bad
Ano de Lançamento: 2008
Duração em minutos: 3055

--- Avaliações do Filme ---
Soma das avaliações: 17.5
Total de avaliações: 2
Média das avaliações: 8.75

--- Tempo Total ---
Tempo total acumulado: 3235 minutos
📊 Estrutura de Diretórios Completa
Code
moviehub/
├── README.md
└── src/
    ├── MediaHub.java
    └── br/
        └── com/
            └── mediahub/
                └── engine/
                    ├── content/
                    │   ├── MediaContent.java
                    │   ├── Movie.java
                    │   └── TVSeries.java
                    └── utilities/
                        └── TimeCalculator.java
🛠️ Tecnologias Utilizadas
Linguagem: Java 8+
Paradigma: Programação Orientada a Objetos (POO)
Conceitos: Herança, Polimorfismo, Encapsulamento, Abstração
IDE Recomendada: Eclipse, IntelliJ IDEA, VSCode com Java Extension Pack
📝 Notas de Desenvolvimento
Funcionalidades Preservadas da Versão Original
✅ Sistema de gerenciamento de conteúdos audiovisuais
✅ Cálculo inteligente de duração por tipo de conteúdo
✅ Sistema de avaliações com média aritmética
✅ Validações de dados de entrada
✅ Polimorfismo para compatibilidade de tipos
✅ Encapsulamento com getters/setters

Melhorias Implementadas
✨ Nomenclatura em inglês para melhor compreensão internacional
✨ Estrutura de pacotes mais organizada (engine/content/ e engine/utilities/)
✨ Nomes de classes mais descritivos e intuitivos
✨ Classe principal com nome mais significativo (MediaHub)
✨ Documentação completa em português

👥 Equipe
Nome
Lucas
João
📜 Licença
Este projeto está sob a licença MIT. Veja detalhes em LICENSE.

<div align="center">
Projeto desenvolvido para a disciplina de Programação Orientada a Objetos (POO).

MovieHub © 2026 - Refatoração do projeto CineTrack

</div>