-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 07-Dez-2019 às 19:28
-- Versão do servidor: 10.4.6-MariaDB
-- versão do PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `lanchonete`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `bairro` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `complemento` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cpf` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `numero` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rua` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `bairro`, `complemento`, `cpf`, `nome`, `numero`, `rua`, `telefone`) VALUES
(1, 'Industrial', 'casa recuada', '12332114621', 'Heitor Oliveira Campos', '1110', 'Dona Maria Gonzaga', '38 99976-8402'),
(4, 'Palma', '', '12312312312', 'David Gonçalves ', '6544', 'Teste do Sul', '38999999');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL,
  `data_pedido` datetime DEFAULT NULL,
  `cliente_id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedidoproduto`
--

CREATE TABLE `pedidoproduto` (
  `idPedidoProduto` int(11) NOT NULL,
  `preco` decimal(19,2) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `pedido_id_pedido` int(11) NOT NULL,
  `produto_id_produto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id_produto` int(11) NOT NULL,
  `ingredientes` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nome_p` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `preco_un` decimal(19,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id_produto`, `ingredientes`, `nome_p`, `preco_un`) VALUES
(1, 'Pão, bacon, milho, tomate, mega molho, mussarela, queijo, bife.', 'Mega Bacon', '14.00'),
(2, 'Pão, bacon, framgo, bife, milho, tomate, queijo, mussarela, mega molho', 'Mega FranBacon', '16.00'),
(5, 'Pão,batata,bife,frango,bacon,molho,tomate,queijo,presunto, picanhaaaaaaa', 'Mega Tudo', '19.00'),
(7, 'Pão, salsicha, milho, queijo, mega molho, tomate cozido, batatas fritas', 'Mega Dog', '12.00'),
(8, 'Frango, catupiri, queijo, milho, molho especial, batatas', 'Mega Torta de Frango', '8.00'),
(9, 'Chocolate, granulado, maracujá, doce de leite, creme de leite, leite condessado', 'Mega Trufa - Maracujá', '2.00'),
(10, 'Massa, Frango, Bacon, Calabresa, Queijo, Milho, Tomate, Picanha', 'Mega Pizza', '25.00');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Índices para tabela `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `FK29x9rbesibgjnudos2kjaqxax` (`cliente_id_cliente`);

--
-- Índices para tabela `pedidoproduto`
--
ALTER TABLE `pedidoproduto`
  ADD PRIMARY KEY (`idPedidoProduto`),
  ADD KEY `FKrhpjesajbj32h6gkcnjv12y67` (`pedido_id_pedido`),
  ADD KEY `FKlcuygcw6eqia2ii2s95kdq95t` (`produto_id_produto`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT de tabela `pedidoproduto`
--
ALTER TABLE `pedidoproduto`
  MODIFY `idPedidoProduto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id_produto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FK29x9rbesibgjnudos2kjaqxax` FOREIGN KEY (`cliente_id_cliente`) REFERENCES `cliente` (`id_cliente`);

--
-- Limitadores para a tabela `pedidoproduto`
--
ALTER TABLE `pedidoproduto`
  ADD CONSTRAINT `FKlcuygcw6eqia2ii2s95kdq95t` FOREIGN KEY (`produto_id_produto`) REFERENCES `produto` (`id_produto`),
  ADD CONSTRAINT `FKrhpjesajbj32h6gkcnjv12y67` FOREIGN KEY (`pedido_id_pedido`) REFERENCES `pedido` (`id_pedido`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
