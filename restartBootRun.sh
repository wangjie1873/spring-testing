#restart application
./gradlew -stop
./source .env
./gradlew bootRun
