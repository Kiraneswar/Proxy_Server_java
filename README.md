# 🖥️ Multi-Threaded Proxy Server & Client

A multi-threaded HTTP proxy server built using Java’s ThreadPoolExecutor.  
The client sends URL requests, receives HTML content from the server, and saves each response as a uniquely named HTML file.  
A MultiClientLauncher is provided to simulate multiple parallel clients for concurrency testing.

---

## 📌 Project Overview

This project demonstrates key Operating Systems concepts:

- Multi-threading  
- Thread pooling  
- Client–Server architecture  
- Socket communication  
- Concurrent execution of multiple tasks  

The proxy server handles many simultaneous URL requests using a fixed-size ThreadPoolExecutor.

---

## ⚙️ Features

- Multi-threaded Proxy Server  
- Thread Pool using Executors.newFixedThreadPool()  
- Concurrent handling of multiple clients  
- Automatic saving of fetched HTML content  
- Stress-testing using MultiClientLauncher  
- Unique file generation using timestamps  

---

## 📁 Project Structure

```
/proxy_server/
│
├── ProxyServer.java
├── ClientHandler.java
├── ProxyClient.java
├── MultiClientLauncher.java
│
└── /downloads/
```

---

## ▶️ Running the Project

### 1. Compile All Java Files

```
javac ProxyServer.java ClientHandler.java ProxyClient.java MultiClientLauncher.java
```

### 2. Start the Proxy Server

```
java ProxyServer
```

### 3. Run a Single Client

```
java ProxyClient
```

### 4. Run Multiple Clients

```
java MultiClientLauncher
```

All received HTML pages will be saved inside:

```
downloads/<unique_filename>.html
```

---

## 🔧 Technologies Used

- Java 17+  
- ThreadPoolExecutor  
- Java Sockets  
- FileWriter  
- TCP Networking  

---

## 🧵 How It Works (Summary)

1. Client connects to server  
2. Sends a URL  
3. Server fetches data from remote website  
4. Server streams HTML back to client  
5. Client saves output in `/downloads` with a timestamp  

---

## 🏆 Team & Credits

Developed as part of the **Operating Systems Course Project**  
for **B.Tech – 5th Semester**.

Contributors:  
- *Your Name Here*  
- *Your Teammates (if any)*  

Faculty / Course:  
Department of Computer Science & Engineering  
Operating Systems Laboratory

---
