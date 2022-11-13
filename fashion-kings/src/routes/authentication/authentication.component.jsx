
import React, { useContext } from 'react';

import SignInForm from "../../components/sign-in-form/sign-in-form.component";
import SignUpForm from "../../components/sign-up-form/sign-up-form.component";
import { CustomerContext } from '../../context/customer.context';
import "./authentication.styles.scss"

const Authentication = () => {
  const  { currentCustomer } = useContext(CustomerContext);

  return(
    <div className="authentication-container">
      {
        currentCustomer? 
        <h2>You are logged in as {currentCustomer.email}</h2> : 
        <>
          <SignInForm />
          <SignUpForm />
        </>
      }
      
      
    </div> 
  )
}

export default Authentication;