MultiThreaded Web Server

A simple multi-threaded web server in Java that handles multiple client requests concurrently using a thread pool. The server reads data from a file (test.txt) and sends it to the client upon request.

Features

Handles multiple clients simultaneously using a thread pool.

Reads content from test.txt and sends it to the client.

Uses Java's ExecutorService for efficient thread management.

Closes client sockets properly to prevent resource leaks.

Requirements

Java 8 or later

Apache JMeter (for performance testing)

How It Works

The server listens on port 8010.

When a client connects, a new thread from the pool processes the request.

The server reads test.txt and sends its content to the client.

The connection is closed after sending the response.

Setup & Run

1. Clone the Repository

git clone <your-repo-link>
cd multithreaded-web-server

2. Compile & Run

javac MultiThreaded/Server.java
java MultiThreaded.Server

Performance Testing with JMeter

Open JMeter and create a new test plan.

Add a TCP Sampler.

Server Name: localhost

Port: 8010

Add a Summary Report Listener.

Start the test and monitor response times & throughput.

Future Improvements

Support HTTP requests instead of raw TCP.

Implement request logging for better monitoring.

Add more configurable options (port, file path, etc.).

License

This project is open-source and free to use.

Feel free to contribute or report issues!

