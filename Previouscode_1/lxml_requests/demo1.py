import requests as req
from lxml import etree as et
#发送请求，获取响应， rep响应对象
rep = req.get('http://beijing.8684.cn/x_35b1e697')    #https://www.w3school.com.cn/example/xmle/books.xml
tree = et.HTML(rep.content)    #content 二进制文件
#print(rep.status_code)  #状态200 表示成功
#print(rep.text)   #字符串类型
#print(tree.xpath('//price/text()'))  #硬写xpath //选取符合条件的节点，不考虑位置  //div[@attr="xx"] 选取带属性的
# print(tree.xpath('//book[@category="cooking"]/title/text()'))
# print(tree.xpath('//book[1]/title/text()'))
print(tree.xpath('//div[@class="bus_site_layer"]/div/a/text()'))  #多个href后面的属性 /a/@href
