# -*- coding: utf-8 -*-
#利用beautifulsoup技术爬取招聘信息
from time import sleep
import pymysql
import requests
import re
from bs4 import BeautifulSoup

#写入数据库
def writesomeinfo(domain,station,salary):
    try:
        conn = pymysql.connect(host='192.168.56.101', db='bookmanage', user='root', passwd='root', port=3306,
                               charset='utf8')
        cur = conn.cursor()

     # 设置编码方式
        cur.execute('SET NAMES utf8;')
        cur.execute('SET CHARACTER SET utf8;')
        cur.execute('SET character_set_connection=utf8;')
      #插入表  #设置占位符%s
        sql = '''
        insert into jobinfo(domain,station,salary)values (%s, %s, %s)
         '''
        cur.execute(sql,(domain,station,salary))     #！！！！参数不能少

    except pymysql.Error as e:
        print('Mysql Error %d: %s' % (e.args[0], e.args[1]))
    finally:
        cur.close()
        conn.commit()
        conn.close()

#爬取信息
def findjob(url):
    headers = {
        'User-Agent': 'Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Mobile Safari/537.36'
    }
    sleep(1)
    html = requests.get(url,headers=headers).text
    soup = BeautifulSoup(html,'lxml')
    #print("区域","岗位","薪资")

    count = 0 #初始记录条数
    for tag in soup.find_all(attrs={"class":"con-list-zcon new-dl"}):       #获取每一条求职信息
        info = tag.find(attrs={"class": "s-butt s-bb1"}).get_text()

        # domain = tag.find(attrs ={"class":"pay"}).text.replace('\n', '')    #区域
        domain = re.findall('工作地点：(.*?)\n',info)
        station = tag.find(attrs={"class":"list-ga gj_tongji js-float"}).text   #岗位
        #salary = tag.find(attrs={"class":"new-dl-salary"}).text     #薪资     find().text 和find().get_text() 无差别
        salary = re.findall('薪资待遇：(.*?)元',info)
        writesomeinfo(domain,station,salary)   #执行写入操作
        count +=1
        print("成功写入1条数据，当前"+str(count)+"条信息")   #每一页的条数



#程序入口
if __name__ == '__main__':
    for i in range(1,15):
        url = "https://bj.ganji.com/zpbiaoqian/p6o"+str(i)+"/"
        findjob(url)








