import sqlite3
conn = sqlite3.connect("test.db")
cur = conn.cursor()
print('数据库创建成功\n')

# # 创建表 PEOPLE（序号、姓名、年龄、公司、薪水）
# cur.execute('create table people'
#             '(id int primary key not null,'
#             'name text not null,'
#             'age int not null,'
#             'company char(50),'
#             'salary real);')
# print('prople 表创建成功！\n')
#
# conn.commit()

# # 插入数据
# cur.execute('insert into people(id, name, age, company, salary) '
#             'values(1, "小杨",26, "华为", 10000.00)');
# cur.execute('insert into people(id, name, age, company, salary) '
#             'values(2, "小颜",26, "百度", 8800.00)');
# cur.execute('insert into people(id, name, age, company, salary) '
#             'values(3, "小红",28, "腾讯", 98000.00)');
# conn.commit()
# print('插入数据成功！\n')

# 查询操作
cursor = cur.execute('select id, name, age, company, salary from people')
print('数据查询成功！')
print('序号', '姓名', '年龄', '公司', '薪水')
for data in cursor.fetchall():
    print('%s %s %s %s %s' %data)


# for row in cursor:
#     print(row[0], row[1], row[2], row[3], row[4])
# print('')

conn.close()
