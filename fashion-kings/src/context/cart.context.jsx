import { createContext, useEffect, useState } from "react";


const addCartItem = (cartItems, productToAdd) => {
  const foundItem = cartItems.find(item => item.id === productToAdd.id);
  if(foundItem) {
    return cartItems.map(ci => 
      ci.id === productToAdd.id ? {...ci, quantity: ci.quantity + 1 }: ci);
  }
  return [...cartItems, {...productToAdd, quantity: 1}];
}

const removeCartItem = (cartItems, productToRemove) => {
  const foundItem = cartItems.find(item => item.id === productToRemove.id);
  if (foundItem.quantity > 1) {
    return cartItems.map(ci =>
      ci.id === productToRemove.id ? {...ci, quantity: ci.quantity -1 }: ci);
  }
  return cartItems;
}

const deleteCartItem = (cartItems, productToDelete) => {
  if (window.confirm(`${productToDelete.name} will be deleted from your cart.`)){
    return cartItems.filter(item => item.id !== productToDelete.id);
  }
  return cartItems;
}

export const CartContext = createContext({
  isCartOpen: false,
  setIsCartOpen: () => false,
  cartItems: [],
  addItemToCart: () => {},
  removeItemFromCart: () => {},
  deleteItemFromCart: () => {},
  cartTotal: 0
});

export const CartProvider = ({children}) => {
  const [isCartOpen, setIsCartOpen ] = useState(false);
  const [cartItems, setCartItems] = useState([]);
  const [cartTotal, setCartTotal] = useState(0); 

  useEffect(() => {
    const newTotal = cartItems.reduce(
      (total, currentItem) => total + (currentItem.quantity * currentItem.price), 0);
      setCartTotal(newTotal);
  }, [cartItems])

  const addItemToCart = (productToAdd) => {
    setCartItems(addCartItem(cartItems, productToAdd));
  }

  const removeItemFromCart = (productToRemove) => {
    setCartItems(removeCartItem(cartItems, productToRemove));
  }

  const deleteItemFromCart = (produtToDelete) => {
    setCartItems(deleteCartItem(cartItems, produtToDelete));
  }

  const value = {
    isCartOpen,
    setIsCartOpen,
    cartItems,
    addItemToCart,
    removeItemFromCart,
    deleteItemFromCart,
    cartTotal
  }
  return <CartContext.Provider value={value}>{children}</CartContext.Provider>
}