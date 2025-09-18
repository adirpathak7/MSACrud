<img width="834" height="472" alt="image" src="https://github.com/user-attachments/assets/42ed66ac-7c64-4958-b429-ccaa1d1d40e7" />MSA Application with JWT & Payara Micro

This project demonstrates a Microservices-based Application (MSA) using:
•	🟦 Jakarta EE 9
•	🟩 Payara Micro
•	🔐 JWT Authentication
•	⚙️ MicroProfile Config
It consists of two main modules:
•	ClientApp: Consumer microservice
•	ServerApp: Resource provider microservice

📁 Project Structure

<img width="834" height="472" alt="image" src="https://github.com/user-attachments/assets/991a66dd-3e90-4e5e-b820-a8b68a42cd4b" />


Setup & Run
1️⃣ Start Payara Server
Make sure payara.jar is in your project root.
Run:

 <img width="940" height="75" alt="image" src="https://github.com/user-attachments/assets/fade79ed-a4f7-45e1-b737-c8cd5c61e30e" />


2️⃣ Configure MicroProfile
Inside both ClientApp and ServerApp, create:

 <img width="940" height="60" alt="image" src="https://github.com/user-attachments/assets/b00af4ee-2606-4c85-93a4-0fa31fe84b90" />

Example for ClientApp:
 
<img width="940" height="96" alt="image" src="https://github.com/user-attachments/assets/e076393b-834b-49ff-b880-cefae0858ecc" />

Example for ServerApp:
 
<img width="766" height="109" alt="image" src="https://github.com/user-attachments/assets/bc00337d-ce17-4b10-80a7-3ec5fdee85c1" />


3️⃣ Generate JWT Token 🔑
Make sure jwtenizr.jar is in the root folder, then run:

 

This will generate:
•	jwt-token.json
•	jwtenizr-config.json
•	microprofile-config.properties
•	token.jwt
Copy the token (without Bearer) into ClientApp/microprofile-config.properties.


4️⃣ Example JWT Configuration

Public Key (ServerApp):

 <img width="940" height="78" alt="image" src="https://github.com/user-attachments/assets/156eb0a8-4733-418e-8031-46c1f8836e58" />

Example jwt-token.json:
 

<img width="572" height="331" alt="image" src="https://github.com/user-attachments/assets/7c1b6a7d-01ef-4509-9116-02e965169359" />



5️⃣ Client JWT Injection
In ServiceInterface.java (inside com.it.clientapp.doctor):

 <img width="940" height="179" alt="image" src="https://github.com/user-attachments/assets/b853b4a9-a63b-4895-8cba-6233158ad77c" />

Secure your API with:

 <img width="940" height="192" alt="image" src="https://github.com/user-attachments/assets/c1e68b24-fac4-4e67-a28e-6504e6f95b58" />


 Common Errors & Fixes

<img width="765" height="289" alt="image" src="https://github.com/user-attachments/assets/fd3c799d-c428-4912-942a-62a2192766b2" />


 Step-by-Step MSA Development Guide
1.	Start Payara server
2.	Use Maven archetype → Create Jakarta EE 9 projects
3.	Define project name and Docker Hub name (optional)
4.	Create another project for the client
5.	Replace javax with jakarta in both apps
6.	Create META-INF under src/main/resources
7.	Add microprofile-config.properties in both apps
8.	In ClientApp:
 
<img width="940" height="60" alt="image" src="https://github.com/user-attachments/assets/f314c754-e52b-41f4-9e55-d473b8e34f41" />


9.  In ServerApp → Create persistence.xml in META-INF
10. Configure DB connection (name, password, useSSL=false)
11. Create entity classes
12. Create EJBs
13. Build REST APIs (inject EJBs into endpoints)
14. Generate JWT using jwt.jar
15. Secure APIs using @RolesAllowed("users")
16. In ServerApp main class:

<img width="656" height="127" alt="image" src="https://github.com/user-attachments/assets/e899b753-74a6-4e49-8635-d4b670f3b7da" />

17.	Add JWT config to ServerApp:

 <img width="553" height="106" alt="image" src="https://github.com/user-attachments/assets/135594ca-2d90-4bc7-b261-27f19d6fd3d0" />

18.  Add JWT token to ClientApp
19.  In ClientApp:
•	Create DTO/entity class (getters/setters only)
•	Create an interface to define ServerApp APIs
•	In the interface, add a method to fetch JWT
20.  Inject the interface into servlets
21.  Build and deploy both apps:

 <img width="940" height="124" alt="image" src="https://github.com/user-attachments/assets/49c634a5-3003-43d5-aac5-8724630662fc" />

URLs

Application	URL
ServerApp	http://localhost:8085/ServerApp/rest/example
ClientApp	http://localhost:8086/ClientApp/ExampleServlet





