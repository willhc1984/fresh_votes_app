-- MySQL dump 10.13  Distrib 5.7.35, for Win64 (x86_64)
--
-- Host: localhost    Database: fresh_votes
-- ------------------------------------------------------
-- Server version	5.7.35-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `tb_authorities`
--

LOCK TABLES `tb_authorities` WRITE;
/*!40000 ALTER TABLE `tb_authorities` DISABLE KEYS */;
INSERT INTO `tb_authorities` VALUES (1,'ROLE_OWNER',1),(2,'ROLE_OWNER',2),(3,'ROLE_OWNER',3),(4,'ROLE_USER',4),(5,'ROLE_USER',5),(6,'ROLE_USER',6);
/*!40000 ALTER TABLE `tb_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_comments`
--

LOCK TABLES `tb_comments` WRITE;
/*!40000 ALTER TABLE `tb_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_features`
--

LOCK TABLES `tb_features` WRITE;
/*!40000 ALTER TABLE `tb_features` DISABLE KEYS */;
INSERT INTO `tb_features` VALUES (1,'Permitir que o usuário saiba quem visitou seu perfil.','Pending review','Visitantes',1,1),(2,'Aumentar numero de likes para não assinantes.','Pending review','Likes ',2,1),(3,'Saber quem visitou seu perfil.','Pending review','Perfil',2,1),(4,'Permitir que o usuário ocultar se esta online.','Pending review','Usuario online',3,1),(5,'Permitir aos usuários enviar gifs animados nas mensagens.','Pending review','Gifs animados',3,1),(6,'Permitir que o usuário envie qualquer tipo de arquivo para outros usuários.','Pending review','Envio de documentos',3,1),(7,'Recomendar melhores vagas de empregos ao usuário.','Pending review','Vagas de emprego',4,1),(8,'Área de inclusão certificados para o perfil.','Pending review','Certificados',4,1),(9,'Usuários conta premium poderá anunciar vagas de emprego.','Pending review','Anuncios',4,1),(10,'Habilitar filtros nas postagens de fotos.','Pending review','Filtros',5,1),(11,'Habilitar ícone de dislike em postagens.','Pending review','Dislike',5,1),(12,'Mostrar a contagem de dislikes para postagens.','Pending review','Visualizar dislike',6,1),(13,'Usuários de conta premium podem baixar os vídeos da plataforma.','Pending review','Baixar videos',6,1),(14,'Habilitar botão para usuário visualizar o vídeo em horário definido.','Pending review','Visualizar mais tarde',6,1),(15,'Usuários poderão anunciar seus produtos na plataforma.','Pending review','Anuncios',1,1),(16,'Backup automático das mensagens mais antigas.','Pending review','Backup',7,2),(17,'Arquivos em anexo poderão ter ate 250mb.','Pending review','Anexos de arquivos',7,2),(18,'E-mails suspeitos cairão diretamente na caixa de spam.','Pending review','Emails suspeitos',7,2),(19,'Exibição de anúncios de lojas ao redor do local de check-in.','Pending review','Anuncios',8,2),(20,'Check-in poderá ser realizado em até 40 min.','Pending review','Tempo de check-in',8,2),(21,'Integrar com API do aplicativo Strava.','Pending review','Integração com strava',8,2),(22,'Disponibilização de API para programadores.','Pending review','API',9,2),(23,'Integração com Linkedin para facilitar recrutamento e seleção.','Pending review','Integração com Linkedin',9,2),(24,'Mostrar as avaliações dos motoristas da plataforma.','Pending review','Reputação de motoristas',10,2),(25,'Motorista poderá escolher homem,mulher ou ambos para as corridas.','Pending review','Seleção de passageiros',10,2),(26,'Passageiros poderão avaliar o motorista no critério de até 5 estrelas.','Pending review','Avaliações',10,2),(27,'Limitar o numero de postagens de mulheres que rebolam demais.','Pending review','Limitação em postagens',11,3),(28,'Habilitar contagem de dislikes para postagens.','Pending review','Dislike',11,3),(29,'Permitir aos usuários excluir comentários maldosos de suas postagens.','Pending review','Excluir comentários maldosos',11,3),(30,'Permitir usuários denunciar perfis fake e hostis na plataforma.','Pending review','Denunciar perfil',11,3),(31,'Habilitar envio de qualquer tipo de arquivo.','Pending review','Envio de arquivos',12,3),(32,'Permitir ao usuário desativar confirmação de leitura de mensagem.','Pending review','Desativar visualização',12,3),(33,'Permite recomendar musicas para os amigos.','Pending review','Recomendar musicas ',13,3),(34,'Sem exibição de propagandas para usuários premium.','Pending review','Usuários premium',13,3),(35,'Limitar tempo das postagens para 10 minutos, no minimo.','Pending review','Limitar tempo',14,3),(36,'Aplicar filtro para mensagens com conteúdo improprio.','Pending review','Filtros para mensagens',15,3),(37,'fg','ghf','gfh',11,4);
/*!40000 ALTER TABLE `tb_features` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_products`
--

LOCK TABLES `tb_products` WRITE;
/*!40000 ALTER TABLE `tb_products` DISABLE KEYS */;
INSERT INTO `tb_products` VALUES (1,'Facebook',1,1),(2,'Tinder',1,1),(3,'WhatsApp',1,1),(4,'Linkedin',1,1),(5,'Instagram',1,1),(6,'Youtube',1,1),(7,'Gmail',1,2),(8,'Gympass',1,2),(9,'Github',1,2),(10,'Uber',0,2),(11,'Tik-Tok',0,3),(12,'Telegram',0,3),(13,'Spotfy',0,3),(14,'Snapchat',0,3),(15,'Messenger',0,3);
/*!40000 ALTER TABLE `tb_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_users`
--

LOCK TABLES `tb_users` WRITE;
/*!40000 ALTER TABLE `tb_users` DISABLE KEYS */;
INSERT INTO `tb_users` VALUES (1,'admin','$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK','admin@master'),(2,'maria','$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK','maria@maria'),(3,'joao','$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK','joao@joao'),(4,'marcos','$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK','marcos@marcos'),(5,'ana','$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK','ana@ana'),(6,'pedro','$2a$12$CtVEGjY3UJUJB91S5OrJjOxFIOQ9h1TGxrMAMWkBJOVMDQ11fq6RK','pedro@pedro');
/*!40000 ALTER TABLE `tb_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tb_votes`
--

LOCK TABLES `tb_votes` WRITE;
/*!40000 ALTER TABLE `tb_votes` DISABLE KEYS */;
INSERT INTO `tb_votes` VALUES (_binary '',1,1),(_binary '',1,4),(_binary '',1,5),(_binary '',1,6),(_binary '',2,1),(_binary '',2,2),(_binary '\0',2,3),(_binary '',2,4),(_binary '',2,6),(_binary '\0',3,2),(_binary '\0',3,3),(_binary '',3,4),(_binary '\0',3,5),(_binary '',3,6),(_binary '',4,1),(_binary '\0',4,2),(_binary '\0',4,3),(_binary '',4,4),(_binary '',5,2),(_binary '\0',5,5),(_binary '',5,6),(_binary '\0',6,1),(_binary '\0',6,2),(_binary '',6,5),(_binary '\0',6,6),(_binary '\0',14,1),(_binary '',14,3),(_binary '',21,6),(_binary '\0',24,6),(_binary '',26,1),(_binary '\0',27,3),(_binary '\0',27,6),(_binary '',30,5),(_binary '\0',32,1),(_binary '',32,2),(_binary '',32,3),(_binary '\0',32,5),(_binary '',33,3),(_binary '\0',33,4),(_binary '',33,6),(_binary '',34,2),(_binary '\0',35,2),(_binary '',36,1),(_binary '\0',36,2),(_binary '',36,3),(_binary '',37,2),(_binary '\0',37,4),(_binary '\0',37,5),(_binary '\0',37,6);
/*!40000 ALTER TABLE `tb_votes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-08  9:52:27
