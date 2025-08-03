**Objetivo:** O sistema tem o objetivo de organizar a ficha de magias de um SpellCaster de Dungeons and Dragons.
## Requisitos: 
#### Funcionais
- RF1 - O sistema deve cadastrar usuários com *name*, *username*, *email* e *password* (inicialmente)
- RF2 - O sistema deve logar os usuários com seu *username* e *password* 
- RF3 - O usuário deve conseguir criar mais de um personagem em sua conta
- RF4 -O usuário deve conseguir editar os personagens criados
- RF5 -O usuário deve conseguir excluir os personagens criados
- RF6 -O personagem deve possuir as seguintes características: *name*, *class*, *level*, *spellSlots*, *spellList*, *spellsKnown*, *charImage*, *usedSlots* 
	- Todas as características serão definidas pelo usuário, exceto *spellSlots* que será definida automaticamente baseada em *class* e *level*
	- *name*: nome do personagem
	- *class*: classe do personagem, uma entre *bard, cleric, druid, sorcerer, warlock, wizard, paladin, ranger, multiclass*
	- *spellsSlot*: a quantidade de espaços de magia disponíveis para cada nível de magia
	- *spellsKnown*: magias conhecidas/preparadas pelo personagem
	- *charImage*: imagem do personagem
	- *usedSlots*: espaços de magia utilizados, separados por nível de magia
- RF7 -O usuário deve conseguir adicionar a *spellsList* magias separadas por nível da magia. 
- RF8 -O usuário deve conseguir ver um pequeno resumo das magias escolhidas
- RF9 -O usuário deve conseguir remover uma magia escolhida
- RF10 -O usuário deve ter um contador por nível de magia para os espaços utilizados
#### Não Funcionais 
- O sistema deve ser seguro 
- O sistema deve ser responsivo 
- O sistema deve permitir atualizações 
- O sistema deve ser multiplataforma 
- O sistema deve ser de fácil uso e entendimento
- O sistema deve ser de fácil manutenção 