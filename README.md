# Criando uma pipeline no Jenkins para Java

## Objetivos

[x] Instalar o Jenkins localmente
[x] Pipeline básica
[x] Build e teste da aplicação
[x] Build da imagem docker
[ ] Publicar a imagem docker no dockerhub
[ ] Fazer o deploy em alguma nuvem

## Instalação do Jenkins

Usei a imagem docker disponível no docker hub: https://hub.docker.com/r/jenkins/jenkins. Usei o comando básico:

    docker run -d --name jenkins -p 8080:8080 jenkins/jenkins:lts-jdk11

## Usando o Jenkins

- Fiz um curso básico da alura: https://www.alura.com.br/curso-online-jenkins-integracao-continua
  O curso é BEM introdutório mesmo... ele nem chega a mostrar a definição de um dockerfile. Juntamente do curso eu criei uma pipeline manualmente bem básica, que fica buscando atualizações na branch main do repositório git. Sempre que há commits novos. Se houver, a pipeline builda e testa o código atualizado.

- Como eu já sabia da existência do arquivo de configuração de pipeline Jenkinsfile, procurei como criar uma pipeline usando ele.

- Para isso eu criei um item de pipeline multibranch

### A saga do Jenkinsfile

- Criei um jenkinsfile padrão, que tinha os steps build, tests e deploy

- Inicialmente não funcionou, porque ele não encontrou o **mvn**. O que achei estranho, porque já tinha o Maven configurado em _Global Tool Configuration_. Após uma breve pesquisa, descobri que precisava adicionar o mvn na diretiva tools do jenkinsfile.
- Rodei a pipeline e... falhou de novo. Não encontrou a jdk, a solução pra esse problema foi baixar uma JDK(17) dentro do container docker e adicionar uma JDK em _Global Tool Configuration_. E também adicionar o nome da JDK na diretiva tools do jenkinsfile.

### A saga do docker dentro do docker
