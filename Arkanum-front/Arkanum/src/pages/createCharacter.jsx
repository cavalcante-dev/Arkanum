import "./characterStyle.css"

export default function CreatCharacter() {

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
                    <div className="div1">
                        <label> Nome do Personagem </label>
                        <input type="text" placeholder="Insira o nome do personagem..." />
                    </div>
                    <div className="div2">
                        <label> Classe de Conjurador </label>
                        <select id="characterClass">
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
                    <div className="div3">
                        <label> Nível </label>
                        <input type="number" min='1' max='20' />
                    </div>
                    <div className="div4">
                        <label> Descrição do Personagem </label>
                        <textarea id="characterDescription" rows='20' cols='30' placeholder="Quem é seu personagem?"></textarea>
                    </div>
                    <div className="div5">
                        <input type="file" />
                    </div>
                    <div className="div6">
                            <p>
                                spell slots
                            </p>
                    </div>

                </div>
                <button className="buttonAdvance" type='button' >AVANÇAR</button>
            </div>

        </div>

    )

}
