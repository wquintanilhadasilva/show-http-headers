FROM openjdk:11.0-jre-slim-buster
ENV APP_NAME="show-http-headers"
ENV TZ="America/Sao_Paulo"
EXPOSE 8000-9000
ENTRYPOINT ["/entrypoint.sh"]

# Run as non-root
RUN useradd -ms /bin/bash test
WORKDIR /home/test
USER test

COPY --chown=test ./target/${APP_NAME}.jar ./${APP_NAME}.jar
COPY --chown=test ./entrypoint.sh /entrypoint.sh
