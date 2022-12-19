FROM ibm-semeru-runtimes:open-18.0.2_9-jdk-focal as builder
RUN mkdir /app
COPY build/libs/homepage-api-1.0.0.jar /app
WORKDIR app
RUN java -Djarmode=layertools -jar homepage-api-1.0.0.jar extract

FROM ibm-semeru-runtimes:open-18.0.2_9-jre-focal
WORKDIR app
COPY --from=builder app/dependencies/ ./
COPY --from=builder app/spring-boot-loader/ ./
COPY --from=builder app/snapshot-dependencies/ ./
COPY --from=builder app/application/ ./
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=33", "-XX:+HeapDumpOnOutOfMemoryError", "-XX:HeapDumpPath=/dumps", "-Djava.security.egd=file:/dev/./urandom", "org.springframework.boot.loader.JarLauncher"]
