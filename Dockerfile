FROM postgres:9.4
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD 12345
ENV POSTGRES_DB jbehave_demo
COPY db/client.sql /docker-entrypoint-initdb.d/
