🚀 Multi-Threaded Proxy Server & Client

A multithreaded HTTP Proxy Server implemented using Java ThreadPoolExecutor, with a client that sends URL requests, receives fetched HTML content, and saves it locally.
A Multi-Client Launcher enables parallel execution of multiple clients to simulate concurrent load.

🧩 Features
✔ Multi-Threaded Proxy Server

Uses ThreadPoolExecutor to efficiently handle multiple requests.

Spawns a separate thread for each incoming client connection.

Fetches remote webpage contents using Java’s URL.openStream().

Serves multiple clients concurrently.

✔ Proxy Client

Connects to proxy server via TCP socket.

Sends URL to fetch.

Receives HTML response from server.

Saves output as a unique HTML file inside /downloads.

✔ Multi-Client Launcher

Automatically spawns any number of clients (10, 20, 100…).

Perfect for stress-testing and demonstrating concurrency.

✔ Thread Pool Visualization

Real-time console logs show:
active threads, thread names, handling URL, etc.

🛠️ Technologies Used
Component	Technology
Programming Language	Java 17+
Concurrency Model	ThreadPoolExecutor
Networking	Java Sockets
File I/O	Java FileWriter
Architecture	Client–Server Model
📂 Project Structure
/proxy_server/
│
├── ProxyServer.java
├── ClientHandler.java
├── ProxyClient.java
├── MultiClientLauncher.java
│
└── /downloads/       # Stores saved HTML files

⚙️ How It Works
▶ 1. Run the Multi-Threaded Proxy Server
javac ProxyServer.java ClientHandler.java
java ProxyServer


Server Output Example:

Proxy Server running on port 8080...
Thread pool size: 20
pool-1-thread-3 handling request...
pool-1-thread-7 handling request...

▶ 2. Run the Client (single request)
javac ProxyClient.java
java ProxyClient


Client Output:

Saved file: example.com_1731572005123.html


HTML is saved in:

downloads/example.com_<timestamp>.html

▶ 3. Run Multiple Clients Automatically
javac MultiClientLauncher.java ProxyClient.java
java MultiClientLauncher


This will launch 20+ clients concurrently (configurable).

Example:

Launching 20 clients...
Client 1 saved file example.com_1731573005121.html
Client 2 saved file example.com_1731573005129.html
...

🧵 Thread Pool Overview

The server uses:

ExecutorService pool = Executors.newFixedThreadPool(20);


Meaning:

Max 20 threads working in parallel.

Extra requests wait in queue.

Efficient CPU usage.

Prevents creating unlimited threads.

Logged metrics:

Active threads

Thread name

Handling URL

Example:

[pool-1-thread-4] Handling URL: https://example.com

💾 HTML Saving Logic

Each downloaded file uses a unique name:

example.com_<timestamp>.html


This avoids overwriting when many clients request the same URL.

🔬 Testing Scenarios
✔ Stress test with 100 clients

Change in MultiClientLauncher.java:

int clientCount = 100;

✔ Test thread pool saturation

Set pool size to small number:

private static final int THREAD_POOL_SIZE = 5;


Watch how tasks queue up!

✔ Validate HTML saved correctly

Open /downloads folder and inspect all generated .html files.
