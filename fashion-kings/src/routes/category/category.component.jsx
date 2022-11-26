import { Fragment, useContext, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import ProductCard from '../../components/product-card/product-card.component';
import { CategoriesContext } from '../../context/categories.context';
import './category.styles.scss';

const Category = () => {
  const {category} = useParams();
  const {categories} = useContext(CategoriesContext);
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const selectedCat = categories.find(({title}) => title.toLowerCase() == category);
    setProducts(selectedCat.items);
  }, [category, categories]);


  return (
    <Fragment>
      <h2 className='category-title'>{category.toUpperCase()}</h2>
      
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