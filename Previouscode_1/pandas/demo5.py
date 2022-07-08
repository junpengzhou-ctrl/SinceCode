import pandas as pd
import numpy as np
s = pd.Series(np.array([1,2,4]))
# print(s[0])
# print(s[[0,1]])
# print(s[-3:])
s1 = pd.Series([1,2,3,4,5],index=['a','b','c','d','e'])
# print(s1['b'])
print(max(s1))
print("-"*20)
print(s1['a':'c'])
print("-"*20)
s1['d']=9
print(s1)
print("-"*20)
print(np.exp(s1))
print(s1.get('f',100))
print("-"*20)
x = [[1, 2],[2,3]]					# 1x2 list
sc =pd.DataFrame(x,columns=['a','c']) # create from given x
print(sc)
print("*"*20)
df=pd.DataFrame(np.arange(6).reshape(3,2))
print(df)
df2=df.append({0:['a','b'], 100:['c','d']}, ignore_index=True)
print(df2)