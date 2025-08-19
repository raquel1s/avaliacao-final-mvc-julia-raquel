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
git clone https://github.com/raquel1s/avaliacao-final-mvc-julia-raquel.git
cd avaliacao-final-mvc-julia-raquel
```

### 2️⃣ Executar o programa
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
- Entrada de título, descrição, prioridade (1-BAIXA, 2-MÉDIA, 3-ALTA) e prazo (AAAA-MM-DD).

### 📋 Listar Tarefas
- Mostra todas as tarefas criadas.
- Tarefas concluídas são exibidas com [CONCLUÍDA] (Decorator).

### ✔️ Concluir Tarefa
- Usuário informa o título da tarefa.
- Tarefa é marcada como concluída (Service) e exibida com [CONCLUÍDA].

### ⏳ Listar Vencidas
- Mostra apenas as tarefas cujo prazo de conclusão é anterior à data atual.

### 🎯 Filtrar Tarefas
- Permite verificar tarefas nas diferentes prioridades (BAIXA, MÉDIA, ALTA).
