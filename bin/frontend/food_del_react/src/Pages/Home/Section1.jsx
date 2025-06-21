import React from "react";
import { Col, Container, Row } from "react-bootstrap";
import Burger from "../../assets/Food_Assets/assets/hero/hero-2.png";
import { Link } from "react-router-dom";

function Section1() {
  const ScrollToMenuSection = () => {
    const section = document.getElementById('menu_section');
    if (section) {
      section.scrollIntoView({ behavior: "smooth" });
    }
  };


  return (
    <section id="home_section" className="hero_section">
      <Container>
        <Row>
          <Col lg={7} className="mb-5 mb-lg-0">
            <div className="position-relative">
              <img src={Burger} className="img-fluid" alt="Hero" />
              <div className="price_badge">
                <div className="badge_text">
                  <h4 className="h4_xs">Only</h4>
                  <h4 className="h3_lg">$6.99</h4>
                </div>
              </div>
            </div>
          </Col>
          <Col lg={5}>
            <div className="hero_text text_center text-align">
              <h1 className="text-white text_center">Cheese Burger</h1>
              <h2 className="text-white text_center">With Onions</h2>
              <p className="text-white pt-2 pb-4">
                Sink your teeth into our juicy Double Patty Burger, stacked high
                with succulent beef patties, crispy onions, fresh tomatoes, and
                a melted slice of cheese that oozes with every bite.
              </p>
              <Link onClick={ScrollToMenuSection} className="btn order_now">
                Order Now
              </Link>
            </div>
          </Col>
        </Row>
      </Container>
    </section>
  );
}

export default Section1