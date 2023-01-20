[English](README.md) | [Português](README.pt-br.md)

## Exercício Livraria

Este projeto é uma aplicação de livraria desenvolvida com Java, e foi criado como parte do segundo módulo da trilha de Back-end do programa [Futuro Polo Tech](https://polotech.americanas.io/). Este programa é uma parceria entre a escola de tecnologia [Ada](https://ada.tech/sou-aluno) e a [Americanas](https://carreiras.americanas.com/).

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
para que possa rapidamente olhar para a terceira camada de HashMaps, que contém os produtos.

Para fazer isso, optei pela solução simples de criar um ID com os 3 primeiros caracteres da categoria,
seguido pelos 3 primeiros caracteres do gênero/tipo e, finalmente, um ID numérico.

Dessa maneira, só precisei criar métodos para "traduzir" esses identificadores de 6 caracteres para as chaves
necessárias para acessar o HashMap onde o item está localizado.

## Executando o código

Para executar este projeto, clone o repositório e importe-o em seu ambiente de desenvolvimento Java preferido.
Certifique-se de ter o Java Development Kit (JDK) versão 17 ou superior instalado em sua máquina.

