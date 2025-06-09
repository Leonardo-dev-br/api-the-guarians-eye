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
com.montclio.theGuardiansEye
java\montclio\theGuardiansEye
├── config                        ← Arquivos de configuração da aplicação (segurança, BD, Autenticação, etc.)
├── controller                    ← Camada responsável por receber as requisições HTTP (REST Controllers)
├── model
│   ├── dto                       ← Objetos de transferência de dados
│   ├── entity                    ← Entidades JPA que representam as tabelas no banco de dados
│   ├── enums                     ← Enumerações utilizadas na aplicação (ex: tipos, estados, perfis)
│   ├── mapper                    ← Conversores entre entidades e DTOs
│   └── repository                ← Interfaces do Spring Data JPA para acesso ao banco
├── service                       ← Camada de regras de negócio (lógica da aplicação)
├── specification                 ← Implementações de filtros e critérios dinâmicos de consulta com Spring Data JPA (Specification API)
└── TheGuardiansEyeApplication.java ← Classe principal que inicia a API Spring Boot

## ▶️ Como Executar o Projeto