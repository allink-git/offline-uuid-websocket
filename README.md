# offline-uuid-websocket
 A simple Java application for generating UUIDs of cracked minecraft players with the ability to grab them via websocket.

## Execution

```sh 
$ java -jar offline-uuid-websocket.jar (PORT, optional, default 6000) 
```

## Usage

Transmit the username of the player who's UUID you would like to retrieve, and the application will return the UUID.

## Example
```javascript
var user = "Notch"

const jar = await proc.spawn("java",["-jar","offline-uuid-websocket.jar"])

var connection = new websockets("ws://localhost:6000")

connection.onopen = () => {
  connection.send(user)
}

connection.onerror = (error) => {
 console.log(`WebSocket error: ${error}`)
}

connection.onmessage = (e) => {
 jar.kill();
 client.write("chat",{
  message:`UUID of ${user} is ${e.data}`
})
```
