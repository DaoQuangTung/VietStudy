import React from "react";
import Header from "../components/Header";
import HeroSection from "../components/HeroSection";
import LanguageSelector from "../components/LanguageSelector";

const HomePage = () => {
  return (
    <div>
      <Header />
      <HeroSection />
      <LanguageSelector />
    </div>
  );
};

export default HomePage;
