# Инструкция по сборке
**При помощи командной строки:**
  1. cd *папка с проектом (пример: cd C:\Users\...\project_name)*
  2. mvn package
  После успешной сборки проекта:
  3. cd target
  4. java -jar *созданный jar-файл (пример: java -jar task-0.0.1-SNAPSHOT.jar)*
  Запросы доступны по адресам localhost:8080/hourse/servlet/count и http://localhost:8080/hourse/rest/count
  Пример запроса: http://localhost:8080/hourse/rest/count?width=50&height=50&start=a15&end=w50

**При помощи IDE Intellij IDEA:**
  1. Открыть проект
  2. Запустить 'TaskApplication'
