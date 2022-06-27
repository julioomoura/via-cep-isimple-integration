FROM jenkins/jenkins:lts-jdk11
USER root
RUN apt-get update \
    && apt-get install -y sudo curl

RUN echo "jenkins ALL=NOPASSWD: ALL" >> /etc/sudoers

RUN curl -fsSL https://get.docker.com/ | bash

USER jenkins