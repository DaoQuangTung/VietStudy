import React from "react";
import "../styles/LanguageSelector.css";

const LanguageSelector = () => {
  return (
    <footer className="footer">
      <div className="lang-option">
        <img src="/usa_flag.jpg" alt="us flag" className="flag" />
        <span>TIẾNG ANH</span>
      </div>
      <div className="lang-option">
        <img src="/japan_flag.jpg" alt="china flag" className="flag" />
        <span>TIẾNG NHẬT</span>
      </div>
    </footer>
  );
};

export default LanguageSelector;
