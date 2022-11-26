
import './cart-icon.styles.scss';

import {ReactComponent as ShoppingIcon } from '../../assets/shopping-bag.svg';
import { useContext } from 'react';
import { CartContext } from '../../context/cart.context';
const CartIcon = () => {

  const {isCartOpen, setIsCartOpen, cartItems } = useContext(CartContext);
  const toggleCartState = () => {
    setIsCartOpen(!isCartOpen);
  }

  return (
    <div className='cart-icon-container' onClick={toggleCartState}>
      <ShoppingIcon className='shopping-icon' />
      <span className='item-count'>{cartItems.length}</span>
    </div>
  )
}

export default CartIcon;