import React, { useEffect, useState } from "react";
import axios from "axios";
import "../Styles/Cart.css";
import { Button, Container, Row, Col, Image, Table } from "react-bootstrap";
import { motion } from "framer-motion";

function Cart() {
  const [cartItems, setCartItems] = useState([]);
  const [subtotal, setSubtotal] = useState(0);
  const [tax, setTax] = useState(0);
  const [total, setTotal] = useState(0);

  const token = localStorage.getItem("token");

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
      const items = response.data;
      setCartItems(items);

      const sub = items.reduce((acc, item) => acc + (item.quantity * item.food.price), 0);
      setSubtotal(sub);
      const calculatedTax = parseFloat((sub * 0.18).toFixed(2));
      setTax(calculatedTax);
      setTotal(sub + calculatedTax);
    } catch (err) {
      console.error("Failed to fetch cart items", err);
    }
  };

  const handleRemoveItem = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/cart/item/delete/${id}`, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      fetchCartItems(); // refresh after deletion
    } catch (err) {
      console.error("Error deleting item", err);
    }
  };

  const handleClearCart = async () => {
    try {
      await axios.delete("http://localhost:8080/cart", {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      fetchCartItems(); // Refresh cart after clearing
    } catch (err) {
      console.error("Error clearing cart", err);
    }
  };

  return (
    <motion.div
      className="cart-page"
      initial={{ opacity: 0, y: 40 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ duration: 0.5 }}
    >
      <Container className="py-5">
        <h2 className="mb-4 text-center">🛒 Your Cart</h2>
        <Row className="justify-content-center">
          <Col md={8}>
            <Table responsive className="cart-table">
              <thead>
                <tr>
                  <th>Product</th>
                  <th>Qty</th>
                  <th>Subtotal</th>
                </tr>
              </thead>
              <tbody>
                {cartItems.map((item) => (
                  <motion.tr
                    key={item.cartItemId}
                    initial={{ opacity: 0, x: -20 }}
                    animate={{ opacity: 1, x: 0 }}
                    transition={{ duration: 0.3 }}
                  >
                    <td className="d-flex align-items-center">
                      <Image
                        src={item.food.imagePath}
                        alt={item.food.name}
                        width={80}
                        height={80}
                        className="me-3 rounded"
                      />
                      <div>
                        <strong>{item.food.name}</strong>
                        <br />
                        Price: ${item.food.price}
                        <br />
                        <span
                          className="remove-btn text-danger"
                          style={{ cursor: "pointer", fontSize: "0.9rem" }}
                          onClick={() => handleRemoveItem(item.cartId)}
                        >
                          <i className="bi bi-trash3-fill me-2"> </i>
                           Remove
                        </span>
                      </div>
                    </td>
                    <td>{item.quantity}</td>
                    <td>${(item.quantity * item.food.price).toFixed(2)}</td>
                  </motion.tr>
                ))}
              </tbody>
            </Table>
            {cartItems.length > 0 && (
              <div className="d-flex justify-content-end mt-3">
                <motion.div
                  initial={{ opacity: 0 }}
                  animate={{ opacity: 1 }}
                  transition={{ delay: 0.2 }}
                  className="d-flex justify-content-end mt-3"
                >
                  <Button
                    variant="outline-danger"
                    className="rounded-pill px-4"
                    onClick={handleClearCart}
                  >
                    <i className="bi bi-trash3-fill me-2"></i>
                    Clear Cart
                  </Button>
                </motion.div>
              </div>
            )}
          </Col>
          <Col md={4}>
            <motion.div
              className="summary-card p-4 rounded shadow-sm"
              initial={{ opacity: 0, x: 30 }}
              animate={{ opacity: 1, x: 0 }}
              transition={{ duration: 0.5 }}
              style={{
                backgroundColor: "#fff",
                borderRadius: "20px",
                border: "1px solid #eee",
              }}
            >
              <h5 className="mb-3 text-center">Cart Summary</h5>
              <div className="d-flex justify-content-between mb-2">
                <span>Subtotal</span>
                <strong>${subtotal.toFixed(2)}</strong>
              </div>
              <div className="d-flex justify-content-between mb-2">
                <span>Tax (18%)</span>
                <strong>${tax.toFixed(2)}</strong>
              </div>
              <div className="d-flex justify-content-between mb-3 border-top pt-2">
                <span>Total</span>
                <strong>${total.toFixed(2)}</strong>
              </div>
              <Button
                className="w-100"
                style={{
                  backgroundColor: "#ff4d4f",
                  border: "none",
                  borderRadius: "25px",
                  fontWeight: "bold",
                  fontSize: "1rem",
                }}
              >
                <i className="bi bi-credit-card me-2"></i>
                Proceed to Checkout
              </Button>
            </motion.div>
          </Col>
        </Row>
      </Container>
    </motion.div>
  );
}

export default Cart;
