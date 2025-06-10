# 🌍 The Guardian’s Eyes

**Sistema Inteligente de Monitoramento e Classificação de Riscos Ambientais**

---

## 👥 Integrantes

| Nome Completo                | RM     |
|-----------------------------|--------|
| Leonardo Pimentel Santos    | 557541 |
| Pedro Henrique Lima Santos | 558243 |
| Vitor Gomes Martins         | 558244 |

---

## 🧠 Contexto do Projeto

Desastres naturais como deslizamentos de terra e enchentes causam graves impactos em áreas urbanas. Muitas prefeituras carecem de ferramentas tecnológicas para monitoramento, previsão e resposta a esses eventos.

**The Guardian’s Eyes** propõe uma solução completa e acessível para enfrentar esse problema, integrando:

- Dispositivos IoT
- Drones com visão computacional
- Inteligência Artificial
- Dashboard interativa

---

## ✅ Solução Proposta
O projeto propõe um sistema inteligente que integra sensores IoT e visão computacional para monitorar e classificar riscos ambientais. Sensores coletam dados em tempo real, enquanto drones capturam imagens aéreas processadas por IA. Essas informações são validadas, armazenadas em banco de dados e exibidas em uma dashboard interativa com alertas, mapas e relatórios, apoiando órgãos como a defesa civil na tomada de decisões rápidas e eficazes em situações de emergência.

### 🛰️ Monitoramento com IoT
Sensores instalados em áreas de risco coletam:
- Velocidade do vento
- Umidade do solo
- Temperatura
- Outros dados ambientais

### 🚁 Visão Computacional para Apoio ao Resgate
- Drones sobrevoam regiões afetadas.
- Detectam automaticamente pessoas em risco.
- A imagem + localização são enviadas:
  - Para a **API .NET**
  - Que comunica com a **API Java**
- A IA classifica a **gravidade do local**.
- As informações são enviadas para as **equipes de resgate**.

> ⚠️ O sistema **não classifica o estado clínico** da pessoa. Apenas a gravidade do ambiente ao redor.

### ⚙️ Processamento com IA
- Imagens são analisadas pela API Java.
- Classificação da gravidade: `leve`, `moderado`, `pesado`.
- Resultados retornam para a API .NET que:
  - Registra a ocorrência
  - Dispara alertas
  - Prioriza ações com base em dados reais

### 📊 Visualização em Tempo Real
- Dashboard com:
  - Alertas em tempo real
  - Mapa georreferenciado
  - Histórico e relatórios automáticos

---


### 🌐 API JAVA
Gerencia as entidades:
- `CapturedImageEntity`
- `DisasterGroupEntity`
- `DisasterSensorEntity`
- `ImpactRatingEntity`
- `LocalEntity`
- `SubgroupDisasterEntity`,
- `SensorEntity`, `VantEntity`
- `UserEntity`


## 🧱 Arquitetura do Projeto
## 📁 Estrutura de Pastas

```text
java\montclio\theGuardiansEye
├── config                      ← Arquivos de configuração (segurança, beans, CORS, etc.)
├── controller                  ← Controladores REST responsáveis pelas rotas da API
├── model
│   ├── dto                     ← Objetos de transferência de dados (Data Transfer Objects)
│   ├── entity                  ← Entidades JPA mapeadas com o banco de dados
│   ├── enums                   ← Enumerações com constantes utilizadas no domínio
│   ├── mapper                  ← Converters entre DTOs e entidades (usualmente com MapStruct ou manual)
│   └── repository              ← Interfaces de repositório (Spring Data JPA)
├── service                     ← Regras de negócio e orquestração das operações
├── specification               ← Filtros e critérios dinâmicos para queries (Specification API)
└── TheGuardiansEyeApplication.java  ← Classe principal que inicia a aplicação Spring Boot


---

## 1. Pré-requisitos

- Java 17+ instalado  
- Maven instalado  
- Banco Oracle configurado com:
  - Tabela `tb_tge_usuario` (coluna `senha VARCHAR2(60)` e `email` único)
  - Flyway com `spring.flyway.baseline-on-migrate=true` no `application.properties`  
- Variável de ambiente ou `application.properties` com:
  ```properties
  spring.datasource.url=jdbc:oracle:thin:@//<host>:1521/<service>
  spring.datasource.username=<usuario>
  spring.datasource.password=<senha>

  jwt.secret=SuaChaveSecretaAqui
  spring.flyway.baseline-on-migrate=true
  

## ▶️ Como Executar o Projeto
1. Executar a classe `TheGuardiansEyeApplication`
2. Testar via Postman / Insomnia -> `http://localhost:8080`
3.1 Registrar novo usuário

- **Method**: `POST`  
- **URL**: `http://localhost:8080/auth/register`  
- **Headers**: `Content-Type: application/json`

- **Body**:
```json
{
  "firstName": "Luciana",
  "lastName": "Fernandes Rocha",
  "cpf": 33322211144,
  "position": "Analista",
  "function": "Gestão de Desastres",
  "authRole": "ADMIN",
  "email": "luciana.rocha@exemplo.com",
  "password": "senhaLuciana2025"
}


**Resposta esperada**:
```json
{
  "token": "<seu_jwt_aqui>",
  "type": "Bearer",
  "email": "luciana.rocha@exemplo.com"
}


3.2 Fazer login
Method: POST

URL: http://localhost:8080/auth/login

Headers:
Content-Type: application/json

Body:
```json
{
  "email": "luciana.rocha@exemplo.com",
  "password": "senhaLuciana2025"
}

Resposta esperada:
```json
{
  "token": "<seu_jwt_aqui>",
  "type": "Bearer",
  "email": "luciana.rocha@exemplo.com"
}
3.3 Acessar endpoint protegido
Method: GET

URL: http://localhost:8080/disaster-group

Headers:
Authorization: Bearer <seu_jwt_aqui>

