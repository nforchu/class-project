import { Fragment} from "react";
import { Link, Outlet } from "react-router-dom";
import "./navigation.styles.scss";

const Navigation = () => {

  return(
    <Fragment>
      <div className="navigation">

       <Link className="logo-container" to={'/'}>
          Logo
       </Link>

        <div className="nav-links-container">
          <Link className="nav-link" to={'shop'}>Shop</Link>
          <Link className="nav-link" to={'contact'}>Contact</Link>
          <Link className="nav-link" to={'auth'}>Sign in</Link>
        </div>
      </div>
      <div className="page-content">
        <Outlet />
      </div>

    </Fragment>
  )

}

export default Navigation;