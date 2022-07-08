# 导入 Selenium.webdriver 扩产库，并提供了 webdriver 实现方法
from selenium import webdriver

# 创建 driv 实例，调用 webdriver.PhantomJS 方法配置路径
driver = webdriver.PhantomJS(executable_path=r"C:\Python34\Scripts\phantomjs-2.1.1-windows\bin\phantomjs.exe")

# 打开百度网页，webdriver 会等待网页元素加载完成之后才能把控制权交回脚本
driver.get('http://www.baidu.com')
# 获取文章标题并赋值给 data 变量输出
data = driver.title
# data 变量值为“百度一下，你就知道”
print(data)