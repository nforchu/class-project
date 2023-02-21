export async  function getCategories () {
  const response = await fetch("http://localhost:8080/categories", {
    method: 'GET',
    headers: {'Content-Type' : 'application/json'}
  });
  return await response.json();
}