import './Style.css'
import { Link } from 'react-router-dom'

export default function Login() {

  return (

    <div className='main'>

      <div className='containerInfo'>

        <p>Gerenciador <br /> de magias para</p>

        <h1>Dungeons<b>&</b> <br /> Dragons</h1>

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

          <form action>
            <label>
              <p>Nome de Usuário</p>
              <input
                type="text"
                placeholder='No minimo 5 caracteres...'
                minLength={5}
                required
              />
            </label>
            <label>
              <p>Senha</p>
              <input
                type="password"
                placeholder='No minimo 5 caracteres...'
                minLength={5}
                required
              />
            </label>
            <button type='submit'>ENTRAR</button>
          </form>

        </div>

        <div className='textbox'>
          <p>Novo por aqui? <Link to="/cadastro">Cadastre-se</Link></p>
        </div>

      </div>

    </div>
  )

}