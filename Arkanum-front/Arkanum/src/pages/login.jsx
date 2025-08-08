import './Style.css'
import { useRef } from 'react'
import { useNavigate } from 'react-router-dom'
import { Link } from 'react-router-dom'
import api from '../services/Api'

export default function Login() {

  const inputUsername = useRef()
  const inputPassword = useRef()

  const navigate = useNavigate()

  async function login() {

    const loginResponse = await api.post('/login', {
      username: inputUsername.current.value,
      password: inputPassword.current.value
    })

    const token = loginResponse.data.accessToken;
    localStorage.setItem('accessToken', token)

    navigate('/welcome')

  }
  
  return (

    <div className='main'>

      <div className='containerInfo'>

        <span>
          <p>Gerenciador <br /> de magias para</p>
          <h1>Dungeons<b>&</b> <br /> Dragons</h1>
        </span>

        <span className='creditInfo'>
          Aplicação não oficial
          <br />desenvolvida sem fins lucrativos.
          <br />
          <br />Créditos:
          <br />Leandro Cavalcante
          <br /><a href="https://github.com/cavalcante-dev" target='_blank'>Github.com</a>
        </span>

      </div>

      <div className='mainContainer'>

        <div className='containerRegister'>

          <h1>LOGIN</h1>

          <form>
            <label>
              <p>Nome de Usuário</p>
              <input
                type="text"
                placeholder='No minimo 5 caracteres...'
                minLength={5}
                required
                ref={inputUsername}
              />
            </label>
            <label>
              <p>Senha</p>
              <input
                type="password"
                placeholder='No minimo 5 caracteres...'
                minLength={5}
                required
                ref={inputPassword}
              />
            </label>
            <button type='button' onClick={login}>ENTRAR</button>
          </form>

        </div>

        <div className='textbox'>
          <p>Novo por aqui? <Link to="/cadastro">Cadastre-se</Link></p>
        </div>

      </div>

    </div>
  )


}