# 📝 Sistema de Gestão de Tarefas

## 📌 Arquitetura escolhida
O sistema foi desenvolvido seguindo o padrão **MVC (Model-View-Controller)**:

- **Model**:  
  Contém a classe `Tarefa` com os atributos e métodos essenciais (`título`, `descrição`, `prioridade`, `prazo`, `concluída`) e o enum `Prioridade`.

- **View**:  
  Simula a interface principal para visualização do usuário através do **menu**.

- **Controller**:  
  Coordena a interação entre o usuário (**View**) e as regras de negócio (**Service**).

---

## 🏗️ Padrões de Projeto aplicados

### 🔨 Factory Method (Criação)
- Classe `TarefaPadrao` cria instâncias de `Tarefa`.
- Encapsula a lógica de criação e facilita a evolução do sistema (ex: novas subclasses de tarefas).

### 🎨 Decorator (Estrutural)
- Classe `DecoratorTarefaConcluida` adiciona a informação **[CONCLUÍDA]** na exibição da tarefa.
- Permite “decorar” tarefas sem alterar a classe original (`Tarefa`).

### ⚙️ Strategy (Comportamental)
- Interface `FiltroTarefaStrategy` define um contrato para **filtragem de tarefas**.
- Exemplos: `FiltroPrioridadeAlta`, `FiltroVencidas`.
- Permite aplicar diferentes estratégias de filtragem dinamicamente, sem modificar o `Service`.

---

## 🚀 Como rodar o sistema

### 1️⃣ Clonar o repositório
```bash
git clone <URL_DO_REPOSITORIO>
cd avaliacao-final-mvc-julia-raquel
```

### 2️⃣ Compilar os arquivos
```bash
javac src/*.java
```

### 3️⃣ Executar o programa
```bash
java src.Main
```

---

## 📖 Exemplos de uso via `main()`

Ao executar, o sistema apresenta o seguinte menu:

```bash
--- Menu de Tarefas ---
1 - Criar Tarefa
2 - Listar Todas
3 - Concluir Tarefa
4 - Listar Vencidas
5 - Filtrar por Prioridade
0 - Sair
Escolha:
```

### ✅ Criar Tarefa
```bash
Digite o título: ...
Digite a descrição: ...
Digite a prioridade (1-BAIXA, 2-MÉDIA, 3-ALTA): ...
Digite o prazo (AAAA-MM-DD): ...
```

### 📋 Listar Tarefas
```bash
Tarefa 1 - [CONCLUÍDA]
Tarefa 2 - Prazo: 2025-08-20
```

### ✔️ Concluir Tarefa
```bash
Digite o título da tarefa que deseja concluir: ...
```

### ⏳ Listar Vencidas
```bash
Tarefa X - Prazo: 2025-08-10 (VENCIDA)
```

### 🎯 Filtrar Tarefas
```bash
Filtrando por prioridade: ALTA
- Tarefa Urgente [CONCLUÍDA]
```
