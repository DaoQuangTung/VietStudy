import React from "react";
import "../styles/Header.css";

const Header = () => {
  return (
    <header className="header">
      <div className="header-left">
        <img src="/logo.png" alt="logo" className="logo" />
        <span className="brand">VietStudy</span>
      </div>
      <div className="header-right">
        NGÔN NGỮ HIỂN THỊ: <span className="lang">TIẾNG VIỆT ▼</span>
      </div>
    </header>
  );
};

export default Header;
