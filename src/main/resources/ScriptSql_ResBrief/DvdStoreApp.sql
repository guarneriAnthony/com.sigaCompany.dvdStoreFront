-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : ven. 15 sep. 2023 à 16:42
-- Version du serveur : 8.0.34-0ubuntu0.22.04.1
-- Version de PHP : 8.1.2-1ubuntu2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `DvdStoreApp`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `email`, `name`) VALUES
(2, 'Marc@mail', 'Marc');

-- --------------------------------------------------------

--
-- Structure de la table `client_seq`
--

CREATE TABLE `client_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `client_seq`
--

INSERT INTO `client_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Structure de la table `dvd`
--

CREATE TABLE `dvd` (
  `id` bigint NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `quantity` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `dvd`
--

INSERT INTO `dvd` (`id`, `gender`, `name`, `price`, `quantity`) VALUES
(1, '+3', 'Winni', 29, 3),
(2, '+12', 'Tarzan', 29, 3),
(102, '+5', 'Bambi', 49, 8);

-- --------------------------------------------------------

--
-- Structure de la table `dvd_seq`
--

CREATE TABLE `dvd_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `dvd_seq`
--

INSERT INTO `dvd_seq` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Structure de la table `sell_entity`
--

CREATE TABLE `sell_entity` (
  `id` bigint NOT NULL,
  `client_id` bigint NOT NULL,
  `dvd_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `sell_entity_seq`
--

CREATE TABLE `sell_entity_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `sell_entity_seq`
--

INSERT INTO `sell_entity_seq` (`next_val`) VALUES
(1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `dvd`
--
ALTER TABLE `dvd`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `sell_entity`
--
ALTER TABLE `sell_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnpiw8rh4r3o5uy2f363wnb400` (`client_id`),
  ADD KEY `FK4oxrwo5qc9k1m0a5cdnlyvywk` (`dvd_id`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `sell_entity`
--
ALTER TABLE `sell_entity`
  ADD CONSTRAINT `FK4oxrwo5qc9k1m0a5cdnlyvywk` FOREIGN KEY (`dvd_id`) REFERENCES `dvd` (`id`),
  ADD CONSTRAINT `FKnpiw8rh4r3o5uy2f363wnb400` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
