import React from 'react';
import { useNavigate } from 'react-router-dom';
import './directory-item.styles.scss';

const DirectoryItem  = ({item}) => {
  const { title, cover, id } = item;
  const navigate = useNavigate();
  const onNavigateHandler = () => navigate(`shop/${id}?title=${title}`);

  return(
    <div onClick={onNavigateHandler}  className="directory-item-container">
      <div className="background-image"
           style={{backgroundImage: `url(http://localhost:8080/category/${id}/images/${cover})`}}
      />
      <div className="body">
        <h2>{title}</h2>
        <p>Shop now</p>
      </div>
    </div>
   
  );
}

export default DirectoryItem;