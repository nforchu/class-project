

import FormInput from '../form-input/form-input.component';
import Button from '../button/button.component';
import './sign-up-form.styles.scss';
import { useState } from 'react';

const defaultValues = {
  displayName: '',
  email: '',
  password: '',
  confirmPassword: ''
}

const SignUpForm = () => {

  const [ formFields, setFormFields ] = useState(defaultValues);
  const {displayName, email, password, confirmPassword } = formFields;

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormFields({...formFields, [name]: value});
  }

  return (
    <div className='sign-up-container'>
      <h2>Don't have an account?</h2>
      <span>Sign up with your email and password</span>
      <form>
        <FormInput 
          label="Display name" 
          inputOptions = {{
            type: 'text',
            required: true,
            name: 'displayName',
            value: displayName,
            onChange: handleChange
          }}/>

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
            onChange: handleChange
          }}/>

        <FormInput 
          label="Confirm Password" 
          inputOptions = {{
            type: 'password',
            required: true,
            name: 'confirmPassword',
            value: confirmPassword,
            onChange: handleChange
          }}/>
        <Button type="submit">Sign up</Button>
  
      </form>
    </div>
  )
}

export default SignUpForm;