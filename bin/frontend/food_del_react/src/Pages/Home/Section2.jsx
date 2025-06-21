import React from "react";
import { Col, Container, Row } from "react-bootstrap";
import { Link } from "react-router-dom";
import Pizza from "../../assets/Food_Assets/assets/about/pizza.png";
import Salad from "../../assets/Food_Assets/assets/about/salad.png";
import Delivery from "../../assets/Food_Assets/assets/about/delivery-bike.png";

// Mock Data Cards
const mockData = [
  {
    image: Pizza,
    title: "Original",
    paragraph: `At Quick Crave, we take pride in our originality, crafting unique flavors that set us apart.`,
  },
  {
    image: Salad,
    title: "Qualty Foods",
    paragraph: `Every bite is made with high-quality, fresh ingredients to ensure an unforgettable taste experience!`,
  },
  {
    image: Delivery,
    title: "Fastest Delivery",
    paragraph: `We ensure that your cravings are satisfied in no time with our fast and reliable delivery service without compromising on quality!`,
  },
  // Add more mock data objects as needed
];

function Section2() {

  const ScrollToMenuSection = () => {
    const section = document.getElementById("menu_section");
    if (section) {
      section.scrollIntoView({ behavior: "smooth" });
    }
  };


  return (
    <>
      <section id="about_section" className="about_section">
        <Container>
          <Row>
            <Col lg={{ span: 8, offset: 2 }} className="text-center">
              <h2>The Burger tastes better when you eat it with your family</h2>
              <p>
                At Quick Crave, we believe that great food should be fast,
                fresh, and absolutely delicious. Our passion for flavor drives
                us to serve mouthwatering burgers, crispy fries, and refreshing
                drinks—all made with the finest ingredients and served with a
                smile. Whether you're grabbing a quick bite on the go or
                indulging in a feast with friends and family, Quick Crave is
                your go-to spot for irresistible fast food that satisfies every
                craving. Come taste the difference, because when hunger strikes,
                we deliver the flavor—fast!
              </p>

              <Link onClick={ScrollToMenuSection} className="btn order_now btn_red">
                Explore Full Menu
              </Link>
            </Col>
          </Row>
        </Container>
      </section>

      <section className="about_wrapper">
        <Container>
          <Row className="justify-content-md-center">
            {mockData.map((cardData, index) => (
              <Col md={6} lg={4} className="mb-4 mb-md-0" key={index}>
                <div className="about_box text-center">
                  <div className="about_icon">
                    <img
                      src={cardData.image}
                      alt="icon"
                      className="img-fluid"
                    />
                    <div>
                      <h4>{cardData.title}</h4>
                      <p>{cardData.paragraph}</p>
                    </div>
                  </div>
                </div>
              </Col>
            ))}
          </Row>
        </Container>
      </section>
    </>
  );
}

export default Section2;
