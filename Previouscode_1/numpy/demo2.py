import numpy as np
s = np.asarray([1,2,3,4,5])
print(type(s))

np.fromiter(range(100),dtype='u8')
print(np.full((3,4,4),7))
print(np.eye(5))  #生成对角为1i其他都是零
print(np.random.random((5,6)))
print(np.linspace(5,8,4)) #等差数列
print('-------------------------------------------')
a = np.array([[3,4,5],[3,4,7]])
s1 =a.flatten()   #加order与不加的区别就是展开的顺序不一样
print(s1)
s2 =a.ravel(order='F')  #展开数组
print(s2)
print(np.moveaxis(a,0,1))
print(s.dtype)
print(a.shape)
print(a.ndim)
print(s.itemsize)
print(a.flags)  #对象的内存信息
t = np.array([1,2,4],dtype=[('age',np.int8)])
print(t)
stu =np.dtype([('name','U20'),('age','i8'),('marks','f4')])
x= np.array([('bob',21,53),('xixi',34,23)],dtype=stu)
print(x['name'])
print(x['age'])


