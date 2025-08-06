import './Style.css'
import { Link, useNavigate } from 'react-router-dom'
import api from '../services/api'
import { useRef, useState } from 'react'
import Welcome from './welcome'

export default function Register() {

  // Inputs para enviar para a API

  const inputUsername = useRef()
  const inputName = useRef()
  const inputPassword = useRef()

  const navigate = useNavigate()

  // Criar novo usuário

  async function createUser() {

    await api.post('/cadastro/newuser', {
      username: inputUsername.current.value,
      name: inputName.current.value,
      password: inputPassword.current.value
    })

    const loginResponse = await api.post('/login', {
      username: inputUsername.current.value,
      password: inputPassword.current.value
    })

    const token = loginResponse.data.accessToken;
    localStorage.setItem('accessToken', token)
    
    console.log('Token: ', token)

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

          <h1>CADASTRAR-SE</h1>

          <form>
            <label>
              <p>Nome</p>
              <input
                type="text"
                placeholder='Insira seu nome de exibição...'
                minLength={3}
                required
                ref={inputName}
              />
            </label>
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
            <button type='button' onClick={createUser}>CRIAR CONTA</button>
          </form>

        </div>

        <div className='textbox'>
          <p>Já tem uma conta? <Link to="/login">Login</Link></p>
        </div>

      </div>

    </div>
  )
}