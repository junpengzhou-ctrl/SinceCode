# import requests as req
# from lxml import etree as et
# html = req.get('http://music.taihe.com/artist')
# tree = et.HTML(html.content)
# print(html.status_code)  #查看状态
# hot = tree.xpath('//dd/a[@title]/text()')
# cold = tree.xpath('//li/a[@title]/text()')
# print(hot+cold)
# print('-----------------------------------')
#
#
# #print(tree.xpath('//div[@class="bus_site_layer"]/div/a/text()'))
