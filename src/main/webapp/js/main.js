let ws;

// Create a new room and enter it
function newRoom() {
  // Calling the ChatServlet to retrieve a new room ID
  const callURL = "http://localhost:8080/WSChatServer-1.0-SNAPSHOT/chat-servlet";
  fetch(callURL, {
    method: 'GET',
    headers: {
      'Accept': 'text/plain',
    },
  })
  .then(response => response.text())
  .then(response => enterRoom(response)); // Enter the room with the code
}

// Enter an existing room
function enterRoom(code) {
  // Refresh the list of rooms

  // Create the web socket
  ws = new WebSocket(`ws://localhost:8080/WSChatServer-1.0-SNAPSHOT/ws/${code}`);

  // Parse messages received from the server and update the UI accordingly
  ws.onmessage = function(event) {
    console.log(event.data);
    // Parsing the server's message as JSON
    let message = JSON.parse(event.data);

    // Handle message
  }
}