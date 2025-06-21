const menuItems = [
    {
      id: null,
      name: "Classic Cheeseburger",
      description: "A juicy Beef Patty with melted cheddar,lettuce ,tomato and a hint of onion and pickle",
      imagePath: "/images/burgers/cheese_burger.png",
      price: 0.99,
      category: "Burgers",
      addOns: [
        { name: "Extra cheese", price: 0.99 },
        { name: "Bacon", price: 1.99 },
        { name: "Extra cheese", price: 0.99 }
      ]
    },
    {
      id: null,
      name: "Aloha Burger",
      description: "A tropical delight with grilled pineapple, teriyaki sauce, and juicy beef patty.",
      imagePath: "/images/burgers/Aloha_burger.png",
      price: 5.99,
      category: "Burgers",
      addOns: [
        { name: "Extra pineapple", price: 0.99 },
        { name: "Bacon", price: 1.99 }
      ]
    },
    {
      id: null,
      name: "BBQ Burger",
      description: "Smoky BBQ sauce, crispy onion rings, and a juicy patty.",
      imagePath: "/images/burgers/BBQ_burger.png",
      price: 6.99,
      category: "Burgers",
      addOns: [
        { name: "Extra BBQ sauce", price: 0.49 },
        { name: "Cheddar cheese", price: 0.99 }
      ]
    },
    {
      id: null,
      name: "Blue Moon Burger",
      description: "A gourmet burger topped with blue cheese and caramelized onions.",
      imagePath: "/images/burgers/Blue-Moon-min.png",
      price: 7.49,
      category: "Burgers",
      addOns: [
        { name: "Extra blue cheese", price: 1.29 },
        { name: "Grilled mushrooms", price: 0.99 }
      ]
    },
    {
      id: null,
      name: "Veg Burger",
      description: "A wholesome vegetarian patty with fresh veggies and a hint of spice.",
      imagePath: "/images/burgers/veg-burger.png",
      price: 4.99,
      category: "Burgers",
      addOns: [
        { name: "Avocado", price: 1.49 },
        { name: "Extra lettuce", price: 0.49 }
      ]
    },
    {
      id: null,
      name: "Apple Pie",
      description: "Classic apple pie with a flaky crust and cinnamon-spiced apples.",
      imagePath: "/images/desserts/apple-pie.png",
      price: 3.49,
      category: "Desserts",
      addOns: []
    },
    {
      id: null,
      name: "Cheesecake",
      description: "Rich and creamy cheesecake with a graham cracker crust.",
      imagePath: "/images/desserts/cheesecake.png",
      price: 4.99,
      category: "Desserts",
      addOns: [
        { name: "Strawberry topping", price: 0.99 }
      ]
    },
    {
      id: null,
      name: "Chocolate Brownie",
      description: "Dense, fudgy brownie with a gooey chocolate center.",
      imagePath: "/images/desserts/chocolate-brownie.png",
      price: 2.99,
      category: "Desserts",
      addOns: []
    },
    {
      id: null,
      name: "Pudding",
      description: "Smooth and creamy vanilla pudding.",
      imagePath: "/images/desserts/pudding.png",
      price: 2.49,
      category: "Desserts",
      addOns: []
    },
    {
      id: null,
      name: "Red Velvet Cake",
      description: "Moist red velvet cake with cream cheese frosting.",
      imagePath: "/images/desserts/red-velvet-cake.png",
      price: 5.49,
      category: "Desserts",
      addOns: []
    },
    {
      id: null,
      name: "Caramel Macchiato",
      description: "Espresso with caramel and steamed milk.",
      imagePath: "/images/drinks/caramel-machiato.png",
      price: 3.99,
      category: "Drinks",
      addOns: [
        { name: "Extra caramel", price: 0.49 }
      ]
    },
    {
      id: null,
      name: "Iced Tea",
      description: "Refreshing black iced tea with lemon.",
      imagePath: "/images/drinks/iced-tea.png",
      price: 2.49,
      category: "Drinks",
      addOns: []
    },
    {
      id: null,
      name: "Lemonade",
      description: "Classic lemonade with a tangy twist.",
      imagePath: "/images/drinks/lemonade.png",
      price: 1.99,
      category: "Drinks",
      addOns: []
    },
    {
      id: null,
      name: "Mojito",
      description: "A refreshing mint and lime soda.",
      imagePath: "/images/drinks/mojito.png",
      price: 2.99,
      category: "Drinks",
      addOns: []
    },
    {
      id: null,
      name: "Smoothie",
      description: "A fruity blend of berries and yogurt.",
      imagePath: "/images/drinks/smoothie.png",
      price: 3.99,
      category: "Drinks",
      addOns: []
    },
    {
      id: null,
      name: "Asian Sesame Salad",
      description: "Crispy greens with sesame dressing and crunchy wontons.",
      imagePath: "/images/salads/asianese-sesame.png",
      price: 4.49,
      category: "Salads",
      addOns: []
    },
    {
      id: null,
      name: "Caesar Salad",
      description: "Romaine lettuce, croutons, and Caesar dressing.",
      imagePath: "/images/salads/caesar.png",
      price: 3.99,
      category: "Salads",
      addOns: []
    },
    {
      id: null,
      name: "Greek Salad",
      description: "Fresh veggies with feta cheese and olives.",
      imagePath: "/images/salads/greek.png",
      price: 4.49,
      category: "Salads",
      addOns: []
    },
    {
      id: null,
      name: "Quinoa Salad",
      description: "Healthy quinoa mixed with fresh greens and lemon dressing.",
      imagePath: "/images/salads/quinoa.png",
      price: 5.49,
      category: "Salads",
      addOns: []
    },
    {
      id: null,
      name: "Southwest Salad",
      description: "A mix of greens, beans, and spicy southwest dressing.",
      imagePath: "/images/salads/southwest.png",
      price: 4.99,
      category: "Salads",
      addOns: []
    },
    {
      name: "Garlic Bread",
      description: "Toasted bread with a rich garlic butter spread.",
      imagePath: "/images/sides/garlic-bread.png",
      price: 2.49,
      category: "Sides",
      addOns: []
    },
    {
      name: "Loaded Fries",
      description: "Crispy fries topped with cheese and bacon.",
      imagePath: "/images/sides/loaded-fries.png",
      price: 3.49,
      category: "Sides",
      addOns: []
    },
    {
      name: "Mac and Cheese",
      description: "Creamy macaroni with a cheddar cheese sauce.",
      imagePath: "/images/sides/mac-and-cheese.png",
      price: 4.49,
      category: "Sides",
      addOns: []
    },
    {
      name: "Onion Rings",
      description: "Crispy fried onion rings served with a dipping sauce.",
      imagePath: "/images/sides/onion-rings.png",
      price: 3.99,
      category: "Sides",
      addOns: []
    },
    {
      name: "Roasted Sweet Potatoes",
      description: "Sweet potatoes roasted with herbs and spices.",
      imagePath: "/images/sides/roasted-sweet-potatoes.png",
      price: 3.49,
      category: "Sides",
      addOns: []
    }
  ];

  
  export default menuItems;