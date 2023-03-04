import { Fragment, useEffect, useState } from 'react';
import { useParams, useSearchParams } from 'react-router-dom';
import ProductCard from '../../components/product-card/product-card.component';
import { getProductsByCategory } from '../../services/category-service';
import './category.styles.scss';

const Category = () => {
  const {category} = useParams();
  const [products, setProducts] = useState([]);
  const [searchParams] = useSearchParams();

  useEffect(() => {
    getProductsByCategory(category).then(data => {
      console.log(data.content)
      setProducts(data.content);
    });
  }, []);


  return (
    <Fragment>
      <h2 className='category-title'>{searchParams.get('title').toUpperCase()}</h2>
      
      <div className='category-container'>
      {
        products && 
          products.map((product, index) => <ProductCard key={index} product={product} />) 
      }
      
      </div>
    </Fragment>
  )
}

export default Category;