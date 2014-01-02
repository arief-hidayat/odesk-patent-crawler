call mvn clean package
cd target/
REM java -jar patent-maintenance-fee-crawler-1.0-SNAPSHOT.jar
REM java -jar -Dgeb.env=chrome -Ddriver.loc="../drivers" patent-maintenance-fee-crawler-1.0-SNAPSHOT.jar
java -jar -Dgeb.env=ie -Ddriver.loc="../drivers" patent-maintenance-fee-crawler-1.0-SNAPSHOT.jar
REM java -jar -Dgeb.env=firefox -Dfirefox.bin="C:/Program Files (x86)/Mozilla/Firefox" patent-maintenance-fee-crawler-1.0-SNAPSHOT.jar
cd ..