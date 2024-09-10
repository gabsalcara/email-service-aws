# Email Service

Este projeto utiliza as APIs da Amazon SES e SparkSpot para enviar e-mails. Utilizando um design de fallback, caso o serviço da Amazon SES não consiga dispara o e-mail o serviço da SparkSpot será requisito para executar o disparo.

## Documentação da API

#### Enviar e-mail

```http
  POST /api/v1/email/

{
    "para":"email@example.com",
    "assunto":"String",
    "body":"String"
}
```
## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente no seu .env

`AWS_ACCESS_KEY`

`AWS_REGION`

`AWS_SECRET_KEY`

`EMAIL`

`SPARKPOST_API_KEY`


## Stack utilizada

**Back-end:**

Java versão 21

SpringBoot 3.3.2

Maven 3.9.6


## Referência

- [Resolvendo DESAFIO de VAGA BACKEND com Java Spring + Arquitetura Limpa](https://www.youtube.com/watch?v=eFgeO9M9lLw)
- [Coding Challenge Guidelines](https://github.com/uber-archive/coding-challenge-tools/blob/master/coding_challenge.md)

