import ProductCard from "../product-card/product-cart.component";
import './category-preview.styles.scss';


const CategoryPrview = ({category}) => {
  const { title, items } = category;
  
  return(
   <div className="category-preview-container">
    <h2>
      <span className="title">{title.toUpperCase()}</span>
    </h2>

    <div className="preview">
      {
        items.filter((_, index) => index < 4)
        .map((product, idx) => <ProductCard key={idx} product={product}/>)
      }
    </div>
   </div>
  )
}

export default CategoryPrview;