import React from "react";
import { Col, Container, Row } from "react-bootstrap";
import PromotionImage from "../../assets/Food_Assets/assets/promotion/pro.png";

function Section4() {
  return (
    <>
      <section id="blog_section" className="promotion_section">
        <Container>
          <Row>
            <Col lg={6} className="text-center mb-5 mb-lg-0">
              <img src={PromotionImage} alt="Promotion" className="img-fluid" />
            </Col>
            <Col lg={6} className="px-5">
              <h2>Nothing brings people together like a good burger</h2>
              <p>
                Our burgers are more than just food – they’re an experience.
                Made with the freshest ingredients and grilled to perfection.
                Whether it’s a casual hangout or a special treat, we’ve got you.
                One bite, and you’ll know why everyone’s talking about us.
              </p>
              <ul>
                <li>
                  <p>
                  Juicy handcrafted patties made fresh every single day
                  </p>
                </li>
                <li>
                  <p>Toasted buns with customizable toppings of your choice</p>
                </li>
                <li>
                  <p>
                  Delivered hot and fresh right to your doorstep
                  </p>
                </li>
              </ul>
            </Col>
          </Row>
        </Container>
      </section>

      {/* BG Parallax Scroll */}
      <section className="bg_parallax_scroll"></section>
    </>
  );
}

export default Section4;
