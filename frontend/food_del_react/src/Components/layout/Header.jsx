import React, { useState,useEffect } from "react";
import { Container, Nav, Navbar } from "react-bootstrap";
import "../../Styles/HeaderStyle.css";
import { Link } from "react-router-dom";
import Logo from "../../assets/Food_Assets/assets/logo/logo.png";
import { toast } from "react-toastify";
import axios from "axios";

function Header() {
  const [nav, setNav] = useState(false);
  const [cartItemCount,setCartItemCount] = useState(0);
  const token = localStorage.getItem("token");
  const isLoggedIn = !!token;

  useEffect(() => {
    fetchCartItems();
  }, []);

  const fetchCartItems = async () => {
    try {
      const response = await axios.get("http://localhost:8080/cart", {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      console.log(response);
      
       setCartItemCount(response.data.length);
    } catch (err) {
      console.error("Failed to fetch cart items", err);
    }
  };

  const changeValueOnScroll = () => {
    const scrollValue = document?.documentElement?.scrollTop;
    scrollValue > 100 ? setNav(true) : setNav(false);
  };

  window.addEventListener("scroll", changeValueOnScroll);

  const ScrollToSection = (id) => {
    const section = document.getElementById(id);
    if (section) {
      section.scrollIntoView({ behavior: "smooth" });
    }
  };

  return (
    <header>
      <Navbar
        collapseOnSelect
        expand="lg"
        className={`${nav === true ? "sticky" : ""}`}
      >
        <Container>
          <Navbar.Brand href="#home">
            <Link>
              <img src={Logo} alt="Logo" className="logo-img" />
            </Link>
          </Navbar.Brand>
          <Navbar.Toggle aria-controls="responsive-navbar-nav" />
          <Navbar.Collapse id="responsive-navbar-nav">
            <Nav className="ms-auto">
              <Nav.Link
                as={Link}
                // to={"/"}
                onClick={() => ScrollToSection("home_section")}
              >
                Home
              </Nav.Link>
              <Nav.Link
                as={Link}
                // to={"/about"}
                onClick={() => ScrollToSection("about_section")}
              >
                About
              </Nav.Link>
              <Nav.Link
                as={Link}
                // to={"/menu"}
                onClick={() => ScrollToSection("menu_section")}
              >
                Our Menu
              </Nav.Link>
              <Nav.Link
                as={Link}
                // to={"/shop"}
                onClick={() => ScrollToSection("shop_section")}
              >
                Shop
              </Nav.Link>
              <Nav.Link
                as={Link}
                // to={"/blog"}
                onClick={() => ScrollToSection("blog_section")}
              >
                Blog
              </Nav.Link>
              <Nav.Link
                as={Link}
                // to={"/contact"}
                onClick={() => ScrollToSection("contact_section")}
              >
                Contact
              </Nav.Link>

              {!isLoggedIn ? (
                <>
                  <Nav.Link as={Link} to="/login">
                    Login/SignUp
                  </Nav.Link>
                </>
              ) : (
                <Nav.Link
                  onClick={() => {
                    localStorage.removeItem("token");
                    window.location.reload();
                    toast.done("You are logged out! Log in again to satisfy your craving");
                  }}
                >
                  Logout
                </Nav.Link>
              )}

              <Nav.Link
                as={Link}
                to={isLoggedIn ? "/cart" : "/login"}
                onClick={(e) => {
                  if (!isLoggedIn) {
                    e.preventDefault();
                    toast.error("Please log in to access the cart");
                  }
                }}
              ></Nav.Link>

              <Nav.Link as={Link} to={"/cart"}>
                <div className="cart">
                  <i class="bi bi-bag fs-5"></i>
                  <em className="roundpoint">{cartItemCount}</em>
                </div>
              </Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </header>
  );
}

export default Header;
