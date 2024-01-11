
drop table if exists nace;
create table nace(
order_id BIGINT NOT NULL AUTO_INCREMENT,
lvl INT,
code VARCHAR(2),
parent VARCHAR(2),
description LONGTEXT,
item_includes MEDIUMBLOB,
also_includes LONGTEXT,
rulings LONGTEXT,
item_excludes LONGTEXT,
reference_isic LONGTEXT,
PRIMARY KEY ( order_id )
);


INSERT INTO nace (lvl, code, parent, description,item_includes, also_includes, rulings, item_excludes, reference_isic ) values (4, '99', '99','Activities of extraterritorial ...', 'null- activities of international organisations such as the United Nations and the specialised agencies of the United Nations system, regional bodies etc., the International Monetary Fund, the World Bank, the World Customs Organisation, the Organisation f','null- activities of diplomatic and consular ...','', '', '9900');
INSERT INTO nace (lvl, code, parent, description,item_includes, also_includes, rulings, item_excludes, reference_isic ) values ( 4, '99', '99','Description','Item includes','other','', '', '9900');
