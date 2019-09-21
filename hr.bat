call mvn -B -s settings.xml -DskipTests=true clean package
call java -Dspring.profiles.active="jpa,heroku" -DDATABASE_URL="mysql://makler:makler@localhost:5432/peopleandtasks" -jar target/dependency/webapp-runner.jar target/*.war
