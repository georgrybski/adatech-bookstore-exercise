[English](README.md) | [Português](README.pt-br.md)

## Exercício Livraria

Este projeto é uma aplicação de livraria desenvolvida com Java, e foi criado como parte do segundo módulo da trilha de
Back-end do programa [Futuro Polo Tech](https://polotech.americanas.io/). Este programa é uma parceria entre a escola
git sde tecnologia [Ada](https://ada.tech/sou-aluno) e a [Americanas](https://carreiras.americanas.com/).

### Requisitos

O sistema deve ser capaz de registrar os seguintes produtos:
- Livros: Devem ter nome, id, preço, gênero, escritor, editora.
- Jogos: Devem ter nome, id, preço, distribuidora, gênero e estúdio.
- Filmes: Devem ter nome, id, preço, estúdio, diretor, gênero e produtor.
- Álbuns de música: Devem ter nome, id, preço, músico/banda, gênero e selo.
- Brinquedos: Devem ter nome, id, preço e tipo.

Além disso, o sistema deve possuir um caixa, que deve ter informações sobre o dinheiro presente nele.

O sistema deve ter as seguintes funcionalidades:
- Adicionar, visualizar, alterar e remover qualquer produto do sistema.
- Ver quantos itens de um tipo específico existem no estoque.
- Ver a listagem completa dos itens em estoque.
- Ver a listagem dos itens em estoque por categoria.
- Realizar a operação de compra, ao realizar esta operação os produtos comprados são removidos do estoque e o dinheiro pago deve ser adicionado ao caixa.

## Minha Implementação

### Banco de Dados em memória

Para armazenar e recuperar os itens, criei um HashMap tridimensional.

A primeira dimensão deste HashMap contém HashMaps que armazenam todos os HashMaps de itens de uma determinada categoria,
com o nome da categoria sendo a chave usada para acessá-la (por exemplo, "Livros").

Dentro desses HashMaps, estão os HashMaps que contêm itens de um determinado gênero ou tipo, com o gênero/tipo sendo a
chave (por exemplo, "Ficção científica", "Romance", etc.).

Dentro da camada final de HashMap, todos os itens dessa categoria e gênero podem ser encontrados, com o ID do produto 
sendo a chave usada para acessá-lo.

Dessa forma, é possível procurar rapidamente um item específico sem ter que iterar por todos os itens até que o produto
de um ID específico seja encontrado.

Além disso, como a localização de todos os itens já é conhecida, não é necessário iterar por quaisquer itens 
desnecessários ao procurar por todos os itens de uma categoria e/ou gênero específico ou ID.

#### Criação dos HashMaps

Neste projeto, optei por oferecer uma lista pré-selecionada de gêneros/tipos, que o usuário poderá selecionar via um menu impresso.

Para tornar modificações, como a adição de novas categorias e gêneros/tipos, o mais fácil possível, todos os HashMaps são criados automaticamente,
inicializando o número certo de HashMaps na localização certa, baseado em arrays que contêm todas as categorias.

As opções de menu e o input aceito também funcionam com base nesses arrays, tornando a adição de mais gêneros tão fácil quanto adicionar uma string a um array.

#### Busca por ID

Como há múltiplas camadas de HashMaps, o ID deve carregar informações sobre onde este item estará localizado. 
Como os itens são organizados por categoria e, em seguida, por gênero/tipo, o ID deve carregar identificadores 
para poder rapidamente olhar para a terceira camada de HashMaps, que contém os produtos.

Para fazer isso, optei pela solução simples de criar um ID com os 3 primeiros caracteres da categoria,
seguido pelos 3 primeiros caracteres do gênero/tipo e, finalmente, um ID numérico.

Dessa maneira, só precisei criar métodos para "traduzir" esses identificadores de 6 caracteres para as chaves
necessárias para acessar o HashMap onde o item está localizado.

### Menus

As interações do usuário são feitas principalmente usando menus, impressos considerando o número de opções,
representadas por matrizes de String.

#### Log in menu

The log in menu can be used to access any created account or the admin acount

The admin account is pre-created and has access to all manipulation and visualization tools,
such as manipulating products, viewing orders and viewing the inventory and sales dashboard

A conta admin é criada durante a inicialização do banco de dados em memória. 
Ela tem acesso à todas as ferramentas de manipulação e visualização,
como a manipulação de produtos, visualziação de ordens e de inventário e dashboard de vendas.

Para acessar a conta admin, selecione `1 - Log in` e insira o usuário `admin` e a senha `admin`.

Segue o processo de login e o menu da conta admin:

![Acessando a conta admin](images/logging-in-admin.png)

#### Criação de contas

Para acessar a funcionalidade de compras, você deverá criar uma conta

Um exemplo do processo:

![Criação de uma conta](images/create-account-menu.png)

Imediatamente após a criação, você estará logado na conta.

Contas, carrinhos de compras e pedidos persistem durante a execução da aplicação.

### Manipulando produtos

Os produtos podem ser adicionados, modificados e removidos fazendo login com o nome de usuário e senha `admin`.

#### Adicionando produtos

Ao adicionar produtos, você será convidado a escolher entre as categorias: '`Albums`, `Books`, `Films`, `Games` 
e `Toys`, seguido de selecionar um dos gêneros/tipos da categoria escolhida.

![Menu de adicionar itens - Exemplo Album](images/add-item-menu.png)

#### Modificando produtos

Ao modificar produtos, você terá que inserir o ID do produto e lhe será mostrado o seguinte menu:

![Menu de modificar itens - Exemplo Book](images/modify-product-menu.png)

#### Visualizando lista de produtos

Você pode acessar a lista de produtos enquanto estiver logado como um cliente ou com a conta `admin`.

Ao selecionar a opção `1 - See product list`, você será convidado a ver quais produtos deseja ver.
Você pode escolher ver todos os produtos, todos os produtos de uma categoria ou produtos de um
gênero/tipo específico dentro de uma categoria.

![Ver lista de produtos - Exemplo Toy](images/see-products-menu.png)

A lista resultante será exibida da seguinte forma:

![Lista de produtos - Exemplo Book](images/see-products-result.png)

## Executando o código

Para executar este projeto, clone o repositório e importe-o em seu ambiente de desenvolvimento Java preferido.
Certifique-se de ter o Java Development Kit (JDK) versão 17 ou superior instalado em sua máquina.

