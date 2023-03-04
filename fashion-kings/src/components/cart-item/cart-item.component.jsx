import './cart-item.styles.scss';

const CartItem = ({item}) => {
  const {name, image, price, stockQuantity, id } = item;

  return (
    <div className='cart-item-container'>
      <img src = {`http://localhost:8080/product/${id}/images/${image}`} alt={name} />
      <div className='item-details'>
        <span className='name'>{name}</span>
        <span className='price'> {stockQuantity } X &euro;{price}</span>
      </div>
    </div>
  )
}

export default CartItem;