import { useEffect, useState } from "react";
import './Style.css'
import api from '../services/Api'
import { Link } from 'react-router-dom'

export default function Welcome() {

    const [userName, setUserName] = useState("")

    const token = localStorage.getItem('accessToken')

    async function getUserName() {
        const response = await api.get('/welcome', {
            headers: {
                Authorization: `Bearer ${token}`
            }
        })
        setUserName(response.data)
    }

    useEffect(() => {
        getUserName()
    }, [])

    return (

        <div className="main">

            <div className='containerInfo'>

                <span>
                    <p>Vamos criar aqui <br /> seu personagem</p>
                    <h1>Estamos <br /> Trabalhando </h1>
                </span>

            </div>

            <div className="mainContainer">
                <div className="containerWelcome">
                    <h1 className='welcomeMessage'>
                        Olá, {userName} <br />
                        BEM VINDO AO ARKANUM!
                    </h1>
                    <div className='textbox'>
                        <p><Link to="/criarpersonagem">Criar Novo Personagem</Link></p>
                    </div>
                    <div className='textbox'>
                        <p><Link to="/meuspersonagens">Meus Personagens</Link></p>
                    </div>
                </div>
            </div>
        </div>

    )

}