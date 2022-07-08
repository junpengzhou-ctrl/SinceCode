import pymysql
# conn = pymysql.connect(host='192.168.56.101', db='bookmanage', user='root', passwd='root', port=3306, charset='utf8')
# cur  = conn.cursor()
#
# res = cur.execute('select * from books')    #res 通过sql语句获取查询结果，返回的是int类型的条数
# print(res)
#
# for data in cur.fetchall():   #通过游标获取数据
#         print('%s %s %s %s' % data)    #数据接受的列数 和 返回的结果的列数应该要相等
# # #建表
# # sql = "create table students_one_more(id int not null primary key auto_increment," \
# #                                "name char(30) not null," \
# #                                "sex char(20) not null)"
# # cur.execute(sql)
# #
# # cur.execute("show tables")
# # for data in cur.fetchall():
# #     print('%s' % data)
# # #conn.commit()   #创建插入数据表时要加上事务
#
# cur.close()
# conn.close()


def writesomeinfo(domain,station,salary):
    try:
        conn = pymysql.connect(host='192.168.56.101', db='bookmanage', user='root', passwd='root', port=3306,
                               charset='utf8')
        cur = conn.cursor()
        count = 0
     # 设置编码方式
        cur.execute('SET NAMES utf8;')
        cur.execute('SET CHARACTER SET utf8;')
        cur.execute('SET character_set_connection=utf8;')
      #插入表  #设置占位符%s
        sql = '''
        insert into jobinfo(domain,station,salary)values (%s, %s, %s)
         '''
        cur.execute(sql,(domain,station,salary))     #！！！！参数不能少
        count +=1
        print("成功写入一条数据库,当前共写入"+str(count)+"条数据")
    except pymysql.Error as e:
        print('Mysql Error %d: %s' % (e.args[0], e.args[1]))
    finally:
        cur.close()
        conn.commit()
        conn.close()

writesomeinfo('朝阳','高薪正规包吃住SPA师','8000-12000元')
