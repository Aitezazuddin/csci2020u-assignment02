# Project Information:
The Chat Server Room is a web application that enables real-time communication among multiple users who join a chat room. The application was created as a programming assignment to demonstrate the use of Java Servlets, WebSockets, and JavaScript technologies. The application has the following features:

- Users can join an existing chat room by entering its code or create a new chat room by clicking a button.
- Users can enter their username and send messages to the chat room. The messages are displayed in chronological order with the sender's name and timestamp.
- Users can see the number of users in the chat room and the list of chat rooms available on the server.
- Users can leave the chat room by closing the browser tab or window. The application will notify other users in the room that someone has left.
- Users can view the chat history of the room by scrolling up or down. The application will load more messages from the server as needed.

The application uses Java Servlets to handle HTTP requests and responses on the server side. The servlets are responsible for generating unique codes for chat rooms, storing and retrieving messages from a database, and sending messages to WebSockets. The application uses WebSockets to establish a bidirectional communication channel between the server and the client. The WebSockets allow the server to push messages to the client without waiting for a request. The application uses JavaScript to manipulate the Document Object Model (DOM) and update the user interface on the client side. The JavaScript also handles the WebSocket events and sends user input to the server.

## Group Members:
Mohammed Aitezazuddin Ahmed

## Screenshots:





## Improvements

We made some enhancements to the original chat server application to improve the user experience and the functionality of the chat rooms. The following features were added:

- A user can create a new chat room or join an existing one by entering the room ID. This allows users to have more control over their chat rooms and to invite other users to join them. The application generates a unique ID for each chat room and displays it on the user interface.
- A chat history is displayed when a user joins a chat room. This allows users to see the previous messages that were sent in the chat room and to catch up with the conversation. The application retrieves the messages from the database and shows them in chronological order.
- Users are notified when a new user joins or leaves the chat room. This allows users to know who is in the chat room and when someone enters or exits. The application sends a message to all users in the chat room with the name of the user who joined or left.
- Users can see which messages were sent by them and which were sent by other users. This allows users to distinguish their own messages from others and to identify the sender of each message. The application shows the username of each message sender and highlights the messages that were sent by the current user.
- Added functionality to clear chat history. This allows users to delete all messages in the chat room and start a new conversation. The application removes all messages from the database and clears the user interface.

## How to Run

The Chat Server Room application is a web-based application that runs on a local server and uses web sockets to communicate with the clients. To run the application, you need to have Java installed on your machine and an IDE that supports Java Servlets and WebSockets. The following steps will guide you through the process of running the application:

- Clone the repository to your local machine. You can use the command `git clone https://github.com/Aitezazuddin/csci2020u-assignment02` or download the zip file from the GitHub page.
- Open the project in an IDE of your choice (e.g. IntelliJ, Eclipse, etc.). You may need to import the project as a Maven project and configure the dependencies and settings accordingly.
- Build and run the application. You can use the IDE's built-in tools to build and run the application or use the command `mvn clean install` and `mvn tomcat7:run` in the terminal. The application will start on port 8080 by default.
- Open a web browser and navigate to http://localhost:8080/chat-room.html. This is the main page of the application where you can join or create a chat room.
- Enter a chat room ID to join or create a new chat room. If the chat room ID already exists, you will join that chat room. If not, you will create a new chat room with that ID. You can also click on the "Create and join new room" button to generate a random ID and join a new chat room.
- Start sending messages and chatting with other users! You can enter your username and type your message in the input fields at the bottom of the page. You can also see the chat history, the number of users, and the list of chat rooms on the page. You can leave the chat room by closing the browser tab or window.

## Other Resources

The following libraries were used in the implementation of this project:

- Apache Tomcat: Apache Tomcat is an open source web server and servlet container that provides a Java environment for running web applications. It supports the Java Servlet and WebSocket specifications and provides various features and tools for web development. We used Apache Tomcat as the server for our chat application and deployed our servlets and web sockets on it. For more information, visit https://tomcat.apache.org/.
- Jakarta Servlet API: Jakarta Servlet API is a Java specification that defines how web servers handle requests and responses from clients. It provides a set of interfaces and classes for creating servlets, which are Java classes that process HTTP requests and generate dynamic content. We used Jakarta Servlet API to create our ChatServlet class, which handles the HTTP requests for creating and joining chat rooms. For more information, visit https://jakarta.ee/specifications/servlet/.
- Jakarta WebSocket API: Jakarta WebSocket API is a Java specification that defines how web servers and clients communicate using web sockets, which are bidirectional communication channels that allow data to be exchanged in real-time. It provides a set of interfaces and classes for creating web socket endpoints, which are Java classes that handle the web socket messages and events. We used Jakarta WebSocket API to create our ChatEndpoint class, which handles the web socket messages for sending and receiving chat messages. For more information, visit https://jakarta.ee/specifications/websocket/.
- jQuery: jQuery is a JavaScript library that simplifies the manipulation of the Document Object Model (DOM), the event handling, the Ajax requests, and the animation effects on the web pages. It provides a cross-browser compatible and easy-to-use syntax for accessing and modifying the elements on the web pages. We used jQuery to update the user interface of our chat application and to send Ajax requests to our servlets. For more information, visit https://jquery.com/.
- Bootstrap: Bootstrap is a CSS framework that provides a collection of styles and components for creating responsive and mobile-friendly web pages. It offers various features such as grids, buttons, forms, icons, modals, alerts, and more. We used Bootstrap to style our chat application and to make it look consistent and attractive. For more information, visit https://getbootstrap.com/.