import React, { useState } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [name, setName] = useState("");
  const [message, setMessage] = useState("");

  const generateMessage = async () => {
    try {
      const response = await axios.post(
        "https://message-generator-backend-ge65.onrender.com/api/messages/generate",
        { prompt: name }
      );
      setMessage(response.data.message);
    } catch (error) {
      console.error("Error generating message:", error);
      setMessage("Something went wrong. Please try again.");
    }
  };

  return (
    <div className="App">
      <h1>Message Generator</h1>
      <input
        type="text"
        placeholder="Enter your name"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <button onClick={generateMessage}>Generate</button>
      <p>{message}</p>
    </div>
  );
}

export default App;




