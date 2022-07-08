#利用beautifulsoup 技术爬取豆瓣信息

from bs4 import BeautifulSoup
#请求库
import requests

def findmovie(url):
#用字典来伪装use agent
  headers = {'User-Agent':'Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Mobile Safari/537.36'}
#获得html
  html = requests.get(url,headers = headers).text
# lxml 解析器来解析  获取soup 对象
  soup = BeautifulSoup(html,'lxml')
#获取所有的标题
  for item in soup.find_all(attrs = {"class":"title"}):
    titile = item.text
    if '/' not in titile:
        print(titile)
# 获取评分和评价人数
  for item in soup.find_all(attrs = {"class":"star"}):
    content = item.get_text()
    content = content.replace('\n', ' ')
    print(content)

# #网址变化规律
# 2  https://movie.douban.com/top250?start=25&filter=
# 3  https://movie.douban.com/top250?start=50&filter=
# 4  https://movie.douban.com/top250?start=75&filter=

# 豆瓣网址
#找到豆瓣下一页的规律
# url = 'https://movie.douban.com/top250?format=text'
for i in range(0,10):
    res = str(i*25)
    url = 'https://movie.douban.com/top250?start='+res+'&filter='
    findmovie(url)






