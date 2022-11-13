import React, { useContext, useState } from "react";

import FormInput from "../form-input/form-input.component";
import "./sign-in-form.styles.scss";
import Button from "../button/button.component";
import { CustomerContext } from "../../context/customer.context";

const defaultValues = {
  email: '',
  password: '',
  username: ''
}

const customer = {email: '', password: ''}

const SignInForm = () => {
  const [formFields, setFormFields] = useState(defaultValues);
  const { email, password } = formFields;

  const { setCurrentCustomer } = useContext(CustomerContext);



  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormFields({...formFields, [name] : value});
  }

  const handleSubmit = (event) => {
    event.preventDefault();
    customer.email = email;
    customer.password = password;
    setCurrentCustomer(customer);
  }

  return (
    <div>
    <h2>Already have an account?</h2>
    <span>Sign in with your email and password</span>    
    <form onSubmit={handleSubmit}>    
      <FormInput 
        label="Email" 
        inputOptions = {{
          type: 'email',
          required: true,
          name: 'email',
          value: email,
          onChange: handleChange
        }}/>

      <FormInput 
         label="Password" 
         inputOptions = {{
          type: 'password',
          required: true,
          name: 'password',
          value: password, 
          onChange:  handleChange
        }}/>

     <Button buttonType="inverted" type="submit">Sign in</Button> <br/>
     <Button buttonType="google" type="submit">Sign in with google</Button>
    </form>
    </div>
  )
}

export default SignInForm;