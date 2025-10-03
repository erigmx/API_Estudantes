# Teste Técnico da AvantSoft
# 📚 API de Estudantes

API REST construída em **Spring Boot** para gerenciar estudantes.

---

## 🚀 Endpoints

### 🔹 Criar Estudante
**POST /students**

- **Request Body:**
```json
{
  "nome": "Gabriel",
  "nota": 8.5
}
```

- **Response (201 Created):**
```json
{
  "id": 1,
  "nome": "Gabriel",
  "nota": 8.5,
  "primeiraLetraNaoRepetida": "g"
}
```

- **Erros possíveis:**
```json
{ "erro": "A nota deve estar entre 0 e 10" }
{ "erro": "O nome é obrigatório" }
```

---

### 🔹 Listar Todos os Estudantes
**GET /students**

- **Response (200 OK):**
```json
[
  {
    "id": 1,
    "nome": "Gabriel",
    "nota": 8.5,
    "primeiraLetraNaoRepetida": "g"
  },
  {
    "id": 2,
    "nome": "Anna",
    "nota": 9.0,
    "primeiraLetraNaoRepetida": "_"
  }
]
```

---

### 🔹 Buscar Estudante por ID
**GET /students/{id}**

- **Exemplo:**
```
GET /students/1
```

- **Response (200 OK):**
```json
{
  "id": 1,
  "nome": "Gabriel",
  "nota": 8.5,
  "primeiraLetraNaoRepetida": "g"
}
```

- **Erro (404 Not Found):**
```json
{ "erro": "Estudante não encontrado" }
```

---

## ✅ Regras Importantes
- Nome não pode ser vazio
- Nota deve estar entre **0 e 10**
- IDs são gerados automaticamente
- A API retorna também a **primeira letra não repetida** do nome
