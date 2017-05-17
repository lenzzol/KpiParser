FROM hseeberger/scala-sbt:latest
COPY . /app
WORKDIR /app

RUN sbt compile
CMD sbt run
EXPOSE 9000
