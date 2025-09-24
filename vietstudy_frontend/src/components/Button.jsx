import React from "react";
import "../styles/App.css";

const Button = ({ text, variant = "primary", onClick }) => {
  return (
    <button
      onClick={onClick}
      className={variant === "primary" ? "btn btn-primary" : "btn btn-secondary"}
    >
      {text}
    </button>
  );
};

export default Button;
