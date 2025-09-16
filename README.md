command's for running application's

for jwt token and file's generation:- java -jar jwt.jar

ClientApp:- java -jar payara.jar --deploy ClientApp/artifact/ClientApp.war --port 8086

ServerApp:- java -jar payara.jar --deploy ServerApp/artifact/ServerApp.war --port 8085 --addlibs mysql.jar --domainconfig domain.xml
