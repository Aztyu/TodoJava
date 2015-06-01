-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 01 Juin 2015 à 18:09
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `projetjava`
--

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_text` text NOT NULL,
  `employee_id` int(11) NOT NULL,
  `todo_id` int(11) NOT NULL,
  `comment_date` datetime NOT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=58 ;

--
-- Contenu de la table `comment`
--

INSERT INTO `comment` (`comment_id`, `comment_text`, `employee_id`, `todo_id`, `comment_date`) VALUES
(49, 'Test de l''heure', 1, 1, '2015-05-30 18:06:19'),
(50, 'test de l''heure', 1, 1, '2015-05-30 18:09:30'),
(51, 'ssdjgkjdgkd', 2, 1, '2015-05-30 18:14:10'),
(52, 'Il est 18:18', 2, 3, '2015-05-30 18:18:14'),
(53, '<html>Il n''est plus utile</html><br>', 1, 8, '2015-05-31 10:12:05'),
(54, '<html>Le test est fini</html><br>', 1, 9, '2015-05-31 10:12:15'),
(55, '<html>dknbkdsnbjsdfn</html><br>', 1, 7, '2015-05-31 10:16:40'),
(56, '<html>ahadhrehe</html><br>', 1, 6, '2015-05-31 10:17:11'),
(57, 'Ainsi que les commentaires !!', 1, 5, '2015-05-31 10:17:44');

-- --------------------------------------------------------

--
-- Structure de la table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `employee_id` int(25) NOT NULL AUTO_INCREMENT,
  `employee_login` varchar(255) NOT NULL,
  `employee_passwd` varchar(255) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `employee`
--

INSERT INTO `employee` (`employee_id`, `employee_login`, `employee_passwd`) VALUES
(1, 'test', 'test'),
(2, 'Username', 'My password'),
(3, 'Corentin', 'test'),
(4, 'Aztyu', 'test'),
(6, 'Username1', 'My password');

-- --------------------------------------------------------

--
-- Structure de la table `manager`
--

CREATE TABLE IF NOT EXISTS `manager` (
  `manager_id` int(25) NOT NULL AUTO_INCREMENT,
  `manager_login` varchar(255) NOT NULL,
  `manager_passwd` varchar(255) NOT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `manager`
--

INSERT INTO `manager` (`manager_id`, `manager_login`, `manager_passwd`) VALUES
(1, 'admin', 'admin'),
(2, 'administrateur', 'test');

-- --------------------------------------------------------

--
-- Structure de la table `todo`
--

CREATE TABLE IF NOT EXISTS `todo` (
  `todo_id` int(11) NOT NULL AUTO_INCREMENT,
  `todo_text` text NOT NULL,
  `todo_isdone` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`todo_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `todo`
--

INSERT INTO `todo` (`todo_id`, `todo_text`, `todo_isdone`) VALUES
(1, 'Bonjour ceci est un test de todo, merci de le marquer comme fini en temps voulu', 0),
(2, 'Ceci est un test', 1),
(3, 'Ceci est un autre test', 0),
(4, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum varius arcu nisl, sollicitudin condimentum augue molestie nec. Cras fringilla, neque id sagittis viverra, elit lectus posuere justo, sit amet molestie sapien urna sed odio. Vivamus viverra ornare interdum. Praesent vulputate magna vitae dolor tempor, ac congue lorem pharetra. Aliquam rutrum felis a porttitor accumsan. Vestibulum id urna mauris. Nulla facilisi. Integer convallis neque non ex lobortis vulputate.\n\nFusce eu lectus enim. Ut consectetur vulputate nibh in blandit. Ut a tellus eu turpis tincidunt sodales. Mauris sit amet suscipit odio, id mattis risus. Praesent suscipit fringilla mi eu gravida. Praesent vel turpis pharetra, commodo sem nec, euismod ex. Nullam ut gravida nisi.\n\nDonec enim odio, tincidunt ut lacus in, convallis auctor felis. Donec scelerisque elementum dolor, quis eleifend ex commodo ac. Fusce ipsum lacus, vehicula at eros vitae, ultricies condimentum sem. In hendrerit vestibulum felis, id vulputate orci feugiat ut. Phasellus dictum massa eu faucibus malesuada. Integer consectetur lorem tempor eros tincidunt maximus. Cras eget dui dolor. Suspendisse pretium, elit ac tempus accumsan, est nulla lobortis velit, sed fermentum lacus leo in elit. Curabitur erat metus, luctus at sapien et, rhoncus sodales nisl.\n\nVivamus ac nulla a nisl facilisis consectetur quis vitae quam. Proin ornare luctus interdum. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla blandit luctus dolor, a eleifend tortor pellentesque ac. Suspendisse ornare magna non mauris consequat maximus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Quisque faucibus, mauris ac vulputate tempor, lorem risus vulputate nulla, in ultrices dui arcu quis magna. Maecenas dapibus venenatis neque et pulvinar. Donec nisi ligula, scelerisque nec nibh non, gravida molestie augue. Integer convallis quam sit amet risus scelerisque, mattis porttitor dolor ultricies. Curabitur porttitor nibh sit amet placerat venenatis. Sed mollis mi lectus, varius interdum tortor condimentum et. Nam ultricies ultrices lacinia. Mauris in justo id leo rhoncus rutrum.\n\nQuisque ultricies enim elit, quis auctor justo scelerisque eu. Proin congue, diam ut aliquam ultricies, libero dui tincidunt arcu, in sagittis nisi metus nec nisi. Aenean et sagittis orci. Etiam tristique rhoncus rutrum. Integer ligula nisl, lobortis eget felis a, rutrum malesuada orci. Integer varius, lorem in commodo luctus, est ante laoreet ex, sed porttitor sapien nulla id ligula. Aenean a laoreet enim. Morbi ac faucibus elit. Fusce ac mattis ligula, a iaculis lorem. Suspendisse potenti. Praesent pharetra luctus massa in bibendum. Proin auctor aliquam augue at tincidunt. Nunc sem lacus, rhoncus a faucibus eget, luctus non ante. Interdum et malesuada fames ac ante ipsum primis in faucibus.', 0),
(5, 'Bonjour et vive les tests', 0),
(6, '<html>sjdnvijanjvnaeijnvjksnjknksdnvjkndfjknvjknjnsjksjjdfjkdfjkdfjdkfjkdfjkdfjkdfjkfjkdfjkfjskg<br>jkjhghjgfsdjklasdagkjkafasdfafgjksdfajksdfsdfasdfaksdfahksdfahklsdfhklsdfsdfsdfajksdfadf<br>jsdfasdfajksdfa</html><br>', 1),
(7, '<html>aNFKNKVNKLSDNVKLNSDlnvknsdnvnskavklnsaklvnklsnvklnsdklnvknsdklvnksdnvklnsdlkvnsdklnvklsnvk<br>nsdklnvklsndkvnsknvklnskvnklsnvklsnvknsknvksnvksnvksnkvnlsknvklsnvklsnklvnslkdvn</html><br>', 1),
(8, '<html>Nouveau todo <h1>trop classe</h1> et tres utile </html><br>', 1),
(9, '<html><h1>Test</h1> ceci est un test de todo et de balise </html><br>', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
