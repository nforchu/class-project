
import React, { useEffect, useState } from 'react';
import { getCategories } from '../../services/category-service';
import DirectoryItem from '../directory-item/directory-item.component';
import './directory.styles.scss';

const Directory = () => {
  const [categories, setCategories] = useState([]);
  useEffect(() => {
    getCategories().then(categories => {
      setCategories(categories)
    })
  }, []);

  return (
    <div className="directory-container">
      {
        categories.map((category, index) => (
          <DirectoryItem key={index} item= {category} />
        ))
      }
    </div>
   
  );

}

export default Directory;