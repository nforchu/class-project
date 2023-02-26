export async function getCategories(){
  const response = await fetch("http://127.0.0.1:8080/categories",  {
    method: 'GET',
    headers: {'Content-Type' : 'application/json'}
  });
  return await response.json();
}


export async function getProducts(pageNumber ) {
  const url = `http://127.0.0.1:8080/products/browse?pageNumber=${pageNumber}`;
  console.log(url);
  const response = await fetch(url, {
    method: 'GET', 
    headers: {'Content-Type' : 'application/json'}
  });
  return await response.json();
}

export async function getCategoryPreview(){
  const response = await fetch("http://127.0.0.1:8080/categories/preview",  {
    method: 'GET',
    headers: {'Content-Type' : 'application/json'}
  });
  return await response.json();
}


