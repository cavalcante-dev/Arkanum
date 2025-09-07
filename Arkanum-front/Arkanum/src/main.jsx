// Importa as ferramentas de roteamento
import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import PrivateRoute from './services/PrivateRoute'
import api from './services/Api'

// Importação de estilos
import './index.css'

// Importação de Páginas
import Home from './pages/home'
import Register from './pages/register'
import Login from './pages/login'
import NotFound from './pages/notfound'
import Welcome from './pages/welcome'
import CreatCharacter from './pages/createCharacter'
import MyCharacters from './pages/myCharacters'

// Componentes Principais 
function Main() {

  return (

    <BrowserRouter>

      <Routes>

        <Route path='/' element={<Home />} />
        <Route path="/cadastro" element={<Register />} />

        <Route path='/login' element={<Login />}/>

        <Route path='/welcome' element={<PrivateRoute/>}>
            <Route path='/welcome' element={<Welcome/>}/>
        </Route>
        <Route path='*' element={<NotFound />} />

        <Route path='/criarpersonagem' element={<PrivateRoute/>}>
            <Route path='/criarpersonagem' element={<CreatCharacter />}/>
        </Route>
        
        <Route path='/meuspersonagens' element={<PrivateRoute/>}>
            <Route path='/meuspersonagens' element={<MyCharacters />}/>
        </Route>


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