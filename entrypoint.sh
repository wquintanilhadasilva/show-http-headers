#!/bin/sh

echo "Iniciando a aplicação..."
exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "${HOME}/${APP_NAME}.jar" "$@"