#自动登录百度网页账号
import time
import os
from selenium import webdriver
from selenium.webdriver.common.keys import Keys

#谷歌驱动
chromedriver = 'F:/Soft/chromedriver.exe'
os.environ["webdriver.chrome.driver"] = chromedriver

#创建已一个dirver 实例
driver = webdriver.Chrome(chromedriver)

#打开网址
driver.get("https://passport.baidu.com/v2/?login&tpl=mn&u=http%3A%2F%2Fwww.baidu.com%2F&sms=5")

time.sleep(5)
driver.find_element_by_id('TANGRAM__PSP_3__footerULoginBtn').click()  #着个定位元素一定是点击手动登录的！！！

#找到输入框实现自动登录
inusername = driver.find_element_by_id('TANGRAM__PSP_3__userName')
inpassword = driver.find_element_by_id('TANGRAM__PSP_3__password')

inusername.send_keys("18351993987")
inpassword.send_keys("MR@zhou0")

#点击登录按钮
login = driver.find_element_by_id('TANGRAM__PSP_3__submit')
login.submit()

time.sleep(20)

driver.close()
driver.quit()

