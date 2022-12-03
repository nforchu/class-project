import { useContext } from 'react';
import CheckoutItem from '../../components/checkout-item/checkout-item.component';
import { CartContext } from '../../context/cart.context';
import './checkout.styles.scss';

const Checkout = () => {
  const {cartItems, cartTotal } = useContext(CartContext);

  return (
    <div className='checkout-container'>
      <div className='checkout-header'>
        <div className='header-block'>
          <span>Product</span>
        </div>

        <div className='header-block'>
          <span>Name</span>
        </div>

        <div className='header-block'>
          <span>Quanity</span>
        </div>

        <div className='header-block'>
          <span>Price</span>
        </div>

        <div className='header-block'>
          <span>Remove</span>
        </div>
      </div>

      {
        cartItems.map((item, index) => {
          return <CheckoutItem key={index}  item={item} />
        })
      }

      <span className='total'>Total: &euro;{cartTotal}</span>
    </div>
  )
}

export default Checkout;