## MultiThreaded Web Server

A simple multi-threaded web server in Java that handles multiple client requests concurrently using a thread pool. The server reads data from a file (test.txt) and sends it to the client upon request.

## Features

* Handles multiple clients simultaneously using a thread pool.
* Reads content from test.txt and sends it to the client.
* Uses Java's ExecutorService for efficient thread management.

## Requirements

* Java 8 or later
* Apache JMeter (for performance testing)

## How It Works

* The server listens on port 8010.
* When a client connects, a new thread from the pool processes the request.
* The server reads test.txt and sends its content to the client.

## Setup & Run

* Clone the Repository
```
git clone (https://github.com/v4vraj/multithreaded-webserver.git)
cd multithreaded-web-server
```

* Compile & Run

```
javac MultiThreaded/Server.java
java MultiThreaded.Server
```

## Performance Testing with JMeter

* Open JMeter and create a new test plan.
* Add a TCP Sampler with the following details:

Server Name: localhost
Port: 8010

* Add a Summary Report Listener.
* Start the test and monitor response times & throughput.
