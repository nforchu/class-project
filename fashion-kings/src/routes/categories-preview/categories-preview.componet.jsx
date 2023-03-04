import { Fragment, useContext, useEffect, useState } from "react"
import CategoryPrview from "../../components/category-preview/category-preview.component";
import { getCategoryPreview } from "../../services/category-service";


const CategoriesPreview = () => {
  const [categories, setCategories] = useState([]);
  useEffect(() => {
    getCategoryPreview().then(data => {
      console.log(data)
      setCategories(data);
    })
  }, [])

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