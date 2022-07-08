import time
import os
from selenium import webdriver
from selenium.webdriver.common.keys import Keys   # 该 Keys 类提供了操作键盘的快捷键，如空格键、回车键等

#获取谷歌驱动器
chromedriver = 'F:/Soft/chromedriver.exe'
os.environ["webdriver.chrome.driver"] = chromedriver

#创建一个div实例
driver = webdriver.Chrome(chromedriver)

#打开网页
driver.get('http://www.baidu.com')

#使用断言来判断所取标题是否含有"百度" ，如果没有的话下面的代码就不会执行
assert "百度" in driver.title

ele = driver.find_element_by_name("wd")  #定位到输入框
#模拟键盘输入espn 并回车
ele.send_keys("espn")
ele.send_keys(Keys.RETURN)

time.sleep(10)

#进行截图操作
driver.save_screenshot('baidu.jpg')     #图片截图最好是png格式，其他格式会警告

#关闭驱动
driver.close()
#退出浏览器
driver.quit()
