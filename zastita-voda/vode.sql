/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     6/11/2018 19:55:34                           */
/*==============================================================*/
SET FOREIGN_KEY_CHECKS = 0;

drop table if exists DOKUMENT;

drop table if exists INSPEKCIJSKI_PREGLED;

drop table if exists KORISNIK;

drop table if exists LICENSA;

drop table if exists MERENJE_KVALITETA;

drop table if exists OPERATER;

drop table if exists PARAMETAR_MERENJA;

drop table if exists POVLACENJE_LICENSE;

drop table if exists PRAVNO_LICE;

drop table if exists PRIJAVA_ZA_INSPEKCIJSKI_PREGLED;

drop table if exists TIP_DOKUMENTA;

drop table if exists TIP_LICENSE;

drop table if exists TIP_PARAMETRA;

drop table if exists VODNI_RESURS;

drop table if exists ZAHTEV_ZA_LICENSU;

/*==============================================================*/
/* Table: DOKUMENT                                              */
/*==============================================================*/
create table DOKUMENT
(
   ID_DOKUMENTA         int not null AUTO_INCREMENT,
   SIFRA_TIPA_DOKUMENTA char(4) not null,
   SADRZAJ_DOKUMENTA    text not null,
   primary key (ID_DOKUMENTA)
);

/*==============================================================*/
/* Table: INSPEKCIJSKI_PREGLED                                  */
/*==============================================================*/
create table INSPEKCIJSKI_PREGLED
(
   ID_PREGLEDA          int not null AUTO_INCREMENT,
   ID_PRIJAVE           int not null,
   DATUM_PREGLEDA       datetime not null,
   IZVESTAJ_PREGLEDA    varchar(2048) not null,
   IME_INSPEKTORA       varchar(255) not null,
   primary key (ID_PREGLEDA)
);

/*==============================================================*/
/* Table: KORISNIK                                              */
/*==============================================================*/
create table KORISNIK
(
   PIB_PRAVNOG_LICA     char(9) not null,
   MATICNI_BROJ_PREDUZECA char(8) not null,
   ID_KORISNIKA         int not null AUTO_INCREMENT,
   LOZINKA_KORISNIKA    varchar(255) not null,
   PRISTUP_ZABRANJEN    bool not null,
   primary key (ID_KORISNIKA)
);

/*==============================================================*/
/* Table: LICENSA                                               */
/*==============================================================*/
create table LICENSA
(
   ID_LICENSE           int not null AUTO_INCREMENT,
   ID_ZAHTEVA           int not null,
   DATUM_IZDAVANJA_LICENSE datetime not null,
   MESTO_IZDAVANJA_LICENSE varchar(255) not null,
   DATUM_ISTICANJA_LICENSE datetime not null,
   primary key (ID_LICENSE)
);

/*==============================================================*/
/* Table: MERENJE_KVALITETA                                     */
/*==============================================================*/
create table MERENJE_KVALITETA
(
   ID_MERENJA           int not null AUTO_INCREMENT,
   ID_VODNOG_RESURSA    int not null,
   DATUM_MERENJA        datetime,
   primary key (ID_MERENJA)
);

/*==============================================================*/
/* Table: OPERATER                                              */
/*==============================================================*/
create table OPERATER
(
   ID_OPERATERA         int not null AUTO_INCREMENT,
   EMAIL_OPERATERA      varchar(255) not null,
   LOZINKA_OPERATERA    varchar(255) not null,
   ADMINISTRATOR        bool not null,
   primary key (ID_OPERATERA)
);

/*==============================================================*/
/* Table: PARAMETAR_MERENJA                                     */
/*==============================================================*/
create table PARAMETAR_MERENJA
(
   SIFRA_PARAMETRA      char(4) not null,
   ID_MERENJA           int not null,
   VREDNOST_PARAMETRA_MERENJA decimal(5,5) not null,
   primary key (SIFRA_PARAMETRA, ID_MERENJA)
);

/*==============================================================*/
/* Table: POVLACENJE_LICENSE                                    */
/*==============================================================*/
create table POVLACENJE_LICENSE
(
   ID_LICENSE           int not null,
   DATUM_POVLACENJA_LICENSE datetime not null,
   RAZLOG_POVLACENJA_LICENSE varchar(255) not null,
   primary key (ID_LICENSE)
);

/*==============================================================*/
/* Table: PRAVNO_LICE                                           */
/*==============================================================*/
create table PRAVNO_LICE
(
   PIB_PRAVNOG_LICA     char(9) not null,
   MATICNI_BROJ_PREDUZECA char(8) not null,
   NAZIV_PRAVNOG_LICA   varchar(255) not null,
   SEDISTE_PRAVNOG_LICA varchar(255) not null,
   TIP_PREDUZECA        varchar(255) not null,
   primary key (PIB_PRAVNOG_LICA, MATICNI_BROJ_PREDUZECA)
);

/*==============================================================*/
/* Table: PRIJAVA_ZA_INSPEKCIJSKI_PREGLED                       */
/*==============================================================*/
create table PRIJAVA_ZA_INSPEKCIJSKI_PREGLED
(
   ID_PRIJAVE           int not null AUTO_INCREMENT,
   ID_VODNOG_RESURSA    int not null,
   DATUM_PRIJAVE_ZA_INSPEKCIJU datetime not null,
   RAZLOG_PRIJAVE_ZA_INSPEKCIJU varchar(255) not null,
   IME_PRIJAVLJIVACA    varchar(255),
   PRIJAVA_ODOBRENA     bool,
   DATUM_ODLUKE_ZA_PRIJAVU_INSPEKCIJE datetime,
   primary key (ID_PRIJAVE)
);

/*==============================================================*/
/* Table: TIP_DOKUMENTA                                         */
/*==============================================================*/
create table TIP_DOKUMENTA
(
   SIFRA_TIPA_DOKUMENTA char(4) not null,
   NAZIV_TIPA_DOKUMENTA varchar(255) not null,
   primary key (SIFRA_TIPA_DOKUMENTA)
);

/*==============================================================*/
/* Table: TIP_LICENSE                                           */
/*==============================================================*/
create table TIP_LICENSE
(
   SIFRA_TIPA_LICENSE   char(4) not null,
   NAZIV_TIPA_LICENSE   varchar(255) not null,
   primary key (SIFRA_TIPA_LICENSE)
);

/*==============================================================*/
/* Table: TIP_PARAMETRA                                         */
/*==============================================================*/
create table TIP_PARAMETRA
(
   SIFRA_PARAMETRA      char(4) not null,
   NAZIV_TIPA_PARAMETRA varchar(255) not null,
   MINIMALNA_STANDARDNA_VREDNOST_PARAMETRA decimal(5,5) not null,
   MAKSIMALNA_STANDARDNA_VREDNOST_PARAMETRA decimal(5,5) not null,
   primary key (SIFRA_PARAMETRA)
);

/*==============================================================*/
/* Table: VODNI_RESURS                                          */
/*==============================================================*/
create table VODNI_RESURS
(
   ID_VODNOG_RESURSA    int not null AUTO_INCREMENT,
   NAZIV_VODNOG_RESURSA varchar(255) not null,
   LOKACIJA_VODNOG_RESURSA varchar(255) not null,
   primary key (ID_VODNOG_RESURSA)
);

/*==============================================================*/
/* Table: ZAHTEV_ZA_LICENSU                                     */
/*==============================================================*/
create table ZAHTEV_ZA_LICENSU
(
   ID_ZAHTEVA           int not null AUTO_INCREMENT,
   PIB_PRAVNOG_LICA     char(9) not null,
   MATICNI_BROJ_PREDUZECA char(8) not null,
   ID_VODNOG_RESURSA    int not null,
   SIFRA_TIPA_LICENSE   char(4) not null,
   DATUM_ZAHTEVA        datetime not null,
   ZAHTEV_PRIHVACEN     bool,
   DATUM_ODLUKE_ZA_IZDAVANJE_LICENSE datetime,
   primary key (ID_ZAHTEVA)
);

alter table DOKUMENT add constraint FK_TIP_DOKUMENTA foreign key (SIFRA_TIPA_DOKUMENTA)
      references TIP_DOKUMENTA (SIFRA_TIPA_DOKUMENTA) on delete restrict on update restrict;

alter table INSPEKCIJSKI_PREGLED add constraint FK_PRIJAVA_INSPEKCIJE foreign key (ID_PRIJAVE)
      references PRIJAVA_ZA_INSPEKCIJSKI_PREGLED (ID_PRIJAVE) on delete restrict on update restrict;

alter table KORISNIK add constraint FK_PRAVNO_LICE_KORISNIKA foreign key (PIB_PRAVNOG_LICA, MATICNI_BROJ_PREDUZECA)
      references PRAVNO_LICE (PIB_PRAVNOG_LICA, MATICNI_BROJ_PREDUZECA) on delete restrict on update restrict;

alter table LICENSA add constraint FK_ZAHTEV_LICENSE foreign key (ID_ZAHTEVA)
      references ZAHTEV_ZA_LICENSU (ID_ZAHTEVA) on delete restrict on update restrict;

alter table MERENJE_KVALITETA add constraint FK_MERENJE_KVALITETA_VODNOG_RESURSA foreign key (ID_VODNOG_RESURSA)
      references VODNI_RESURS (ID_VODNOG_RESURSA) on delete restrict on update restrict;

alter table PARAMETAR_MERENJA add constraint FK_IME_TIPA_PARAMETRA foreign key (SIFRA_PARAMETRA)
      references TIP_PARAMETRA (SIFRA_PARAMETRA) on delete restrict on update restrict;

alter table PARAMETAR_MERENJA add constraint FK_PARAMETAR_MERENJA_KVALITETA foreign key (ID_MERENJA)
      references MERENJE_KVALITETA (ID_MERENJA) on delete restrict on update restrict;

alter table POVLACENJE_LICENSE add constraint FK_POVLACENJE_LICENSE foreign key (ID_LICENSE)
      references LICENSA (ID_LICENSE) on delete restrict on update restrict;

alter table PRIJAVA_ZA_INSPEKCIJSKI_PREGLED add constraint FK_PRIJAVLJENI_VODNI_RESURS foreign key (ID_VODNOG_RESURSA)
      references VODNI_RESURS (ID_VODNOG_RESURSA) on delete restrict on update restrict;

alter table ZAHTEV_ZA_LICENSU add constraint FK_PRAVNO_LICE_ZAHTEVA foreign key (PIB_PRAVNOG_LICA, MATICNI_BROJ_PREDUZECA)
      references PRAVNO_LICE (PIB_PRAVNOG_LICA, MATICNI_BROJ_PREDUZECA) on delete restrict on update restrict;

alter table ZAHTEV_ZA_LICENSU add constraint FK_TIP_LICENSE foreign key (SIFRA_TIPA_LICENSE)
      references TIP_LICENSE (SIFRA_TIPA_LICENSE) on delete restrict on update restrict;

alter table ZAHTEV_ZA_LICENSU add constraint FK_VOZNI_RESURS_ZAHTEVA foreign key (ID_VODNOG_RESURSA)
      references VODNI_RESURS (ID_VODNOG_RESURSA) on delete restrict on update restrict;

SET FOREIGN_KEY_CHECKS = 1;