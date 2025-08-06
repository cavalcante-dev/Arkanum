import './Style.css'
import { Link } from 'react-router-dom'

export default function Home() {

    return (

        <div>
            <div>
                <p>HOME</p>
                <div className='textbox'>
                <p>Novo aqui? <Link to="/cadastro">Cadastre-se</Link></p>
                </div>
                <div className='textbox'>
                <p>Já tem uma conta? <Link to="/login">Login</Link></p>
                </div>
            </div>
        </div>

    )

}