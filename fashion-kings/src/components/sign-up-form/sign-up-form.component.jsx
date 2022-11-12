

import FormInput from '../form-input/form-input.component';
import Button from '../button/button.component';
import './sign-up-form.styles.scss';

const SignUpForm = () => {

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
            name: 'displayName'
          }}/>

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

        <FormInput 
          label="Confirm Password" 
          inputOptions = {{
            type: 'password',
            required: true,
            name: 'confirmPassword'
          }}/>
        <Button type="submit">Sign up</Button>
  
      </form>
    </div>
  )
}

export default SignUpForm;