FROM adoptopenjdk/openjdk11:jdk-11.0.3.7

ENV WILDFLY_VERSION=26.0.0.Final

RUN apt-get update && \
    apt-get install -y curl

RUN mkdir -p /opt/jboss && \
    cd /opt/jboss && \
    curl -L https://github.com/wildfly/wildfly/releases/download/${WILDFLY_VERSION}/wildfly-${WILDFLY_VERSION}.tar.gz | tar xzf - && \
    mv wildfly-${WILDFLY_VERSION} wildfly

ENTRYPOINT [ "/opt/jboss/wildfly/bin/standalone.sh", "-b",  "0.0.0.0", "-bmanagement", "0.0.0.0" ]    