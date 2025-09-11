import "./characterStyle.css"
import api from '../services/Api'
import { use, useRef, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

export default function CreatCharacter() {

    const token = localStorage.getItem('accessToken')

    const navigate = useNavigate()

    const inputName = useRef()
    const inputClass = useRef()
    const inputLevel = useRef()
    const inputDescription = useRef()

    async function createCharacter() {

        await api.post(
            '/criarpersonagem/novopersonagem',
            {
                name: inputName.current.value,
                characterClass: inputClass.current.value,
                characterLevel: inputLevel.current.value,
                characterDescription: inputDescription.current.value,

            },
            {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            }
        )

        navigate('/meuspersonagens')

    }

    return (

        <div className="main">

            <div className='containerInfo'>

                <span>
                    <p>Inicie a <br /> aventura</p>
                    <h1>Criar Novo<br />Personagem </h1>
                </span>

            </div>

            <div className="mainContainer">
                <div className="containerCreatCharacter">

                    <div className="characterCreation">

                        <div className="name">
                            <label> Nome do Personagem </label>
                            <input type="text" placeholder="Insira o nome do personagem..." ref={inputName} />
                        </div>
                        <div className="class">
                            <label> Classe de Conjurador </label>
                            <select id="characterClass" ref={inputClass}>
                                <option value=""> Selecione sua Classe </option>
                                <option value="1">Bardo</option>
                                <option value="2">Bruxo</option>
                                <option value="3">Clérigo</option>
                                <option value="4">Druida</option>
                                <option value="5">Feiticeiro</option>
                                <option value="6">Mago</option>
                                <option value="7">Paladino</option>
                                <option value="8">Patrulheiro</option>
                                <option value="9">Multiclasse</option>
                            </select>
                        </div>
                        <div className="level">
                            <label> Nível </label>
                            <select id="characterClass" ref={inputLevel}>
                                <option value=""> Selecione seu Nível </option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                                <option value="13">13</option>
                                <option value="14">14</option>
                                <option value="15">15</option>
                                <option value="16">16</option>
                                <option value="17">17</option>
                                <option value="18">18</option>
                                <option value="19">19</option>
                                <option value="20">20</option>
                            </select>
                        </div>
                        <div className="description">
                            <label> Descrição do Personagem </label>
                            <textarea id="characterDescription" placeholder="Quem é seu personagem?" ref={inputDescription}></textarea>
                        </div>

                    </div>

                    <div className="spells">
                        <h1>
                            ESPAÇOS DE MAGIA DISPONÍVEIS
                        </h1>
                        <ul>
                            <li>
                                NÍVEL 1 <hr /> <b>0</b>
                            </li>
                            <li>
                                NÍVEL 2 <hr /> <b>0</b>
                            </li>
                            <li>
                                NÍVEL 3 <hr /> <b>0</b>
                            </li>
                            <li>
                                NÍVEL 4 <hr /> <b>0</b>
                            </li>
                            <li>
                                NÍVEL 5 <hr /> <b>0</b>
                            </li>
                            <li>
                                NÍVEL 6 <hr /> <b>0</b>
                            </li>
                            <li>
                                NÍVEL 7 <hr /> <b>0</b>
                            </li>
                            <li>
                                NÍVEL 8 <hr /> <b>0</b>
                            </li>
                            <li>
                                NÍVEL 9 <hr /> <b>0</b>
                            </li>
                        </ul>
                    </div>

                </div>
                <button className="buttonAdvance" type='button' onClick={createCharacter} >AVANÇAR</button>
            </div>

        </div>

    )

}
