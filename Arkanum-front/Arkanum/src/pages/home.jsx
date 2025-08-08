import './Style.css'
import { Link } from 'react-router-dom'

export default function Home() {

    return (

        <div className="main">

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
                    <h1>HOME</h1>
                    <div className='textboxHome'>
                        <p>Novo aqui? <Link to="/cadastro">Cadastre-se</Link></p>
                    </div>
                    <div className='textboxHome'>
                        <p>Já tem uma conta? <Link to="/login">Login</Link></p>
                    </div>
                </div>
            </div>

        </div>



    )

}