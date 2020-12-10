INSERT INTO tb_area(area_name,priority) values('东苑',3);
INSERT INTO tb_area(area_name,priority) values('西苑',2);
--
INSERT INTO tb_person_info(name,profile_img,email,gender,enable_status,user_type) values('测试','test','test','1',1,2);
INSERT INTO tb_shop_category(shop_category_name,shop_category_desc,shop_category_img,priority) values('咖啡奶茶','咖啡奶茶','test',1);
INSERT INTO tb_shop_category(shop_category_name,shop_category_desc,shop_category_img,priority) values('咖啡','测试类别','test3',0);
INSERT INTO tb_shop_category(shop_category_name,shop_category_desc,shop_category_img,priority) values('水果','水果类别','水果',9);
INSERT INTO tb_product_category(shop_id,product_category_name,priority,create_time) values(1,'商品测试类别1',10,now());
INSERT INTO tb_head_line(line_name,line_link,line_img,priority,enable_status,create_time,last_edit_time) values('测试头条1','测试头条1','测试头条1',1,1,now(),now());
INSERT INTO tb_head_line(line_name,line_link,line_img,priority,enable_status,create_time,last_edit_time) values('测试头条2','测试头条2','测试头条2',4,1,now(),now());
INSERT INTO tb_head_line(line_name,line_link,line_img,priority,enable_status,create_time,last_edit_time) values('测试头条3','测试头条3','测试头条3',8,1,now(),now());