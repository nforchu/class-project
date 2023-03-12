import { Fragment, useContext, useEffect} from "react";
import { Link, Outlet } from "react-router-dom";
import CartDropdown from "../../components/cart-dropdown/cart-dropdown.component";
import CartIcon from "../../components/cart-icon/cart-icon.component";
import { CartContext } from "../../context/cart.context";
import { CustomerContext } from "../../context/customer.context";
import { ReactComponent as CrownLogo } from '../../assets/crown.svg';
import "./navigation.styles.scss";

const Navigation = () => {

  const  { currentCustomer, setCurrentCustomer } = useContext(CustomerContext);
  const { isCartOpen, getCart, setItems } = useContext(CartContext);
  const signoutHandler = () => {
    setCurrentCustomer(null);
  }

  useEffect(() => {
    getCart(1).then(data => {
      if(data && data.products){
        console.log('********************************')
        console.log(data);
        console.log('********************************')
        setItems(data.products)
      }
    })
  }, [])

  
  return(
    <Fragment>
      <div className="navigation">

       <Link className="logo-container" to={'/'}>
          <CrownLogo className="logo"/>
          <span className="site-name">Fashion Kings</span>
       </Link>

        <div className="nav-links-container">
          <Link className="nav-link" to={'browse'}>Browse</Link>
          <Link className="nav-link" to={'shop'}>Shop</Link>
          <Link className="nav-link" to={'contact'}>Contact</Link>
          {
            currentCustomer ?
            (<span onClick={signoutHandler} className="nav-link">Signout</span>) : 
            (<Link className="nav-link" to={'auth'}>Sign in</Link>)
          }
          <CartIcon />
        </div>
        { isCartOpen && <CartDropdown /> }
        
      </div>
      <div className="page-content">
        <Outlet />
      </div>

    </Fragment>
  )

}

export default Navigation;