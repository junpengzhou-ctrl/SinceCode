import pandas as pd
import numpy as np
s = pd.Series(np.array([1,2,3,3,4,5,2,3,4]))
print(s)
print(s[2])
print(s.value_counts())  #相同数据出现的频率，生成新的Series


s = pd.Series({'a':1,'b':2,'c':3})
print(type(s))
print(s)
s = pd.Series(5,index = [1,2,3,4])   #index 可以自定义标签
print(s)   #索引