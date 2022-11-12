import React from "react";

import FormInput from "../form-input/form-input.component";
import "./sign-in-form.styles.scss";
import Button from "../button/button.component";

const SignInForm = () => {

  return (
    <div>
    <h2>Already have an account?</h2>
    <span>Sign in with your email and password</span>    
    <form>    
      <FormInput 
        label="Email" 
        inputOptions = {{
          type: 'email',
          required: true,
          name: 'email'
        }}/>

      <FormInput 
         label="Password" 
         inputOptions = {{
          type: 'password',
          required: true,
          name: 'password'
        }}/>

     <Button buttonType="inverted" type="submit">Sign in</Button> <br/>
     <Button buttonType="google" type="submit">Sign in with google</Button>
    </form>
    </div>
  )
}

export default SignInForm;