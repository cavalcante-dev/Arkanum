// Importa as ferramentas de roteamento
import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

// Importação de estilos
import './index.css'

// Importação de Páginas
import Home from './pages/home'
import Register from './pages/register'
import Login from './pages/login'
import NotFound from './pages/notfound'
import Welcome from './pages/welcome'

// Componentes Principais 
function Main() {

  return (

    <BrowserRouter>

      <Routes>

        <Route path='/' element={<Home />} />
        <Route path="/cadastro" element={<Register />} />
        <Route path='/login' element={<Login />} />
        <Route path='/welcome' element={<Welcome />} />
        <Route path='*' element={<NotFound />} />

      </Routes>

    </BrowserRouter>

  )

}

// Render da Aplicação

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Main />
  </StrictMode>
)