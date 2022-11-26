import React from 'react';
import { useNavigate } from 'react-router-dom';
import './directory-item.styles.scss';

const DirectoryItem  = ({item}) => {
  const { title, imageUrl, route } = item;
  const navigate = useNavigate();
  const onNavigateHandler = () => navigate(route)

  return(
    <div onClick={onNavigateHandler}  className="directory-item-container">
      <div className="background-image"
           style={{backgroundImage: `url(${imageUrl}})`}}
      />
      <div className="body">
        <h2>{title}</h2>
        <p>Shop now</p>
      </div>
    </div>
   
  );
}

export default DirectoryItem;