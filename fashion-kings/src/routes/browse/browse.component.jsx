import { useEffect, useState } from "react";
import Button from "../../components/button/button.component";
import ProductCard from "../../components/product-card/product-card.component";
import { getProducts } from "../../services/category-service";


const Browse = () => {
  const [pageNumber, setPageNumber] = useState(0);
  const [products, setProducts] = useState([]);
  useEffect(() => {
    getProducts(pageNumber).then(data => {
      setProducts(data.content);
    });
  },[pageNumber])


  const getNextPage = () => {
    setPageNumber(pageNumber + 1);
    console.log(pageNumber);
  }
  
  return (
    <div className="category-container">
      {
        products.map((product, index) => <ProductCard key={index} product={product}/>)
      }
      <Button buttonType="inverted" onClick={getNextPage} >next</Button>
    </div>
  )
}

export default Browse;