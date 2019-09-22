call mvn -B -s settings.xml -DskipTests=true clean package
call java -Dspring.profiles.active="jpa,heroku" -DCLEARDB_DATABASE_URL="mysql://makler:makler@localhost:3306/peopleandtasks?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC" -jar target/dependency/webapp-runner.jar target/*.war
