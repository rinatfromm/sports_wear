import { Route, Routes } from 'react-router-dom'
import './styles/App.css'
import Layout from './layout'
import Categories from '../pages/categories'
import MainPage from '../pages/mainPage'
import Products from '../pages/products'
import Sales from '../pages/sales'


function App(): JSX.Element {


  return (
    <div className="App" >
      <Routes>
        <Route path='/' element={<Layout />}>
          <Route index element={<MainPage />} />
          <Route path="categories" element={<Categories />} />
          <Route path="products" element={<Products />} />
          <Route path="sales" element={<Sales />} />
        </Route>
      </Routes>
    </div>
  )
}

export default App
