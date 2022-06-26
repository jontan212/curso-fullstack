-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-06-2022 a las 20:56:36
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistema_de_quejas`
--
CREATE DATABASE IF NOT EXISTS `sistema_de_quejas` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `sistema_de_quejas`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distritos`
--

CREATE TABLE `distritos` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `mapa` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `distritos`
--

INSERT INTO `distritos` (`codigo`, `nombre`, `mapa`) VALUES
(1, 'Moncloa', 'moncloa.gif'),
(2, 'Salamanca', 'salamanca.jpg'),
(3, 'Retiro', 'retiro.jpg'),
(4, 'Arganzuela', 'arganzuela.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `quejas`
--

CREATE TABLE `quejas` (
  `codigo` int(11) NOT NULL,
  `sexo` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `tipo_de_queja` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `x` int(11) NOT NULL,
  `y` int(11) NOT NULL,
  `codigo_distrito` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `quejas`
--

INSERT INTO `quejas` (`codigo`, `sexo`, `tipo_de_queja`, `descripcion`, `x`, `y`, `codigo_distrito`) VALUES
(1, 'hombre', 'Social', 'primera queja de tipo social', 334, 357, 3),
(2, 'hombre', 'Conflictiva', 'Tengo un problema conflictivo en el hospital', 310, 191, 3),
(3, 'mujer', 'Ambiental', 'tengo un problema ambiental', 530, 266, 3),
(4, 'hombre', 'Ambiental', 'problema tipo ambiental en moncloa', 495, 289, 1),
(5, 'mujer', 'Conflictiva', 'problema conflictivo', 446, 265, 4),
(6, 'hombre', 'Conflictiva', 'vrvrrtvewsevrtevtrv', 122, 210, 4),
(7, 'hombre', 'Social', 'cecffefdedxexc', 171, 276, 3),
(8, 'hombre', 'Ambiental', 'xdexedx', 583, 130, 1),
(9, 'mujer', 'Conflictiva', 'cedcxdec', 94, 184, 1),
(10, 'hombre', 'Social', 'dxexexe', 150, 127, 3),
(11, 'hombre', 'Ambiental', 'cexexecx', 278, 87, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `distritos`
--
ALTER TABLE `distritos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `quejas`
--
ALTER TABLE `quejas`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `codigo_distrito` (`codigo_distrito`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `distritos`
--
ALTER TABLE `distritos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `quejas`
--
ALTER TABLE `quejas`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `quejas`
--
ALTER TABLE `quejas`
  ADD CONSTRAINT `quejas_ibfk_1` FOREIGN KEY (`codigo_distrito`) REFERENCES `distritos` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
