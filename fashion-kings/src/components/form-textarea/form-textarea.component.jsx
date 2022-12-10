
import React from 'react';

const FormTextarea = ({label, inputOptions}) => {
  return(
    <div className='group'>      
      <textarea className='form-input' {...inputOptions}/>
      {label && (
        <label 
        className={`${inputOptions.value.length ?  'shrink' : ''      
                          }  form-input-label`}>
          {label}
        </label>
      )
      }
      
      <textarea>
        dsfasfddasfda
      </textarea>
    </div>
    
  )
}

export default FormTextarea;