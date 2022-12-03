
import React, { useState } from 'react';
import Button from '../../components/button/button.component';

import FormInput from '../../components/form-input/form-input.component';
import FormTextarea from '../../components/form-textarea/form-textarea.component';
import './contact.styles.scss';

const defaultFormFields = {
  email: '',
  subject: '',
  message: ''
}

const Contact = () => {
  const contactImageUrl = 'https://i.ibb.co/KV18Ysr/floral-skirt.png';
  const [formFields, setFormFields ] = useState(defaultFormFields);
  const { email, subject, message } = formFields;

  const handleChage = (event) => {
    const {name, value} = event.target;
    setFormFields({...formFields, [name]: value});

  }

  return(
    <div className='contact-container'>
      <div className='image-container'
        style={{backgroundImage: `url(${contactImageUrl})`}} />

      <div className='content'>
        
        <form className='form'>
          <h3>Contact us</h3>
          <FormInput 
            label="Email"
            inputOptions={{
                type: 'email',
                required: true,
                name: 'email',
                value: email,
                onChange: handleChage  }} />
          <FormInput 
            label="Subject"
            inputOptions={{
                type: 'text',
                required: true,
                name: 'subject',
                value: subject,
                onChange: handleChage  }} />
          <FormTextarea 
            label="Message"
            inputOptions={{
                required: true,
                name: 'message',
                value: message,
                rows: 6,
                onChange: handleChage  }} />

          <Button buttonType="inverted" type="submit">Send message</Button>   
        </form>

        <div className='info'>
          <h3>Info</h3>
          <div className='contact'>
            sales@fashionkings.com
            (+32) 4600 000
          </div>

          <div className='address'>
            <span className='address-item'>Alpha Street</span>
            <span className='address-item'>1000 Brussels,</span>
            <span className='address-item'>Belgium</span>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Contact;