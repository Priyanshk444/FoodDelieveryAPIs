import React from "react";
import { Container, Row, Col } from "react-bootstrap";
import { Link } from "react-router-dom";

function Section7() {
  return (
    <section id="contact_section" className="contact_section">
      <Container>
        <Row className="justify-content-center">
          <Col sm={8} className="text-center">
            <h4>We Guarantee</h4>
            <h2>30 Minutes Delivery!</h2>
            <p>
              Craving something delicious? Get your favorite burgers delivered
              piping hot and lightning fast! Experience our super quick delivery
              service — satisfaction at your doorstep in no time!
            </p>
            <Link to="/" className="btn btn_red px-4 py-2 rounded-0">
              Call: 999-888-7777
            </Link>
          </Col>
        </Row>
      </Container>
    </section>
  );
}

export default Section7;
