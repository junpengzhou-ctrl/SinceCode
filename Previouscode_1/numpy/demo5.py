import numpy as np
x = np.arange(100).reshape(5,1,5,4)
y = np.arange(20).reshape(4,5,1)
for s,t in np.nditer([x,y]):
    print(s,t)

a = np.array([[1,2,3], [4,5,6]])  	# 2x3 array
b = np.array([[7,8,9], [10,11,12]])
print(np.add(a,b))
print(np.subtract(a,b))
print(np.multiply(a,b))  #a*b
print(np.divide(a,b))  #a/b
print(np.mod(a,b))
print(np.logical_and(x,y))
print('------------------------------')
print(np.logical_not(x))
print(np.amin(a,axis=1)) #最小元素
print(np.argmin(a,axis=1))#最小元素上的索引
print(np.ptp(a))  #找到最大值和最小值的差值
print(a.ptp(axis=1))  #在一维的差值
print(np.mean(a,axis=0))  #mean 是求平均值
