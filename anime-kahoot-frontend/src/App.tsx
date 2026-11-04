import { useState } from "react";
import Login from "./components/Login";
import Register from "./components/Register";
import "./App.css";

function App() {
  const [mode, setMode] = useState<"login" | "register">("login");

  return (
    <div style={{ maxWidth: 400, margin: "40px auto" }}>
      <div style={{ display: "flex", gap: 8, marginBottom: 16 }}>
        <button type="button" onClick={() => setMode("login")}>
          Login
        </button>
        <button type="button" onClick={() => setMode("register")}>
          Register
        </button>
      </div>

      {mode === "login" ? <Login /> : <Register />}
    </div>
  );
}

export default App;