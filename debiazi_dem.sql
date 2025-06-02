-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-06-2025 a las 01:26:41
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `debiazi_dem`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE `autor` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `biografia` varchar(1500) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`id`, `apellido`, `biografia`, `nombre`) VALUES
(1, 'Ruiz Zafón', 'Autor español conocido por \'La Sombra del Viento\'.', 'Carlos'),
(2, 'Wells', 'Escritor británico, pionero de la ciencia ficción moderna.', 'H.G.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor_aud`
--

CREATE TABLE `autor_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `biografia` varchar(1500) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `autor_aud`
--

INSERT INTO `autor_aud` (`id`, `rev`, `revtype`, `apellido`, `biografia`, `nombre`) VALUES
(1, 1, 0, 'Ruiz Zafón', 'Autor español conocido por \'La Sombra del Viento\'.', 'Carlos'),
(2, 3, 0, 'Wells', 'Escritor británico, pionero de la ciencia ficción moderna.', 'H.G.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `domicilio`
--

CREATE TABLE `domicilio` (
  `id` bigint(20) NOT NULL,
  `calle` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `fk_localidad` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `domicilio`
--

INSERT INTO `domicilio` (`id`, `calle`, `numero`, `fk_localidad`) VALUES
(2, 'Av. Siempre Viva', 742, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `domicilio_aud`
--

CREATE TABLE `domicilio_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `calle` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `fk_localidad` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `domicilio_aud`
--

INSERT INTO `domicilio_aud` (`id`, `rev`, `revtype`, `calle`, `numero`, `fk_localidad`) VALUES
(2, 52, 0, 'Av. Siempre Viva', 742, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `id` bigint(20) NOT NULL,
  `fecha` int(11) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `paginas` int(11) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`id`, `fecha`, `genero`, `paginas`, `titulo`) VALUES
(1, 2020, 'Fantasía', 320, 'El Viaje Eterno'),
(2, 1895, 'Ciencia Ficción', 180, 'La Máquina del Tiempo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro_aud`
--

CREATE TABLE `libro_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `fecha` int(11) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `paginas` int(11) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro_aud`
--

INSERT INTO `libro_aud` (`id`, `rev`, `revtype`, `fecha`, `genero`, `paginas`, `titulo`) VALUES
(1, 4, 0, 2020, 'Fantasía', 320, 'El Viaje Eterno'),
(2, 5, 0, 1895, 'Ciencia Ficción', 180, 'La Máquina del Tiempo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro_autores`
--

CREATE TABLE `libro_autores` (
  `libro_id` bigint(20) NOT NULL,
  `autores_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro_autores`
--

INSERT INTO `libro_autores` (`libro_id`, `autores_id`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro_autores_aud`
--

CREATE TABLE `libro_autores_aud` (
  `rev` int(11) NOT NULL,
  `libro_id` bigint(20) NOT NULL,
  `autores_id` bigint(20) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro_autores_aud`
--

INSERT INTO `libro_autores_aud` (`rev`, `libro_id`, `autores_id`, `revtype`) VALUES
(4, 1, 1, 0),
(5, 2, 2, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localidad`
--

CREATE TABLE `localidad` (
  `id` bigint(20) NOT NULL,
  `denominacion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `localidad`
--

INSERT INTO `localidad` (`id`, `denominacion`) VALUES
(1, 'Springfield');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localidad_aud`
--

CREATE TABLE `localidad_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `denominacion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `localidad_aud`
--

INSERT INTO `localidad_aud` (`id`, `rev`, `revtype`, `denominacion`) VALUES
(1, 2, 0, 'Springfield');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `fk_domicilio` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `apellido`, `dni`, `nombre`, `fk_domicilio`) VALUES
(2, 'Pérez', 34999888, 'Laura', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_aud`
--

CREATE TABLE `persona_aud` (
  `id` bigint(20) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `fk_domicilio` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona_aud`
--

INSERT INTO `persona_aud` (`id`, `rev`, `revtype`, `apellido`, `dni`, `nombre`, `fk_domicilio`) VALUES
(2, 52, 0, 'Pérez', 34999888, 'Laura', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_libro`
--

CREATE TABLE `persona_libro` (
  `persona_id` bigint(20) NOT NULL,
  `libro_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona_libro`
--

INSERT INTO `persona_libro` (`persona_id`, `libro_id`) VALUES
(2, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_libro_aud`
--

CREATE TABLE `persona_libro_aud` (
  `rev` int(11) NOT NULL,
  `persona_id` bigint(20) NOT NULL,
  `libro_id` bigint(20) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona_libro_aud`
--

INSERT INTO `persona_libro_aud` (`rev`, `persona_id`, `libro_id`, `revtype`) VALUES
(52, 2, 1, 0),
(52, 2, 2, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `revision_info`
--

CREATE TABLE `revision_info` (
  `id` int(11) NOT NULL,
  `revision_date` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `revision_info`
--

INSERT INTO `revision_info` (`id`, `revision_date`) VALUES
(1, '2025-06-01 20:16:34.000000'),
(2, '2025-06-01 20:16:57.000000'),
(3, '2025-06-01 20:17:09.000000'),
(4, '2025-06-01 20:17:42.000000'),
(5, '2025-06-01 20:17:49.000000'),
(52, '2025-06-01 20:25:31.000000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seq_revision_id`
--

CREATE TABLE `seq_revision_id` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `seq_revision_id`
--

INSERT INTO `seq_revision_id` (`next_val`) VALUES
(151);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `autor_aud`
--
ALTER TABLE `autor_aud`
  ADD PRIMARY KEY (`rev`,`id`);

--
-- Indices de la tabla `domicilio`
--
ALTER TABLE `domicilio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsq48s35e5o185ajo3mloiqxjk` (`fk_localidad`);

--
-- Indices de la tabla `domicilio_aud`
--
ALTER TABLE `domicilio_aud`
  ADD PRIMARY KEY (`rev`,`id`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `libro_aud`
--
ALTER TABLE `libro_aud`
  ADD PRIMARY KEY (`rev`,`id`);

--
-- Indices de la tabla `libro_autores`
--
ALTER TABLE `libro_autores`
  ADD KEY `FK4n6u17jdtrjai8yitxsmm7tly` (`autores_id`),
  ADD KEY `FKsoheqe18ertlksjno9y33x0am` (`libro_id`);

--
-- Indices de la tabla `libro_autores_aud`
--
ALTER TABLE `libro_autores_aud`
  ADD PRIMARY KEY (`libro_id`,`rev`,`autores_id`),
  ADD KEY `FK3ob89ixgsd42wwpgwmfp31v18` (`rev`);

--
-- Indices de la tabla `localidad`
--
ALTER TABLE `localidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `localidad_aud`
--
ALTER TABLE `localidad_aud`
  ADD PRIMARY KEY (`rev`,`id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKtf82o8p6mim2vdcl7kh56jltw` (`fk_domicilio`);

--
-- Indices de la tabla `persona_aud`
--
ALTER TABLE `persona_aud`
  ADD PRIMARY KEY (`rev`,`id`);

--
-- Indices de la tabla `persona_libro`
--
ALTER TABLE `persona_libro`
  ADD UNIQUE KEY `UKklwo566p2xgu8txcyls6vx0ai` (`libro_id`),
  ADD KEY `FKd8c57cn01g1qhcax4yanhi2o4` (`persona_id`);

--
-- Indices de la tabla `persona_libro_aud`
--
ALTER TABLE `persona_libro_aud`
  ADD PRIMARY KEY (`persona_id`,`rev`,`libro_id`),
  ADD KEY `FKjbftjxxjxf1q7woqa3gxgvmr` (`rev`);

--
-- Indices de la tabla `revision_info`
--
ALTER TABLE `revision_info`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autor`
--
ALTER TABLE `autor`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `domicilio`
--
ALTER TABLE `domicilio`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `localidad`
--
ALTER TABLE `localidad`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `autor_aud`
--
ALTER TABLE `autor_aud`
  ADD CONSTRAINT `FKr81sephxfyvqkjffreeeunf0s` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);

--
-- Filtros para la tabla `domicilio`
--
ALTER TABLE `domicilio`
  ADD CONSTRAINT `FKsq48s35e5o185ajo3mloiqxjk` FOREIGN KEY (`fk_localidad`) REFERENCES `localidad` (`id`);

--
-- Filtros para la tabla `domicilio_aud`
--
ALTER TABLE `domicilio_aud`
  ADD CONSTRAINT `FKr2va00h51h6v43r7txxpov81` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);

--
-- Filtros para la tabla `libro_aud`
--
ALTER TABLE `libro_aud`
  ADD CONSTRAINT `FK4w9s9iy7nnmjlyvmdh4f2dw7c` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);

--
-- Filtros para la tabla `libro_autores`
--
ALTER TABLE `libro_autores`
  ADD CONSTRAINT `FK4n6u17jdtrjai8yitxsmm7tly` FOREIGN KEY (`autores_id`) REFERENCES `autor` (`id`),
  ADD CONSTRAINT `FKsoheqe18ertlksjno9y33x0am` FOREIGN KEY (`libro_id`) REFERENCES `libro` (`id`);

--
-- Filtros para la tabla `libro_autores_aud`
--
ALTER TABLE `libro_autores_aud`
  ADD CONSTRAINT `FK3ob89ixgsd42wwpgwmfp31v18` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);

--
-- Filtros para la tabla `localidad_aud`
--
ALTER TABLE `localidad_aud`
  ADD CONSTRAINT `FK7ifunt3yuv3bghhcv86k1s75y` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `FKdvcd83wmvj0mwmbu3kyoisobn` FOREIGN KEY (`fk_domicilio`) REFERENCES `domicilio` (`id`);

--
-- Filtros para la tabla `persona_aud`
--
ALTER TABLE `persona_aud`
  ADD CONSTRAINT `FK3nishbkv6n49yoqu3eugomin` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);

--
-- Filtros para la tabla `persona_libro`
--
ALTER TABLE `persona_libro`
  ADD CONSTRAINT `FK6oar3k71e0huyyjlxd0a8qnct` FOREIGN KEY (`libro_id`) REFERENCES `libro` (`id`),
  ADD CONSTRAINT `FKd8c57cn01g1qhcax4yanhi2o4` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`);

--
-- Filtros para la tabla `persona_libro_aud`
--
ALTER TABLE `persona_libro_aud`
  ADD CONSTRAINT `FKjbftjxxjxf1q7woqa3gxgvmr` FOREIGN KEY (`rev`) REFERENCES `revision_info` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
