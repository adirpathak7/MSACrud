MSA Application with JWT & Payara Micro

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
│── ClientApp/                     # Client microservice
│── ServerApp/                     # Server microservice
│── domain.xml                     # Domain configuration
│── jwt.jar                        # JWT generator jar
│── jwtenizr-config.json           # JWT configuration
│── jwt-token.json                 # JWT payload definition
│── token.jwt                      # Generated token
│── mysql.jar                      # MySQL driver
│── payara-micro.jar               # Payara Micro server
│── microprofile-config.properties # Config for JWT + services
│── README.md                      # Project documentation


🚀 Setup & Run
1️⃣ Start Payara Micro Server

Make sure payara-micro-6.x.x.jar is in your project root.
Run:

java -jar payara-micro-6.2025.4.jar --deploy ServerApp/target/ServerApp.war --port 8085
java -jar payara-micro-6.2025.4.jar --deploy ClientApp/target/ClientApp.war --port 8086


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
  "groups": ["Admin", "User"]
}

5️⃣ Client JWT Injection

In ServiceInterface.java (ClientApp):

default String generateJWTToken() {
    Config config = ConfigProvider.getConfig();
    String token = "Bearer " + config.getValue("jwt-string", String.class);
    System.out.println("Token = " + token);
    return token;
}

👉 Secure API with:

@GET
@ClientHeaderParam(name = "Authorization", value = "{generateJWTToken}")
@RolesAllowed("Admin")
@Produces(MediaType.TEXT_PLAIN)
public String get();


⚠️ Common Errors

Error: Unable to access jarfile payara-micro-6.2025.4.jar
➝ Ensure payara-micro.jar is in project root.

401 Unauthorized
➝ Re-run java -jar jwtenizr.jar to regenerate JWT token and update microprofile-config.properties.

META-INF Not Found
➝ Ensure exact name: META-INF/microprofile-config.properties.

✅ Summary

Start Payara Micro.
Generate Jakarta EE projects.
Configure MicroProfile.
Generate JWT using jwtenizr.jar.
Add token to ClientApp.
Secure APIs with @RolesAllowed.
Deploy Client & Server apps.