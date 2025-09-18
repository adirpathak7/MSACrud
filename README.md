<img width="591" height="358" alt="image" src="https://github.com/user-attachments/assets/ad4f97d4-78e3-49f8-b04c-2446e49b8ed8" />MSA Application with JWT & Payara Micro

This project demonstrates a Microservices-based Application (MSA) using:

🟦 Jakarta EE 9
🟩 Payara Micro
🔑 JWT Authentication
⚙️ MicroProfile Config

It consists of two main modules:

ClientApp (consumer application)
ServerApp (resource provider application)

Project Structure

Root Folder
│── ClientApp/                       # Client microservice
│── ServerApp/                       # Server microservice
│── domain.xml                       # Domain configuration
│── jwt.jar                          # JWT generator jar
│── jwtenizr-config.json             # JWT configuration
│── jwt-token.json                   # JWT payload definition
│── token.jwt                        # Generated token
│── mysql.jar                        # MySQL driver
│── payara.jar                       # Payara Micro server
│── microprofile-config.properties   # Config for JWT + services
│── README.md                        0# Project documentation

<img width="542" height="319" alt="image" src="https://github.com/user-attachments/assets/d1186b7d-e1ad-4a98-b53a-15f5280f83d5" />

🚀 Setup & Run
1️⃣ Start Payara Server

Make sure payara-micro-6.x.x.jar is in your project root.
Run:

java -jar payara.jar --deploy ServerApp/artifact/ServerApp.war --port 8085 --addlibs mysql.jar --domainconfig domain.xml
java -jar payara.jar --deploy ClientApp/artifact/ClientApp.war --port 8086


2️⃣ Configure MicroProfile

Inside both projects:

👉 Create folder:

src/main/resources/META-INF

Add microprofile-config.properties

👉 Example for ClientApp:

clkey/mp-rest/url=http://localhost:8085/MSAResource/rest/example
jwt-string=your-jwt-token-here

👉 Example for ServerApp:

mp.jwt.verify.publickey=<your-public-key>
mp.jwt.verify.issuer=airhacks


3️⃣ Generate JWT Token 🔑

Place jwtenizr.jar in project root and run:

java -jar jwtenizr.jar

✅ This will auto-generate:

▪️ jwt-token.json
▪️ jwtenizr-config.json
▪️ microprofile-config.properties
▪️ token.jwt

Copy the token (without Bearer) into ClientApp microprofile-config.properties.

4️⃣ Example JWT Configuration

Generated public key config (to put in ServerApp):

mp.jwt.verify.publickey=MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8A...
mp.jwt.verify.issuer=airhacks

👉 Example jwt-token.json:

{
  "iss": "airhacks",
  "jti": "42",
  "sub": "duke",
  "upn": "duke",
  "groups": ["admin", "user"]
}

5️⃣ Client JWT Injection

In ServiceInterface.java (ClientApp inside com.it.clientapp.doctor):

default String getToken() {
        Config config = ConfigProvider.getConfig();
        String token = "Bearer " + config.getValue("jwt", String.class);;
        return token;
}

👉 Secure API with:

@GET
@ClientHeaderParam(name = "Authorization", value = "{getToken}")
@RolesAllowed("Admin")
@Produces(MediaType.TEXT_PLAIN)
public String get();


⚠️ Common Errors

Error: Unable to access jarfile payara.jar
➝ Ensure payara.jar is in project root.

401 Unauthorized
➝ Re-run java -jar jwt.jar to regenerate JWT token and update microprofile-config.properties.

META-INF Not Found
➝ Ensure exact name: META-INF/microprofile-config.properties.


👉 Step by step guide for MSA applications:

• start payara server
• java with maven -> project from archetype -> create Jakarta EE 9 projects
• write project name and docker-hub-name
• one more project for client project
• change javax to jakarta from both project
• in src/main/resources -> create new folder META-INF
• in META-INF -> create microprofile-config.properties in both project
• in ClientApp add clkey/mp-rest/url= {server app url like:- http://localhost:8085/ServerApp/rest/example}
• in server (resource) app META-INF create persistence.xml
• add the required things in persistence.xml (above is the example)
• in your domain.xml change the database name and change password also if there is not useSSL propert so add it and change the value false
• create the entity
• create the ejb
• create the api's and call the ejb'e method into the api's method
• generate JWT using jwt.jar
• authorized the api's using     @RolesAllowed("users")
• add the 2 annotation's in the bootstraps file of server app [ @LoginConfig(authMethod = "MP-JWT") and @RolesAllowed({"admin", "user"}) ]
• in server app microprofile-config.properties add the mp.jwt.verify.publickey and mp.jwt.verify.issuer
• add token to ClientApp in microprofile-config.properties
• create a entity file in the ClientApp and only write properties and it's getters & setters
• create a package in the ClientApp and into the package create an Interface and Servlet
• in interface write the all the api's which you created in the service of the server app also authorized it
• into the interface create a default method for get the JWT token
• you have to inject the interface in your servlet and call the interface method to display the data or do the operation
• you can create N number of servlet's based on your requirement
• clean and build the client & server apps
• first you have to deploy server app then you can deploy the client app
• ServerApp deploy command:- java -jar payara.jar --deploy ServerApp/artifact/ServerApp.war --port 8085 --addlibs mysql.jar --domainconfig domain.xml
• ClientApp deploy command:- java -jar payara.jar --deploy ClientApp/artifact/ClientApp.war --port 8086
• ServerApp url:- http://localhost:8085/ServerApp/rest/example
• ClientApp url:- http://localhost:8086/ClientApp/ExampleServlet
