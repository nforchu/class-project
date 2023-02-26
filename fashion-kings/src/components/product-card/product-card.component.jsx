import { useContext } from 'react';
import { CartContext } from '../../context/cart.context';
import Button from '../button/button.component';
import './product-card.styles.scss';

const ProductCard = ({product}) => {

  const {title, price, id, image} = product;
  const {addItemToCart} = useContext(CartContext);

  const addProductHandler = () => addItemToCart(product);

  return (
    <div className='product-card-container'> 
      <img src={`http://localhost:8080/product/${id}/images/${image}`} alt={title} />
      <div className='footer'>
        <span className='name'>{title}</span>
        <span className='price'>{price}</span>
      </div> 

     <Button buttonType="inverted" onClick={addProductHandler} >Add to Cart</Button> 
    </div>
  )
}

export default ProductCard;