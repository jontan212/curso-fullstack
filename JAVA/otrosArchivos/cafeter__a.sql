-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-06-2022 a las 15:37:56
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
-- Base de datos: `cafetería`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `camareros`
--

CREATE TABLE `camareros` (
  `ID_Camarero` varchar(4) COLLATE utf8_spanish_ci NOT NULL,
  `Nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `Contraseña` varchar(4) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `camareros`
--

INSERT INTO `camareros` (`ID_Camarero`, `Nombre`, `Contraseña`) VALUES
('1234', 'Juanjo', '0000'),
('4321', 'José Manuel', '8888'),
('9876', 'Patricia', '4444');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `desglose_venta`
--

CREATE TABLE `desglose_venta` (
  `ID_Ticket` int(4) NOT NULL,
  `ID_Producto` varchar(3) COLLATE utf8_spanish_ci NOT NULL,
  `Unidad` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `desglose_venta`
--

INSERT INTO `desglose_venta` (`ID_Ticket`, `ID_Producto`, `Unidad`) VALUES
(13, '001', 1),
(13, '003', 1),
(13, '004', 2),
(13, '008', 1),
(14, '004', 1),
(14, '005', 1),
(14, '009', 1),
(14, '010', 1),
(15, '003', 1),
(15, '008', 1),
(16, '003', 1),
(16, '004', 1),
(16, '005', 1),
(16, '010', 1),
(17, '010', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_mesa`
--

CREATE TABLE `detalle_mesa` (
  `ID_Ticket` int(4) NOT NULL,
  `ID_Camarero` varchar(4) COLLATE utf8_spanish_ci NOT NULL,
  `ID_Mesa` varchar(1) COLLATE utf8_spanish_ci NOT NULL,
  `Fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Total_Ticket` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `detalle_mesa`
--

INSERT INTO `detalle_mesa` (`ID_Ticket`, `ID_Camarero`, `ID_Mesa`, `Fecha`, `Total_Ticket`) VALUES
(13, '9876', '3', '2022-06-15 20:04:23', 13),
(14, '9876', '3', '2022-06-15 20:04:59', 6.75),
(15, '9876', '4', '2022-06-15 20:08:14', 8.5),
(16, '1234', '1', '2022-06-15 20:10:15', 6.25),
(17, '1234', '1', '2022-06-15 20:11:14', 1.5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesas`
--

CREATE TABLE `mesas` (
  `ID_Mesa` varchar(1) COLLATE utf8_spanish_ci NOT NULL,
  `Estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `mesas`
--

INSERT INTO `mesas` (`ID_Mesa`, `Estado`) VALUES
('1', 1),
('2', 0),
('3', 0),
('4', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `ID_Producto` varchar(3) COLLATE utf8_spanish_ci NOT NULL,
  `Nombre_Producto` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `Precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`ID_Producto`, `Nombre_Producto`, `Precio`) VALUES
('001', 'Aquarius Naranja', 2.5),
('003', 'Café con leche y bollo', 2),
('004', 'Capuccino', 1),
('005', 'Coca-Cola', 2.5),
('006', 'Café', 0.9),
('008', 'Hamburguesa', 6.5),
('009', 'Helado', 2.5),
('010', 'Infusión', 0.75),
('014', 'Tarta de chocolate', 4),
('016', 'Tarta de fresa', 4),
('019', 'Zumo de naranja', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `camareros`
--
ALTER TABLE `camareros`
  ADD PRIMARY KEY (`ID_Camarero`);

--
-- Indices de la tabla `desglose_venta`
--
ALTER TABLE `desglose_venta`
  ADD PRIMARY KEY (`ID_Ticket`,`ID_Producto`),
  ADD KEY `ID_Producto` (`ID_Producto`),
  ADD KEY `ID_Ticket` (`ID_Ticket`),
  ADD KEY `ID_Ticket_2` (`ID_Ticket`),
  ADD KEY `ID_Producto_2` (`ID_Producto`);

--
-- Indices de la tabla `detalle_mesa`
--
ALTER TABLE `detalle_mesa`
  ADD PRIMARY KEY (`ID_Ticket`),
  ADD KEY `ID_Camarero` (`ID_Camarero`),
  ADD KEY `ID_Mesa` (`ID_Mesa`),
  ADD KEY `ID_Mesa_2` (`ID_Mesa`);

--
-- Indices de la tabla `mesas`
--
ALTER TABLE `mesas`
  ADD PRIMARY KEY (`ID_Mesa`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`ID_Producto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalle_mesa`
--
ALTER TABLE `detalle_mesa`
  MODIFY `ID_Ticket` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `desglose_venta`
--
ALTER TABLE `desglose_venta`
  ADD CONSTRAINT `desglose_venta_ibfk_1` FOREIGN KEY (`ID_Producto`) REFERENCES `productos` (`ID_Producto`),
  ADD CONSTRAINT `desglose_venta_ibfk_2` FOREIGN KEY (`ID_Ticket`) REFERENCES `detalle_mesa` (`ID_Ticket`);

--
-- Filtros para la tabla `detalle_mesa`
--
ALTER TABLE `detalle_mesa`
  ADD CONSTRAINT `detalle_mesa_ibfk_1` FOREIGN KEY (`ID_Camarero`) REFERENCES `camareros` (`ID_Camarero`),
  ADD CONSTRAINT `detalle_mesa_ibfk_2` FOREIGN KEY (`ID_Mesa`) REFERENCES `mesas` (`ID_Mesa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
