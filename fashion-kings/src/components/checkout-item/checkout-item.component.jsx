import { useContext } from 'react';
import { CartContext } from '../../context/cart.context';
import './checkout-item.styles.scss';

const CheckoutItem = ({item}) => {
  
  const {addItemToCart, removeItemFromCart, deleteItemFromCart } = useContext(CartContext);
  const {title, image, price, id, stockQuantity } = item;

  const addItemHander = () => addItemToCart(item);
  const removeItemHandler = () => removeItemFromCart(item);
  const deleteItemHandler = () => deleteItemFromCart(item);

  return (
    <div className='checkout-item-container'>
      <div className='image-container'>
        <img src={`http://localhost:8080/product/${id}/images/${image}`} alt={title} />
      </div>
      <span className='name'>{title}</span>

      <span className='quantity'>
        <div 
          className='arrow'
          onClick={removeItemHandler}>&#10094;</div>
        <span className='value'>{stockQuantity}</span>
        <div 
          className='arrow'
          onClick={addItemHander}>&#10095;</div>
      </span>
      <span className='price'>&euro;{price}</span>
      
      <div>
        <span className='remove-button' onClick={deleteItemHandler}>&#10005;</span>
      </div>
    </div>
  )
}

export default CheckoutItem;