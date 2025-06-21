import React, { useEffect, useState } from "react";
import { Col, Card } from "react-bootstrap";
import axios from "axios";
import { toast } from "react-toastify";

function Cards({ id, imageURL, title, price, paragraph }) {


  const [quantity, setQuantity] = useState(0);

  useEffect(() => {
    const fetchQuantity = async () => {
      const token = localStorage.getItem("token");
      try {
        const response = await axios.get("http://localhost:8080/cart", {
          headers: {
            Authorization: `Bearer ${token}`,
            "Content-Type": "application/json",
          },
        });

        const foundItem = response.data.find((item) => item.food.id == id);
        if (foundItem) {
          setQuantity(foundItem.quantity);  
        }
      } catch (error) {
        console.error(error);
      }
    };

    fetchQuantity();
  }, [id]);


  const handleAddToCart = async () => {
    const token = localStorage.getItem("token");
    try {
      const res = await axios.post(
        "http://localhost:8080/cart",
        { id },
        {
          headers: {
            Authorization: `Bearer ${token}`,
            "Content-Type": "application/json",
          },
        }
      );
      console.log("Added to cart:", res.data);
      toast.success("Item added to cart!");

      // await fetchQuantity();
      setQuantity((prev) => prev + 1); // Show counter after first addition
    } catch (err) {
      toast.error("Error adding to cart");
      console.error(err);
    }
  };

  const handleDecrementFromCart = async () => {
    const token = localStorage.getItem("token");
    try {
      const response = await axios.delete(
        `http://localhost:8080/cart/item/decrement/${id}`,
        {
          headers: {
            Authorization: `Bearer ${token}`,
            "Content-Type": "application/json",
          },
        }
      );
      console.log("Item removed from cart");
      toast.success("Item removed from cart!");

      // await fetchQuantity();
      setQuantity((prev) => prev - 1);
    } catch (err) {
      toast.error("Error removing from cart");
      console.error(err);
    }
  };

  const increment = () => {
    handleAddToCart();
  };

  const decrement = () => {
    handleDecrementFromCart();
  };

  return (
    <Col sm={6} lg={4} xl={3} className="mb-4">
      <Card className="overflow-hidden">
        <div className="overflow-hidden">
          <Card.Img variant="top" src={imageURL} alt={title} />
        </div>
        <Card.Body>
          <div className="d-flex align-items-center justify-content-between">
            <div className="wishlist">
              <i className="bi bi-heart"></i>
            </div>
          </div>

          <Card.Title>{title}</Card.Title>
          <Card.Text>{paragraph}</Card.Text>

          <div className="d-flex align-items-center justify-content-between">
            <div className="menu_price">
              <h5 className="mb-0">${price}</h5>
            </div>
            <div className="add_to_card">
              {quantity === 0 ? (
                <button
                  className="btn btn-danger btn-sm"
                  onClick={handleAddToCart}
                >
                  <i className="bi bi-bag me-2"></i>
                  Add To Cart
                </button>
              ) : (
                <div className="d-flex align-items-center">
                  <button
                    className="btn btn-outline-secondary btn-sm"
                    onClick={decrement}
                  >
                    −
                  </button>
                  <span className="mx-2">{quantity}</span>
                  <button
                    className="btn btn-outline-secondary btn-sm"
                    onClick={increment}
                  >
                    +
                  </button>
                </div>
              )}
            </div>
          </div>
        </Card.Body>
      </Card>
    </Col>
  );
}

export default Cards;
