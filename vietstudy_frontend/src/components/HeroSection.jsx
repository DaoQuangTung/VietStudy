import React from "react";
import Button from "./Button";
import "../styles/HeroSection.css";

const HeroSection = () => {
  return (
    <main className="hero">
      <div className="hero-left">
        <img src="/hero.png" alt="illustration" className="hero-img" />
      </div>
      <div className="hero-right">
        <h1 className="hero-title">
          Học ngoại ngữ miễn phí, vui nhộn <br /> và hiệu quả!
        </h1>
        <div className="hero-buttons">
          <Button text="BẮT ĐẦU" variant="primary" />
          <Button text="TÔI ĐÃ CÓ TÀI KHOẢN" variant="secondary" />
        </div>
      </div>
    </main>
  );
};

export default HeroSection;
