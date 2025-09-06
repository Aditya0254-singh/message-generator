import React, { useState } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [name, setName] = useState("");      
  const [message, setMessage] = useState(""); 
  const [loading, setLoading] = useState(false); 

  const generateMessage = async () => {
    if (!name.trim()) {
      setMessage("Please enter a name or prompt.");
      return;
    }

    setLoading(true);
    setMessage("");

    try {
      const response = await axios.post("http://localhost:8080/api/messages/generate", {
        prompt: name
      });
      setMessage(response.data.message); 
    } catch (error) {
      console.error("Error generating message:", error);
      setMessage("Something went wrong. Please try again.");
    } finally {
      setLoading(false);
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
      <button onClick={generateMessage} disabled={loading}>
        {loading ? "Generating..." : "Generate"}
      </button>
      <p style={{ marginTop: "20px", fontWeight: "bold" }}>{message}</p>
    </div>
  );
}

export default App;


