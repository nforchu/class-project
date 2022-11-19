import { Fragment, useContext } from "react"
import CategoryPrview from "../../components/category-preview/category-preview.component";
import { CategoriesContext } from "../../context/categories.context";

const CategoriesPreview = () => {
  const { categories } = useContext(CategoriesContext);

  return(
    <Fragment>
      {      
        categories.map((category, index) => {
          return <CategoryPrview key={index} category={category}/>
        })
      }
    </Fragment>
  )
}

export default CategoriesPreview;