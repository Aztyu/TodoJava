-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 05 Juin 2015 à 18:52
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=89 ;

--
-- Contenu de la table `comment`
--

INSERT INTO `comment` (`comment_id`, `comment_text`, `employee_id`, `todo_id`, `comment_date`) VALUES
(81, '<html>Ceci est un test commentaire</html><br>', 1, 16, '2015-06-05 18:35:22'),
(82, '<html>tstcgtcve</html><br>', 1, 16, '2015-06-05 18:36:00'),
(83, '<html>test pseudo comment</html><br>', 1, 16, '2015-06-05 18:39:51'),
(84, '<html>test comment<br></html><br>', 2, 16, '2015-06-05 18:48:12'),
(85, '<html>test</html><br>', 2, 14, '2015-06-05 18:49:40'),
(86, '<html>test</html><br>', 2, 16, '2015-06-05 18:49:50'),
(87, '<html>test</html><br>', 2, 15, '2015-06-05 18:49:56'),
(88, '<html>C''est un joli todo !</html><br>', 1, 17, '2015-06-05 18:50:51');

-- --------------------------------------------------------

--
-- Structure de la table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `employee_id` int(25) NOT NULL AUTO_INCREMENT,
  `employee_login` varchar(255) NOT NULL,
  `employee_passwd` varchar(255) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `employee`
--

INSERT INTO `employee` (`employee_id`, `employee_login`, `employee_passwd`) VALUES
(1, 'test', 'test'),
(2, 'Username', 'My password'),
(3, 'Corentin', 'test'),
(4, 'Aztyu', 'test'),
(6, 'Username1', 'My password'),
(7, 'alexandre', 'alexandre');

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
  `todo_date` datetime NOT NULL,
  PRIMARY KEY (`todo_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Contenu de la table `todo`
--

INSERT INTO `todo` (`todo_id`, `todo_text`, `todo_isdone`, `todo_date`) VALUES
(14, '<html>Ceci est un test</html><br>', 0, '2015-06-03 00:00:00'),
(15, '<html>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam convallis sem metus, laci<br>ia suscipit nunc dapibus eu. Ut auctor pretium neque, non egestas orci vehicula eu. Etia<br> volutpat orci non magna vulputate venenatis. Integer finibus nisl sit amet mi tincidunt<br> vitae convallis lorem facilisis. Integer porta commodo augue, et scelerisque arcu euism<br>d at. Vivamus semper eu nulla in porta. Etiam lacinia pretium accumsan.<br><br>Pellentesque ac dui dui. Nullam finibus tellus eu nunc aliquet hendrerit. Nullam auctor au<br>ue quis nisl luctus, non tincidunt nulla ullamcorper. Sed placerat, enim et dignissim pr<br>tium, nisl felis placerat erat, vitae luctus nibh elit in dui. Curabitur sed enim consec<br>etur lectus sodales vehicula sed ut velit. Suspendisse purus velit, fringilla eu ultrice<br> posuere, ornare non augue. Fusce semper tellus non ex feugiat molestie. Cras consequat <br>ccumsan felis, in egestas neque facilisis eget. Etiam tincidunt pretium turpis, interdum<br>accumsan nisl lacinia vitae. Ut vitae consectetur lectus, sit amet lobortis lectus. Maur<br>s auctor non orci sed imperdiet. In ullamcorper sapien felis, eget sagittis eros laoreet<br>vitae. Mauris rhoncus lobortis mi eget ultrices. Nulla varius metus neque, ac fermentum <br>olor imperdiet sit amet. Praesent tristique erat nulla, et efficitur ex aliquet vel. Mae<br>enas ultrices nec ex sed accumsan.<br><br>Maecenas turpis massa, bibendum at accumsan sit amet, fermentum et neque. Nulla finibus an<br>e ante, aliquam ullamcorper enim rhoncus a. Maecenas pharetra dui sit amet est rhoncus, <br>uis euismod eros pellentesque. Duis eu ipsum in purus laoreet volutpat. Nunc aliquam jus<br>o et sapien viverra, a malesuada nibh ornare. Aenean vitae est tincidunt, mattis sapien <br>uis, egestas augue. Ut eget lacus et sem ultricies consectetur. Praesent id mi dictum, p<br>rta leo non, finibus arcu. Fusce dictum nisi eu mollis condimentum. Etiam interdum, orci<br>non mattis dignissim, dui ante fringilla leo, ut congue lorem sem a lectus. Etiam cursus<br>malesuada lorem vel hendrerit. Duis tincidunt placerat lobortis. Nunc pretium laoreet an<br>e. Sed eget tellus et nisl tincidunt ullamcorper. Nullam erat lacus, faucibus vitae tell<br>s non, ultrices gravida sapien. Aliquam faucibus orci nec laoreet dictum.<br><br>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egest<br>s. Pellentesque mattis velit a odio facilisis pulvinar. Pellentesque eu urna purus. Pell<br>ntesque sit amet dignissim dui. Nam sed ante ante. Quisque eu quam nisl. Nunc dictum ele<br>entum euismod. Donec purus mi, lobortis non iaculis ac, tincidunt ac nibh. Curabitur ele<br>entum augue at porta varius. Vestibulum id sem leo.<br><br>In quis dolor magna. Cras cursus ut mauris quis euismod. Vivamus elit elit, lacinia effici<br>ur iaculis ut, finibus semper elit. Fusce pellentesque pulvinar interdum. Sed gravida fe<br>giat libero et placerat. Donec ac diam eu nisi pharetra rhoncus. Etiam leo ligula, facil<br>sis sed pulvinar eget, cursus in orci. Fusce semper odio sit amet justo dignissim mollis<br> Donec tempor neque molestie quam posuere, et rhoncus mi scelerisque. Nullam varius posu<br>re fermentum. Aenean consequat magna sed mi porta, id faucibus ex dapibus. Praesent matt<br>s justo ligula, id tincidunt ipsum semper non. Quisque elementum massa non felis condime<br>tum, id scelerisque est egestas. Aenean vitae mi ac dolor maximus consectetur.</html>', 0, '2015-06-02 00:00:00'),
(16, '<html>test date 05/06/2015 18h35</html><br>', 0, '2015-06-05 18:35:08'),
(17, '<html><h1>test</h1> balises html</html><br>', 0, '2015-06-05 18:50:22');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
