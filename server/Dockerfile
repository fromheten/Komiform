FROM clojure
MAINTAINER Martin Josefsson <komiform@martinjosefsson.com>
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY project.clj /usr/src/app/
RUN lein deps
COPY . /usr/src/app
RUN mv "$(lein uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" app-standalone.jar
EXPOSE 3000
VOLUME /tmp/komiform
ENTRYPOINT ["java", "-jar", "app-standalone.jar"]
