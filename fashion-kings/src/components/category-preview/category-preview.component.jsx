import { useNavigate } from "react-router-dom";
import ProductCard from "../product-card/product-card.component";
import './category-preview.styles.scss';


const CategoryPrview = ({category}) => {
  const { title, items } = category;
  const navigate = useNavigate();

  const onNavigateHandler = () => navigate(`${title.toLowerCase()}`)
  
  return(
   <div className="category-preview-container">
    <h2>
      <span className="title" onClick={onNavigateHandler}>{title.toUpperCase()}</span>
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