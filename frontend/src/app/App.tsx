import { Route, Routes } from 'react-router-dom'
import './styles/App.css'
import Layout from './layout'
import MainPage from '../pages/mainPage'
import Products from '../pages/products'
import Sales from '../pages/sales'
import AboutUS from '../pages/aboutUs'
import Basket from '../pages/basket'
import NewCollection from '../pages/newCollection'


function App(): JSX.Element {


  return (
    <div className="App" >
      <Routes>
        <Route path='/' element={<Layout />}>
          <Route index element={<MainPage />} />
          <Route path="products" element={<Products />} />
          <Route path='newCollection' element={<NewCollection />} />
          <Route path="sales" element={<Sales />} />
          <Route path='aboutUs' element={<AboutUS />} />
          <Route path='basket' element={<Basket />} />
        </Route>
      </Routes>
    </div>
  )
}

export default App
